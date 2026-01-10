package com.example.practice.ui.uikit.preview

import CommunityOff
import CommunityOn
import NutritionOff
import NutritionOn
import ProgressOn
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.ui.uikit.theme.Poppins
import com.example.practice.ui.uikit.components.AppButton
import com.example.practice.ui.uikit.components.AppOutlinedButton
import com.example.practice.ui.uikit.components.AppToggleCheckBox
import com.example.practice.ui.uikit.components.BottomNavigation
import io.github.composegears.valkyrie.Add
import io.github.composegears.valkyrie.Arrow
import io.github.composegears.valkyrie.Attachment
import io.github.composegears.valkyrie.Bell
import io.github.composegears.valkyrie.BellNotificationOff
import io.github.composegears.valkyrie.BellNotificationOn
import io.github.composegears.valkyrie.BookmarkOff
import io.github.composegears.valkyrie.BookmarkOff1
import io.github.composegears.valkyrie.BookmarkOn
import io.github.composegears.valkyrie.BulbOff
import io.github.composegears.valkyrie.BulbOn
import io.github.composegears.valkyrie.Calories
import io.github.composegears.valkyrie.CardioDefault
import io.github.composegears.valkyrie.CardioVariant
import io.github.composegears.valkyrie.Check
import io.github.composegears.valkyrie.CupOff
import io.github.composegears.valkyrie.CupOn
import io.github.composegears.valkyrie.CheckProgressFull
import io.github.composegears.valkyrie.ResourcesWhite
import io.github.composegears.valkyrie.SupportWhite
import io.github.composegears.valkyrie.FemaleOn
import io.github.composegears.valkyrie.FemaleOff
import io.github.composegears.valkyrie.HomeWhite
import io.github.composegears.valkyrie.ListOff
import io.github.composegears.valkyrie.ListOn
import io.github.composegears.valkyrie.MaleOff
import io.github.composegears.valkyrie.Property1MaleOn
import io.github.composegears.valkyrie.NotificationOff
import io.github.composegears.valkyrie.Property1NotificationOn
import io.github.composegears.valkyrie.PlayOff
import io.github.composegears.valkyrie.PlayOn
import io.github.composegears.valkyrie.StarOff
import io.github.composegears.valkyrie.StarOn
import io.github.composegears.valkyrie.CheckProgress1
import io.github.composegears.valkyrie.ResourcesPurple
import io.github.composegears.valkyrie.SupportPurple
import io.github.composegears.valkyrie.CheckProgress2
import io.github.composegears.valkyrie.CheckProgress3
import io.github.composegears.valkyrie.CheckWhite
import io.github.composegears.valkyrie.Community
import io.github.composegears.valkyrie.Cup
import io.github.composegears.valkyrie.DumbbellDefault
import io.github.composegears.valkyrie.DumbbellVariant
import io.github.composegears.valkyrie.EmptyPoint
import io.github.composegears.valkyrie.Facebook
import io.github.composegears.valkyrie.Favorites
import io.github.composegears.valkyrie.FillPoint
import io.github.composegears.valkyrie.FingerprintIcon
import io.github.composegears.valkyrie.Globe
import io.github.composegears.valkyrie.GoogleIcon
import io.github.composegears.valkyrie.HomePurple
import io.github.composegears.valkyrie.Idea
import io.github.composegears.valkyrie.Instagram
import io.github.composegears.valkyrie.Key
import io.github.composegears.valkyrie.Logout
import io.github.composegears.valkyrie.ManGender
import io.github.composegears.valkyrie.Mark
import io.github.composegears.valkyrie.Message
import io.github.composegears.valkyrie.Microphone
import io.github.composegears.valkyrie.Nutrition
import io.github.composegears.valkyrie.Off
import io.github.composegears.valkyrie.On
import io.github.composegears.valkyrie.Privacity
import io.github.composegears.valkyrie.Profile
import io.github.composegears.valkyrie.ProgressList
import io.github.composegears.valkyrie.ProgressOff
import io.github.composegears.valkyrie.ProgressTracking
import io.github.composegears.valkyrie.SearchOff
import io.github.composegears.valkyrie.SearchOn
import io.github.composegears.valkyrie.Settings
import io.github.composegears.valkyrie.StarDefault
import io.github.composegears.valkyrie.StarVariant
import io.github.composegears.valkyrie.StartSmallOff
import io.github.composegears.valkyrie.StartSmallOn
import io.github.composegears.valkyrie.Store
import io.github.composegears.valkyrie.SupportAgent
import io.github.composegears.valkyrie.Telegram
import io.github.composegears.valkyrie.TimeDefault
import io.github.composegears.valkyrie.TimeVariant
import io.github.composegears.valkyrie.UserOff
import io.github.composegears.valkyrie.UserOn
import io.github.composegears.valkyrie.Icons
import io.github.composegears.valkyrie.Visibility
import io.github.composegears.valkyrie.WhatsApp
import io.github.composegears.valkyrie.WomanGender
import io.github.composegears.valkyrie.WorkOut
import io.github.composegears.valkyrie.WorkoutOff
import io.github.composegears.valkyrie.WorkoutOn

@Preview(widthDp = 700, heightDp = 1200)
@Composable
fun IconsAndImages() {
    Column(
        modifier = Modifier
            .background(Color.Transparent)
            .fillMaxWidth()
    ) {
        Column {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                    .background(MaterialTheme.colorScheme.primary)
                    .width(640.dp)
                    .height(60.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    modifier = Modifier.padding(start = 24.dp),
                    text = "Funtional Icons",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontSize = 24.sp,
                        fontWeight = Bold
                    )
                )
            }
            Row(modifier = Modifier.padding(4.dp)) {
                Column(modifier = Modifier.padding(8.dp)) {
                    Image(
                        painter = rememberVectorPainter(image = Icons.CheckProgress1),
                        contentDescription = "check",
                        modifier = Modifier
                            .size(70.dp)
                            .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                    )
                    Image(
                        painter = rememberVectorPainter(image = Icons.CheckProgress2),
                        contentDescription = "check",
                        modifier = Modifier
                            .size(70.dp)
                            .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                    )
                    Image(
                        painter = rememberVectorPainter(image = Icons.CheckProgress3),
                        contentDescription = "check",
                        modifier = Modifier
                            .size(70.dp)
                            .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                    )
                    Image(
                        painter = rememberVectorPainter(image = Icons.CheckProgressFull),
                        contentDescription = "check",
                        modifier = Modifier
                            .size(70.dp)
                            .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                    )
                }

                Column(modifier = Modifier.padding(8.dp)) {
                    Image(
                        painter = rememberVectorPainter(image = Icons.MaleOff),
                        contentDescription = "check",
                        modifier = Modifier
                            .size(70.dp)
                            .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                    )
                    Image(
                        painter = rememberVectorPainter(image = Icons.Property1MaleOn),
                        contentDescription = "check",
                        modifier = Modifier
                            .size(70.dp)
                            .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                    )
                    Image(
                        painter = rememberVectorPainter(image = Icons.FemaleOff),
                        contentDescription = "check",
                        modifier = Modifier
                            .size(70.dp)
                            .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                    )
                    Image(
                        painter = rememberVectorPainter(image = Icons.FemaleOn),
                        contentDescription = "check",
                        modifier = Modifier
                            .size(70.dp)
                            .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                    )
                }
                Column {
                    Row(modifier = Modifier.padding(start = 4.dp, top = 8.dp, end = 4.dp, bottom = 8.dp)) {
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = Icons.BulbOff),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = Icons.BulbOn),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = Icons.CupOff),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = Icons.CupOn),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = Icons.ListOff),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = Icons.ListOn),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = Icons.StarOff),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = Icons.StarOn),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = Icons.NotificationOff),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = Icons.Property1NotificationOn),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }

                        Spacer(modifier = Modifier.padding(16.dp))

                        Column {
                            Image(
                                painter = rememberVectorPainter(image = Icons.HomeWhite),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 5.dp, end = 5.dp, bottom = 5.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = Icons.HomePurple),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = Icons.ResourcesWhite),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = Icons.ResourcesPurple),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = Icons.SupportWhite),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = Icons.SupportPurple),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }


                        Column {
                            Image(
                                painter = rememberVectorPainter(image = Icons.BookmarkOff),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = Icons.BookmarkOn),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = Icons.BookmarkOff1),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = Icons.BookmarkOn),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }

                        Column {
                            Image(
                                painter = rememberVectorPainter(image = Icons.Add),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = Icons.Check),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = Icons.PlayOff),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = Icons.PlayOn),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                    }

                    Row(modifier = Modifier.padding(start = 4.dp, top = 8.dp, end = 4.dp, bottom = 8.dp)) {
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = Icons.WorkoutOff),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = Icons.WorkoutOn),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = ProgressOff),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = ProgressOn),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = NutritionOff),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = NutritionOn),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = CommunityOff),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = CommunityOn),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }

                        Spacer(modifier = Modifier.padding(16.dp))

                        Column {
                            Image(
                                painter = rememberVectorPainter(image = Icons.SearchOff),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = Icons.SearchOn),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = Icons.BellNotificationOff),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = Icons.BellNotificationOn),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = Icons.UserOff),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = Icons.UserOn),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }

                        Spacer(modifier = Modifier.padding(16.dp))

                        Column {
                            Image(
                                painter = rememberVectorPainter(image = Icons.StarDefault),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = Icons.StarVariant),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = Icons.CardioDefault),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = Icons.CardioVariant),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = Icons.DumbbellDefault),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = Icons.DumbbellVariant),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = Icons.TimeDefault),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = Icons.TimeVariant),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                    }

                    Row(modifier = Modifier.padding(start = 4.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)) {
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = Icons.Profile),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = Icons.Favorites),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = Icons.Privacity),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = Icons.Settings),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = Icons.SupportAgent),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = Icons.Logout),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = Icons.Globe),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = Icons.WhatsApp),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }

                        Column {
                            Image(
                                painter = rememberVectorPainter(image = Icons.Attachment),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = Icons.Facebook),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = Icons.Microphone),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = Icons.Instagram),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = Icons.Telegram),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = Icons.Key),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }

                        Column {
                            Image(
                                painter = rememberVectorPainter(image = Icons.Bell),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Spacer(modifier = Modifier.padding(16.dp))

                        Row(modifier = Modifier.padding(start = 4.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)) {
                            Column {
                                Image(
                                    painter = rememberVectorPainter(image = Icons.Off),
                                    contentDescription = "check",
                                    modifier = Modifier
                                        .size(35.dp)
                                        .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                                )
                                Image(
                                    painter = rememberVectorPainter(image = Icons.On),
                                    contentDescription = "check",
                                    modifier = Modifier
                                        .size(35.dp)
                                        .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                                )
                            }

                            Spacer(modifier = Modifier.padding(16.dp))

                            Column {
                                Image(
                                    painter = rememberVectorPainter(image = Icons.EmptyPoint),
                                    contentDescription = "check",
                                    modifier = Modifier
                                        .size(35.dp)
                                        .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                                )
                                Image(
                                    painter = rememberVectorPainter(image = Icons.FillPoint),
                                    contentDescription = "check",
                                    modifier = Modifier
                                        .size(35.dp)
                                        .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                                )
                            }
                            Column {
                                Image(
                                    painter = rememberVectorPainter(image = Icons.StartSmallOff),
                                    contentDescription = "check",
                                    modifier = Modifier
                                        .size(35.dp)
                                        .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                                )
                                Image(
                                    painter = rememberVectorPainter(image = Icons.StartSmallOn),
                                    contentDescription = "check",
                                    modifier = Modifier
                                        .size(35.dp)
                                        .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                                )
                            }
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.padding(16.dp))


        Column {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                    .background(MaterialTheme.colorScheme.primary)
                    .width(640.dp)
                    .height(60.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    modifier = Modifier.padding(start = 24.dp),
                    text = "Buttons",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontSize = 24.sp,
                        fontWeight = Bold
                    )
                )
            }
            Row(
                modifier = Modifier.padding(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.padding(4.dp)) {
                    AppButton(
                        modifier = Modifier.width(156.dp),
                        text = "Log In",
                        buttonColor = MaterialTheme.colorScheme.onBackground,
                        textColor = MaterialTheme.colorScheme.primary
                    ) { }
                    AppButton(
                        modifier = Modifier.width(156.dp),
                        text = "Log In",
                        buttonColor = MaterialTheme.colorScheme.background,
                        textColor = MaterialTheme.colorScheme.primary
                    ) { }
                }
                Column(modifier = Modifier.padding(4.dp)) {
                    AppButton(
                        modifier = Modifier.width(156.dp),
                        text = "Log In",
                        buttonColor = MaterialTheme.colorScheme.secondary,
                        textColor = MaterialTheme.colorScheme.primary
                    ) { }
                    AppButton(
                        modifier = Modifier.width(156.dp),
                        text = "Log In",
                        buttonColor = MaterialTheme.colorScheme.primary,
                    ) { }
                }

                Spacer(modifier = Modifier.padding(12.dp))

                Column(modifier = Modifier.padding(4.dp)) {
                    AppButton(
                        modifier = Modifier.width(100.dp).height(25.dp),
                        text = "Main Button",
                        buttonColor = MaterialTheme.colorScheme.onBackground,
                        textColor = MaterialTheme.colorScheme.primary
                    ) { }

                    Spacer(modifier = Modifier.padding(4.dp))

                    AppButton(
                        modifier = Modifier.width(100.dp).height(25.dp),
                        text = "Main Button",
                        buttonColor = MaterialTheme.colorScheme.secondary,
                        textColor = MaterialTheme.colorScheme.onSecondary
                    ) { }
                }

                Column(modifier = Modifier.padding(4.dp)) {
                    AppButton(
                        modifier = Modifier.width(100.dp).height(25.dp),
                        text = "Main Button",
                        buttonColor = MaterialTheme.colorScheme.secondary,
                        textColor = MaterialTheme.colorScheme.onSecondary
                    ) { }

                    Spacer(modifier = Modifier.padding(4.dp))

                    AppButton(
                        modifier = Modifier
                            .width(100.dp).height(25.dp)
                            .border(
                                width = 2.dp,
                                color = MaterialTheme.colorScheme.secondary,
                                shape = RoundedCornerShape(28.dp)
                            ),
                        text = "Main Button",
                        textStyle = MaterialTheme.typography.labelSmall,
                        buttonColor = MaterialTheme.colorScheme.background,
                        textColor = MaterialTheme.colorScheme.onPrimary
                    ) { }
                }

                Spacer(modifier = Modifier.padding(12.dp))

                Column(modifier = Modifier.padding(4.dp)) {
                    AppButton(
                        modifier = Modifier.width(100.dp).height(25.dp),
                        text = "Main Button",
                        buttonColor = MaterialTheme.colorScheme.onBackground,
                        textColor = MaterialTheme.colorScheme.primary,
                        image = rememberVectorPainter(image = Icons.Store),
                        imageSize = 14.dp
                    ) { }

                    Spacer(modifier = Modifier.padding(4.dp))

                    AppButton(
                        modifier = Modifier.width(100.dp).height(25.dp),
                        text = "Main Button",
                        buttonColor = MaterialTheme.colorScheme.secondary,
                        textColor = MaterialTheme.colorScheme.onSecondary,
                        image = rememberVectorPainter(image = Icons.Store),
                        imageSize = 14.dp,
                        imageColor = MaterialTheme.colorScheme.onTertiary
                    ) { }
                }
            }
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(16.dp))
                    .padding(start = 4.dp, top = 0.dp, end = 4.dp, bottom = 0.dp)
            ) {
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = "Menu Switch On / Off ",
                    color = MaterialTheme.colorScheme.secondary,
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontSize = 12.sp,
                        fontWeight = Bold
                    )
                )
            }

            Row(
                modifier = Modifier.padding(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    AppToggleCheckBox(
                        text = "Lose Weight",
                        textStyle = MaterialTheme.typography.labelSmall,
                        isSelected = false,
                        onClick = { },
                        modifier = Modifier.width(110.dp),
                        circleSize = 20.dp,
                    )
                    AppToggleCheckBox(
                        text = "Lose Weight",
                        textStyle = MaterialTheme.typography.labelSmall,
                        isSelected = true,
                        onClick = { },
                        modifier = Modifier.width(110.dp),
                        circleSize = 20.dp,
                    )
                }

                Spacer(modifier = Modifier.padding(20.dp))

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Row(modifier = Modifier.padding(4.dp)) {
                        AppButton(
                            text = "FAQ",
                            modifier = Modifier.width(140.dp).height(20.dp),
                            buttonColor = MaterialTheme.colorScheme.secondary,
                            textColor = MaterialTheme.colorScheme.onSecondary
                        ) { }
                        Spacer(modifier = Modifier.width(24.dp))
                        AppButton(
                            text = "Contact Us",
                            modifier = Modifier.width(140.dp).height(20.dp),
                            buttonColor = MaterialTheme.colorScheme.onBackground,
                            textColor = MaterialTheme.colorScheme.primary
                        ) { }
                    }
                    Row(modifier = Modifier.padding(4.dp)) {
                        AppButton(
                            text = "General",
                            modifier = Modifier.width(98.dp).height(20.dp),
                            buttonColor = MaterialTheme.colorScheme.secondary,
                            textColor = MaterialTheme.colorScheme.onSecondary
                        ) { }
                        Spacer(modifier = Modifier.width(4.dp))
                        AppButton(
                            text = "Account",
                            modifier = Modifier.width(98.dp).height(20.dp),
                            buttonColor = MaterialTheme.colorScheme.onBackground,
                            textColor = MaterialTheme.colorScheme.primary
                        ) { }
                        Spacer(modifier = Modifier.width(4.dp))
                        AppButton(
                            text = "Services",
                            modifier = Modifier.width(98.dp).height(20.dp),
                            buttonColor = MaterialTheme.colorScheme.onBackground,
                            textColor = MaterialTheme.colorScheme.primary
                        ) { }
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    AppButton(
                        text = "Search",
                        modifier = Modifier.width(304.dp).height(35.dp),
                        buttonColor = MaterialTheme.colorScheme.onBackground,
                        textColor = MaterialTheme.colorScheme.onSecondary
                    ) { }
                }

                Spacer(modifier = Modifier.padding(20.dp))

                Box(
                    modifier = Modifier.padding(8.dp),
                    contentAlignment = Alignment.Center
                ){
                    Box(
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(20.dp))
                            .width(100.dp)
                            .height(80.dp),
                    )
                    AppOutlinedButton(
                        text = "NEW B UTTON",
                        textColor = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.width(140.dp)
                    ) { }
                }
            }
            Text(
                modifier = Modifier.padding(start = 4.dp, top = 8.dp, end = 0.dp, bottom = 4.dp),
                text = "Bottom Navigation",
                color = MaterialTheme.colorScheme.secondary,
                style = TextStyle(
                    fontFamily = Poppins,
                    fontSize = 12.sp,
                    fontWeight = Bold
                )
            )
            Box(modifier = Modifier.width(150.dp)) {

            }
            BottomNavigation(modifier = Modifier)
        }

        Spacer(modifier = Modifier.padding(16.dp))


        Column {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                    .background(MaterialTheme.colorScheme.primary)
                    .width(640.dp)
                    .height(60.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    modifier = Modifier.padding(start = 24.dp),
                    text = "Icons",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontSize = 24.sp,
                        fontWeight = Bold
                    )
                )
            }
            Row {
                Column(modifier = Modifier.padding(4.dp)) {
                    Text(
                        modifier = Modifier.padding(start = 4.dp, top = 8.dp, end = 0.dp, bottom = 4.dp),
                        text = "Editable Icons",
                        color = MaterialTheme.colorScheme.secondary,
                        style = TextStyle(
                            fontFamily = Poppins,
                            fontSize = 12.sp,
                            fontWeight = Bold
                        )
                    )
                    Row(modifier = Modifier.padding(start = 4.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)) {
                        Image(
                            painter = rememberVectorPainter(image = Icons.WorkOut),
                            contentDescription = "check",
                            modifier = Modifier
                                .size(35.dp)
                                .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                        )
                        Image(
                            painter = rememberVectorPainter(image = Icons.ProgressTracking),
                            contentDescription = "check",
                            modifier = Modifier
                                .size(35.dp)
                                .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                        )
                        Image(
                            painter = rememberVectorPainter(image = Icons.Nutrition),
                            contentDescription = "check",
                            modifier = Modifier
                                .size(35.dp)
                                .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                        )
                        Image(
                            painter = rememberVectorPainter(image = Icons.Community),
                            contentDescription = "check",
                            modifier = Modifier
                                .size(35.dp)
                                .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                        )
                    }
                    Row(modifier = Modifier.padding(start = 4.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)) {
                        Image(
                            painter = rememberVectorPainter(image = Icons.Calories),
                            contentDescription = "check",
                            modifier = Modifier
                                .size(35.dp)
                                .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                        )
                        Image(
                            painter = rememberVectorPainter(image = Icons.DumbbellDefault),
                            contentDescription = "check",
                            modifier = Modifier
                                .size(35.dp)
                                .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                        )
                        Image(
                            painter = rememberVectorPainter(image = Icons.Cup),
                            contentDescription = "check",
                            modifier = Modifier
                                .size(35.dp)
                                .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                        )
                        Image(
                            painter = rememberVectorPainter(image = Icons.ProgressList),
                            contentDescription = "check",
                            modifier = Modifier
                                .size(35.dp)
                                .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                        )
                    }
                    Row(modifier = Modifier.padding(start = 4.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)) {
                        Image(
                            painter = rememberVectorPainter(image = Icons.BookmarkOff),
                            contentDescription = "check",
                            modifier = Modifier
                                .size(35.dp)
                                .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                        )
                        Image(
                            painter = rememberVectorPainter(image = Icons.Idea),
                            contentDescription = "check",
                            modifier = Modifier
                                .size(35.dp)
                                .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                        )
                        Image(
                            painter = rememberVectorPainter(image = Icons.ManGender),
                            contentDescription = "check",
                            modifier = Modifier
                                .size(35.dp)
                                .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                        )
                        Image(
                            painter = rememberVectorPainter(image = Icons.WomanGender),
                            contentDescription = "check",
                            modifier = Modifier
                                .size(35.dp)
                                .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .padding(start = 4.dp, top = 48.dp, end = 4.dp)
                        .width(2.dp)
                        .height(110.dp)
                        .background(MaterialTheme.colorScheme.secondary)
                )

                Column(
                    modifier = Modifier
                        .padding(4.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        modifier = Modifier.padding(start = 4.dp, top = 8.dp, bottom = 4.dp),
                        text = "Editable Bottom Navigation Icons",
                        color = MaterialTheme.colorScheme.secondary,
                        style = TextStyle(
                            fontFamily = Poppins,
                            fontSize = 12.sp,
                            fontWeight = Bold
                        )
                    )
                    Column(
                        modifier = Modifier
                            .height(120.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {

                        Row(
                            modifier = Modifier.padding(4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = rememberVectorPainter(Icons.HomeWhite),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(Icons.ResourcesWhite),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(Icons.SupportWhite),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(4.dp)
                            )
                        }

                        Row(
                            modifier = Modifier.padding(4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = rememberVectorPainter(Icons.Message),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(Icons.CheckWhite),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(Icons.Visibility),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(4.dp)
                            )
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .padding(start = 4.dp, top = 48.dp, end = 4.dp)
                        .width(2.dp)
                        .height(110.dp)
                        .background(MaterialTheme.colorScheme.secondary)
                )

                Column(
                    modifier = Modifier
                        .padding(4.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    Box(
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(16.dp))
                            .padding(start = 4.dp, top = 0.dp, end = 4.dp, bottom = 0.dp)
                    ) {
                        Text(
                            modifier = Modifier.padding(4.dp),
                            text = "Icons from bottom navigation",
                            color = MaterialTheme.colorScheme.secondary,
                            style = TextStyle(
                                fontFamily = Poppins,
                                fontSize = 12.sp,
                                fontWeight = Bold
                            )
                        )
                    }

                    Box(
                        modifier = Modifier
                            .height(120.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            modifier = Modifier.padding(4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = rememberVectorPainter(Icons.HomeWhite),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(Icons.ResourcesWhite),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(Icons.BookmarkOff),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(Icons.SupportWhite),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(4.dp)
                            )
                        }
                    }
                }

            }

            Column(modifier = Modifier.padding(4.dp)) {
                Box(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(16.dp))
                        .padding(start = 4.dp, top = 0.dp, end = 4.dp, bottom = 0.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(4.dp),
                        text = "Icons Components",
                        color = MaterialTheme.colorScheme.secondary,
                        style = TextStyle(
                            fontFamily = Poppins,
                            fontSize = 12.sp,
                            fontWeight = Bold
                        )
                    )
                }
                Row(modifier = Modifier.padding(4.dp)) {
                    Image(
                        painter = rememberVectorPainter(Icons.Calories),
                        contentDescription = null,
                        modifier = Modifier
                            .size(35.dp)
                            .padding(4.dp)
                    )
                    Image(
                        painter = rememberVectorPainter(Icons.WorkOut),
                        contentDescription = null,
                        modifier = Modifier
                            .size(35.dp)
                            .padding(4.dp)
                    )
                    Image(
                        painter = rememberVectorPainter(Icons.ResourcesWhite),
                        contentDescription = null,
                        modifier = Modifier
                            .size(35.dp)
                            .padding(4.dp)
                    )
                    Image(
                        painter = rememberVectorPainter(Icons.Nutrition),
                        contentDescription = null,
                        modifier = Modifier
                            .size(35.dp)
                            .padding(4.dp)
                    )
                    Image(
                        painter = rememberVectorPainter(Icons.GoogleIcon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .padding(4.dp)
                    )
                    Image(
                        painter = rememberVectorPainter(Icons.Facebook),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .padding(4.dp)
                    )
                    Image(
                        painter = rememberVectorPainter(Icons.FingerprintIcon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .padding(4.dp)
                    )
                    Image(
                        painter = rememberVectorPainter(Icons.Arrow),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .padding(4.dp)
                    )
                }
                Row(modifier = Modifier.padding(4.dp)) {
                    Image(
                        painter = rememberVectorPainter(Icons.Community),
                        contentDescription = null,
                        modifier = Modifier
                            .size(35.dp)
                            .padding(4.dp)
                    )
                    Image(
                        painter = rememberVectorPainter(Icons.DumbbellDefault),
                        contentDescription = null,
                        modifier = Modifier
                            .size(35.dp)
                            .padding(4.dp)
                    )
                    Image(
                        painter = rememberVectorPainter(Icons.TimeDefault),
                        contentDescription = null,
                        modifier = Modifier
                            .size(35.dp)
                            .padding(4.dp)
                    )
                    Image(
                        painter = rememberVectorPainter(Icons.Mark),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .padding(4.dp)
                    )
                }
            }
        }
    }
}