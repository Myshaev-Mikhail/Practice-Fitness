package com.example.practice.ui.uikit.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Light
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.ui.uikit.theme.LeagueSpartan

@Composable
fun Search(
    modifier: Modifier
) {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        textStyle = TextStyle(
            fontFamily = LeagueSpartan,
            fontWeight = Normal,
            fontSize = 14.sp,
            color = Color.Black
        ),
        placeholder = {
            Text(
                text = "Search",
                fontFamily = LeagueSpartan,
                fontWeight = Light,
                fontSize = 12.sp,
                color = Color.Black.copy(alpha = 0.5f)
            )
        },
        shape = RoundedCornerShape(12.dp),
        singleLine = true,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.onPrimary,
            focusedContainerColor = MaterialTheme.colorScheme.onPrimary
        ),
        modifier = modifier.fillMaxWidth()
    )
}