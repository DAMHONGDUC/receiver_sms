package com.receiver.sms.presentation.screens.create_observer

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.receiver.sms.presentation.components.observer_form.ObserverFormEvent
import com.receiver.sms.presentation.components.observer_form.ObserverFormState
import com.receiver.sms.utils.ValidationWithRegex
import javax.inject.Inject

class CreateObserverViewModel @Inject constructor(
    private val validate: ValidationWithRegex = ValidationWithRegex(),
) : ViewModel() {
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

            is ObserverFormEvent.Submit -> {
                onSubmit()
            }
        }
    }

    private fun onSubmit() {
        if (onValidateAll()) {
            // submit
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
