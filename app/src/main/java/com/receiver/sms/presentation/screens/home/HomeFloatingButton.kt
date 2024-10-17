package com.receiver.sms.presentation.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import com.receiver.sms.core.resources.AppIconSize
import com.receiver.sms.presentation.components.TransformContainer

@Composable
fun HomeFloatingButton(modifier: Modifier = Modifier) {
    TransformContainer(
        modifier = modifier,
        closeBuilder = { voidCallback ->
            FloatingActionButton(
                onClick = { voidCallback() },
                modifier = Modifier.size(AppIconSize.superLarge),
                content = {
                    Icon(
                        painter = rememberVectorPainter(Icons.Filled.Add),
                        contentDescription = null,
                        modifier = Modifier.size(AppIconSize.base)
                    )
                }
            )
        },
        openBuilder = { voidCallback ->
            AddContentScreen(
                modifier = Modifier.fillMaxSize(),
                onBack = { voidCallback() }
            )
        }
    )

}