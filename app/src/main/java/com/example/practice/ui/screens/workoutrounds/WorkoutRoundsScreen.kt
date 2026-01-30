package com.example.practice.ui.screens.workoutrounds

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practice.FitnessScreen
import com.example.practice.domain.models.WorkoutBadgeItem
import com.example.practice.ui.screens.workoutrounds.actions.WorkoutRoundsSideEffect
import com.example.practice.ui.uikit.components.BadgeItem
import com.example.practice.ui.uikit.components.BottomNavigation
import com.example.practice.ui.uikit.components.TopBar
import com.example.practice.ui.uikit.components.WorkoutHeader

@Composable
fun WorkoutRoundsScreen(
    navController: NavController,
    viewModel: WorkoutRoundsViewModel
) {
    val uiState by viewModel.uiStateEmitter.collectAsState()
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()

    val entry = navController.currentBackStackEntry

    val workoutId = entry
        ?.arguments
        ?.getInt("workoutId")
        ?: 0

    LaunchedEffect(workoutId) {
        viewModel.loadWorkout(workoutId)
    }

    when (sideEffect) {
        is WorkoutRoundsSideEffect.ShowNavigationNext -> {

        }
        is WorkoutRoundsSideEffect.Empty -> {
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
                title = uiState.workout
                    ?.filter
                    ?.name
                    ?.lowercase()
                    ?.replaceFirstChar { it.uppercase() }
                    ?: ""
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                uiState.workout?.let { workout ->
                    WorkoutHeader(
                        badgeText = workout.title,
                        timeText = workout.duration,
                        caloriesText = workout.calories,
                        mainImage = painterResource(workout.imageRes),
                        title = null,
                        subtitle = null
                    )
                }

                uiState.visibleItems
                    .chunked(3)
                    .forEachIndexed { index, round ->
                    Text(
                        text = "Round ${index + 1}",
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 24.dp, top = 16.dp, bottom = 4.dp)
                    )

                    round.forEach { item ->
                        val badge = item as WorkoutBadgeItem.Item
                        BadgeItem(
                            modifier = Modifier
                                .padding(start = 20.dp, top = 12.dp, end = 20.dp)
                                .clickable {
                                    navController.navigate(
                                        FitnessScreen.WorkoutRoundDetail.createRoute(
                                            workoutId,
                                            badge.id
                                        )
                                    )
                                },
                            icon = rememberVectorPainter(badge.icon),
                            titleText = badge.titleText,
                            subtitleIcon = rememberVectorPainter(badge.subtitleIcon),
                            subtitleText = badge.subtitleText,
                            trailingTopText = badge.trailingTopText
                        )
                    }
                }
                Spacer(Modifier.height(56.dp))
            }
        }
        BottomNavigation(
            navController = navController,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}