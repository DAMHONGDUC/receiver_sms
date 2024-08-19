package com.receiver.sms.utils.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    background = md_theme_dark_background,
    onSecondary = md_theme_dark_onSecondary,
    onBackground = md_theme_dark_onBackground
)
private val LightColorPalette = lightColors(
    background = md_theme_light_background,
    onSecondary = md_theme_light_onSecondary,
    onBackground = md_theme_light_onBackground
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(colors.background)
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        content = content
    )
}