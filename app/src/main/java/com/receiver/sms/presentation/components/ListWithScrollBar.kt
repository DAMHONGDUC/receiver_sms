package com.receiver.sms.presentation.components

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import com.receiver.sms.core.resources.AppColors
import my.nanihadesuka.compose.LazyColumnScrollbar
import my.nanihadesuka.compose.ScrollbarSettings

@Composable
fun ListWithScrollBar(listState: LazyListState, body: @Composable () -> Unit) {
    LazyColumnScrollbar(
        state = listState,
        settings = ScrollbarSettings.Default.copy(thumbUnselectedColor = AppColors.gray),
    ) {
        body()
    }
}