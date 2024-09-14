package com.receiver.sms.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.receiver.sms.utils.resources.AppColors
import com.receiver.sms.utils.resources.AppIconSize

@Composable
fun CustomIconButton(
    onClick: () -> Unit,
    imageVector: ImageVector,
    color: Color = AppColors.iconColor
) {
    Pressable(onClick = onClick) {
        Icon(
            imageVector,
            contentDescription = "",
            tint = color,
            modifier = Modifier
                .padding(6.dp)
                .size(AppIconSize().base())
        )
    }
}