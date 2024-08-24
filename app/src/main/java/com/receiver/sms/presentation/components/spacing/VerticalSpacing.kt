package com.receiver.sms.presentation.components.spacing

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.receiver.sms.utils.resources.AppBoxModel

@Composable
fun VerticalSpacing(value: Dp = AppBoxModel().spacing()) {
    Spacer(modifier = Modifier.height(value))
}