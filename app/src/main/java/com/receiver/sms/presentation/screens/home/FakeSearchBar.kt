package com.receiver.sms.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.receiver.sms.core.resources.AppBoxModel
import com.receiver.sms.core.resources.AppColors
import com.receiver.sms.core.resources.AppIconSize
import com.receiver.sms.core.resources.AppTextStyle
import com.receiver.sms.core.resources.wGreyText
import com.receiver.sms.presentation.components.Pressable
import com.receiver.sms.presentation.components.spacing.HorizontalSpacing

@Composable
fun FakeSearchBar() {
    Pressable(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(AppBoxModel.circleClip))
            .background(AppColors.textFieldBGGrey),
        onClick = {}
    )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(
                    horizontal = AppBoxModel.padding,
                    vertical = 12.dp
                )
        ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = null,
                tint = AppColors.mainContent,
                modifier = Modifier.size(AppIconSize.xBase)
            )
            HorizontalSpacing()
            Text(
                text = "Search observe number",
                style = AppTextStyle().xBase.wGreyText()
            )
        }
    }

}