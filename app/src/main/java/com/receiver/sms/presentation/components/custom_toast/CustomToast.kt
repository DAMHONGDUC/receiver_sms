package com.receiver.sms.presentation.components.custom_toast

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.dokar.sonner.Toaster
import com.dokar.sonner.ToasterState

@Composable
fun CustomToast(state: ToasterState) {
    Toaster(
        state = state,
        showCloseButton = true,
        alignment = Alignment.TopCenter,
        richColors = true,
        darkTheme = true,
    )
}