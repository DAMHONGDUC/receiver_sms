package com.receiver.sms.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.receiver.sms.presentation.components.app_container.AppContainer
import com.receiver.sms.utils.view_model.ViewModelState

private val LOG_TAG = "HomeScreenLOG"

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = hiltViewModel()) {
    val listSMSObserver = homeViewModel.listSMSObserver.collectAsState().value

    fun createSMSObserve() {
        homeViewModel.createSMSObserve()
    }

    Scaffold { paddingValues ->
        AppContainer {
            Column {
                Button(onClick = { createSMSObserve() }) {
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
