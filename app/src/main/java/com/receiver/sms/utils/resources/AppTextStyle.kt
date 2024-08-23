package com.receiver.sms.utils.resources

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.receiver.sms.R

class AppTextStyle {
    val CustomFontFamily = FontFamily(
        Font(R.font.poppins_bold, FontWeight.Bold),
        Font(R.font.poppins_medium, FontWeight.Medium),
        Font(R.font.poppins_medium, FontWeight.Normal),
        Font(R.font.poppins_semi_bold, FontWeight.SemiBold)
    )
    val xLarge: TextStyle = TextStyle(
        fontFamily = CustomFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = AppColors.textColor
    )
    val large: TextStyle = TextStyle(
        fontFamily = CustomFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 19.sp,
        color = AppColors.textColor
    )
    val medium: TextStyle = TextStyle(
        fontFamily = CustomFontFamily,
        fontWeight = FontWeight.Normal,
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