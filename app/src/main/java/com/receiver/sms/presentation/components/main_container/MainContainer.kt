package com.receiver.sms.presentation.components.main_container

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.receiver.sms.presentation.components.custom_app_bar.CustomAppBar
import com.receiver.sms.utils.resources.AppBoxModel
import com.receiver.sms.utils.resources.AppColors

@Composable
fun MainContainer(
    paddingHorizontal: Dp = 0.dp,
    paddingVertical: Dp = AppBoxModel().haftMainPadding(),
    topBarTitle: String = "",
    onBack: () -> Unit = {},
    enableBack: Boolean = true,
    scroll: Boolean = true,
    content: @Composable () -> Unit,
) {
    Scaffold(topBar = {
        CustomAppBar(
            title = topBarTitle,
            onBack = onBack,
            enableBack = enableBack
        )
    }) { padding ->
        Box(
            modifier = Modifier
                .padding(horizontal = paddingHorizontal, vertical = paddingVertical)
                .fillMaxSize()
                .background(color = AppColors.background)
        ) {
            content()
        }
    }

}



