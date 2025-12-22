package com.example.practice.ui.uikit.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.ui.uikit.theme.Poppins
import io.github.composegears.valkyrie.TimeDefault
import io.github.composegears.valkyrie.Icons

@Composable
fun StatsCard(
    modifier: Modifier = Modifier,
    dayLabel: String,
    dayNumber: String,
    centerTitle: String,
    centerValue: String,
    rightTitle: String,
    rightValue: String,
) {
    Box(
        modifier = modifier
            .background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(24.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column {
                Text(
                    text = dayLabel,
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontWeight = Medium,
                        fontSize = 11.sp
                    )
                )
                Text(
                    text = dayNumber,
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontWeight = Medium,
                        fontSize = 20.sp
                    )
                )
            }

            Spacer(Modifier.width(16.dp))

            Box(
                Modifier
                    .height(40.dp)
                    .width(1.dp)
                    .background(MaterialTheme.colorScheme.onPrimary)
            )

            Spacer(Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = centerTitle,
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontWeight = Medium,
                        fontSize = 11.sp
                    )
                )
                Text(
                    text = centerValue,
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontWeight = Medium,
                        fontSize = 20.sp
                    )
                )
            }

            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = rightTitle,
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontWeight = Medium,
                        fontSize = 11.sp
                    )
                )
                Row(
                    verticalAlignment = Alignment.Bottom
                ) {
                    Image(
                        painter = rememberVectorPainter(image = Icons.TimeDefault),
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp)
                            .padding(end = 6.dp)
                            .align(Alignment.Bottom)
                    )
                    Text(
                        modifier = Modifier.align(Alignment.Bottom),
                        text = rightValue,
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = TextStyle(
                            fontFamily = Poppins,
                            fontWeight = Medium,
                            fontSize = 12.sp
                        )
                    )
                }
            }
        }
    }
}