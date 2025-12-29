package com.example.practice.ui.uikit.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Light
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.ui.uikit.theme.LeagueSpartan
import com.example.practice.ui.uikit.theme.Poppins

@Composable
fun ProfileHorizontalCard(
    modifier: Modifier = Modifier,
    avatar: Painter,
    name: String,
    age: Int,
    genderSymbol: Painter,
    weightKg: Int,
    heightMeters: Float
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.tertiary)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = name,
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontWeight = Bold,
                        fontSize = 22.sp
                    )
                )

                Spacer(modifier = Modifier.width(4.dp))

                Image(
                    painter = genderSymbol,
                    contentDescription = null,
                    modifier = Modifier
                        .size(16.dp),
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.secondary)
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Row {
                Text(
                    text = "Age: ",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.titleSmall
                )

                Text(
                    text = "Age: $age",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.bodySmall
                )
            }


            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .width(10.dp)
                        .height(40.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.secondary)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = "$weightKg Kg",
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.titleSmall
                    )
                    Text(
                        text = "Weight",
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.bodySmall
                    )
                }

                Spacer(modifier = Modifier.width(24.dp))

                Box(
                    modifier = Modifier
                        .width(10.dp)
                        .height(40.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.secondary)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = String.format("%.2f CM", heightMeters),
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.titleSmall
                    )
                    Text(
                        text = "Height",
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }

        Image(
            painter = avatar,
            contentDescription = null,
            modifier = Modifier
                .size(110.dp)
                .clip(CircleShape)
        )
    }
}