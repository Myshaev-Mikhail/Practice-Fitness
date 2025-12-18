package com.example.practice.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Light
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.R
import com.example.practice.ui.font.LeagueSpartan
import com.example.practice.ui.font.Poppins

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
            .background(colorResource(id = R.color.light_purple))
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
                    color = colorResource(id = R.color.white),
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
                    colorFilter = ColorFilter.tint(colorResource(R.color.lime_green))
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Row {
                Text(
                    text = "Age: ",
                    color = colorResource(id = R.color.white),
                    style = TextStyle(
                        fontFamily = LeagueSpartan,
                        fontWeight = SemiBold,
                        fontSize = 14.sp
                    )
                )

                Text(
                    text = "Age: $age",
                    color = colorResource(id = R.color.white),
                    style = TextStyle(
                        fontFamily = LeagueSpartan,
                        fontWeight = Light,
                        fontSize = 14.sp
                    )
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
                        .background(colorResource(id = R.color.lime_green))
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = "$weightKg Kg",
                        color = colorResource(id = R.color.white),
                        style = TextStyle(
                            fontFamily = LeagueSpartan,
                            fontWeight = SemiBold,
                            fontSize = 14.sp
                        )
                    )
                    Text(
                        text = "Weight",
                        color = colorResource(id = R.color.white),
                        style = TextStyle(
                            fontFamily = LeagueSpartan,
                            fontWeight = Light,
                            fontSize = 14.sp
                        )
                    )
                }

                Spacer(modifier = Modifier.width(24.dp))

                Box(
                    modifier = Modifier
                        .width(10.dp)
                        .height(40.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(colorResource(id = R.color.lime_green))
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = String.format("%.2f CM", heightMeters),
                        color = colorResource(id = R.color.white),
                        style = TextStyle(
                            fontFamily = LeagueSpartan,
                            fontWeight = SemiBold,
                            fontSize = 14.sp
                        )
                    )
                    Text(
                        text = "Height",
                        color = colorResource(id = R.color.white),
                        style = TextStyle(
                            fontFamily = LeagueSpartan,
                            fontWeight = Light,
                            fontSize = 14.sp
                        )
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