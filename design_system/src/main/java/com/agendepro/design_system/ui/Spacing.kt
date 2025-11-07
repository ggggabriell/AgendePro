package com.agendepro.design_system.ui

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Design system spacing values
 * Following Material Design 3 spacing guidelines (4dp grid system)
 */
data class Spacing(
    val none: Dp = 0.dp,
    val extraSmall: Dp = 4.dp,
    val small: Dp = 8.dp,
    val medium: Dp = 16.dp,
    val large: Dp = 24.dp,
    val extraLarge: Dp = 32.dp,
    val extraExtraLarge: Dp = 40.dp,
    val huge: Dp = 48.dp,
    val extraHuge: Dp = 64.dp,

    val buttonPadding: Dp = 16.dp,
    val cardPadding: Dp = 16.dp,
    val screenPadding: Dp = 16.dp,
    val itemSpacing: Dp = 8.dp,
    val sectionSpacing: Dp = 24.dp,
    val iconPadding: Dp = 12.dp,
    val dividerPadding: Dp = 8.dp
)

/**
 * CompositionLocal for accessing spacing throughout the app
 */
val LocalSpacing = staticCompositionLocalOf { Spacing() }

/**
 * Extension property to access spacing from MaterialTheme
 * Usage: MaterialTheme.spacing.medium
 */
object MaterialThemeExtensions {
    val androidx.compose.material3.MaterialTheme.spacing: Spacing
        @androidx.compose.runtime.Composable
        @androidx.compose.runtime.ReadOnlyComposable
        get() = LocalSpacing.current
}
