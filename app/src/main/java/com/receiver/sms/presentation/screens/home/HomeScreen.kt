package com.receiver.sms.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dokar.sonner.ToastType
import com.receiver.sms.domain.model.ToastMsgModel
import com.receiver.sms.presentation.components.MainContainer
import com.receiver.sms.presentation.screens.home.components.RequestSMSPermissionModal
import com.receiver.sms.presentation.screens.main.MainViewModel
import com.receiver.sms.utils.view_model.ViewModelState

private val LOG_TAG = "HomeScreenLOG"

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
    mainVM: MainViewModel,
    navToCreateObserverScreen: () -> Unit
) {
    val listSMSObserver = homeViewModel.listSMSObserver.collectAsState().value

    fun createSMSObserve() {
        homeViewModel.createSMSObserve(actionAfterCreated = {
            mainVM.setToast(
                ToastMsgModel(
                    msg = "Create observer Success!",
                    type = ToastType.Success
                )
            )
        })
    }


    MainContainer(
        paddingVertical = 0.dp,
        enableBack = false,
    ) {
        RequestSMSPermissionModal {
            Column {
                Button(onClick = navToCreateObserverScreen) {
                    Text("Create observe")
                }
                Text(text = "HomeScreen")

                when (listSMSObserver) {
                    is ViewModelState.Loading -> {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .fillMaxSize()
                                .wrapContentSize(
                                    Alignment.Center
                                )
                        )
                    }

                    is ViewModelState.Success -> {
                        LazyColumn(modifier = Modifier.fillMaxSize()) {
                            items(listSMSObserver.data.count()) { index ->
                                Text(listSMSObserver.data[index].sender)
                            }
                        }
                    }

                    is ViewModelState.Error -> {
                        Text(
                            "error"
                        )
                    }

                    ViewModelState.Empty -> Text(
                        "Empty"
                    )
                }
            }
        }
    }

}
