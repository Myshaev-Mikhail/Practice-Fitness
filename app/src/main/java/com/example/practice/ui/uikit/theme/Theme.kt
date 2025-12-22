package com.example.practice.ui.uikit.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

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
    onPrimary = White,

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

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}