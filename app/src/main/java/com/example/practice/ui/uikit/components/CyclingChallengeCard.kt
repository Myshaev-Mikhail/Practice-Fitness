package com.example.practice.ui.uikit.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.practice.R
import io.github.composegears.valkyrie.Calories
import io.github.composegears.valkyrie.Icons
import io.github.composegears.valkyrie.StartSmallOn
import io.github.composegears.valkyrie.TimeDefault

@Composable
fun CyclingChallengeCard(
    modifier: Modifier = Modifier,
    background: Color = MaterialTheme.colorScheme.onPrimary,
    title: String = "Cycling\nChallenge",
    styleTitle: TextStyle = MaterialTheme.typography.titleMedium,
    isDescription: Boolean = false,
    description: String = "Lorem Ipsum Dolor Sit Amet Consectetur.\nMagnis Pellentesque Felis\nUllamcorper Imperdiet.",
    duration: String = "15 Minutes",
    calories: String = "150 Cal",
    styleDescription: TextStyle = MaterialTheme.typography.labelMedium,
    image: Painter = painterResource(id = R.mipmap.woman_helping_man_gym_bike)
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors(
            containerColor = background
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 20.dp, top = 4.dp, end = 0.dp, bottom = 4.dp)
            ) {

                Text(
                    text = title,
                    style = styleTitle
                )

                Spacer(modifier = Modifier.height(4.dp))


                if (isDescription) {
                    Text(
                        text = description,
                        style = styleDescription
                    )
                } else {
                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = rememberVectorPainter(Icons.TimeDefault),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(9.dp),
                                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSecondary)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = duration,
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onSecondary
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Image(
                                painter = rememberVectorPainter(Icons.Calories),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(7.dp)
                                    .height(9.dp),
                                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSecondary)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = calories,
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onSecondary
                            )
                        }
                    }
                }
            }

            Box {
                Image(
                    painter = image,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.clip(RoundedCornerShape(32.dp))
                )

                Image(
                    painter = rememberVectorPainter(image = Icons.StartSmallOn),
                    contentDescription = "star",
                    modifier = Modifier
                        .size(16.dp)
                        .align(Alignment.TopEnd)
                        .offset(x = (-10).dp, y = 6.dp)
                )
            }
        }
    }
}