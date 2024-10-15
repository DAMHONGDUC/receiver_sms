package com.receiver.sms.presentation.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.receiver.sms.presentation.components.Pressable
import com.receiver.sms.presentation.components.spacing.VerticalSpacing
import com.receiver.sms.core.resources.AppColors
import com.receiver.sms.core.resources.AppIconSize
import com.receiver.sms.core.resources.AppTextStyle

@Composable
fun CreateSMSObserverButton(
    height: Dp = 100.dp,
    onClick: () -> Unit,
    borderRadius: Dp = 8.dp,
    border: Dp = 1.dp,
    elevation: Dp = 8.dp,
    paddingHorizontal: Dp = 100.dp
) {
    val roundShape = RoundedCornerShape(borderRadius)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
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
                clip = roundShape,
                onClick = onClick,
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = AppColors.white, shape = roundShape)
                    .border(width = border, color = AppColors.border, shape = roundShape)
            ) {
                Column(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        Icons.Filled.Add, contentDescription = "", modifier = Modifier
                            .size(AppIconSize().xBase())
                    )
                    VerticalSpacing(value = 5.dp)
                    Text("Create SMS Observer", style = AppTextStyle().small)
                }
            }
        }
    }
}
