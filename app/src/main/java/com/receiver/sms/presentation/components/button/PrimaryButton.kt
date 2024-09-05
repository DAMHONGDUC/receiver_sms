package com.receiver.sms.presentation.components.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.receiver.sms.utils.resources.AppBoxModel
import com.receiver.sms.utils.resources.AppColors
import com.receiver.sms.utils.resources.AppTextStyle

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = AppColors.primary,
    borderRadius: Dp = 100.dp,
    elevation: Dp = 2.dp
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = AppColors.white,
            disabledBackgroundColor = Color.Gray,
            disabledContentColor = Color.LightGray,
        ),
        shape = RoundedCornerShape(borderRadius),
        elevation = ButtonDefaults.elevation(defaultElevation = elevation)
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(vertical = AppBoxModel().haftMainPadding()),
            style = AppTextStyle().medium.copy(
                color = AppColors.white,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}