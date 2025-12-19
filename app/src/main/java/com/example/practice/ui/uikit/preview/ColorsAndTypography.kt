package com.example.practice.ui.uikit.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Light
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.text.font.FontWeight.Companion.Thin
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.R
import com.example.practice.ui.uikit.theme.LeagueSpartan
import com.example.practice.ui.uikit.theme.Poppins

@Preview(widthDp = 600, heightDp = 1200)
@Composable
fun ColorsAndTypography() {
    Column {
        Column {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                    .background(MaterialTheme.colorScheme.primary)
                    .width(540.dp)
                    .height(120.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    modifier = Modifier.padding(start = 24.dp),
                    text = "Colors",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontSize = 36.sp,
                        fontWeight = Bold
                    )
                )
            }
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
                    .background(MaterialTheme.colorScheme.onBackground)
            ) {
                Column {
                    Row(modifier = Modifier.padding(24.dp)) {
                        Column {
                            Box(
                                modifier = Modifier
                                    .padding(12.dp)
                                    .size(width = 140.dp, height = 85.dp)
                                    .clip(RoundedCornerShape(20.dp))
                                    .border(2.dp, Color.Black, RoundedCornerShape(20.dp))
                                    .background(MaterialTheme.colorScheme.onBackground)
                            )
                            Text("White", fontWeight = Bold, modifier = Modifier.padding(start = 24.dp))
                            Text("#FFFFFF", color = Color.Gray, fontSize = 12.sp, modifier = Modifier.padding(start = 24.dp))
                        }
                        Column {
                            Box(
                                modifier = Modifier
                                    .padding(12.dp)
                                    .size(width = 140.dp, height = 85.dp)
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(MaterialTheme.colorScheme.background)
                            )
                            Text("Black", fontWeight = Bold, modifier = Modifier.padding(start = 24.dp))
                            Text("#232323", color = Color.Gray, fontSize = 12.sp, modifier = Modifier.padding(start = 24.dp))
                        }
                    }
                    Row(modifier = Modifier.padding(24.dp)) {
                        Column {
                            Box(
                                modifier = Modifier
                                    .padding(12.dp)
                                    .size(width = 140.dp, height = 85.dp)
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(MaterialTheme.colorScheme.secondary)
                            )
                            Text("Lime Green", fontWeight = Bold, modifier = Modifier.padding(start = 24.dp))
                            Text("#E2F163", color = Color.Gray, fontSize = 12.sp, modifier = Modifier.padding(start = 24.dp))
                        }
                        Column {
                            Box(
                                modifier = Modifier
                                    .padding(12.dp)
                                    .size(width = 140.dp, height = 85.dp)
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(MaterialTheme.colorScheme.primary)
                            )
                            Text("Purple", fontWeight = Bold, modifier = Modifier.padding(start = 24.dp))
                            Text("#896CFE", color = Color.Gray, fontSize = 12.sp, modifier = Modifier.padding(start = 24.dp))
                        }

                        // Light Purple
                        Column {
                            Box(
                                modifier = Modifier
                                    .padding(12.dp)
                                    .size(width = 140.dp, height = 85.dp)
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(MaterialTheme.colorScheme.secondary)
                            )
                            Text("Light Purple", fontWeight = Bold, modifier = Modifier.padding(start = 24.dp))
                            Text("#B3A0FF", color = Color.Gray, fontSize = 12.sp, modifier = Modifier.padding(start = 24.dp))
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.padding(32.dp))
        Column {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                    .background(MaterialTheme.colorScheme.primary)
                    .width(540.dp)
                    .height(120.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    modifier = Modifier.padding(start = 24.dp),
                    text = "Typography",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontSize = 36.sp,
                        fontWeight = Bold
                    )
                )
            }
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
                    .background(MaterialTheme.colorScheme.onBackground)
                    .width(540.dp)
            ) {
                Column(modifier = Modifier.width(540.dp).height(450.dp)) {
                    Row(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(12.dp)
                    ) {
                        Text(
                            modifier = Modifier.padding(start = 24.dp),
                            text = "Poppins",
                            color = MaterialTheme.colorScheme.onSecondary,
                            style = TextStyle(
                                fontFamily = Poppins,
                                fontSize = 32.sp,
                                fontWeight = Bold
                            )
                        )
                        Text(
                            modifier = Modifier.padding(start = 24.dp),
                            text = "(titles & Subtitles)",
                            color = MaterialTheme.colorScheme.onSecondary,
                            style = TextStyle(
                                fontFamily = Poppins,
                                fontSize = 28.sp,
                                fontWeight = Light
                            )
                        )
                    }
                    Row(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(bottom = 12.dp)
                    ) {
                        Text(
                            modifier = Modifier.padding(start = 24.dp),
                            text = "League Spartan",
                            color = MaterialTheme.colorScheme.onSecondary,
                            style = TextStyle(
                                fontFamily = LeagueSpartan,
                                fontSize = 32.sp,
                                fontWeight = Bold
                            )
                        )
                        Text(
                            modifier = Modifier.padding(start = 24.dp),
                            text = "(body text)",
                            color = MaterialTheme.colorScheme.onSecondary,
                            style = TextStyle(
                                fontFamily = LeagueSpartan,
                                fontSize = 28.sp,
                                fontWeight = Light
                            )
                        )
                    }
                    Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                        Box(
                            modifier = Modifier.background(MaterialTheme.colorScheme.background)
                        ) {
                            Column(modifier = Modifier.padding(start = 4.dp, top = 12.dp, end = 4.dp, bottom = 12.dp)) {
                                Text(
                                    modifier = Modifier.padding(start = 12.dp),
                                    text = "Bold",
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    style = TextStyle(
                                        fontFamily = Poppins,
                                        fontSize = 32.sp,
                                        fontWeight = Bold
                                    )
                                )
                                Text(
                                    modifier = Modifier.padding(start = 12.dp, end = 12.dp),
                                    text = "Semibold",
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    style = TextStyle(
                                        fontFamily = Poppins,
                                        fontSize = 32.sp,
                                        fontWeight = SemiBold
                                    )
                                )
                                Text(
                                    modifier = Modifier.padding(start = 12.dp),
                                    text = "Medium",
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    style = TextStyle(
                                        fontFamily = Poppins,
                                        fontSize = 32.sp,
                                        fontWeight = Medium
                                    )
                                )
                                Text(
                                    modifier = Modifier.padding(start = 12.dp),
                                    text = "Regular",
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    style = TextStyle(
                                        fontFamily = Poppins,
                                        fontSize = 32.sp,
                                        fontWeight = Normal
                                    )
                                )
                                Text(
                                    modifier = Modifier.padding(start = 12.dp),
                                    text = "Light",
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    style = TextStyle(
                                        fontFamily = Poppins,
                                        fontSize = 32.sp,
                                        fontWeight = Light
                                    )
                                )
                                Text(
                                    modifier = Modifier.padding(start = 12.dp),
                                    text = "Thin",
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    style = TextStyle(
                                        fontFamily = Poppins,
                                        fontSize = 32.sp,
                                        fontWeight = Thin
                                    )
                                )
                            }
                        }

                        Spacer(modifier = Modifier.width(20.dp))

                        Box(
                            modifier = Modifier.background(MaterialTheme.colorScheme.background)
                        ) {
                            Column(modifier = Modifier.padding(start = 4.dp, top = 12.dp, end = 4.dp, bottom = 12.dp)) {
                                Text(
                                    modifier = Modifier.padding(start = 8.dp, top = 8.dp, end = 12.dp, bottom = 8.dp),
                                    text = "Bold",
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    style = TextStyle(
                                        fontFamily = LeagueSpartan,
                                        fontSize = 32.sp,
                                        fontWeight = Bold
                                    )
                                )
                                Text(
                                    modifier = Modifier.padding(start = 8.dp, top = 8.dp, end = 32.dp, bottom = 8.dp),
                                    text = "Semibold",
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    style = TextStyle(
                                        fontFamily = LeagueSpartan,
                                        fontSize = 32.sp,
                                        fontWeight = SemiBold
                                    )
                                )
                                Text(
                                    modifier = Modifier.padding(8.dp),
                                    text = "Medium",
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    style = TextStyle(
                                        fontFamily = LeagueSpartan,
                                        fontSize = 32.sp,
                                        fontWeight = Medium
                                    )
                                )
                                Text(
                                    modifier = Modifier.padding(8.dp),
                                    text = "Regular",
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    style = TextStyle(
                                        fontFamily = LeagueSpartan,
                                        fontSize = 32.sp,
                                        fontWeight = Normal
                                    )
                                )
                                Text(
                                    modifier = Modifier.padding(8.dp),
                                    text = "Light",
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    style = TextStyle(
                                        fontFamily = LeagueSpartan,
                                        fontSize = 32.sp,
                                        fontWeight = Light
                                    )
                                )
                                Text(
                                    modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                                    text = "Thin",
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    style = TextStyle(
                                        fontFamily = LeagueSpartan,
                                        fontSize = 32.sp,
                                        fontWeight = Thin
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}