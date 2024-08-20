package com.receiver.sms.presentation.components.app_container

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.receiver.sms.utils.resources.AppBoxModel
import com.receiver.sms.utils.resources.AppColors

@Composable
fun AppContainer(
    paddingHorizontal: Dp = AppBoxModel().mainPadding(),
    verticalHorizontal: Dp = AppBoxModel().mainPadding(),
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(horizontal = paddingHorizontal, vertical = verticalHorizontal)
            .fillMaxSize()
            .background(color = AppColors.background)
    ) {
        content()
    }
}

