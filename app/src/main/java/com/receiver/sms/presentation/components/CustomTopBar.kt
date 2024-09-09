package com.receiver.sms.presentation.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.receiver.sms.utils.resources.AppColors
import com.receiver.sms.utils.resources.AppIconSize
import com.receiver.sms.utils.resources.AppTextStyle

@Composable
fun CustomTopBar(
    onBack: () -> Unit = {},
    enableBack: Boolean = true,
    title: String,
    bg: Color = AppColors.primary,
    mainColor: Color = AppColors.white,
    elevation: Dp = 4.dp,
    textStyle: TextStyle = AppTextStyle().xLarge,
    topBarAction: @Composable() (RowScope.() -> Unit) = {}
) {
    TopAppBar(
        modifier = Modifier.height(50.dp),
        backgroundColor = bg,
        navigationIcon = if (enableBack) {
            {
                IconButton(onClick = onBack) {
                    Icon(
                        modifier = Modifier.size(AppIconSize().base()),
                        imageVector = Icons.Filled.ArrowBackIosNew,
                        contentDescription = "backIcon",
                        tint = mainColor
                    )
                }
            }
        } else null,
        elevation = elevation,
        title = {
            Text(
                title,
                style = textStyle.copy(
                    color = mainColor
                )
            )
        },
        actions = topBarAction
    )
}