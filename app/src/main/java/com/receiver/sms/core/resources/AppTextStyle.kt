package com.receiver.sms.core.resources

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.receiver.sms.R

class AppTextStyle {
    private val mainTextStyle = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.roboto_black_900, FontWeight.Black),
            Font(R.font.roboto_bold_700, FontWeight.Bold),
            Font(R.font.roboto_medium_500, FontWeight.Medium),
            Font(R.font.roboto_regular_400, FontWeight.Normal),
            Font(R.font.roboto_light_300, FontWeight.Light),
            Font(R.font.roboto_thin_100, FontWeight.Thin),
        ),
        color = AppColors.mainContent
    )
    val xLarge: TextStyle = mainTextStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = AppTextSize.xLarge
    )
    val large: TextStyle = mainTextStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = AppTextSize.large
    )
    val xMedium: TextStyle = mainTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = AppTextSize.xMedium
    )
    val medium: TextStyle = mainTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = AppTextSize.medium
    )
    val xBase: TextStyle = mainTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = AppTextSize.xBase
    )
    val base: TextStyle = mainTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = AppTextSize.base
    )
    val small: TextStyle = mainTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = AppTextSize.small
    )
    val xSmall: TextStyle = mainTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = AppTextSize.xSmall
    )
}

// Extension functions for TextStyle
fun TextStyle.wFontWeight() = copy(fontWeight = FontWeight.Normal)