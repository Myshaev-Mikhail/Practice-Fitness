package com.example.practice.ui.screens.progress_tracking.workout_log

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.practice.FitnessScreen
import com.example.practice.R
import com.example.practice.ui.screens.progress_tracking.workout_log.actions.ProgressTrackingAction
import com.example.practice.ui.screens.progress_tracking.workout_log.actions.ProgressTrackingSideEffect
import com.example.practice.ui.uikit.components.AppButton
import com.example.practice.ui.uikit.components.BottomNavigation
import com.example.practice.ui.uikit.components.CalendarWidget
import com.example.practice.ui.uikit.components.ProfileHorizontalCard
import com.example.practice.ui.uikit.components.TopBar
import com.example.practice.ui.uikit.theme.FitnessTheme
import io.github.composegears.valkyrie.Icons
import io.github.composegears.valkyrie.WomanGender
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProgressTrackingScreen(
    navController: NavController
) {
    val viewModel: ProgressTrackingViewModel = koinViewModel()
    val uiState by viewModel.uiStateEmitter.collectAsState()
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()

    LaunchedEffect(sideEffect) {
        when (sideEffect) {
            is ProgressTrackingSideEffect.Empty -> {
                // Nothing
            }

            is ProgressTrackingSideEffect.ShowCharts -> {
                navController.navigate(FitnessScreen.Charts.route)
                viewModel.clearSideEffect()
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
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(vertical = 40.dp)
        ) {
            TopBar(
                navController = navController,
                title = "Progress Tracking"
            )

            ProfileHorizontalCard(
                avatar = rememberAsyncImagePainter(model = uiState.avatarUri ?: R.mipmap.ic_group1),
                name = uiState.fullName.orEmpty(),
                age = uiState.age ?: 0,
                genderSymbol = rememberVectorPainter(image = Icons.WomanGender),
                weightKg = uiState.weight ?: 0f,
                heightMeters = uiState.height ?: 0
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                AppButton(
                    modifier = Modifier.weight(1f),
                    text = "Workout Log",
                    textColor = MaterialTheme.colorScheme.outlineVariant,
                    textStyle = MaterialTheme.typography.headlineSmall,
                    buttonColor = MaterialTheme.colorScheme.secondary,
                    onClick = {
                        // Nothing
                    }
                )

                Spacer(modifier = Modifier.width(12.dp))

                AppButton(
                    modifier = Modifier.weight(1f),
                    text = "Charts",
                    textColor = MaterialTheme.colorScheme.primary,
                    textStyle = MaterialTheme.typography.headlineSmall,
                    buttonColor = MaterialTheme.colorScheme.outline,
                    onClick = {
                        viewModel.handleUiAction(ProgressTrackingAction.ChartsPressed)
                    }
                )
            }

            CalendarWidget(
                modifier = Modifier.width(350.dp)
            )
        }

        BottomNavigation(
            navController = navController,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}
