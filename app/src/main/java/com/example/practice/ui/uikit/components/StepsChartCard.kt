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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.ui.utils.localizedAppText
import com.example.practice.ui.uikit.theme.Poppins

@Composable
fun StepsChartCard(
    modifier: Modifier = Modifier,
    title: String,
    yLabels: List<Int>,
    months: List<String>,
    values: List<Float>,
) {
    val context = LocalContext.current

    BoxWithConstraints(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(250f / 240f)
            .heightIn(min = 220.dp, max = 420.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(MaterialTheme.colorScheme.background)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(24.dp)
            )
    ) {
        val contentPadding = (maxWidth * 0.06f).coerceIn(16.dp, 24.dp)
        val titleBottomGap = (maxWidth * 0.06f).coerceIn(14.dp, 28.dp)
        val yLabelWidth = (maxWidth * 0.14f).coerceIn(34.dp, 54.dp)
        val chartGap = (maxWidth * 0.04f).coerceIn(8.dp, 18.dp)
        val axisTopGap = (maxWidth * 0.03f).coerceIn(6.dp, 12.dp)
        val monthTopGap = (maxWidth * 0.02f).coerceIn(4.dp, 8.dp)
        val barWidth = (maxWidth * 0.06f).coerceIn(16.dp, 34.dp)
        val axisHeight = (maxWidth * 0.008f).coerceIn(3.dp, 5.dp)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
        ) {
            Text(
                text = context.localizedAppText(title),
                color = MaterialTheme.colorScheme.secondary,
                style = TextStyle(
                    fontFamily = Poppins,
                    fontWeight = Medium,
                    fontSize = 17.sp
                )
            )

            Spacer(modifier = Modifier.height(titleBottomGap))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalAlignment = Alignment.Bottom
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(yLabelWidth),
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

                Spacer(modifier = Modifier.width(chartGap))

                Row(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    verticalAlignment = Alignment.Bottom
                ) {
                    values.forEach { value ->
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight(),
                            contentAlignment = Alignment.BottomCenter
                        ) {
                            Box(
                                modifier = Modifier
                                    .width(barWidth)
                                    .fillMaxHeight()
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(MaterialTheme.colorScheme.onPrimary)
                                    .border(
                                        width = 1.dp,
                                        color = MaterialTheme.colorScheme.onSecondary,
                                        shape = RoundedCornerShape(12.dp)
                                    ),
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
                }
            }

            Spacer(modifier = Modifier.height(axisTopGap))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(axisHeight)
                    .background(Color.White)
            )

            Spacer(modifier = Modifier.height(monthTopGap))

            Row(modifier = Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.width(yLabelWidth + chartGap))

                Row(modifier = Modifier.weight(1f)) {
                    months.forEach {
                        Box(
                            modifier = Modifier.weight(1f),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = context.localizedAppText(it),
                                color = MaterialTheme.colorScheme.secondary,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
        }
    }
}
