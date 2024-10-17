package com.receiver.sms.presentation.components.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.receiver.sms.core.resources.AppColors
import com.receiver.sms.core.resources.AppTextStyle

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: Dp = 5.dp,
    backgroundColor: Color = AppColors.primary,
    borderRadius: Dp = 100.dp,
    elevation: Dp = 2.dp,
    fillMaxWidth: Boolean = false
) {
    Button(
        onClick = onClick,
        modifier = if (fillMaxWidth) {
            modifier.fillMaxWidth()
        } else {
            modifier
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = AppColors.white,
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.LightGray,
        ),
        shape = RoundedCornerShape(borderRadius),
        elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = elevation)
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(contentPadding),
            style = AppTextStyle().medium.copy(
                color = AppColors.white,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}