package com.example.practice.ui.uikit.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Light
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.ui.uikit.theme.LeagueSpartan
import com.example.practice.ui.uikit.theme.Poppins

@Composable
fun BadgeItem(
    modifier: Modifier = Modifier,
    icon: Painter,
    iconBackgroundColor: Color? = null,
    iconBackgroundSize: Dp = 36.dp,
    overlineText: String? = null,
    titleText: String,
    subtitleText: String? = null,
    subtitleIcon: Painter? = null,
    trailingIcon: Painter? = null,
    trailingTopText: String? = null,
    trailingBottomText: String? = null,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.onPrimary, shape = RoundedCornerShape(24.dp))
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (iconBackgroundColor != null) {
                Box(
                    modifier = Modifier
                        .size(iconBackgroundSize)
                        .background(
                            color = iconBackgroundColor,
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = icon,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp),
                    )
                }
            } else {
                Image(
                    painter = icon,
                    contentDescription = null
                )
            }


            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                if (overlineText != null) {
                    Text(
                        text = overlineText,
                        color = MaterialTheme.colorScheme.onSecondary,
                        style = TextStyle(
                            fontFamily = LeagueSpartan,
                            fontWeight = Light,
                            fontSize = 12.sp
                        )
                    )
                }

                Text(
                    text = titleText,
                    color = MaterialTheme.colorScheme.onSecondary,
                    style = MaterialTheme.typography.bodyMedium
                )

                if (subtitleText != null) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        if (subtitleIcon != null) {
                            Image(
                                painter = subtitleIcon,
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.tertiary),
                                modifier = Modifier.size(10.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            text = subtitleText,
                            color = MaterialTheme.colorScheme.tertiary,
                            style = TextStyle(
                                fontFamily = Poppins,
                                fontWeight = Medium,
                                fontSize = 12.sp
                            )
                        )
                    }
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (trailingIcon != null) {
                    Image(
                        painter = trailingIcon,
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                        modifier = Modifier.size(11.dp)
                    )
                }

                Spacer(modifier = Modifier.width(4.dp))

                Column {
                    if (trailingTopText != null) {
                        Text(
                            text = trailingTopText,
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    if (trailingBottomText != null) {
                        Text(
                            text = trailingBottomText,
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }
}