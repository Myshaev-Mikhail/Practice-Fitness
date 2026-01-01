package com.example.practice.ui.screens.onbording.onboardingpage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import io.github.composegears.valkyrie.Arrow
import io.github.composegears.valkyrie.Icons

@Composable
fun OnboardingPageScreen(
    page: OnboardingPage,
    currentPage: Int,
    totalPages: Int,
    onSkip: () -> Unit
) {
    Box(Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(page.imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        if (currentPage != 3) {
            Button(
                modifier = Modifier
                    .align(alignment = Alignment.TopEnd)
                    .padding(top = 40.dp),
                onClick = onSkip,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Text(
                    "Skip",
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(end = 4.dp)
                )

                Image(
                    painter = rememberVectorPainter(image = Icons.Arrow),
                    contentDescription = "skip",
                    modifier = Modifier
                        .graphicsLayer(scaleX = -1f)
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .background(MaterialTheme.colorScheme.tertiary)
                .padding(start = 24.dp, top = 12.dp, end = 24.dp, bottom = 12.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = rememberVectorPainter(page.icon),
                    contentDescription = null,
                    modifier = Modifier.size(35.dp),
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.secondary)
                )

                Text(
                    text = page.title,
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.titleLarge
                )

                Text(
                    text = page.description,
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.titleLarge
                )
                Row(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    repeat(totalPages - 1) { index ->
                        val selected = currentPage == index + 1

                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .size(width = 28.dp, height = 4.dp)
                                .background(
                                    color = if (selected)
                                        MaterialTheme.colorScheme.onPrimary
                                    else
                                        MaterialTheme.colorScheme.primary,
                                    shape = RoundedCornerShape(50)
                                )
                        )
                    }
                }
            }
        }
    }
}