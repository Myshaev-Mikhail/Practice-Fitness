package com.example.practice.ui.uikit.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.practice.ui.utils.localizedAppText

@Composable
fun ToggleSwitch(
    title: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current

    val trackColor by animateColorAsState(
        targetValue = if (checked)
            MaterialTheme.colorScheme.secondary
        else
            MaterialTheme.colorScheme.primary,
        label = ""
    )

    val trackWidth = 44.dp
    val trackHeight = 25.dp
    val thumbSize = 21.dp

    val thumbOffset by animateDpAsState(
        targetValue = if (checked)
            trackWidth - thumbSize - 2.dp
        else
            2.dp,
        label = ""
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onCheckedChange(!checked) }
            .padding(horizontal = 24.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = context.localizedAppText(title),
            modifier = Modifier.weight(1f),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.headlineSmall
        )

        Box(
            modifier = Modifier
                .width(trackWidth)
                .height(trackHeight)
                .background(
                    color = trackColor,
                    shape = RoundedCornerShape(50)
                )
        ) {
            Box(
                modifier = Modifier
                    .size(thumbSize)
                    .offset(x = thumbOffset)
                    .align(Alignment.CenterStart)
                    .background(MaterialTheme.colorScheme.background, shape = CircleShape)
            )
        }
    }
}
