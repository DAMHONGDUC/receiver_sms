package com.receiver.sms.presentation.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.receiver.sms.presentation.components.Pressable
import com.receiver.sms.utils.resources.AppColors

@Composable
fun CreateSMSObserverButton(
    height: Dp = 120.dp,
    onClick: () -> Unit,
    borderRadius: Dp = 8.dp,
    border: Dp = 1.dp,
    elevation: Dp = 5.dp,
    paddingHorizontal: Dp = 70.dp
) {
    val roundShape = RoundedCornerShape(borderRadius)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(color = AppColors.primary)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(color = AppColors.background)
            )
        }


        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = paddingHorizontal)
                .shadow(elevation = elevation, shape = roundShape)
                .align(Alignment.Center)
        ) {
            Pressable(
                onClick = onClick,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = roundShape)
                    .background(color = AppColors.white, shape = roundShape)
                    .border(width = border, color = AppColors.border, shape = roundShape)
            ) {
                Text(
                    text = "Create SMS Observer",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(16.dp)
                )
            }
        }
    }
}
