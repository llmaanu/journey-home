package br.senai.sp.jandira.jouneyperfil.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object AppThemeColors {
    // CORES DO MODO CLARO
    val LightPrimary = Color(0xFF341E9B)
    val LightSecondary = Color(0xFF7A68C2)
    val LightBackground = Color(0xFFF0E5FF)
    val LightText = Color.Black
    val LightTextOnPrimary = Color.White
    val LightTextOnSecondary = Color.White
    val LightCard = Color(0xFF341E9B)


    val DarkPrimary = Color(0xFF1F1B38)
    val DarkSecondary = Color(0xFF3C3456)
    val DarkBackground = Color(0xFF121212)
    val DarkText = Color.White
    val DarkTextOnPrimary = Color.White
    val DarkTextOnSecondary = Color.White
    val DarkCard = Color(0xFF1F1B38)
}


private val DarkColorPalette = darkColorScheme(
    primary = AppThemeColors.DarkPrimary,
    secondary = AppThemeColors.DarkSecondary,
    background = AppThemeColors.DarkBackground,
    surface = AppThemeColors.DarkBackground,
    onPrimary = AppThemeColors.DarkTextOnPrimary,
    onBackground = AppThemeColors.DarkText,
    onSurface = AppThemeColors.DarkText
)

private val LightColorPalette = lightColorScheme(
    primary = AppThemeColors.LightPrimary,
    secondary = AppThemeColors.LightSecondary,
    background = AppThemeColors.LightBackground,
    surface = AppThemeColors.LightBackground,
    onPrimary = AppThemeColors.LightTextOnPrimary,
    onBackground = AppThemeColors.LightText,
    onSurface = AppThemeColors.LightText
)


@Composable
fun JouneyperfilTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        content = content
    )
}