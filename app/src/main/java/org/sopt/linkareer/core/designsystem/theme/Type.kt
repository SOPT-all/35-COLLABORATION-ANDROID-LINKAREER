package org.sopt.linkareer.core.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import org.sopt.linkareer.R

// Set of Material typography styles to start with
val Typography =
    Typography(
        bodyLarge =
            TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp,
            ),
        /* Other default text styles to override
        titleLarge = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 22.sp,
            lineHeight = 28.sp,
            letterSpacing = 0.sp
        ),
        labelSmall = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Medium,
            fontSize = 11.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.5.sp
        ) */
    )

@Immutable
data class LINKareerTypography(
    // Title
    val title1B18: TextStyle,
    val title2B17: TextStyle,
    val title3B16: TextStyle,
    val title4B15: TextStyle,
    val title5B14: TextStyle,
    // Body
    val body1B16: TextStyle,
    val body2B14: TextStyle,
    val body3B13: TextStyle,
    val body4B12: TextStyle,
    val body5B11: TextStyle,
    val body6M15: TextStyle,
    val body7M14: TextStyle,
    val body8M13: TextStyle,
    val body9M12: TextStyle,
    val body10M11: TextStyle,
    val body11M10: TextStyle,
    val body12R12: TextStyle,
    val body13R11: TextStyle,
    val body14R10: TextStyle,
    // Label
    val label1B11: TextStyle,
    val label2B10: TextStyle,
    val label3M11: TextStyle,
    val label4M10: TextStyle,
    val label5M8: TextStyle,
)

val defaultLINKareerTypography =
    LINKareerTypography(
        // Title
        title1B18 =
            TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_kr_bold)),
                fontWeight = FontWeight.W700,
                lineHeight = 1.0.em,
                letterSpacing = (-0.02).em,
            ),
        title2B17 =
            TextStyle(
                fontSize = 17.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_kr_bold)),
                fontWeight = FontWeight.W700,
                lineHeight = 1.0.em,
                letterSpacing = (-0.05).em,
            ),
        title3B16 =
            TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_kr_bold)),
                fontWeight = FontWeight.W700,
                lineHeight = 1.0.em,
                letterSpacing = (-0.01).em,
            ),
        title4B15 =
            TextStyle(
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_kr_bold)),
                fontWeight = FontWeight.W700,
                lineHeight = 1.0.em,
                letterSpacing = (-0.02).em,
            ),
        title5B14 =
            TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_kr_bold)),
                fontWeight = FontWeight.W700,
                lineHeight = 1.0.em,
                letterSpacing = 0.01.em,
            ),
        // Body
        body1B16 =
            TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_kr_bold)),
                fontWeight = FontWeight.W700,
                lineHeight = 1.0.em,
                letterSpacing = (-0.01).em,
            ),
        body2B14 =
            TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_kr_bold)),
                fontWeight = FontWeight.W700,
                lineHeight = 1.0.em,
                letterSpacing = 0.01.em,
            ),
        body3B13 =
            TextStyle(
                fontSize = 13.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_kr_bold)),
                fontWeight = FontWeight.W700,
                lineHeight = 1.0.em,
                letterSpacing = (-0.03).em,
            ),
        body4B12 =
            TextStyle(
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_kr_bold)),
                fontWeight = FontWeight.W700,
                lineHeight = 1.5.em,
                letterSpacing = (-0.01).em,
            ),
        body5B11 =
            TextStyle(
                fontSize = 11.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_kr_bold)),
                fontWeight = FontWeight.W700,
                lineHeight = 1.5.em,
                letterSpacing = (-0.05).em,
            ),
        body6M15 =
            TextStyle(
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_kr_medium)),
                fontWeight = FontWeight.W500,
                lineHeight = 1.0.em,
                letterSpacing = (-0.03).em,
            ),
        body7M14 =
            TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_kr_medium)),
                fontWeight = FontWeight.W500,
                lineHeight = 1.0.em,
                letterSpacing = (-0.04).em,
            ),
        body8M13 =
            TextStyle(
                fontSize = 13.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_kr_medium)),
                fontWeight = FontWeight.W500,
                lineHeight = 1.5.em,
                letterSpacing = (-0.04).em,
            ),
        body9M12 =
            TextStyle(
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_kr_medium)),
                fontWeight = FontWeight.W500,
                lineHeight = 1.5.em,
                letterSpacing = (-0.05).em,
            ),
        body10M11 =
            TextStyle(
                fontSize = 11.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_kr_medium)),
                fontWeight = FontWeight.W500,
                lineHeight = 1.75.em,
                letterSpacing = (-0.05).em,
            ),
        body11M10 =
            TextStyle(
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_kr_medium)),
                fontWeight = FontWeight.W500,
                lineHeight = 1.75.em,
                letterSpacing = (-0.01).em,
            ),
        body12R12 =
            TextStyle(
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_kr_regular)),
                fontWeight = FontWeight.W400,
                lineHeight = 1.5.em,
                letterSpacing = (-0.03).em,
            ),
        body13R11 =
            TextStyle(
                fontSize = 11.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_kr_regular)),
                fontWeight = FontWeight.W400,
                lineHeight = 1.75.em,
                letterSpacing = (-0.01).em,
            ),
        body14R10 =
            TextStyle(
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_kr_regular)),
                fontWeight = FontWeight.W400,
                lineHeight = 1.75.em,
                letterSpacing = (-0.01).em,
            ),
        // Label
        label1B11 =
            TextStyle(
                fontSize = 11.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_kr_bold)),
                fontWeight = FontWeight.W700,
                lineHeight = 1.0.em,
                letterSpacing = (-0.03).em,
            ),
        label2B10 =
            TextStyle(
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_kr_bold)),
                fontWeight = FontWeight.W700,
                lineHeight = 1.0.em,
                letterSpacing = (-0.04).em,
            ),
        label3M11 =
            TextStyle(
                fontSize = 11.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_kr_medium)),
                fontWeight = FontWeight.W500,
                lineHeight = 1.0.em,
                letterSpacing = (-0.05).em,
            ),
        label4M10 =
            TextStyle(
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_kr_medium)),
                fontWeight = FontWeight.W500,
                lineHeight = 1.0.em,
                letterSpacing = (-0.04).em,
            ),
        label5M8 =
            TextStyle(
                fontSize = 8.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_kr_medium)),
                fontWeight = FontWeight.W500,
                lineHeight = 1.0.em,
                letterSpacing = (-0.04).em,
            ),
    )

val LocalLINKareerTypography = staticCompositionLocalOf { defaultLINKareerTypography }
