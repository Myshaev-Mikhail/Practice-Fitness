package com.example.practice.ui.screens.workoutrounddetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.practice.ui.screens.workoutrounddetail.intents.WorkoutRoundDetailAction
import com.example.practice.ui.screens.workoutrounddetail.intents.WorkoutRoundDetailSideEffect
import com.example.practice.ui.uikit.components.BottomNavigation
import com.example.practice.ui.uikit.components.ExerciseCard
import com.example.practice.ui.uikit.components.TopBar
import com.example.practice.ui.uikit.components.WorkoutRoundDetail

@Composable
fun WorkoutRoundDetailScreen(
    navController: NavController
) {

    val viewModel: WorkoutRoundDetailViewModel = viewModel()
    val uiState by viewModel.uiStateEmitter.collectAsState()
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()

    when (sideEffect) {
        is WorkoutRoundDetailSideEffect.Empty -> {
            // Nothing
        }
    }

    val entry = navController.currentBackStackEntry

    val workoutId = entry?.arguments?.getInt("workoutId") ?: return
    val badgeId = entry.arguments?.getInt("badgeId") ?: return

    LaunchedEffect(workoutId, badgeId) {
        viewModel.uiAction(
            WorkoutRoundDetailAction.Load(
                workoutId = workoutId,
                badgeId = badgeId
            )
        )
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

            uiState.imageRes?.let {
                WorkoutRoundDetail(
                    image = painterResource(it),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            ExerciseCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 24.dp, bottom = 72.dp),
                title = uiState.title,
                description = uiState.description,
                durationText = uiState.time,
                levelText = uiState.rep
            )
        }

        BottomNavigation(
            navController = navController,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}