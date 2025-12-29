package com.example.practice.ui.uikit.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import io.github.composegears.valkyrie.Calories
import io.github.composegears.valkyrie.Icons
import io.github.composegears.valkyrie.StartSmallOn
import io.github.composegears.valkyrie.TimeDefault

@Composable
fun RecipeCard(
    badgeText: String,
    title: String? = null,
    timeText: String,
    caloriesText: String,
    mainImage: Painter,
    modifier: Modifier = Modifier,
    colorFilterStar: Color? = null
) {
    Box(
        modifier = modifier
            .wrapContentSize()
            .clip(RoundedCornerShape(24.dp))
    ) {
        Image(
            painter = mainImage,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )

        Box(
            modifier = Modifier
                .offset(x = 8.dp)
                .align(Alignment.TopEnd)
                .background(
                    color = MaterialTheme.colorScheme.secondary,
                    shape = RoundedCornerShape(
                        topStart = 50.dp,
                        topEnd = 50.dp,
                        bottomStart = 50.dp,
                        bottomEnd = 0.dp
                    )
                )
                .padding(horizontal = 20.dp, vertical = 6.dp)
        ) {
            Text(
                text = badgeText,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth()
                .background(
                    color = Color.Black.copy(alpha = 0.6f),
                    shape = RoundedCornerShape(
                        bottomStart = 24.dp,
                        bottomEnd = 24.dp
                    )
                )
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(end = 32.dp)
            ) {
                if (title != null) {
                    Text(
                        text = title,
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(modifier = Modifier.height(6.dp))
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = rememberVectorPainter(Icons.TimeDefault),
                        contentDescription = null,
                        modifier = Modifier.size(9.dp)
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = timeText,
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.labelMedium
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Image(
                        painter = rememberVectorPainter(Icons.Calories),
                        contentDescription = null,
                        modifier = Modifier
                            .width(7.dp)
                            .height(9.dp)
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = caloriesText,
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
            Image(
                painter = rememberVectorPainter(image = Icons.StartSmallOn),
                contentDescription = "star",
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .size(16.dp),
                colorFilter = colorFilterStar?.let {
                    ColorFilter.tint(it)
                }
            )
        }
    }
}