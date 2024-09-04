package com.receiver.sms.presentation.screens.create_observer

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.receiver.sms.presentation.components.MainContainer
import com.receiver.sms.presentation.components.observer_form.ObserverForm
import com.receiver.sms.presentation.components.observer_form.ObserverFormEvent
import com.receiver.sms.presentation.components.spacing.VerticalSpacing
import com.receiver.sms.presentation.screens.main.MainViewModel

@Composable
fun CreateObserverScreen(
    mainVM: MainViewModel,
    createObserverVM: CreateObserverViewModel = hiltViewModel(),
    onBack: () -> Unit
) {
    MainContainer(
        onBack = onBack,
        ) {
        Column {
            ObserverForm(state = createObserverVM.state, createObserverVM = createObserverVM)
            VerticalSpacing()
            Button(
                onClick = {
                    createObserverVM.onEvent(ObserverFormEvent.Submit)
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = "Submit")
            }
        }
    }

}


