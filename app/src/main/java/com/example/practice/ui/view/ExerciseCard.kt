package com.example.practice.ui.view

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Light
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.R
import com.example.practice.ui.font.LeagueSpartan
import com.example.practice.ui.font.Poppins
import io.github.composegears.valkyrie.TimeDefault
import io.github.composegears.valkyrie.ValkyrieIcons

@Composable
fun ExerciseCard(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color(0xFFE6F56D),
    title: String,
    description: String,
    durationText: String,
    levelText: String
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(28.dp)
            )
            .padding(8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                style = TextStyle(
                    fontFamily = Poppins,
                    fontWeight = Medium,
                    fontSize = 18.sp
                ),
                color = colorResource(id = R.color.black),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = description,
                style = TextStyle(
                    fontFamily = Poppins,
                    fontWeight = Light,
                    fontSize = 10.sp
                ),
                color = colorResource(id = R.color.black),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(50)
                    )
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = rememberVectorPainter(ValkyrieIcons.TimeDefault),
                        contentDescription = null,
                        modifier = Modifier.size(12.dp),
                        colorFilter = ColorFilter.tint(colorResource(id = R.color.black))
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = durationText,
                        style = TextStyle(
                            fontFamily = LeagueSpartan,
                            fontWeight = Light,
                            fontSize = 15.sp
                        ),
                        color = colorResource(id = R.color.black),
                    )
                }

                Spacer(modifier = Modifier.width(20.dp))

                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(colorResource(id = R.color.black), CircleShape)
                )

                Spacer(modifier = Modifier.width(20.dp))

                Text(
                    text = levelText,
                    style = TextStyle(
                        fontFamily = LeagueSpartan,
                        fontWeight = Light,
                        fontSize = 15.sp
                    ),
                    color = colorResource(id = R.color.black)
                )
            }
        }
    }
}