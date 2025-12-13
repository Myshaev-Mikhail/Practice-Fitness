package com.example.practice.ui.uikit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import com.example.practice.ui.view.BadgeItem
import com.example.practice.ui.view.ExerciseCard
import com.example.practice.ui.view.ProfileStatsCard
import com.example.practice.ui.view.StatsCard
import com.example.practice.ui.view.WeightPicker
import io.github.composegears.valkyrie.NotificationOff
import io.github.composegears.valkyrie.PlayOff
import io.github.composegears.valkyrie.PlayOn
import io.github.composegears.valkyrie.Property1NotificationOn
import io.github.composegears.valkyrie.SearchOff
import io.github.composegears.valkyrie.TimeDefault
import io.github.composegears.valkyrie.ValkyrieIcons
import io.github.composegears.valkyrie.WorkOut

@Preview(widthDp = 1050, heightDp = 1400)
@Composable
fun AdditionalElements() {
    Column {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                .background(colorResource(id = R.color.purple))
                .width(1050.dp)
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

        Row(modifier = Modifier.padding(4.dp)) {
            Column {
                Text(
                    modifier = Modifier.padding(start = 4.dp, top = 8.dp, end = 0.dp, bottom = 4.dp),
                    text = "Avatar",
                    color = colorResource(R.color.lime_green),
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontSize = 12.sp,
                        fontWeight = Bold
                    )
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.mipmap.ic_group1),
                        contentDescription = "group",
                        modifier = Modifier
                            .size(55.dp)
                            .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                    )
                    Image(
                        painter = painterResource(id = R.mipmap.ic_group1),
                        contentDescription = "group",
                        modifier = Modifier
                            .size(65.dp)
                            .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                    )
                    Image(
                        painter = painterResource(id = R.mipmap.ic_group),
                        contentDescription = "group",
                        modifier = Modifier
                            .size(65.dp)
                            .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                    )
                    Box(
                        modifier = Modifier
                            .padding(start = 8.dp, top = 12.dp, end = 8.dp)
                            .width(2.dp)
                            .height(250.dp)
                            .background(colorResource(R.color.lime_green))
                    )
                }
            }

            Column {
                Text(
                    modifier = Modifier.padding(start = 4.dp, top = 8.dp, end = 0.dp, bottom = 4.dp),
                    text = "Badges",
                    color = colorResource(R.color.lime_green),
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontSize = 12.sp,
                        fontWeight = Bold
                    )
                )
                Row {
                    BadgeItem(
                        modifier = Modifier.size(width = 300.dp, height = 55.dp),
                        icon = rememberVectorPainter(image = ValkyrieIcons.PlayOff),
                        titleText = "Russian Twists",
                        subtitleIcon = rememberVectorPainter(image = ValkyrieIcons.TimeDefault),
                        subtitleText = "00:15",
                        trailingTopText = "Repetition 2x"
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    BadgeItem(
                        modifier = Modifier.size(width = 300.dp, height = 55.dp),
                        icon = rememberVectorPainter(image = ValkyrieIcons.PlayOn),
                        titleText = "Russian Twists",
                        subtitleIcon = rememberVectorPainter(image = ValkyrieIcons.TimeDefault),
                        subtitleText = "00:15",
                        trailingTopText = "Repetition 2x"
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row {
                    BadgeItem(
                        modifier = Modifier.size(width = 300.dp, height = 55.dp),
                        icon = rememberVectorPainter(image = ValkyrieIcons.NotificationOff),
                        titleText = "Don’t forget to drink water",
                        subtitleText = "June 10 - 8:00 AM",
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    BadgeItem(
                        modifier = Modifier.size(width = 300.dp, height = 55.dp),
                        icon = rememberVectorPainter(image = ValkyrieIcons.Property1NotificationOn),
                        titleText = "Don’t forget to drink water",
                        subtitleText = "June 10 - 8:00 AM",
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                BadgeItem(
                    modifier = Modifier.size(width = 300.dp, height = 55.dp),
                    icon = rememberVectorPainter(image = ValkyrieIcons.WorkOut),
                    iconBackgroundColor = colorResource(R.color.purple),
                    titleText = "Upper Body Workout",
                    subtitleText = "June 09",
                    trailingIcon = rememberVectorPainter(image = ValkyrieIcons.TimeDefault),
                    trailingTopText = "Duration",
                    trailingBottomText = "25 Mins"
                )
                Spacer(modifier = Modifier.height(20.dp))
                BadgeItem(
                    modifier = Modifier.size(width = 300.dp, height = 55.dp),
                    icon = rememberVectorPainter(image = ValkyrieIcons.SearchOff),
                    iconBackgroundColor = colorResource(R.color.lime_green),
                    titleText = "Circuit",
                )
            }
            Box(
                modifier = Modifier
                    .padding(start = 28.dp, top = 12.dp, end = 8.dp)
                    .width(2.dp)
                    .height(270.dp)
                    .background(colorResource(R.color.lime_green))
            )

            Column {
                Text(
                    modifier = Modifier.padding(start = 4.dp, top = 8.dp, end = 0.dp, bottom = 4.dp),
                    text = "Illustrations",
                    color = colorResource(R.color.lime_green),
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontSize = 12.sp,
                        fontWeight = Bold
                    )
                )
                Image(
                    painter = painterResource(id = R.mipmap.ic_cup),
                    contentDescription = "woman",
                    modifier = Modifier
                        .size(155.dp)
                        .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                )
            }

        }

        Box(
            modifier = Modifier
                .padding(start = 28.dp, top = 28.dp, end = 8.dp, bottom = 28.dp)
                .width(990.dp)
                .height(2.dp)
                .background(colorResource(R.color.lime_green))
        )

        Row(modifier = Modifier.padding(4.dp)) {
            Column {
                Text(
                    modifier = Modifier.padding(start = 4.dp, top = 8.dp, end = 0.dp, bottom = 4.dp),
                    text = "Cards",
                    color = colorResource(R.color.lime_green),
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontSize = 12.sp,
                        fontWeight = Bold
                    )
                )

                StatsCard(
                    modifier = Modifier.size(width = 280.dp, height = 65.dp),
                    dayLabel = "Thu",
                    dayNumber = "14",
                    centerTitle = "Steps",
                    centerValue = "3,679",
                    rightTitle = "Duration",
                    rightValue = "1hr40m",
                )

                Spacer(modifier = Modifier.height(12.dp))

                ExerciseCard(
                    modifier = Modifier.size(width = 280.dp, height = 140.dp),
                    title = "Dumbbell Step Up",
                    description = "Lorem Ipsum Dolor Sit Amet, Consectetur Adipiscing Elit. Sed Cursus Libero Eget.",
                    durationText = "12 Minutes",
                    levelText = "Medium"
                )

                Spacer(modifier = Modifier.height(12.dp))

                ProfileStatsCard(
                    modifier = Modifier.size(width = 280.dp, height = 140.dp),
                    avatar = painterResource(id = R.mipmap.ic_group1),
                    name = "Madison",
                    description = "Lorem ipsum dolor sit amet consectetur. Tortor aenean suspendisse pretium nunc non facilisi.",
                    likesCount = "30,254",
                    commentsCount = "12,254",
                    viewsCount = "1,254"
                )
            }
        }



        Row(modifier = Modifier.padding(4.dp)) {
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
        WeightPicker()
    }
}