package com.receiver.sms.presentation.screens.create_observer

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dokar.sonner.ToastType
import com.receiver.sms.data.data_source.local.entity.SMSObserveEntity
import com.receiver.sms.domain.model.ToastMsgModel
import com.receiver.sms.domain.use_case.UseCase
import com.receiver.sms.presentation.components.observer_form.ObserverFormEvent
import com.receiver.sms.presentation.components.observer_form.ObserverFormState
import com.receiver.sms.utils.validation.ValidationWithRegex
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private val LOG_TAG = "CreateObserverViewModelLOG"

@HiltViewModel
class CreateObserverViewModel @Inject constructor(
    private val useCase: UseCase,
) : ViewModel() {
    private val validate: ValidationWithRegex = ValidationWithRegex()
    var state by mutableStateOf(ObserverFormState())

    fun onEvent(event: ObserverFormEvent) {
        when (event) {
            is ObserverFormEvent.ObserverSenderChanged -> {
                val validate = validate.isNotEmpty(event.observerSender)
                state = state.copy(
                    observerSender = event.observerSender,
                    observerSenderError = if (validate) null else "Observer sender must not empty"
                )
            }

            is ObserverFormEvent.BodyChanged -> {
                val validate = validate.isNotEmpty(event.body)
                state = state.copy(
                    body = event.body,
                    bodyError = if (validate) null else "Body must not empty"
                )
            }

            is ObserverFormEvent.EndPointChanged -> {
                val validate = validate.isNotEmpty(event.endPoint)
                state = state.copy(
                    endPoint = event.endPoint,
                    endPointError = if (validate) null else "Endpoint must not empty"
                )
            }

            is ObserverFormEvent.HeaderChanged -> {
                state = state.copy(header = event.header)
            }

            is ObserverFormEvent.ParamsChanged -> {
                state = state.copy(params = event.params)
            }
        }
    }

    fun onSubmit(onSuccess: () -> Unit, showResult: (ToastMsgModel) -> Unit) {
        if (onValidateAll()) {
            viewModelScope.launch {
                var toastMsgModel = ToastMsgModel(
                    msg = "Create observer Success!",
                    type = ToastType.Success
                )

                try {
                    useCase.insertSMSObserveUC(
                        smsObserveEntity = SMSObserveEntity(
                            sender = state.observerSender,
                            endpoint = state.endPoint,
                            body = state.body,
                            header = state.header ?: ""
                        )
                    )

                    onSuccess()

                } catch (e: Exception) {
                    toastMsgModel = ToastMsgModel(
                        msg = "Create observer Failed!",
                        type = ToastType.Error
                    )
                }

                showResult(toastMsgModel)
            }
        }
    }

    private fun onValidateAll(): Boolean {
        val validateObserverSender = validate.isNotEmpty(state.observerSender)
        val validateBody = validate.isNotEmpty(state.body)
        val validateEndpoint = validate.isNotEmpty(state.endPoint)

        if (!validateObserverSender) {
            state = state.copy(observerSenderError = "Observer sender must not empty")
        }

        if (!validateBody) {
            state = state.copy(bodyError = "Body must not empty")
        }

        if (!validateEndpoint) {
            state = state.copy(endPointError = "Endpoint must not empty")
        }

        return validateObserverSender && validateBody && validateEndpoint
    }
}
