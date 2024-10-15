package com.receiver.sms.presentation.components.observer_form

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import cafe.adriel.lyricist.LocalStrings
import com.receiver.sms.presentation.components.AppTextField
import com.receiver.sms.presentation.screens.create_observe.CreateObserveViewModel

@Composable
fun ObserverForm(state: ObserverFormState, createObserverVM: CreateObserveViewModel) {
    val tr = LocalStrings.current

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
            title = tr.observeForm.observedPhoneNumberTitle,
            hint = tr.observeForm.observedPhoneNumberHint,
        )
        AppTextField(
            value = state.endPoint,
            onValueChange = {
                createObserverVM.onEvent(
                    ObserverFormEvent.EndPointChanged(it)
                )
            },
            isError = !state.endPointError.isNullOrEmpty(),
            errorMessage = state.endPointError,
            title = tr.observeForm.endpointTitle,
            hint = tr.observeForm.endpointHint,
        )
        AppTextField(
            value = state.body,
            onValueChange = {
                createObserverVM.onEvent(
                    ObserverFormEvent.BodyChanged(it)
                )
            },
            isError = !state.bodyError.isNullOrEmpty(),
            errorMessage = state.bodyError,
            title = tr.observeForm.bodyTitle,
            hint = tr.observeForm.bodyHint,
        )
    }
}