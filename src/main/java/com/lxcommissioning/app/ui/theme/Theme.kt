package com.lxcommissioning.app.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = LXBlue,
    onPrimary = LXWhite,
    secondary = LXBlueDark,
    surface = LXGray,
    onSurface = LXTextDark,
    error = LXDanger
)

private val DarkColorScheme = darkColorScheme(
    primary = LXBlue,
    onPrimary = LXWhite,
    surface = Color(0xFF121212),
    onSurface = LXGray,
    error = LXDanger
)

@Composable
fun LXTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
