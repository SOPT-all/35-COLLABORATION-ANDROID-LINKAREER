package org.sopt.linkareer.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

// gray scale
val White = Color(0xFFFFFFFF)
val Gray100 = Color(0xFFFAFAFA)
val Gray200 = Color(0xFFF4F4F4)
val Gray300 = Color(0xFFEDEDED)
val Gray400 = Color(0xFFB9B9B9)
val Gray500 = Color(0xFF989898)
val Gray600 = Color(0xFF868686)
val Gray700 = Color(0xFF4E4D4D)
val Gray800 = Color(0xFF323232)
val Gray900 = Color(0xFF202020)
val Black = Color(0xFF000000)

// primary
val Blue50 = Color(0xFFF5F6FA)
val Blue100 = Color(0xFFE0F7FF)
val Blue200 = Color(0xFFBFE8FF)
val Blue = Color(0xFF01A0FE)

// alert/red
val Red100 = Color(0xFFFCF0F0)
val Red = Color(0xFFF2272A)

// alert/yellow
val Yellow = Color(0xFFF3DB43)
val Yellow400 = Color(0xFFFFC942)
val Yellow500 = Color(0xFFFFAE16)

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
        white = White,
        gray100 = Gray100,
        gray200 = Gray200,
        gray300 = Gray300,
        gray400 = Gray400,
        gray500 = Gray500,
        gray600 = Gray600,
        gray700 = Gray700,
        gray800 = Gray800,
        gray900 = Gray900,
        black = Black,
        // primary
        blue50 = Blue50,
        blue100 = Blue100,
        blue200 = Blue200,
        blue = Blue,
        // alert/red
        red100 = Red100,
        red = Red,
        // alert/yellow
        yellow = Yellow,
        yellow400 = Yellow400,
        yellow500 = Yellow500,
    )

val LocalLINKareerColors =
    staticCompositionLocalOf {
        defaultLINKareerColors
    }
