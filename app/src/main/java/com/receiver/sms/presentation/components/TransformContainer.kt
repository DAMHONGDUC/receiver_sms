package com.receiver.sms.presentation.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.EaseInCubic
import androidx.compose.animation.core.EaseOutCubic
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp

enum class ContainerState {
    Close,
    Open,
}

@Composable
fun TransformContainer(
    openBuilder: @Composable (voidCallback: () -> Unit) -> Unit,
    closeBuilder: @Composable (voidCallback: () -> Unit) -> Unit,
    modifier: Modifier = Modifier,
) {
    var containerState by remember { mutableStateOf(ContainerState.Close) }
    val transition = updateTransition(containerState, label = "container transform")
    val animatedColor by transition.animateColor(
        label = "color",
    ) { state ->
        when (state) {
            ContainerState.Close -> MaterialTheme.colorScheme.primaryContainer
            ContainerState.Open -> MaterialTheme.colorScheme.surface
        }
    }
    val cornerRadius by transition.animateDp(
        label = "corner radius",
        transitionSpec = {
            when (targetState) {
                ContainerState.Close -> tween(
                    durationMillis = 400,
                    easing = EaseOutCubic,
                )

                ContainerState.Open -> tween(
                    durationMillis = 200,
                    easing = EaseInCubic,
                )
            }
        }
    ) { state ->
        when (state) {
            ContainerState.Close -> 22.dp
            ContainerState.Open -> 0.dp
        }
    }
    val elevation by transition.animateDp(
        label = "elevation",
        transitionSpec = {
            when (targetState) {
                ContainerState.Close -> tween(
                    durationMillis = 400,
                    easing = EaseOutCubic,
                )

                ContainerState.Open -> tween(
                    durationMillis = 200,
                    easing = EaseOutCubic,
                )
            }
        }
    ) { state ->
        when (state) {
            ContainerState.Close -> 6.dp
            ContainerState.Open -> 0.dp
        }
    }
    val padding by transition.animateDp(
        label = "padding",
    ) { state ->
        when (state) {
            ContainerState.Close -> 16.dp
            ContainerState.Open -> 0.dp
        }
    }

    transition.AnimatedContent(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .padding(end = padding, bottom = padding)
            .shadow(
                elevation = elevation,
                shape = RoundedCornerShape(cornerRadius)
            )
            .drawBehind { drawRect(animatedColor) },
        transitionSpec = {
            (
                    fadeIn(animationSpec = tween(220, delayMillis = 90)) +
                            scaleIn(
                                initialScale = 0.92f,
                                animationSpec = tween(220, delayMillis = 90)
                            )
                    )
                .togetherWith(fadeOut(animationSpec = tween(90)))
                .using(SizeTransform(clip = false, sizeAnimationSpec = { _, _ ->
                    tween(
                        durationMillis = 500,
                        easing = FastOutSlowInEasing
                    )
                }))
        }
    ) { state ->
        when (state) {
            ContainerState.Close -> {
                closeBuilder {
                    containerState = ContainerState.Open
                }
            }

            ContainerState.Open -> {
                openBuilder {
                    containerState = ContainerState.Close
                }
            }
        }
    }
}

