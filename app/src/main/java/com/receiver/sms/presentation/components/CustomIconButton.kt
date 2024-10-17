package com.receiver.sms.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.receiver.sms.core.resources.AppColors
import com.receiver.sms.core.resources.AppIconSize

@Composable
fun CustomIconButton(
    onClick: () -> Unit,
    imageVector: ImageVector,
    padding: Dp = 8.dp,
    color: Color = AppColors.iconColor
) {
    Pressable(onClick = onClick) {
        Icon(
            imageVector,
            contentDescription = "",
            tint = color,
            modifier = Modifier
                .padding(padding)
                .size(AppIconSize.base)
        )
    }
}