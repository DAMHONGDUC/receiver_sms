package com.receiver.sms.presentation.screens.create_observer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.receiver.sms.presentation.components.CustomScrollView
import com.receiver.sms.presentation.components.MainContainer
import com.receiver.sms.presentation.components.button.PrimaryButton
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
        topBarTitle = "Create Observer",
    ) {
        CustomScrollView(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ObserverForm(state = createObserverVM.state, createObserverVM = createObserverVM)
            VerticalSpacing()
            PrimaryButton(
                onClick = {
                    createObserverVM.onEvent(ObserverFormEvent.Submit)
                },
                text = "Submit"
            )
        }
    }

}


