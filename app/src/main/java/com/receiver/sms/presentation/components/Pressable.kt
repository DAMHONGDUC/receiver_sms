package com.receiver.sms.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape

@Composable
fun Pressable(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    clip: Shape = CircleShape,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .clip(clip)
            .clickable(
                onClick = onClick,
            )
    ) {
        content()
    }
}
