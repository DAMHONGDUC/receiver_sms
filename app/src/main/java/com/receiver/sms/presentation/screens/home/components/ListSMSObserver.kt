package com.receiver.sms.presentation.screens.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.receiver.sms.core.resources.AppColors
import com.receiver.sms.core.view_model.ViewModelState
import com.receiver.sms.domain.model.SMSObserveModel
import com.receiver.sms.presentation.components.empty.CustomEmpty
import com.receiver.sms.presentation.components.error.CustomError

@Composable
fun ListSMSObserver(listSMSObserver: ViewModelState<List<SMSObserveModel>>) {
    when (listSMSObserver) {
        is ViewModelState.Loading -> {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                CircularProgressIndicator(
                    color = AppColors.primary
                )
            }
        }

        is ViewModelState.Success -> {
            if (listSMSObserver.data.isNotEmpty()) {
                val listState = rememberLazyListState()

                LazyColumn(
                    state = listState, modifier = Modifier
                        .fillMaxSize()
                ) {
                    itemsIndexed(listSMSObserver.data) { _, sms ->
                        SMSObserverRow(sms = sms)
                    }
                }
            } else {
                CustomEmpty()
            }
        }

        is ViewModelState.Error -> {
            CustomError(msg = "Get list SMS observer failed")
        }

        ViewModelState.Empty -> CustomEmpty()
    }
}