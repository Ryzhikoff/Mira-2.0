package ui.themes

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp
import mira.shared.generated.resources.Res
import mira.shared.generated.resources.wix_madefor_display
import org.jetbrains.compose.resources.Font

object Fonts {

    val title: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = FontFamily(Font(Res.font.wix_madefor_display, weight = FontWeight.Normal)),
            fontSize = 18.sp,
            lineHeight = 20.sp,
            letterSpacing = TextUnit(0.05f, TextUnitType.Sp),
        )

    val titleBold: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = FontFamily(Font(Res.font.wix_madefor_display, weight = FontWeight.Bold)),
            fontSize = 18.sp,
            lineHeight = 20.sp,
            letterSpacing = TextUnit(0.05f, TextUnitType.Sp),
        )

    val body: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = FontFamily(Font(Res.font.wix_madefor_display, weight = FontWeight.Medium)),
            fontSize = 14.sp,
            lineHeight = 18.sp,
            letterSpacing = TextUnit(0.01f, TextUnitType.Sp),
        )

    val notion: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = FontFamily(Font(Res.font.wix_madefor_display, weight = FontWeight.Bold)),
            fontSize = 12.sp,
            lineHeight = 16.sp,
            letterSpacing = TextUnit(0.05f, TextUnitType.Sp),
        )

    val dateNumber: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = FontFamily(Font(Res.font.wix_madefor_display, weight = FontWeight.ExtraBold)),
            fontSize = 22.sp,
            lineHeight = 24.sp,
            letterSpacing = TextUnit(0.05f, TextUnitType.Sp),
        )

    val links: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = FontFamily(Font(Res.font.wix_madefor_display, weight = FontWeight.Medium)),
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = TextUnit(0.01f, TextUnitType.Sp),
            textDecoration = TextDecoration.Underline
        )

    val buttons: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = FontFamily(Font(Res.font.wix_madefor_display, weight = FontWeight.SemiBold)),
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = TextUnit(0.01f, TextUnitType.Sp),
        )

    val bubbleText: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = FontFamily(Font(Res.font.wix_madefor_display, weight = FontWeight.Medium)),
            fontSize = 12.sp,
            lineHeight = 14.sp,
            letterSpacing = TextUnit(0.01f, TextUnitType.Sp),
        )

//    private fun jostMedium(): FontFamily = FontFamily(
//        Font(Res.font.jost_medium, weight = FontWeight.Medium)
//    )
//
//    val big: TextStyle
//        @Composable
//        get() = TextStyle(
//            fontFamily = jostMedium(),
//            fontSize = 25.sp,
//            letterSpacing = TextUnit(-0.041f, TextUnitType.Sp),
//            lineHeight = 22.sp
//        )
}