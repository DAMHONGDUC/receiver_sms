package com.receiver.sms.presentation.screens.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.receiver.sms.domain.model.SMSObserveModel
import com.receiver.sms.presentation.components.spacing.VerticalSpacing
import com.receiver.sms.utils.resources.AppColors
import com.receiver.sms.utils.resources.AppTextStyle

@Composable
fun SMSObserverRow(sms: SMSObserveModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = sms.sender,
            style = AppTextStyle().base
        )
        VerticalSpacing(value = 5.dp)
        Text(
            sms.body,
            style = AppTextStyle().small.copy(color = AppColors.subTextColor)
        )
    }
}
