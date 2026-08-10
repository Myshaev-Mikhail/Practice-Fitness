package com.example.practice.ui.screens.progress_tracking.charts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practice.FitnessScreen
import com.example.practice.ui.screens.progress_tracking.charts.actions.ChartsAction
import com.example.practice.ui.screens.progress_tracking.charts.actions.ChartsSideEffect
import com.example.practice.ui.uikit.components.AppButton
import com.example.practice.ui.uikit.components.BottomNavigation
import com.example.practice.ui.uikit.components.StepsChartCard
import com.example.practice.ui.uikit.components.TopBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun ChartsScreen(
    navController: NavController
) {
    val viewModel: ChartsViewModel = koinViewModel()
    val uiState by viewModel.uiStateEmitter.collectAsState()
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()

    LaunchedEffect(sideEffect) {
        when (sideEffect) {
            is ChartsSideEffect.Empty -> {
                // Nothing
            }

            is ChartsSideEffect.ShowProgressTracking -> {
                navController.navigate(FitnessScreen.ProgressTracking.route)
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

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                AppButton(
                    modifier = Modifier.weight(1f),
                    text = "Workout Log",
                    textColor = MaterialTheme.colorScheme.primary,
                    textStyle = MaterialTheme.typography.headlineSmall,
                    buttonColor = MaterialTheme.colorScheme.outline,
                    onClick = {
                        viewModel.handleUiAction(ChartsAction.ProgressTrackingPressed)
                    }
                )

                Spacer(modifier = Modifier.width(12.dp))

                AppButton(
                    modifier = Modifier.weight(1f),
                    text = "Charts",
                    textColor = MaterialTheme.colorScheme.outlineVariant,
                    textStyle = MaterialTheme.typography.headlineSmall,
                    buttonColor = MaterialTheme.colorScheme.secondary,
                    onClick = {
                        // Nothing
                    }
                )
            }

            StepsChartCard(
                modifier = Modifier
                    .padding(start = 20.dp, top = 24.dp, end = 20.dp)
                    .fillMaxWidth(),
                title = "Steps",
                yLabels = uiState.monthSteps.fromMaxToMinSteps,
                months = uiState.monthSteps.month,
                values = uiState.monthSteps.normalizeSteps
            )

        }

        BottomNavigation(
            navController = navController,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}
