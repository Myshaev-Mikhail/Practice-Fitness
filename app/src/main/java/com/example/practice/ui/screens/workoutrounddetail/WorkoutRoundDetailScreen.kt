package com.example.practice.ui.screens.workoutrounddetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
            TopBar(navController = navController, title = "Exercise Detail")

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.tertiary)
            ) {
                uiState.imageRes?.let {
                    Image(
                        painter = painterResource(it),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp)
                    )
                }
            }

            Spacer(Modifier.height(16.dp))

            ExerciseCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                title = uiState.title,
                description = "Lorem Ipsum Dolor Sit Amet, Consectetur Adipiscing Elit. Sed Cursus Libero Eget.",
                durationText = "12 Minutes",
                levelText = "Medium"
            )
        }

        BottomNavigation(
            navController = navController,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}