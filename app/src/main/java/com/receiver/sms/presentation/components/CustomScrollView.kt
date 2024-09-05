package com.receiver.sms.presentation.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.receiver.sms.utils.verticalScrollbar

@Composable
fun CustomScrollView(
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    modifier: Modifier = Modifier,
    padding: Dp = 0.dp,
    scrollState: ScrollState = rememberScrollState(),
    content: @Composable () -> Unit,
) {
    Column(
        horizontalAlignment = horizontalAlignment,
        verticalArrangement = verticalArrangement,
        modifier = modifier
            .then(
                Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .verticalScrollbar(scrollState)
                    .verticalScroll(state = scrollState)
                    .height(IntrinsicSize.Max)
            )
    ) {
        content()
    }
}