package com.example.practice.ui.uikit.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.practice.R
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CircleCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    strokeColor: Color = MaterialTheme.colorScheme.primary,
    innerCircleColor: Color = MaterialTheme.colorScheme.secondary,
    text: String,
    textStyle: TextStyle = MaterialTheme.typography.labelLarge.copy(fontSize = 16.sp),
    textColor: Color = MaterialTheme.colorScheme.outline
) {
    val innerCircleScale by animateFloatAsState(
        targetValue = if (checked) 1f else 0f,
        label = "InnerCircleScale"
    )

    Row(
        modifier = Modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                onCheckedChange(!checked)
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = modifier
                .size(48.dp)
                .drawWithCache {
                    val strokeWidth = 3.dp.toPx()
                    val outerRadius = size.minDimension / 2 - strokeWidth
                    val middleRadius = outerRadius * 0.65f
                    val innerCircleMaxRadius = middleRadius - strokeWidth

                    onDrawBehind {
                        val center = this.center

                        drawCircle(
                            color = strokeColor,
                            radius = outerRadius,
                            center = center,
                            style = Stroke(width = strokeWidth)
                        )

                        drawCircle(
                            color = strokeColor,
                            radius = middleRadius,
                            center = center,
                            style = Stroke(width = 2.dp.toPx())
                        )

                        if (innerCircleScale > 0f) {
                            drawCircle(
                                color = innerCircleColor,
                                radius = innerCircleMaxRadius * innerCircleScale,
                                center = center
                            )
                        }
                    }
                }
        )
        //Spacer(modifier = Modifier.width(8.dp))
        Text(
            modifier = Modifier.weight(1f),
            text = text,
            style = textStyle,
            color = textColor
        )
    }
}

@Preview
@Composable
fun CircleCheckboxPreview() {
    CircleCheckbox(
        modifier = Modifier.size(32.dp),
        checked = true,
        onCheckedChange = {  },
        text = stringResource(R.string.meal_plan_allergy_title)
    )
}
