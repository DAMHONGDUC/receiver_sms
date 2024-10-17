package com.receiver.sms.presentation.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.receiver.sms.core.resources.AppBoxModel
import com.receiver.sms.core.resources.AppColors
import com.receiver.sms.core.resources.AppIconSize
import com.receiver.sms.core.resources.AppTextStyle
import com.receiver.sms.core.resources.wGreyText
import com.receiver.sms.domain.model.SMSObserveModel
import com.receiver.sms.presentation.components.Pressable
import com.receiver.sms.presentation.components.spacing.VerticalSpacing

@Composable
fun SMSObserverRow(sms: SMSObserveModel) {
    Pressable(
        clip = (RoundedCornerShape(AppBoxModel.normalClip)),
        onClick = { /*TODO*/ }) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.padding(
                    vertical = AppBoxModel.padding,
                    horizontal = AppBoxModel.padding + 4.dp
                )
            ) {
                Text(
                    text = sms.sender,
                    style = AppTextStyle().base
                )
                VerticalSpacing(value = 5.dp)
                Text(
                    sms.body,
                    style = AppTextStyle().small.wGreyText()
                )
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Filled.MoreVert,
                    contentDescription = "",
                    tint = AppColors.iconColor,
                    modifier = Modifier
                        .size(AppIconSize.base)
                )
            }
        }
    }
}
