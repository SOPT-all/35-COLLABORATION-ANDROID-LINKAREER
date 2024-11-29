package org.sopt.linkareer.core.designsystem.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val lightColorScheme =
    lightColorScheme(
        primary = Blue,
        background = White,
    )

object LINKareerTheme {
    val colors: LINKareerColors
        @Composable
        @ReadOnlyComposable
        get() = LocalLINKareerColors.current

    val typography: LINKareerTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalLINKareerTypography.current
}

@Composable
fun ProvideLINKareerColorsAndTypography(
    colors: LINKareerColors,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalLINKareerColors provides colors,
        content = content,
    )
}

@Composable
fun LINKareerAndroidTheme(
    backgroundColor: Color = Blue,
    content: @Composable () -> Unit,
) {
    val view = LocalView.current

    ProvideLINKareerColorsAndTypography(colors = defaultLINKareerColors) {
        if (!view.isInEditMode) {
            SideEffect {
                (view.context as Activity).window.run {
                    statusBarColor = backgroundColor.toArgb()
                    WindowCompat.getInsetsController(this, view).isAppearanceLightStatusBars = true
                }
            }
        }
        MaterialTheme(
            colorScheme = lightColorScheme,
            typography = Typography,
            content = content,
        )
    }
}
