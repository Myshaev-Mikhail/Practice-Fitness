package com.example.practice.ui.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun WorkoutHeader(
    badgeText: String,
    timeText: String,
    caloriesText: String,
    mainImage: Painter,
    title: String? = "",
    subtitle: String? = ""
) {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.tertiary)
            .padding(start = 24.dp, top = 24.dp, end = 24.dp, bottom = 24.dp)
    ) {
        RecipeCard(
            badgeText = badgeText,
            timeText = timeText,
            caloriesText = caloriesText,
            mainImage = mainImage,
        )
    }

    if (title != null) {
        Spacer(Modifier.height(24.dp))
        Text(
            modifier = Modifier.padding(start = 24.dp),
            text = title,
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.titleLarge
        )
    Spacer(Modifier.height(4.dp))
    }

    if (subtitle != null) {
        Text(
            modifier = Modifier.padding(start = 24.dp),
            text = subtitle,
            color = MaterialTheme.colorScheme.outline,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(16.dp))
    }
}