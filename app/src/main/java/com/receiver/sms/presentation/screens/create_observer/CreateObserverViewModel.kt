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
                state = state.copy(observerSender = event.observerSender)
            }

            is ObserverFormEvent.BodyChanged -> {
                state = state.copy(body = event.body)
            }

            is ObserverFormEvent.EndPointChanged -> {
                state = state.copy(endPoint = event.endPoint)
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
        // validate observer sender
        if (validate.isEmpty(state.observerSender)) {
            state = state.copy(observerSenderError = "Observer sender must not empty")

        }
        // validate endpoint
        if (validate.isEmpty(state.endPoint)) {
            state = state.copy(endPointError = "Endpoint must not empty")

        }
        // validate body
        if (validate.isEmpty(state.body)) {
            state = state.copy(bodyError = "Body must not empty")

        }
    }
}
