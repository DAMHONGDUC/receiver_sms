package com.receiver.sms.presentation.components.observer_form

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.receiver.sms.presentation.components.AppTextField
import com.receiver.sms.presentation.screens.create_observer.CreateObserverViewModel
import com.receiver.sms.utils.resources.AppBoxModel

@Composable
fun ObserverForm(state: ObserverFormState, createObserverVM: CreateObserverViewModel) {
    Column(verticalArrangement = Arrangement.spacedBy(AppBoxModel().spacing())) {
        AppTextField(
            value = state.observerSender,
            onValueChange = {
                createObserverVM.onEvent(
                    ObserverFormEvent.ObserverSenderChanged(it)
                )
            },
            isError = !state.observerSenderError.isNullOrEmpty(),
            errorMessage = state.observerSenderError,
            label = "Observer Sender",
            placeholder = "Enter your sender"
        )
        AppTextField(
            value = state.endPoint,
            onValueChange = {
                createObserverVM.onEvent(
                    ObserverFormEvent.EndPointChanged(it)
                )
            },
            isError = !state.observerSenderError.isNullOrEmpty(),
            errorMessage = state.observerSenderError,
            label = "Endpoint",
            placeholder = "Enter your endpoint"
        )
        AppTextField(
            value = state.body,
            onValueChange = {
                createObserverVM.onEvent(
                    ObserverFormEvent.BodyChanged(it)
                )
            },
            isError = !state.observerSenderError.isNullOrEmpty(),
            errorMessage = state.observerSenderError,
            label = "Body",
            placeholder = "Enter your body"
        )
    }
}