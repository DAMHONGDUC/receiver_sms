package com.receiver.sms.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.receiver.sms.utils.resources.AppBoxModel
import com.receiver.sms.utils.resources.AppColors

@Composable
fun MainContainer(
    paddingHorizontal: Dp = AppBoxModel().mainPadding(),
    paddingVertical: Dp = AppBoxModel().mainPadding(),
    topBarTitle: String = "",
    onBack: () -> Unit = {},
    enableBack: Boolean = true,
    content: @Composable () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CustomAppBar(
                title = topBarTitle,
                onBack = onBack,
                enableBack = enableBack
            )
        }) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = paddingHorizontal, vertical = paddingVertical)
                .background(color = AppColors.background)
        ) {
            content()
        }
    }
}


