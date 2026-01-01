package com.example.practice.ui.uikit.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
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
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    ),

    bodyMedium = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 13.sp
    ),

    titleSmall = TextStyle(
        fontFamily = LeagueSpartan,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    ),

    bodySmall = TextStyle(
        fontFamily = LeagueSpartan,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp
    ),

    labelMedium = TextStyle(
        fontFamily = LeagueSpartan,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp
    ),

    titleMedium = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),

    titleLarge = TextStyle(
        fontFamily = Poppins,
        fontWeight = Bold,
        fontSize = 20.sp
    )
)