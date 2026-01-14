package com.example.practice.ui.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppToggleCheckBox(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.headlineSmall,
    circleSize: Dp = 36.dp
) {
    val backgroundColor =
        if (isSelected) MaterialTheme.colorScheme.outlineVariant else MaterialTheme.colorScheme.outline

    val borderColor =
        if (isSelected) MaterialTheme.colorScheme.outline else MaterialTheme.colorScheme.outlineVariant

    val textColor =
        if (isSelected) MaterialTheme.colorScheme.outline else MaterialTheme.colorScheme.outlineVariant

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(50.dp))
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(50.dp)
            )
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(50.dp)
            )
            .clickable { onClick() }
            .padding(horizontal = 20.dp, vertical = 14.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = text,
                style = textStyle,
                color = textColor
            )

            Box(
                modifier = Modifier
                    .size(circleSize)
                    .background(
                        color = if (isSelected) MaterialTheme.colorScheme.secondary else Color.Transparent,
                        shape = androidx.compose.foundation.shape.CircleShape
                    )
                    .border(
                        width = 2.dp,
                        color = borderColor,
                        shape = androidx.compose.foundation.shape.CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                if (isSelected) {
                    Text(
                        text = "✓",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.outlineVariant
                    )
                }
            }
        }
    }
}