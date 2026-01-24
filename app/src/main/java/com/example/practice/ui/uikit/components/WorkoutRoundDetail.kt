package com.example.practice.ui.uikit.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import io.github.composegears.valkyrie.Icons
import io.github.composegears.valkyrie.PlayOff
import io.github.composegears.valkyrie.StarVariant

@Composable
fun WorkoutRoundDetail(
    image: Painter,
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.tertiary)
            .padding(24.dp)
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Image(
            modifier = Modifier
                .align(Alignment.Center)
                .size(80.dp),
            painter = rememberVectorPainter(image = Icons.PlayOff),
            contentDescription = null,
            )

        Image(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .size(22.dp)
                .offset(x = -(16.dp), y = 16.dp),
            painter = rememberVectorPainter(image = Icons.StarVariant),
            contentDescription = null,
        )
    }
}