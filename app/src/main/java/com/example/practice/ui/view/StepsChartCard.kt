package com.example.practice.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Light
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.R
import com.example.practice.ui.font.Poppins

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
            .background(colorResource(id = R.color.black))
            .border(
                width = 1.dp,
                color = colorResource(id = R.color.white),
                shape = RoundedCornerShape(24.dp)
            )
            .padding(start = 16.dp, top = 8.dp, end = 12.dp, bottom = 8.dp)
    ) {
        Text(
            text = title,
            color = colorResource(id = R.color.lime_green),
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
                    color = colorResource(id = R.color.lime_green),
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontWeight = Light,
                        fontSize = 13.sp
                    )
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
                            .background(colorResource(id = R.color.white)),
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(value.coerceIn(0f, 1f))
                                .clip(RoundedCornerShape(4.dp))
                                .background(colorResource(id = R.color.lime_green))
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
                        .background(colorResource(R.color.white))
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
                            color = colorResource(id = R.color.lime_green),
                            style = TextStyle(
                                fontFamily = Poppins,
                                fontWeight = Medium,
                                fontSize = 13.sp
                            )
                        )
                    }
                }
            }
        }
    }
}