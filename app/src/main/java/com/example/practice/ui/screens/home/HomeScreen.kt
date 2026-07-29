package com.example.practice.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.practice.FitnessScreen
import com.example.practice.R
import com.example.practice.ui.screens.home.actions.HomeAction
import com.example.practice.ui.screens.home.actions.HomeSideEffect
import com.example.practice.ui.uikit.components.BottomNavigation
import com.example.practice.ui.uikit.components.CyclingChallengeCard
import com.example.practice.ui.uikit.components.NavBar
import com.example.practice.ui.uikit.components.WorkoutPreviewCard
import com.example.practice.ui.uikit.theme.Poppins
import io.github.composegears.valkyrie.Arrow
import io.github.composegears.valkyrie.BellNotificationOff
import io.github.composegears.valkyrie.Calories
import io.github.composegears.valkyrie.Icons
import io.github.composegears.valkyrie.SearchOff
import io.github.composegears.valkyrie.UserOff
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    navController: NavController
) {
    val viewModel: HomeViewModel = koinViewModel()
    val uiState by viewModel.uiStateEmitter.collectAsState()
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()

    LaunchedEffect(sideEffect) {
        when (sideEffect) {
            is HomeSideEffect.ShowSearchScreen -> {
            //navController.navigate(FitnessScreen.LogIn.route)
                viewModel.clearSideEffect()
            // TODO
            }
            is HomeSideEffect.ShowNotificationScreen -> {
                navController.navigate(FitnessScreen.NotificationSetting.route)
                viewModel.clearSideEffect()
            // TODO
            }
            is HomeSideEffect.ShowProfileScreen -> {
                navController.navigate(FitnessScreen.Profile.route)
                viewModel.clearSideEffect()
            }
            is HomeSideEffect.ShowProgressTrackingScreen -> {
            //navController.navigate(FitnessScreen.LogIn.route)
                viewModel.clearSideEffect()
            // TODO
            }
            is HomeSideEffect.ShowNutritionScreen -> {
            //navController.navigate(FitnessScreen.LogIn.route)
                viewModel.clearSideEffect()
            // TODO
            }
            is HomeSideEffect.ShowCommunityScreen -> {
            //navController.navigate(FitnessScreen.LogIn.route)
                viewModel.clearSideEffect()
            // TODO
            }
            is HomeSideEffect.ShowWorkoutSeeAll -> {
                navController.navigate(FitnessScreen.Workout.route)
                viewModel.clearSideEffect()
            }
            is HomeSideEffect.Empty -> {
            // Nothing
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(top = 36.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, top = 0.dp, end = 24.dp, bottom = 0.dp),
                verticalAlignment = Alignment.Top
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(4.dp)
                            .align(Alignment.Start)
                    ) {
                        Text(
                            text = uiState.nickname?.let {
                                stringResource(R.string.home_hi_name, it)
                            } ?: stringResource(R.string.home_hi),
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                    Text(
                        text = stringResource(R.string.home_challenge_limits),
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
                Row(
                    modifier = Modifier.padding(start = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = rememberVectorPainter(image = Icons.SearchOff),
                        contentDescription = "search",
                        modifier = Modifier
                            .padding(8.dp)
                            .size(24.dp)
                            .clickable {
                                viewModel.handleUiAction(HomeAction.Search)
                            }
                    )
                    Image(
                        painter = rememberVectorPainter(image = Icons.BellNotificationOff),
                        contentDescription = "notification",
                        modifier = Modifier
                            .padding(8.dp)
                            .size(24.dp)
                            .clickable {
                                viewModel.handleUiAction(HomeAction.Notification)
                            }
                    )
                    Image(
                        painter = rememberVectorPainter(image = Icons.UserOff),
                        contentDescription = "profile_user",
                        modifier = Modifier
                            .padding(8.dp)
                            .size(24.dp)
                            .clickable {
                                viewModel.handleUiAction(HomeAction.Profile)
                            }
                    )
                }
            }
            NavBar(
                workout = true,
                onWorkoutClick = { null },
                onProgressClick = {
                    viewModel.handleUiAction(HomeAction.ProgressTracking)
                },
                onNutritionClick = {
                    viewModel.handleUiAction(HomeAction.Nutrition)
                },
                onCommunityClick = {
                    viewModel.handleUiAction(HomeAction.Community)
                },
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 24.dp)
                    .clickable {
                        viewModel.handleUiAction(HomeAction.WorkoutSeeAll)
                    },
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.recommendations),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondary
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = stringResource(R.string.see_all),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.outline
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Image(
                        painter = rememberVectorPainter(Icons.Arrow),
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp)
                            .rotate(180f)
                    )
                }
            }
            Row(
                modifier = Modifier.padding(start = 24.dp, top = 12.dp, bottom = 12.dp)
            ) {
                WorkoutPreviewCard(
                    modifier = Modifier.width(150.dp),
                    title = "squat Exercise",
                    durationText = "12 Minutes",
                    exercisesText = "120 Kcal",
                    image = painterResource(id = R.mipmap.woman_helping_man_gym_1_2),
                    isStar = true,
                    icon = rememberVectorPainter(Icons.Calories)
                )
                Spacer(modifier = Modifier.width(8.dp))
                WorkoutPreviewCard(
                    modifier = Modifier.width(150.dp),
                    title = "Full Body stretching",
                    durationText = "12 Minutes",
                    exercisesText = "120 Kcal",
                    image = painterResource(id = R.mipmap.woman_helping_man_gym_1_2),
                    isStar = false,
                    icon = rememberVectorPainter(Icons.Calories)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.tertiary)
                    .padding(20.dp)
            ) {
                CyclingChallengeCard(
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
            }

            Text(
                text = stringResource(R.string.articles_tips),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.padding(start = 24.dp, top = 12.dp)
            )
            Row(
                modifier = Modifier.padding(start = 24.dp, top = 8.dp, bottom = 24.dp)
            ) {
                WorkoutPreviewCard(
                    modifier = Modifier.width(150.dp),
                    title = "squat Exercise",
                    durationText = "12 Minutes",
                    exercisesText = "120 Kcal",
                    image = painterResource(id = R.mipmap.woman_helping_man_gym_1_2),
                    isStar = true,
                    icon = rememberVectorPainter(Icons.Calories)
                )
                Spacer(modifier = Modifier.width(8.dp))
                WorkoutPreviewCard(
                    modifier = Modifier.width(150.dp),
                    title = "Full Body stretching",
                    durationText = "12 Minutes",
                    exercisesText = "120 Kcal",
                    image = painterResource(id = R.mipmap.woman_helping_man_gym_1_2),
                    isStar = false,
                    icon = rememberVectorPainter(Icons.Calories)
                )
            }
        }

        BottomNavigation(
            navController = navController,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}
