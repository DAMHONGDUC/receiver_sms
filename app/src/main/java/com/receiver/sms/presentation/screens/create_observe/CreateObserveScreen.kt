package com.receiver.sms.presentation.screens.create_observe

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.receiver.sms.presentation.components.CustomScrollView
import com.receiver.sms.presentation.components.app.MainContainer
import com.receiver.sms.presentation.components.button.PrimaryButton
import com.receiver.sms.presentation.components.observer_form.ObserverForm
import com.receiver.sms.presentation.screens.main.MainViewModel

@Composable
fun CreateObserveScreen(
    mainVM: MainViewModel,
    createObserverVM: CreateObserveViewModel = hiltViewModel(),
    onBack: () -> Unit
) {
    MainContainer(
        onBack = onBack,
        topBarTitle = "Create SMS Observe",
    ) {
        CustomScrollView(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ObserverForm(state = createObserverVM.state, createObserverVM = createObserverVM)
            PrimaryButton(
                onClick = {
                    createObserverVM.onSubmit(
                        onSuccess = {
                            onBack()
                        },
                        showResult = { toastMsgModel ->
                            mainVM.setToast(toastMsgModel)
                        }
                    )
                },
                text = "Submit"
            )
        }
    }

}


