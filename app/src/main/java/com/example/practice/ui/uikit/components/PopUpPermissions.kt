package com.example.practice.ui.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.practice.R

@Composable
fun PopUpPermissions(
    modifier: Modifier = Modifier,
    text: String,
    image: Painter,
    onClickYes: () -> Unit,
    onClickNo: () -> Unit
) {
    val shape = RoundedCornerShape(24.dp)

    Column(
        modifier = modifier
            .clip(shape)
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = shape
            )
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline.copy(alpha = 0.75f),
                shape = shape
            )
            .padding(horizontal = 20.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(66.dp)
                .background(
                    color = MaterialTheme.colorScheme.secondary,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(34.dp),
                painter = image,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.outlineVariant
            )
        }

        Spacer(modifier = Modifier.height(18.dp))

        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.outline,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            AppOutlinedButton(
                modifier = Modifier.weight(1f),
                text = stringResource(R.string.yes),
                textColor = MaterialTheme.colorScheme.outlineVariant,
                textStyle = MaterialTheme.typography.titleMedium,
                backgroundColor = MaterialTheme.colorScheme.secondary,
                borderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.7f)
            ) {
                onClickYes()
            }

            Spacer(modifier = Modifier.width(16.dp))

            AppOutlinedButton(
                modifier = Modifier.weight(1f),
                text = stringResource(R.string.no),
                backgroundColor = MaterialTheme.colorScheme.background,
                borderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.7f),
                textColor = MaterialTheme.colorScheme.outline,
                textStyle = MaterialTheme.typography.titleMedium
            ) {
                onClickNo()
            }
        }
    }
}
