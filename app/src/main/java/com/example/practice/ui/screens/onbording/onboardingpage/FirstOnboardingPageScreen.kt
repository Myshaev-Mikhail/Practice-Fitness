package com.example.practice.ui.screens.onbording.onboardingpage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.R
import com.example.practice.ui.uikit.theme.LeagueSpartan
import com.example.practice.ui.uikit.theme.Poppins

@Composable
fun FirstOnboardingPageScreen() {
    Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.secondary)) {
        Image(
            painter = painterResource(id = R.mipmap.beautiful_young_sporty_woman_training_workout_gym),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(modifier = Modifier.align(Alignment.Center)) {
            Text(
                text = "Welcom to",
                color = MaterialTheme.colorScheme.secondary,
                style = TextStyle(
                    fontFamily = LeagueSpartan,
                    fontSize = 24.sp,
                    fontWeight = Bold
                ),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Image(
                painter = painterResource(id = R.mipmap.ic_logo),
                contentDescription = null,
                modifier = Modifier.size(height = 120.dp, width = 180.dp)
            )
            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    text = "FIT",
                    color = MaterialTheme.colorScheme.secondary,
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontSize = 36.sp,
                        fontWeight = Bold
                    )
                )
                Text(
                    text = "BODY",
                    color = MaterialTheme.colorScheme.secondary,
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontSize = 36.sp,
                        fontWeight = Normal
                    ),
                    modifier = Modifier.padding(start = 2.dp)
                )
            }
        }
    }
}