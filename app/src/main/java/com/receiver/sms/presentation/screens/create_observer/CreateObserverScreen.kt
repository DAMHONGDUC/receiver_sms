package com.receiver.sms.presentation.screens.create_observer

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.receiver.sms.presentation.components.AppTextField
import com.receiver.sms.presentation.components.observer_form.ObserverFormEvent
import com.receiver.sms.presentation.screens.main.MainViewModel

@Composable
fun CreateObserverScreen(
    mainVM: MainViewModel,
    createObserverVM: CreateObserverViewModel = hiltViewModel()
) {
    val state = createObserverVM.state
    Column {
        AppTextField(
            value = state.observerSender,
            onValueChange = {
                createObserverVM.onEvent(
                    ObserverFormEvent.ObserverSenderChanged(it)
                )
            },
            isError = state.observerSenderError != null,
            label = "Observer Sender",
        )
    }
}


