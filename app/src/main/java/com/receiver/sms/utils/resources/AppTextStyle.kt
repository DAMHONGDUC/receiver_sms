package com.receiver.sms.utils.resources

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.receiver.sms.R

class AppTextStyle {
    private val CustomFontFamily = FontFamily(
        Font(R.font.roboto_black_900, FontWeight.Black),
        Font(R.font.roboto_bold_700, FontWeight.Bold),
        Font(R.font.roboto_medium_500, FontWeight.Medium),
        Font(R.font.roboto_regular_400, FontWeight.Normal),
        Font(R.font.roboto_light_300, FontWeight.Light),
        Font(R.font.roboto_thin_100, FontWeight.Thin),
    )
    val xLarge: TextStyle = TextStyle(
        fontFamily = CustomFontFamily,
        fontWeight = FontWeight.Black,
        fontSize = 21.sp,
        color = AppColors.textColor
    )
    val large: TextStyle = TextStyle(
        fontFamily = CustomFontFamily,
        fontWeight = FontWeight.Black,
        fontSize = 20.sp,
        color = AppColors.textColor
    )
    val medium: TextStyle = TextStyle(
        fontFamily = CustomFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        color = AppColors.textColor
    )
    val base: TextStyle = TextStyle(
        fontFamily = CustomFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = AppColors.textColor
    )
    val small: TextStyle = TextStyle(
        fontFamily = CustomFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = AppColors.textColor
    )
    val xSmall: TextStyle = TextStyle(
        fontFamily = CustomFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = AppColors.textColor
    )

}

// Extension functions for TextStyle
fun TextStyle.wFontWeight() = copy(fontWeight = FontWeight.Normal)