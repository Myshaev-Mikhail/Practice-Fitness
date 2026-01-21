package com.example.practice.ui.uikit.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Purple,
    onPrimary = White,

    secondary = LimeGreen,
    onSecondary = Black,

    tertiary = LightPurple,
    onTertiary = Black,

    background = Black,
    onBackground = White,

    outline = White,
    outlineVariant = Black,
)

private val LightColorScheme = lightColorScheme(
    primary = Purple,
    onPrimary = Black,

    secondary = LimeGreen,
    onSecondary = Black,

    tertiary = LightPurple,
    onTertiary = Black,

    background = White,
    onBackground = Black,

    outline = Black,
    outlineVariant = White,
)

@Composable
fun FitnessTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    val view = LocalView.current

    SideEffect {
        val window = (view.context as android.app.Activity).window
        window.statusBarColor = Color.Transparent.toArgb()

        WindowCompat.getInsetsController(window, view).apply {
            isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}