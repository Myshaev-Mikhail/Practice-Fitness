package com.example.practice.ui.uikit

import CommunityOff
import CommunityOn
import NutritionOff
import NutritionOn
import ProgressOn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.R
import com.example.practice.ui.font.Poppins
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
import io.github.composegears.valkyrie.SupportAgent
import io.github.composegears.valkyrie.Telegram
import io.github.composegears.valkyrie.TimeDefault
import io.github.composegears.valkyrie.TimeVariant
import io.github.composegears.valkyrie.UserOff
import io.github.composegears.valkyrie.UserOn
import io.github.composegears.valkyrie.ValkyrieIcons
import io.github.composegears.valkyrie.Visibility
import io.github.composegears.valkyrie.WhatsApp
import io.github.composegears.valkyrie.WomanGender
import io.github.composegears.valkyrie.WorkOut
import io.github.composegears.valkyrie.WorkoutOff
import io.github.composegears.valkyrie.WorkoutOn

@Preview(widthDp = 1000, heightDp = 1500)
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
                    .background(colorResource(id = R.color.purple))
                    .width(640.dp)
                    .height(60.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    modifier = Modifier.padding(start = 24.dp),
                    text = "Funtional Icons",
                    color = colorResource(R.color.white),
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontSize = 24.sp,
                        fontWeight = Bold
                    )
                )
            }
            Row(modifier = Modifier.padding(start = 4.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)) {
                Column(modifier = Modifier.padding(8.dp)) {
                    Image(
                        painter = rememberVectorPainter(image = ValkyrieIcons.CheckProgress1),
                        contentDescription = "check",
                        modifier = Modifier
                            .size(70.dp)
                            .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                    )
                    Image(
                        painter = rememberVectorPainter(image = ValkyrieIcons.CheckProgress2),
                        contentDescription = "check",
                        modifier = Modifier
                            .size(70.dp)
                            .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                    )
                    Image(
                        painter = rememberVectorPainter(image = ValkyrieIcons.CheckProgress3),
                        contentDescription = "check",
                        modifier = Modifier
                            .size(70.dp)
                            .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                    )
                    Image(
                        painter = rememberVectorPainter(image = ValkyrieIcons.CheckProgressFull),
                        contentDescription = "check",
                        modifier = Modifier
                            .size(70.dp)
                            .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                    )
                }

                Column(modifier = Modifier.padding(8.dp)) {
                    Image(
                        painter = rememberVectorPainter(image = ValkyrieIcons.MaleOff),
                        contentDescription = "check",
                        modifier = Modifier
                            .size(70.dp)
                            .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                    )
                    Image(
                        painter = rememberVectorPainter(image = ValkyrieIcons.Property1MaleOn),
                        contentDescription = "check",
                        modifier = Modifier
                            .size(70.dp)
                            .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                    )
                    Image(
                        painter = rememberVectorPainter(image = ValkyrieIcons.FemaleOff),
                        contentDescription = "check",
                        modifier = Modifier
                            .size(70.dp)
                            .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                    )
                    Image(
                        painter = rememberVectorPainter(image = ValkyrieIcons.FemaleOn),
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
                                painter = rememberVectorPainter(image = ValkyrieIcons.BulbOff),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.BulbOn),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.CupOff),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.CupOn),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.ListOff),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.ListOn),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.StarOff),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.StarOn),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.NotificationOff),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.Property1NotificationOn),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }

                        Spacer(modifier = Modifier.padding(16.dp))

                        Column {
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.HomeWhite),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 5.dp, end = 5.dp, bottom = 5.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.HomePurple),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.ResourcesWhite),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.ResourcesPurple),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.SupportWhite),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.SupportPurple),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }


                        Column {
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.BookmarkOff),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.BookmarkOn),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.BookmarkOff1),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.BookmarkOn),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }

                        Column {
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.Add),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.Check),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.PlayOff),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.PlayOn),
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
                                painter = rememberVectorPainter(image = ValkyrieIcons.WorkoutOff),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.WorkoutOn),
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
                                painter = rememberVectorPainter(image = ValkyrieIcons.SearchOff),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.SearchOn),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.BellNotificationOff),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.BellNotificationOn),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.UserOff),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.UserOn),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }

                        Spacer(modifier = Modifier.padding(16.dp))

                        Column {
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.StarDefault),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.StarVariant),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.CardioDefault),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.CardioVariant),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.DumbbellDefault),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.DumbbellVariant),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.TimeDefault),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.TimeVariant),
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
                                painter = rememberVectorPainter(image = ValkyrieIcons.Profile),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.Favorites),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.Privacity),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.Settings),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.SupportAgent),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.Logout),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.Globe),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.WhatsApp),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }

                        Column {
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.Attachment),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.Facebook),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.Microphone),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.Instagram),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }
                        Column {
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.Telegram),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.Key),
                                contentDescription = "check",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                            )
                        }

                        Column {
                            Image(
                                painter = rememberVectorPainter(image = ValkyrieIcons.Bell),
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
                                    painter = rememberVectorPainter(image = ValkyrieIcons.Off),
                                    contentDescription = "check",
                                    modifier = Modifier
                                        .size(35.dp)
                                        .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                                )
                                Image(
                                    painter = rememberVectorPainter(image = ValkyrieIcons.On),
                                    contentDescription = "check",
                                    modifier = Modifier
                                        .size(35.dp)
                                        .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                                )
                            }

                            Spacer(modifier = Modifier.padding(16.dp))

                            Column {
                                Image(
                                    painter = rememberVectorPainter(image = ValkyrieIcons.EmptyPoint),
                                    contentDescription = "check",
                                    modifier = Modifier
                                        .size(35.dp)
                                        .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                                )
                                Image(
                                    painter = rememberVectorPainter(image = ValkyrieIcons.FillPoint),
                                    contentDescription = "check",
                                    modifier = Modifier
                                        .size(35.dp)
                                        .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                                )
                            }
                            Column {
                                Image(
                                    painter = rememberVectorPainter(image = ValkyrieIcons.StartSmallOff),
                                    contentDescription = "check",
                                    modifier = Modifier
                                        .size(35.dp)
                                        .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                                )
                                Image(
                                    painter = rememberVectorPainter(image = ValkyrieIcons.StartSmallOn),
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
                    .background(colorResource(id = R.color.purple))
                    .width(640.dp)
                    .height(60.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    modifier = Modifier.padding(start = 24.dp),
                    text = "Buttons",
                    color = colorResource(R.color.white),
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontSize = 24.sp,
                        fontWeight = Bold
                    )
                )
            }
            Row() {
                Column {

                }
            }
        }

        Spacer(modifier = Modifier.padding(16.dp))


        Column {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                    .background(colorResource(id = R.color.purple))
                    .width(640.dp)
                    .height(60.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    modifier = Modifier.padding(start = 24.dp),
                    text = "Icons",
                    color = colorResource(R.color.white),
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
                        color = colorResource(R.color.lime_green),
                        style = TextStyle(
                            fontFamily = Poppins,
                            fontSize = 12.sp,
                            fontWeight = Bold
                        )
                    )
                    Row(modifier = Modifier.padding(start = 4.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)) {
                        Image(
                            painter = rememberVectorPainter(image = ValkyrieIcons.WorkOut),
                            contentDescription = "check",
                            modifier = Modifier
                                .size(35.dp)
                                .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                        )
                        Image(
                            painter = rememberVectorPainter(image = ValkyrieIcons.ProgressTracking),
                            contentDescription = "check",
                            modifier = Modifier
                                .size(35.dp)
                                .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                        )
                        Image(
                            painter = rememberVectorPainter(image = ValkyrieIcons.Nutrition),
                            contentDescription = "check",
                            modifier = Modifier
                                .size(35.dp)
                                .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                        )
                        Image(
                            painter = rememberVectorPainter(image = ValkyrieIcons.Community),
                            contentDescription = "check",
                            modifier = Modifier
                                .size(35.dp)
                                .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                        )
                    }
                    Row(modifier = Modifier.padding(start = 4.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)) {
                        Image(
                            painter = rememberVectorPainter(image = ValkyrieIcons.Calories),
                            contentDescription = "check",
                            modifier = Modifier
                                .size(35.dp)
                                .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                        )
                        Image(
                            painter = rememberVectorPainter(image = ValkyrieIcons.DumbbellDefault),
                            contentDescription = "check",
                            modifier = Modifier
                                .size(35.dp)
                                .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                        )
                        Image(
                            painter = rememberVectorPainter(image = ValkyrieIcons.Cup),
                            contentDescription = "check",
                            modifier = Modifier
                                .size(35.dp)
                                .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                        )
                        Image(
                            painter = rememberVectorPainter(image = ValkyrieIcons.ProgressList),
                            contentDescription = "check",
                            modifier = Modifier
                                .size(35.dp)
                                .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                        )
                    }
                    Row(modifier = Modifier.padding(start = 4.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)) {
                        Image(
                            painter = rememberVectorPainter(image = ValkyrieIcons.BookmarkOff),
                            contentDescription = "check",
                            modifier = Modifier
                                .size(35.dp)
                                .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                        )
                        Image(
                            painter = rememberVectorPainter(image = ValkyrieIcons.Idea),
                            contentDescription = "check",
                            modifier = Modifier
                                .size(35.dp)
                                .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                        )
                        Image(
                            painter = rememberVectorPainter(image = ValkyrieIcons.ManGender),
                            contentDescription = "check",
                            modifier = Modifier
                                .size(35.dp)
                                .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                        )
                        Image(
                            painter = rememberVectorPainter(image = ValkyrieIcons.WomanGender),
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
                        .background(colorResource(R.color.lime_green))
                )

                Column(
                    modifier = Modifier
                        .padding(4.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        modifier = Modifier.padding(start = 4.dp, top = 8.dp, bottom = 4.dp),
                        text = "Editable Bottom Navigation Icons",
                        color = colorResource(R.color.lime_green),
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
                                painter = rememberVectorPainter(ValkyrieIcons.HomeWhite),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(ValkyrieIcons.ResourcesWhite),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(ValkyrieIcons.SupportWhite),
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
                                painter = rememberVectorPainter(ValkyrieIcons.Message),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(ValkyrieIcons.CheckWhite),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(ValkyrieIcons.Visibility),
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
                        .background(colorResource(R.color.lime_green))
                )

                Column(
                    modifier = Modifier
                        .padding(4.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    Box(
                        modifier = Modifier
                            .background(colorResource(R.color.purple), shape = RoundedCornerShape(16.dp))
                            .padding(start = 4.dp, top = 0.dp, end = 4.dp, bottom = 0.dp)
                    ) {
                        Text(
                            modifier = Modifier.padding(4.dp),
                            text = "Icons from bottom navigation",
                            color = colorResource(R.color.lime_green),
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
                                painter = rememberVectorPainter(ValkyrieIcons.HomeWhite),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(ValkyrieIcons.ResourcesWhite),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(ValkyrieIcons.BookmarkOff),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(4.dp)
                            )
                            Image(
                                painter = rememberVectorPainter(ValkyrieIcons.SupportWhite),
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
                        .background(colorResource(R.color.purple), shape = RoundedCornerShape(16.dp))
                        .padding(start = 4.dp, top = 0.dp, end = 4.dp, bottom = 0.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(4.dp),
                        text = "Icons Components",
                        color = colorResource(R.color.lime_green),
                        style = TextStyle(
                            fontFamily = Poppins,
                            fontSize = 12.sp,
                            fontWeight = Bold
                        )
                    )
                }
                Row(modifier = Modifier.padding(4.dp)) {
                    Image(
                        painter = rememberVectorPainter(ValkyrieIcons.Calories),
                        contentDescription = null,
                        modifier = Modifier
                            .size(35.dp)
                            .padding(4.dp)
                    )
                    Image(
                        painter = rememberVectorPainter(ValkyrieIcons.WorkOut),
                        contentDescription = null,
                        modifier = Modifier
                            .size(35.dp)
                            .padding(4.dp)
                    )
                    Image(
                        painter = rememberVectorPainter(ValkyrieIcons.ResourcesWhite),
                        contentDescription = null,
                        modifier = Modifier
                            .size(35.dp)
                            .padding(4.dp)
                    )
                    Image(
                        painter = rememberVectorPainter(ValkyrieIcons.Nutrition),
                        contentDescription = null,
                        modifier = Modifier
                            .size(35.dp)
                            .padding(4.dp)
                    )
                    Image(
                        painter = rememberVectorPainter(ValkyrieIcons.GoogleIcon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .padding(4.dp)
                    )
                    Image(
                        painter = rememberVectorPainter(ValkyrieIcons.Facebook),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .padding(4.dp)
                    )
                    Image(
                        painter = rememberVectorPainter(ValkyrieIcons.FingerprintIcon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .padding(4.dp)
                    )
                    Image(
                        painter = rememberVectorPainter(ValkyrieIcons.Arrow),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .padding(4.dp)
                    )
                }
                Row(modifier = Modifier.padding(4.dp)) {
                    Image(
                        painter = rememberVectorPainter(ValkyrieIcons.Community),
                        contentDescription = null,
                        modifier = Modifier
                            .size(35.dp)
                            .padding(4.dp)
                    )
                    Image(
                        painter = rememberVectorPainter(ValkyrieIcons.DumbbellDefault),
                        contentDescription = null,
                        modifier = Modifier
                            .size(35.dp)
                            .padding(4.dp)
                    )
                    Image(
                        painter = rememberVectorPainter(ValkyrieIcons.TimeDefault),
                        contentDescription = null,
                        modifier = Modifier
                            .size(35.dp)
                            .padding(4.dp)
                    )
                    Image(
                        painter = rememberVectorPainter(ValkyrieIcons.Mark),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .padding(4.dp)
                    )
                }
            }
        }


        Column {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                    .background(colorResource(id = R.color.purple))
                    .width(640.dp)
                    .height(60.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    modifier = Modifier.padding(start = 24.dp),
                    text = "Additional Elements",
                    color = colorResource(R.color.white),
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontSize = 24.sp,
                        fontWeight = Bold
                    )
                )
            }
            Row(modifier = Modifier.padding(start = 4.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)) {
                Image(
                    painter = painterResource(id = R.mipmap.ic_group),
                    contentDescription = "group",
                    modifier = Modifier
                        .size(65.dp)
                        .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                )

                Image(
                    painter = painterResource(id = R.mipmap.woman_working_out_gym_2_1),
                    contentDescription = "woman",
                    modifier = Modifier
                        .size(65.dp)
                        .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                )

                Image(
                    painter = painterResource(id = R.mipmap.woman_helping_man_gym_1_1),
                    contentDescription = "woman",
                    modifier = Modifier
                        .size(65.dp)
                        .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                )

                Image(
                    painter = painterResource(id = R.mipmap.woman_helping_man_gym_1),
                    contentDescription = "woman",
                    modifier = Modifier
                        .size(65.dp)
                        .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                )

                Image(
                    painter = painterResource(id = R.mipmap.woman_helping_man_gym_bike),
                    contentDescription = "woman",
                    modifier = Modifier
                        .size(65.dp)
                        .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                )


            }
            Row(modifier = Modifier.padding(start = 4.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)) {
                Image(
                    painter = painterResource(id = R.mipmap.woman_helping_man_gym_1_4),
                    contentDescription = "woman",
                    modifier = Modifier
                        .size(65.dp)
                        .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                )

                Image(
                    painter = painterResource(id = R.mipmap.woman_helping_man_gym_1_2),
                    contentDescription = "woman",
                    modifier = Modifier
                        .size(65.dp)
                        .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                )

                Image(
                    painter = painterResource(id = R.mipmap.ic_logo),
                    contentDescription = "woman",
                    modifier = Modifier
                        .size(65.dp)
                        .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                )

                Image(
                    painter = painterResource(id = R.mipmap.ic_cup),
                    contentDescription = "woman",
                    modifier = Modifier
                        .size(65.dp)
                        .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                )
            }
            Row(modifier = Modifier.padding(start = 4.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)) {
                Image(
                    painter = painterResource(id = R.mipmap.beautiful_young_sporty_man_training_workout_gym),
                    contentDescription = "woman",
                    modifier = Modifier
                        .size(65.dp)
                        .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                )

                Image(
                    painter = painterResource(id = R.mipmap.beautiful_young_sporty_woman_training_workout_gym),
                    contentDescription = "woman",
                    modifier = Modifier
                        .size(65.dp)
                        .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                )

                Image(
                    painter = painterResource(id = R.mipmap.beautiful_young_sporty_woman_training_workout_gym_3),
                    contentDescription = "woman",
                    modifier = Modifier
                        .size(65.dp)
                        .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                )
                Image(
                    painter = painterResource(id = R.mipmap.beautiful_young_sporty_man_training_workout_gym_3),
                    contentDescription = "woman",
                    modifier = Modifier
                        .size(65.dp)
                        .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                )
            }
        }
    }
}