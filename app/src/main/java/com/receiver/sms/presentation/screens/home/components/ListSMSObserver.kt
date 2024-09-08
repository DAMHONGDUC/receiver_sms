package com.receiver.sms.presentation.screens.home.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.receiver.sms.domain.model.SMSObserveModel
import com.receiver.sms.utils.view_model.ViewModelState

@Composable
fun ListSMSObserver(listSMSObserver: ViewModelState<List<SMSObserveModel>>) {
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