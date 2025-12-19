package com.example.practice.ui.uikit.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.unit.sp
import com.example.practice.R

val LeagueSpartan = FontFamily(
    Font(R.font.league_spartan_bold, FontWeight.Bold),
    Font(R.font.league_spartan_light, FontWeight.Light),
    Font(R.font.league_spartan_medium, FontWeight.Medium,),
    Font(R.font.league_spartan_regular, FontWeight.Normal),
    Font(R.font.league_spartan_semibold, FontWeight.SemiBold),
    Font(R.font.league_spartan_thin, FontWeight.Thin),
)

val Poppins = FontFamily(
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_light, FontWeight.Light),
    Font(R.font.poppins_medium, FontWeight.Medium,),
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_thin, FontWeight.Thin),
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    labelLarge = TextStyle(
        fontFamily = LeagueSpartan,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),

    labelSmall = TextStyle(
        fontFamily = LeagueSpartan,
        fontSize = 10.sp,
        fontWeight = FontWeight.Normal
    ),

    // Обычный текст / подписи (Poppins 13sp Medium)
    bodyMedium = TextStyle(
        fontFamily = Poppins,
        fontSize = 13.sp,
        fontWeight = FontWeight.Medium
    ),//////////////////////////////////////////////////////

    // Акцент / небольшой заголовок (LeagueSpartan 14sp SemiBold)
    titleSmall = TextStyle(
        fontFamily = LeagueSpartan,
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold
    ),////////////////////////////////

    // Вторичный текст (LeagueSpartan 14sp Light)
    bodySmall = TextStyle(
        fontFamily = LeagueSpartan,
        fontSize = 14.sp,
        fontWeight = FontWeight.Light
    )////////////////
)