package com.example.practice.ui.uikit.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.unit.dp
import com.example.practice.R
import io.github.composegears.valkyrie.Calories
import io.github.composegears.valkyrie.Icons
import io.github.composegears.valkyrie.PlayOff
import io.github.composegears.valkyrie.StartSmallOn
import io.github.composegears.valkyrie.TimeDefault
import io.github.composegears.valkyrie.WorkOut

@Composable
fun WorkoutCard(
    modifier: Modifier = Modifier,
    title: String = "Upper Body",
    duration: String = "60 Minutes",
    calories: String = "1320 Kcal",
    exercises: String = "5 Exercises",
    image: Painter = painterResource(id = R.mipmap.woman_helping_man_gym_1),
    colorFilterStar: Color? = null
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onPrimary
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp, top = 16.dp, end = 4.dp, bottom = 12.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSecondary
                )

                Spacer(modifier = Modifier.height(8.dp))

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

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = rememberVectorPainter(image = Icons.WorkOut),
                            contentDescription = "check",
                            modifier = Modifier
                                .width(7.dp)
                                .height(8.dp),
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSecondary),
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = exercises,
                            style = MaterialTheme.typography.labelMedium,
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .width(148.dp)
                    .height(110.dp)
            ) {
                Image(
                    painter = image,
                    contentDescription = "woman",
                    modifier = Modifier
                        .fillMaxSize()
                        //.clickable { TODO() }
                        .clip(
                            RoundedCornerShape(
                                topEnd = 28.dp,
                                bottomEnd = 28.dp
                            )
                        ),
                    contentScale = ContentScale.Crop
                )

                Image(
                    painter = rememberVectorPainter(image = Icons.PlayOff),
                    contentDescription = "video",
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.Center)
                )

                Image(
                    painter = rememberVectorPainter(image = Icons.StartSmallOn),
                    contentDescription = "star",
                    modifier = Modifier
                        .size(16.dp)
                        .align(Alignment.TopEnd)
                        .offset(x = (-10).dp, y = 6.dp),
                    colorFilter = colorFilterStar?.let {
                        ColorFilter.tint(it)
                    }
                )
            }
        }
    }
}