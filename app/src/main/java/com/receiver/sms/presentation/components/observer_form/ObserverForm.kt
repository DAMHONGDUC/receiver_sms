package com.receiver.sms.presentation.components.observer_form

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.receiver.sms.presentation.components.AppTextField
import com.receiver.sms.presentation.components.spacing.VerticalSpacing
import com.receiver.sms.presentation.screens.create_observer.CreateObserverViewModel

@Composable
fun ObserverForm(state: ObserverFormState, createObserverVM: CreateObserverViewModel) {
    Column {
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
        )
        VerticalSpacing()
        AppTextField(
            value = state.endPoint,
            onValueChange = {
                createObserverVM.onEvent(
                    ObserverFormEvent.ObserverSenderChanged(it)
                )
            },
            isError = !state.observerSenderError.isNullOrEmpty(),
            errorMessage = state.observerSenderError,
            label = "End Point",
        )
        VerticalSpacing()
        AppTextField(
            value = state.body,
            onValueChange = {
                createObserverVM.onEvent(
                    ObserverFormEvent.ObserverSenderChanged(it)
                )
            },
            isError = !state.observerSenderError.isNullOrEmpty(),
            errorMessage = state.observerSenderError,
            label = "Body",
        )
    }
}