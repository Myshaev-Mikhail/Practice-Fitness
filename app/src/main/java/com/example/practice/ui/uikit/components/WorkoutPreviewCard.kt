package com.example.practice.ui.uikit.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.practice.R
import com.example.practice.ui.uikit.theme.Poppins
import io.github.composegears.valkyrie.Calories
import io.github.composegears.valkyrie.Icons
import io.github.composegears.valkyrie.PlayOff
import io.github.composegears.valkyrie.StartSmallOn
import io.github.composegears.valkyrie.TimeDefault
import io.github.composegears.valkyrie.WorkOut

@Composable
fun WorkoutPreviewCard(
    title: String,
    durationText: String,
    exercisesText: String,
    image: Painter,
    modifier: Modifier = Modifier
) {
    val configuration = LocalConfiguration.current
    val imageWidth = configuration.screenWidthDp.dp / 2.3f
    val bottomCorner = 16.dp

    Column(
        modifier = modifier
            .width(imageWidth)
            .clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
            .background(MaterialTheme.colorScheme.onSecondary)
    ) {
        Box(
            modifier = Modifier
                .width(imageWidth)
        ) {
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.width(imageWidth)
            )

            Image(
                painter = rememberVectorPainter(Icons.StartSmallOn),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
                    .size(15.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.secondary)
            )
        }

        Box(
            modifier = Modifier
                .width(imageWidth)
                .background(
                    color = MaterialTheme.colorScheme.onPrimary,
                    shape = RoundedCornerShape(
                        bottomStart = bottomCorner,
                        bottomEnd = bottomCorner
                    )
                )
                .padding(start = 1.dp, end = 1.dp, bottom = 1.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(imageWidth)
                    .background(
                        color = MaterialTheme.colorScheme.onSecondary,
                        shape = RoundedCornerShape(
                            bottomStart = bottomCorner,
                            bottomEnd = bottomCorner
                        )
                    )
                    .padding(start = 8.dp, top = 4.dp, end = 4.dp, bottom = 12.dp)
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .offset(y = (-15).dp)
                ) {
                    Image(
                        painter = rememberVectorPainter(Icons.PlayOff),
                        contentDescription = null,
                        modifier = Modifier.size(23.dp)
                    )
                }

                Column {
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = title,
                        color = MaterialTheme.colorScheme.secondary,
                        style = TextStyle(
                            fontFamily = Poppins,
                            fontWeight = Normal,
                            fontSize = 12.sp
                        )
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = rememberVectorPainter(Icons.TimeDefault),
                            contentDescription = null,
                            modifier = Modifier.size(9.dp),
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            text = durationText,
                            color = MaterialTheme.colorScheme.onPrimary,
                            style = MaterialTheme.typography.labelMedium
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Image(
                            painter = rememberVectorPainter(Icons.WorkOut),
                            contentDescription = null,
                            modifier = Modifier
                                .width(7.dp)
                                .height(8.dp),
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            text = exercisesText,
                            color = MaterialTheme.colorScheme.onPrimary,
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }
            }
        }
    }
}