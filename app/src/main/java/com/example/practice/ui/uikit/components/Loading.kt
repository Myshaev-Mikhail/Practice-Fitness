package com.example.practice.ui.uikit.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.tooling.preview.Preview
import io.github.composegears.valkyrie.Check
import io.github.composegears.valkyrie.Icons
import kotlinx.coroutines.delay

@Composable
fun Loading(
    modifier: Modifier = Modifier.fillMaxWidth(),
    isLoading: Boolean,
    color: Color = MaterialTheme.colorScheme.primary,
) {
    var dotCount by remember { mutableStateOf(0) }

    LaunchedEffect(isLoading) {
        dotCount = 0
        while (isLoading) {
            delay(400L)
            dotCount = (dotCount + 1) % 8
        }
    }

    BoxWithConstraints(
        modifier = modifier.aspectRatio(1f),
        contentAlignment = Alignment.Center
    ) {
        val circleDiameter = minOf(maxWidth, maxHeight) * 0.8f

        Canvas(modifier = Modifier.matchParentSize()) {
            val canvasWidth = size.width
            val canvasHeight = size.height
            val center = Offset(x = canvasWidth / 2, y = canvasHeight / 2)

            val mainCircleRadius = size.minDimension / 2 * 0.8f
            val strokeWidth = mainCircleRadius * 2 * 0.05f
            val innerDiameter = mainCircleRadius * 2 - strokeWidth

            drawCircle(
                color = color,
                radius = mainCircleRadius,
                center = center,
                style = Stroke(width = strokeWidth)
            )
            if (isLoading) {
                val dotRadius = innerDiameter * 0.09f
                val dotsWidth = innerDiameter * 0.9f
                val dotSpacing = (dotsWidth - dotRadius * 2) / 2

                val startX = center.x - dotSpacing

                for (i in 0 until dotCount) {
                    drawCircle(
                        color = color,
                        radius = dotRadius,
                        center = Offset(
                            x = startX + (i * dotSpacing),
                            y = center.y
                        )
                    )
                }
            }
        }

        if (!isLoading) {
            Icon(
                modifier = Modifier.size(circleDiameter * 0.6f),
                painter = rememberVectorPainter(Icons.Check),
                contentDescription = null,
                tint = color
            )
        }
    }
}

@Preview(widthDp = 100, heightDp = 100)
@Composable
fun LoadingPreview() {
    Loading(
        isLoading = false
    )
}
