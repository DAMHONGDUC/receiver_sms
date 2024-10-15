package com.receiver.sms.presentation.screens.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.receiver.sms.domain.model.SMSObserveModel
import com.receiver.sms.presentation.components.ListWithScrollBar
import com.receiver.sms.presentation.components.empty.CustomEmpty
import com.receiver.sms.presentation.components.error.CustomError
import com.receiver.sms.core.resources.AppColors
import com.receiver.sms.core.view_model.ViewModelState

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
                    color = MaterialTheme.colors.primary
                )
            }
        }

        is ViewModelState.Success -> {
            if (listSMSObserver.data.isNotEmpty()) {
                val listState = rememberLazyListState()

                ListWithScrollBar(
                    listState = listState,
                ) {
                    LazyColumn(
                        state = listState, modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        itemsIndexed(listSMSObserver.data) { index, sms ->
                            SMSObserverRow(sms = sms)
                            if (index < listSMSObserver.data.size - 1) {
                                Divider(
                                    modifier = Modifier.padding(vertical = 2.dp),
                                    color = AppColors.gray,
                                    thickness = 0.5.dp
                                )
                            }
                        }
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