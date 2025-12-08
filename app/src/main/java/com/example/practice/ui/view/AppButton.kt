package com.example.practice.ui.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.R
import com.example.practice.ui.font.LeagueSpartan

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    text: String,
    buttonColor: Color = colorResource(R.color.purple),
    textColor: Color = colorResource(R.color.white),
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
    ) {
        Text(
            text = text,
            color = textColor,
            modifier = Modifier.padding(vertical = 12.dp),
            style = TextStyle(
                fontFamily = LeagueSpartan,
                fontSize = 24.sp,
                fontWeight = Medium
            ),
        )
    }
}