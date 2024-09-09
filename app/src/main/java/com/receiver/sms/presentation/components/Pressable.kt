package com.receiver.sms.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import com.receiver.sms.utils.resources.AppColors

@Composable
fun Pressable(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    rippleColor: Color = AppColors.black,
    clip: Shape = CircleShape,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .clip(clip)
            .clickable(
                onClick = onClick,
                indication = rememberRipple(bounded = true, color = rippleColor), // Ripple effect
                interactionSource = remember { MutableInteractionSource() }
            )
    ) {
        content()
    }
}
