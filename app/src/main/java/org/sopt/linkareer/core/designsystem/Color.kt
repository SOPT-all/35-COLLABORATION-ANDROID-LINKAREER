package org.sopt.linkareer.core.designsystem

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

// gray scale
val white = Color(0xFFFFFFFF)
val gray100 = Color(0xFFFAFAFA)
val gray200 = Color(0xFFF4F4F4)
val gray300 = Color(0xFFEDEDED)
val gray400 = Color(0xFFB9B9B9)
val gray500 = Color(0xFF989898)
val gray600 = Color(0xFF868686)
val gray700 = Color(0xFF4E4D4D)
val gray800 = Color(0xFF323232)
val gray900 = Color(0xFF202020)
val black = Color(0xFF000000)

// primary
val blue50 = Color(0xFFF5F6FA)
val blue100 = Color(0xFFE0F7FF)
val blue200 = Color(0xFFBFE8FF)
val blue = Color(0xFF01A0FE)

// alert/red
val red100 = Color(0xFFFCF0F0)
val red = Color(0xFFF2272A)

// alert/yellow
val yellow = Color(0xFFF3DB43)
val yellow400 = Color(0xFFFFC942)
val yellow500 = Color(0xFFFFAE16)

@Immutable
data class LINKareerColors(
    // gray scale
    val white: Color,
    val gray100: Color,
    val gray200: Color,
    val gray300: Color,
    val gray400: Color,
    val gray500: Color,
    val gray600: Color,
    val gray700: Color,
    val gray800: Color,
    val gray900: Color,
    val black: Color,
    // primary
    val blue50: Color,
    val blue100: Color,
    val blue200: Color,
    val blue: Color,
    // alert/red
    val red100: Color,
    val red: Color,
    // alert/yellow
    val yellow: Color,
    val yellow400: Color,
    val yellow500: Color,
)

val defaultLINKareerColors =
    LINKareerColors(
        // gray scale
        white = white,
        gray100 = gray100,
        gray200 = gray200,
        gray300 = gray300,
        gray400 = gray400,
        gray500 = gray500,
        gray600 = gray600,
        gray700 = gray700,
        gray800 = gray800,
        gray900 = gray900,
        black = black,
        // primary
        blue50 = blue50,
        blue100 = blue100,
        blue200 = blue200,
        blue = blue,
        // alert/red
        red100 = red100,
        red = red,
        // alert/yellow
        yellow = yellow,
        yellow400 = yellow400,
        yellow500 = yellow500,
    )

val LocalLINKareerColors =
    staticCompositionLocalOf {
        defaultLINKareerColors
    }
