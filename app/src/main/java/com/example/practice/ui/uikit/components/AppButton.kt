package com.example.practice.ui.uikit.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
    textStyle: TextStyle = MaterialTheme.typography.labelLarge,
    image: Painter? = null,
    imageSize: Dp? = null,
    imageColor: Color? = null,
    buttonColor: Color = MaterialTheme.colorScheme.primary,
    buttonPaddingValues: PaddingValues = PaddingValues(0.dp),
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth().defaultMinSize(minHeight = 0.dp),
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
        contentPadding = buttonPaddingValues,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (image != null) {
                Image(
                    painter = image,
                    contentDescription = null,
                    colorFilter = imageColor?.let { ColorFilter.tint(it) },

                    modifier = if (imageSize != null) {
                        Modifier.size(imageSize).padding(end = 4.dp)
                    } else {
                        Modifier.padding(end = 4.dp)
                    }
                )
            }

            Text(
                text = text,
                color = textColor,
                style = textStyle,
            )
        }
    }
}