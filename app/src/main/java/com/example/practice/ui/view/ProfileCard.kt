package com.example.practice.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun ProfileCard(
    modifier: Modifier = Modifier,
    avatar: Painter,
    name: String,
    email: String,
    birthday: String,
    weightKg: Int,
    age: Int,
    heightMeters: Float
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = avatar,
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = name,
            color = colorResource(id = R.color.white),
            style = TextStyle(
                fontFamily = Poppins,
                fontWeight = Bold,
                fontSize = 20.sp
            )
        )

        Text(
            text = email,
            color = colorResource(id = R.color.white),
            style = TextStyle(
                fontFamily = Poppins,
                fontWeight = Light,
                fontSize = 13.sp
            )
        )

        Spacer(modifier = Modifier.height(4.dp))

        Row {
            Text(
                text = "Birthday: ",
                color = colorResource(id = R.color.white),
                style = TextStyle(
                    fontFamily = Poppins,
                    fontWeight = SemiBold,
                    fontSize = 13.sp
                )
            )
            Text(
                text = birthday,
                color = colorResource(id = R.color.white),
                style = TextStyle(
                    fontFamily = Poppins,
                    fontWeight = Light,
                    fontSize = 13.sp
                )
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(colorResource(id = R.color.purple)),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "$weightKg Kg",
                    color = colorResource(id = R.color.white),
                    style = TextStyle(
                        fontFamily = LeagueSpartan,
                        fontWeight = SemiBold,
                        fontSize = 14.sp
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))
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

            Box(
                modifier = Modifier
                    .width(1.dp)
                    .height(48.dp)
                    .background(colorResource(id = R.color.white).copy(alpha = 0.4f))
            )

            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "$age",
                    color = colorResource(id = R.color.white),
                    style = TextStyle(
                        fontFamily = LeagueSpartan,
                        fontWeight = SemiBold,
                        fontSize = 14.sp
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Years Old",
                    color = colorResource(id = R.color.white),
                    style = TextStyle(
                        fontFamily = LeagueSpartan,
                        fontWeight = Light,
                        fontSize = 14.sp
                    )
                )
            }

            Box(
                modifier = Modifier
                    .width(1.dp)
                    .height(48.dp)
                    .background(colorResource(id = R.color.white).copy(alpha = 0.4f))
            )

            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = String.format("%.2f M", heightMeters),
                    color = colorResource(id = R.color.white),
                    style = TextStyle(
                        fontFamily = LeagueSpartan,
                        fontWeight = SemiBold,
                        fontSize = 14.sp
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))
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
}