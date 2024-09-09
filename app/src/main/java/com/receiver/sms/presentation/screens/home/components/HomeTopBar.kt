package com.receiver.sms.presentation.screens.home.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.receiver.sms.presentation.components.CustomTopBar
import com.receiver.sms.presentation.components.Pressable
import com.receiver.sms.utils.resources.AppColors
import com.receiver.sms.utils.resources.AppIconSize
import com.receiver.sms.utils.resources.AppTextStyle

@Composable
fun HomeTopBar() {
    CustomTopBar(
        bg = AppColors.primary,
        mainColor = AppColors.white,
        title = "SMS Observer",
        textStyle = AppTextStyle().base.copy(fontWeight = FontWeight.SemiBold),
        enableBack = false,
        elevation = 0.dp,
        topBarAction = {
            Pressable(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = "",
                    tint = AppColors.white,
                    modifier = Modifier
                        .padding(6.dp)
                        .size(AppIconSize().base())
                )
            }
        }
    )
}
