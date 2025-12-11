package com.example.practice.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.R
import com.example.practice.ui.font.LeagueSpartan

@Composable
fun AppToggleButton(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    selectedColor: Color = colorResource(id = R.color.lime_green),
    unselectedColor: Color = Color.Transparent,
    textSelectedColor: Color = Color.White,
    textStyle: TextStyle = TextStyle(
        fontFamily = LeagueSpartan,
        fontSize = 14.sp,
        fontWeight = Medium
    ),
    circleSize: Dp = 22.dp,
    buttonColor: Color = colorResource(id = R.color.black)
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = buttonColor,
                shape = RoundedCornerShape(20.dp)
            )
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 4.dp),
        contentAlignment = Alignment.CenterStart
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = text,
                color = textSelectedColor,
                style = textStyle
            )

            Box(
                modifier = Modifier
                    .size(circleSize)
                    .background(
                        color = if (isSelected) selectedColor else unselectedColor,
                        shape = androidx.compose.foundation.shape.CircleShape
                    )
                    .border(
                        width = 1.dp,
                        color = Color.Black,
                        shape = androidx.compose.foundation.shape.CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                if (isSelected) {
                    Text(
                        "✓",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
            }
        }
    }
}