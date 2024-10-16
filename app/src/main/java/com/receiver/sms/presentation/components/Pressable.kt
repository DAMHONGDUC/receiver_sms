package com.receiver.sms.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import com.receiver.sms.core.resources.AppColors

@Composable
fun Pressable(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    rippleColor: Color = AppColors.black,
    clip: Shape = CircleShape,
    content: @Composable () -> Unit
) {
    // Wrap content in a Box with a clickable modifier for press interaction
    Box(
        modifier = modifier
            .clip(clip) // Clip the Box shape
            .clickable(
                onClick = onClick, // Handle click events
            )
    ) {
        // Content composable to be displayed inside the Box
        content()
    }
}
