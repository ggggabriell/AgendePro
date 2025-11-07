package com.agendepro.design_system.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun AgendeProTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    CompositionLocalProvider(LocalSpacing provides Spacing()) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}


private val DarkColorScheme = darkColorScheme(
    primary = Purple40,
    secondary = Pink40,
    background = Background,
    surface = Surface,
    onBackground = OnBackground,
    onSurface = OnSurface,
    onPrimary = OnPrimary,
    onSecondary = OnSecondary,
    error = Error,
    onError = OnError
)

private val LightColorScheme = lightColorScheme(
    primary = Purple80,
    secondary = Pink80,
    background = Background,
    surface = Surface,
    onBackground = OnBackground,
    onSurface = OnSurface,
    onPrimary = OnPrimary,
    onSecondary = OnSecondary,
    error = Error,
    onError = OnError
)
