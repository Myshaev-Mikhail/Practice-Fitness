package com.example.practice.ui.uikit.preview

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.R
import com.example.practice.ui.uikit.theme.Poppins
import com.example.practice.ui.uikit.components.BadgeItem
import com.example.practice.ui.uikit.components.CalendarWidget
import com.example.practice.ui.uikit.components.CyclingChallengeCard
import com.example.practice.ui.uikit.components.ExerciseCard
import com.example.practice.ui.uikit.components.HeightPicker
import com.example.practice.ui.uikit.components.LogIn
import com.example.practice.ui.uikit.components.ProfileCard
import com.example.practice.ui.uikit.components.ProfileHorizontalCard
import com.example.practice.ui.uikit.components.ProfileStatsCard
import com.example.practice.ui.uikit.components.RecipeCard
import com.example.practice.ui.uikit.components.Search
import com.example.practice.ui.uikit.components.SignUp
import com.example.practice.ui.uikit.components.StatsCard
import com.example.practice.ui.uikit.components.StepsChartCard
import com.example.practice.ui.uikit.components.WeightPicker
import com.example.practice.ui.uikit.components.WorkoutCard
import com.example.practice.ui.uikit.components.WorkoutPreviewCard
import io.github.composegears.valkyrie.BulbOn
import io.github.composegears.valkyrie.NotificationOff
import io.github.composegears.valkyrie.PlayOff
import io.github.composegears.valkyrie.PlayOn
import io.github.composegears.valkyrie.SearchOff
import io.github.composegears.valkyrie.TimeDefault
import io.github.composegears.valkyrie.Icons
import io.github.composegears.valkyrie.WomanGender
import io.github.composegears.valkyrie.WorkOut

@Preview(widthDp = 2450, heightDp = 3500)
@Composable
fun AdditionalElements() {
    Column {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                .background(MaterialTheme.colorScheme.primary)
                .width(1050.dp)
                .height(60.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                modifier = Modifier.padding(start = 24.dp),
                text = "Additional Elements",
                color = MaterialTheme.colorScheme.onPrimary,
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
                    color = MaterialTheme.colorScheme.secondary,
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
                            .background(MaterialTheme.colorScheme.secondary)
                    )
                }
            }

            Column {
                Text(
                    modifier = Modifier.padding(start = 4.dp, top = 8.dp, end = 0.dp, bottom = 4.dp),
                    text = "Badges",
                    color = MaterialTheme.colorScheme.secondary,
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontSize = 12.sp,
                        fontWeight = Bold
                    )
                )
                Row {
                    BadgeItem(
                        modifier = Modifier.size(width = 300.dp, height = 55.dp),
                        icon = rememberVectorPainter(image = Icons.PlayOff),
                        titleText = "Russian Twists",
                        subtitleIcon = rememberVectorPainter(image = Icons.TimeDefault),
                        subtitleText = "00:15",
                        trailingTopText = "Repetition 2x"
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    BadgeItem(
                        modifier = Modifier.size(width = 300.dp, height = 55.dp),
                        icon = rememberVectorPainter(image = Icons.PlayOn),
                        titleText = "Russian Twists",
                        subtitleIcon = rememberVectorPainter(image = Icons.TimeDefault),
                        subtitleText = "00:15",
                        trailingTopText = "Repetition 2x"
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row {
                    BadgeItem(
                        modifier = Modifier.size(width = 300.dp, height = 55.dp),
                        icon = rememberVectorPainter(image = Icons.NotificationOff),
                        titleText = "Don’t forget to drink water",
                        subtitleText = "June 10 - 8:00 AM",
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    BadgeItem(
                        modifier = Modifier.size(width = 300.dp, height = 55.dp),
                        icon = rememberVectorPainter(image = Icons.BulbOn),
                        titleText = "Don’t forget to drink water",
                        subtitleText = "June 10 - 8:00 AM",
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                BadgeItem(
                    modifier = Modifier.size(width = 300.dp, height = 55.dp),
                    icon = rememberVectorPainter(image = Icons.WorkOut),
                    iconBackgroundColor = MaterialTheme.colorScheme.primary,
                    titleText = "Upper Body Workout",
                    subtitleText = "June 09",
                    trailingIcon = rememberVectorPainter(image = Icons.TimeDefault),
                    trailingTopText = "Duration",
                    trailingBottomText = "25 Mins"
                )
                Spacer(modifier = Modifier.height(20.dp))
                BadgeItem(
                    modifier = Modifier.size(width = 300.dp, height = 55.dp),
                    icon = rememberVectorPainter(image = Icons.SearchOff),
                    iconBackgroundColor = MaterialTheme.colorScheme.secondary,
                    titleText = "Circuit",
                )
            }
            Box(
                modifier = Modifier
                    .padding(start = 28.dp, top = 12.dp, end = 8.dp)
                    .width(2.dp)
                    .height(270.dp)
                    .background(MaterialTheme.colorScheme.secondary)
            )

            Column {
                Text(
                    modifier = Modifier.padding(start = 4.dp, top = 8.dp, end = 0.dp, bottom = 4.dp),
                    text = "Illustrations",
                    color = MaterialTheme.colorScheme.secondary,
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

            Column {
                Text(
                    modifier = Modifier.padding(start = 4.dp, top = 8.dp, end = 0.dp, bottom = 4.dp),
                    text = "Оставшиеся картинки",
                    color = MaterialTheme.colorScheme.secondary,
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontSize = 12.sp,
                        fontWeight = Bold
                    )
                )
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
                Row(modifier = Modifier.padding(start = 4.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)) {
                    Image(
                        painter = painterResource(id = R.mipmap.woman_helping_man_gym_bike),
                        contentDescription = "woman",
                        modifier = Modifier
                            .size(65.dp)
                            .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                    )

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
            }
        }

        Box(
            modifier = Modifier
                .padding(start = 28.dp, top = 28.dp, end = 8.dp, bottom = 28.dp)
                .width(990.dp)
                .height(2.dp)
                .background(MaterialTheme.colorScheme.secondary)
        )

        Row(modifier = Modifier.padding(4.dp)) {
            Column {
                Text(
                    modifier = Modifier.padding(start = 4.dp, top = 8.dp, end = 0.dp, bottom = 4.dp),
                    text = "Cards",
                    color = MaterialTheme.colorScheme.secondary,
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
            Spacer(modifier = Modifier.width(20.dp))
            Column(modifier = Modifier.padding(4.dp)) {
                ProfileCard(
                    modifier = Modifier.size(width = 300.dp, height = 240.dp),
                    avatar = painterResource(id = R.mipmap.ic_group1),
                    name = "Madison Smith",
                    email = "madisons@example.com",
                    birthday = "April 1st",
                    weightKg = 75,
                    age = 28,
                    heightMeters = 1.65f
                )
                Spacer(modifier = Modifier.height(20.dp))
                ProfileHorizontalCard(
                    modifier = Modifier.size(width = 310.dp, height = 140.dp),
                    avatar = painterResource(R.mipmap.ic_group1),
                    name = "Madison",
                    age = 28,
                    genderSymbol = rememberVectorPainter(image = Icons.WomanGender),
                    weightKg = 75,
                    heightMeters = 1.65f
                )
            }

            Box(
                modifier = Modifier
                    .padding(start = 8.dp, top = 12.dp, end = 8.dp)
                    .width(2.dp)
                    .height(400.dp)
                    .background(MaterialTheme.colorScheme.secondary)
            )

            Column(modifier = Modifier.padding(4.dp)) {
                Text(
                    modifier = Modifier.padding(start = 4.dp, top = 8.dp, end = 0.dp, bottom = 4.dp),
                    text = "Graphs",
                    color = MaterialTheme.colorScheme.secondary,
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontSize = 12.sp,
                        fontWeight = Bold
                    )
                )
                Spacer(modifier = Modifier.height(20.dp))
                StepsChartCard(
                    title = "Steps",
                    yLabels = listOf(170, 165, 155, 150),
                    months = listOf("Jan", "Feb", "Mar", "Apr"),
                    values = listOf(0.65f, 0.85f, 0.55f, 0.60f)
                )
                WeightPicker(modifier = Modifier.width(310.dp))
            }

            Spacer(modifier = Modifier.width(20.dp))
            HeightPicker()
        }

        Box(
            modifier = Modifier
                .padding(start = 28.dp, top = 28.dp, end = 8.dp, bottom = 28.dp)
                .width(990.dp)
                .height(2.dp)
                .background(MaterialTheme.colorScheme.secondary)
        )

        Row(modifier = Modifier.padding(4.dp)) {
            Column(modifier = Modifier.padding(4.dp)) {
                Text(
                    modifier = Modifier.padding(start = 4.dp, top = 8.dp, end = 0.dp, bottom = 4.dp),
                    text = "Calendar",
                    color = MaterialTheme.colorScheme.secondary,
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontSize = 12.sp,
                        fontWeight = Bold
                    )
                )

                Box(
                    modifier = Modifier
                    .padding(8.dp)
                    .size(300.dp)
                ) {
                    CalendarWidget(
                        modifier = Modifier.width(350.dp)
                    )
                }

                Text(
                    modifier = Modifier.padding(start = 4.dp, top = 8.dp, end = 0.dp, bottom = 4.dp),
                    text = "App Logo",
                    color = MaterialTheme.colorScheme.secondary,
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontSize = 12.sp,
                        fontWeight = Bold
                    )
                )
                Spacer(modifier = Modifier.height(12.dp))
                Box {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.mipmap.ic_logo),
                            contentDescription = "woman",
                            modifier = Modifier
                                .width(270.dp)
                                .height(120.dp)
                                .padding(start = 0.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                        )
                        Row {
                            Text(
                                text = "FIT",
                                color = MaterialTheme.colorScheme.secondary,
                                style = TextStyle(
                                    fontFamily = Poppins,
                                    fontSize = 80.sp,
                                    fontWeight = Bold
                                )
                            )
                            Text(
                                text = "BODY",
                                color = MaterialTheme.colorScheme.secondary,
                                style = TextStyle(
                                    fontFamily = Poppins,
                                    fontSize = 80.sp,
                                    fontWeight = Normal
                                )
                            )
                        }
                    }
                }
            }

            Box(
                modifier = Modifier
                    .padding(start = 28.dp, top = 12.dp, end = 8.dp)
                    .width(2.dp)
                    .height(650.dp)
                    .background(MaterialTheme.colorScheme.secondary)
            )

            Column(modifier = Modifier.padding(4.dp)) {
                Text(
                    modifier = Modifier.padding(start = 4.dp, top = 8.dp, end = 0.dp, bottom = 4.dp),
                    text = "CTA",
                    color = MaterialTheme.colorScheme.secondary,
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontSize = 12.sp,
                        fontWeight = Bold
                    )
                )

                Box(
                    modifier = Modifier.width(850.dp).height(680.dp)
                ) {
                    Row {
                        Column {
                            WorkoutCard(modifier = Modifier.width(400.dp))
                            Spacer(modifier = Modifier.height(8.dp))
                            CyclingChallengeCard(
                                modifier = Modifier
                                    .width(400.dp),
                                background = MaterialTheme.colorScheme.onSecondary,
                                title = "Weekly \n" + "Challenge",
                                styleTitle = TextStyle(
                                    fontFamily = Poppins,
                                    fontWeight = Medium,
                                    fontSize = 24.sp,
                                    color = MaterialTheme.colorScheme.secondary
                                ),
                                description = "Plank With Hip Twist",
                                styleDescription = TextStyle(
                                    fontFamily = Poppins,
                                    fontWeight = Normal,
                                    fontSize = 12.sp,
                                    color = MaterialTheme.colorScheme.onPrimary
                                ),
                                image = painterResource(id = R.mipmap.woman_helping_man_gym_1_4)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            RecipeCard(
                                modifier = Modifier.width(360.dp),
                                badgeText = "Recipe Of The Day",
                                title = "Carrot And Orange Smoothie",
                                timeText = "10 Minutes",
                                caloriesText = "70 Cal",
                                mainImage = painterResource(id = R.mipmap.woman_helping_man_gym_1_1),
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            WorkoutPreviewCard(
                                modifier = Modifier.width(150.dp),
                                title = "Loop Band Exercises",
                                durationText = "45 Minutes",
                                exercisesText = "5 Exercises",
                                image = painterResource(id = R.mipmap.woman_helping_man_gym_1_2),
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            CyclingChallengeCard(modifier = Modifier.width(400.dp))
                            Spacer(modifier = Modifier.height(8.dp))
                            RecipeCard(
                                modifier = Modifier.width(360.dp),
                                badgeText = "dumbbell step up",
                                timeText = "12 Minutes",
                                caloriesText = "120 Cal",
                                mainImage = painterResource(id = R.mipmap.woman_working_out_gym_2_1),
                            )
                        }

                    }
                }

            }

            Box(
                modifier = Modifier
                    .padding(start = 28.dp, top = 12.dp, end = 8.dp)
                    .width(2.dp)
                    .height(650.dp)
                    .background(MaterialTheme.colorScheme.secondary)
            )

            Column(modifier = Modifier.padding(4.dp)) {
                Text(
                    modifier = Modifier.padding(start = 4.dp, top = 8.dp, end = 0.dp, bottom = 4.dp),
                    text = "Input Fields",
                    color = MaterialTheme.colorScheme.secondary,
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontSize = 12.sp,
                        fontWeight = Bold
                    )
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    modifier = Modifier.padding(start = 12.dp, top = 8.dp, end = 0.dp, bottom = 4.dp),
                    text = "Search",
                    color = MaterialTheme.colorScheme.secondary,
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontSize = 12.sp,
                        fontWeight = Bold
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                Search(modifier = Modifier.width(350.dp))

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    modifier = Modifier.padding(start = 12.dp, top = 8.dp, end = 0.dp, bottom = 4.dp),
                    text = "Password & Date Iput Feild",
                    color = MaterialTheme.colorScheme.secondary,
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontSize = 12.sp,
                        fontWeight = Bold
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                //LogIn(modifier = Modifier.width(350.dp))
                Spacer(modifier = Modifier.height(8.dp))
                //SignUp(modifier = Modifier.width(350.dp))
            }
        }
    }
}