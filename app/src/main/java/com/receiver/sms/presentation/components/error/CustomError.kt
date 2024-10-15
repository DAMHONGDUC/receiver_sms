package com.receiver.sms.presentation.components.error

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.receiver.sms.presentation.components.spacing.HorizontalSpacing
import com.receiver.sms.core.resources.AppColors
import com.receiver.sms.core.resources.AppTextStyle

@Composable
fun CustomError(msg: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically)
        {
            Icon(
                Icons.Filled.Error,
                contentDescription = "",
                modifier = Modifier.size(20.dp),
                tint = AppColors.red
            )
            HorizontalSpacing(value = 5.dp)
            Text(
                text = msg,
                style = AppTextStyle().small.copy(color = AppColors.red)
            )
        }
    }
}