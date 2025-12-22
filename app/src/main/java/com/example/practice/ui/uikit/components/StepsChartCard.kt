package com.example.practice.ui.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Light
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.ui.uikit.theme.Poppins

@Composable
fun StepsChartCard(
    modifier: Modifier = Modifier,
    title: String,
    yLabels: List<Int>,
    months: List<String>,
    values: List<Float>,
) {
    Box(
        modifier = modifier
            .width(250.dp)
            .height(240.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(MaterialTheme.colorScheme.background)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outlineVariant,
                shape = RoundedCornerShape(24.dp)
            )
            .padding(start = 16.dp, top = 8.dp, end = 12.dp, bottom = 8.dp)
    ) {
        Text(
            text = title,
            color = MaterialTheme.colorScheme.secondary,
            style = TextStyle(
                fontFamily = Poppins,
                fontWeight = Medium,
                fontSize = 17.sp
            ),
            modifier = Modifier.align(Alignment.TopStart)
        )

        Column(
            modifier = Modifier
                .height(165.dp)
                .align(Alignment.CenterStart)
                .padding(top = 20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            yLabels.forEach {
                Text(
                    text = it.toString(),
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(start = 40.dp),
                horizontalArrangement = Arrangement.spacedBy(36.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                values.forEach { value ->

                    Box(
                        modifier = Modifier
                            .width(16.dp)
                            .fillMaxHeight()
                            .clip(RoundedCornerShape(12.dp))
                            .background(MaterialTheme.colorScheme.onPrimary)
                            .border(width = 1.dp, color = MaterialTheme.colorScheme.onSecondary),
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(value.coerceIn(0f, 1f))
                                .clip(RoundedCornerShape(4.dp))
                                .background(MaterialTheme.colorScheme.secondary)
                        )
                    }
                }
            }

            Column {
                Box(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .width(240.dp)
                        .height(2.dp)
                        .background(MaterialTheme.colorScheme.onBackground)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 36.dp),
                    horizontalArrangement = Arrangement.spacedBy(28.dp)
                ) {
                    months.forEach {
                        Text(
                            text = it,
                            color = MaterialTheme.colorScheme.secondary,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }
}