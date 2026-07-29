package com.example.practice.ui.screens.workout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practice.FitnessScreen
import com.example.practice.domain.models.WorkoutFilter
import com.example.practice.ui.screens.workout.actions.WorkoutAction
import com.example.practice.ui.screens.workout.actions.WorkoutSideEffect
import com.example.practice.ui.uikit.components.AppButton
import com.example.practice.ui.uikit.components.BottomNavigation
import com.example.practice.ui.uikit.components.TopBar
import com.example.practice.ui.uikit.components.WorkoutCard
import com.example.practice.ui.uikit.components.WorkoutHeader
import org.koin.androidx.compose.koinViewModel

@Composable
fun WorkoutScreen(
    navController: NavController
) {
    val viewModel: WorkoutViewModel = koinViewModel()
    val uiState by viewModel.uiStateEmitter.collectAsState()
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()

    val filters = listOf(
        WorkoutFilter.BEGINNER to "Beginner",
        WorkoutFilter.INTERMEDIATE to "Intermediate",
        WorkoutFilter.ADVANCED to "Advanced"
    )

    when (sideEffect) {
        is WorkoutSideEffect.ShowNavigationNext -> {
            val effect = sideEffect as WorkoutSideEffect.ShowNavigationNext
            navController.navigate(
                FitnessScreen.WorkoutRounds.createRoute(
                    effect.filter,
                    effect.workoutId
                )
            )
            viewModel.clearSideEffect()
        }

        is WorkoutSideEffect.Empty -> {
            // Nothing
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
                .padding(top = 40.dp)
        ) {
            TopBar(
                navController = navController,
                title = uiState.selectedFilter
                    ?.name
                    ?.lowercase()
                    ?.replaceFirstChar { it.uppercase() }
                    ?: ""
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(start = 12.dp, top = 8.dp, end = 24.dp, bottom = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                filters.forEach { (filter, title) ->
                    AppButton(
                        modifier = Modifier
                            .width(110.dp)
                            .height(30.dp),
                        text = title,
                        textColor = if (uiState.selectedFilter == filter) {
                            MaterialTheme.colorScheme.onSecondary
                        } else {
                            MaterialTheme.colorScheme.primary
                        },
                        textStyle = MaterialTheme.typography.headlineSmall,
                        buttonColor = if (uiState.selectedFilter == filter) {
                            MaterialTheme.colorScheme.secondary
                        } else {
                            MaterialTheme.colorScheme.onBackground
                        }
                    ) {
                        viewModel.handleUiAction(
                            WorkoutAction.SelectFilter(filter)
                        )
                    }
                    Spacer(Modifier.width(4.dp))
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                WorkoutHeader(
                    badgeText = uiState.workoutHeadCardItem!!.badgeText,
                    timeText = uiState.workoutHeadCardItem!!.timeText,
                    caloriesText = uiState.workoutHeadCardItem!!.caloriesText,
                    mainImage = painterResource(id = uiState.workoutHeadCardItem!!.mainImage),
                    title = uiState.workoutHeadCardItem!!.title,
                    subtitle = uiState.workoutHeadCardItem!!.subtitle
                )

                uiState.visibleWorkouts.forEach { workout ->
                    WorkoutCard(
                        modifier = Modifier.padding(start = 12.dp, top = 8.dp, end = 12.dp, bottom = 8.dp),
                        title = workout.title,
                        duration = workout.duration,
                        calories = workout.calories,
                        exercises = workout.exercises,
                        image = painterResource(workout.imageRes),
                        onClick = {
                            viewModel.handleUiAction(
                                WorkoutAction.NavigationNext(
                                    filter = workout.filter,
                                    workoutId = workout.id
                                )
                            )
                        }
                    )
                }
                Spacer(Modifier.height(52.dp))
            }
        }
        BottomNavigation(
            navController = navController,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}