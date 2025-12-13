package com.example.practice.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Light
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.R
import com.example.practice.ui.font.LeagueSpartan
import io.github.composegears.valkyrie.BookmarkOff1
import io.github.composegears.valkyrie.BookmarkOn
import io.github.composegears.valkyrie.Message
import io.github.composegears.valkyrie.ValkyrieIcons
import io.github.composegears.valkyrie.Visibility

@Composable
fun ProfileStatsCard(
    modifier: Modifier = Modifier,
    avatar: Painter,
    name: String,
    description: String,
    likesCount: String,
    commentsCount: String,
    viewsCount: String,
    borderColor: Color = colorResource(id = R.color.lime_green),
    backgroundColor: Color = colorResource(id = R.color.black),
    accentColor: Color = colorResource(id = R.color.lime_green),
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(24.dp)
            )
            .border(
                width = 1.5.dp,
                color = borderColor,
                shape = RoundedCornerShape(24.dp)
            )
            .padding(8.dp)
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = avatar,
                    contentDescription = null,
                    modifier = Modifier
                        .size(44.dp)
                        .clip(CircleShape)
                )

                Spacer(Modifier.width(12.dp))

                Text(
                    text = name,
                    style = TextStyle(
                        fontFamily = LeagueSpartan,
                        fontWeight = Bold,
                        fontSize = 25.sp
                    ),
                    color = accentColor,
                    modifier = Modifier.weight(1f)
                )

                Image(
                    painter = rememberVectorPainter(image = ValkyrieIcons.BookmarkOff1),
                    contentDescription = null,
                    modifier = Modifier.size(22.dp)
                )
            }

            Spacer(Modifier.height(16.dp))

            Text(
                text = description,
                style = TextStyle(
                    fontFamily = LeagueSpartan,
                    fontWeight = Light,
                    fontSize = 14.sp
                ),
                color = colorResource(id = R.color.lime_green)
            )

            Spacer(Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = rememberVectorPainter(ValkyrieIcons.BookmarkOn),
                        contentDescription = null,
                        modifier = Modifier.size(13.dp)
                    )
                    Spacer(Modifier.width(6.dp))
                    Text(
                        text = likesCount,
                        style = TextStyle(
                            fontFamily = LeagueSpartan,
                            fontWeight = Light,
                            fontSize = 13.sp
                        ),
                        color = colorResource(id = R.color.lime_green)
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = rememberVectorPainter(ValkyrieIcons.Message),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(colorResource(id = R.color.purple)),
                        modifier = Modifier.size(13.dp)
                    )
                    Spacer(Modifier.width(6.dp))
                    Text(
                        text = commentsCount,
                        style = TextStyle(
                            fontFamily = LeagueSpartan,
                            fontWeight = Light,
                            fontSize = 13.sp
                        ),
                        color = colorResource(id = R.color.lime_green)
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = rememberVectorPainter(ValkyrieIcons.Visibility),
                        contentDescription = null,
                        modifier = Modifier.size(13.dp)
                    )
                    Spacer(Modifier.width(6.dp))
                    Text(
                        text = viewsCount,
                        style = TextStyle(
                            fontFamily = LeagueSpartan,
                            fontWeight = Light,
                            fontSize = 13.sp
                        ),
                        color = colorResource(id = R.color.lime_green)
                    )
                }
            }
        }
    }
}