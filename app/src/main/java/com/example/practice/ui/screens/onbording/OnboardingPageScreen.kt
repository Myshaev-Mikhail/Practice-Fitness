package com.example.practice.ui.screens.onbording

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.R
import com.example.practice.ui.font.Poppins

@Composable
fun OnboardingPageScreen(
    page: OnboardingPage,
    currentPage: Int,
    totalPages: Int
) {
    Box(Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(page.imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .background(colorResource(id = R.color.light_purple))
                .padding(start = 24.dp, top = 12.dp, end = 24.dp, bottom = 12.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = rememberVectorPainter(page.icon),
                    contentDescription = null,
                    modifier = Modifier.size(35.dp),
                    colorFilter = ColorFilter.tint(colorResource(id = R.color.lime_green))
                )

                Text(
                    text = page.title,
                    color = colorResource(R.color.white),
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontSize = 20.sp,
                        fontWeight = Bold
                    )
                )

                Text(
                    text = page.description,
                    color = colorResource(R.color.white),
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontSize = 20.sp,
                        fontWeight = Bold
                    )
                )
                Row(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    repeat(totalPages - 1) { index ->
                        val selected = currentPage == index + 1

                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .size(width = 28.dp, height = 4.dp)
                                .background(
                                    color = if (selected)
                                        colorResource(id = R.color.white)
                                    else
                                        colorResource(id = R.color.purple),
                                    shape = RoundedCornerShape(50)
                                )
                        )
                    }
                }
            }
        }
    }
}