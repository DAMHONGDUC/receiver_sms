package com.receiver.sms.presentation.components.empty

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.receiver.sms.R
import com.receiver.sms.presentation.components.spacing.VerticalSpacing
import com.receiver.sms.core.resources.AppColors
import com.receiver.sms.core.resources.AppTextStyle

@Composable
fun CustomEmpty() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "SMS Observer empty",
                style = AppTextStyle().small.copy(color = AppColors.emptyColor)
            )
            VerticalSpacing()
            Icon(
                painter = painterResource(id = R.drawable.data_empty),
                contentDescription = "Description of Icon",
                modifier = Modifier.size(20.dp),
                tint = AppColors.emptyColor
            )
        }
    }
}