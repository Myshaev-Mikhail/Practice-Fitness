package com.example.practice.ui.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.ui.font.Poppins

@Composable
fun AppOutlinedButton(
    modifier: Modifier = Modifier,
    text: String,
    backgroundColor: Color = Color.Black.copy(alpha = 0.2f),
    borderColor: Color = Color.White,
    textColor: Color = Color.White,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor
        ),
        border = BorderStroke(2.dp, borderColor)
    ) {
        Text(
            text = text,
            color = textColor,
            modifier = Modifier.padding(vertical = 12.dp),
            style = TextStyle(
                fontFamily = Poppins,
                fontSize = 24.sp,
                fontWeight = Bold
            )
        )
    }
}
