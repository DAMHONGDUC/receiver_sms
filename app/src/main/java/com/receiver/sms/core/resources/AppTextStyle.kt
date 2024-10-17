package com.receiver.sms.core.resources

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.receiver.sms.core.theme.CustomFontFamily

class AppTextStyle {
    private val mainTextStyle = TextStyle(
        fontFamily = CustomFontFamily,
        fontWeight = FontWeight.Medium,
        color = AppColors.mainContent
    )
    val xLarge: TextStyle = mainTextStyle.copy(
        fontSize = AppTextSize.xLarge
    )
    val large: TextStyle = mainTextStyle.copy(
        fontSize = AppTextSize.large
    )
    val xMedium: TextStyle = mainTextStyle.copy(
        fontSize = AppTextSize.xMedium
    )
    val medium: TextStyle = mainTextStyle.copy(
        fontSize = AppTextSize.medium
    )
    val xBase: TextStyle = mainTextStyle.copy(
        fontSize = AppTextSize.xBase
    )
    val base: TextStyle = mainTextStyle.copy(
        fontSize = AppTextSize.base
    )
    val small: TextStyle = mainTextStyle.copy(
        fontSize = AppTextSize.small
    )
    val xSmall: TextStyle = mainTextStyle.copy(
        fontSize = AppTextSize.xSmall
    )
}

// Extension functions for TextStyle
fun TextStyle.wSemiBold() = copy(fontWeight = FontWeight.SemiBold)
fun TextStyle.wGreyText() = copy(color = AppColors.subContent)