package com.example.practice.ui.uikit.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.practice.R

@Composable
fun CyclingChallengeCard(
    modifier: Modifier = Modifier,
    background: Color = MaterialTheme.colorScheme.onPrimary,
    title: String = "Cycling\nChallenge",
    styleTitle: TextStyle = MaterialTheme.typography.titleMedium,
    description: String = "Lorem Ipsum Dolor Sit Amet Consectetur.\nMagnis Pellentesque Felis\nUllamcorper Imperdiet.",
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

                Text(
                    text = description,
                    style = styleDescription
                )
            }

            Box {
                Image(
                    painter = image,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.clip(RoundedCornerShape(32.dp))
                )
            }
        }
    }
}