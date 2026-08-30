package com.example.practice.ui.screens.progress_tracking.charts

import android.Manifest
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practice.FitnessScreen
import com.example.practice.R
import com.example.practice.data.steps.StepSyncScheduler
import com.example.practice.extensions.hasStepsPermission
import com.example.practice.ui.screens.progress_tracking.charts.actions.ChartsAction
import com.example.practice.ui.screens.progress_tracking.charts.actions.ChartsSideEffect
import com.example.practice.ui.uikit.components.AppButton
import com.example.practice.ui.uikit.components.BottomNavigation
import com.example.practice.ui.uikit.components.PopUpPermissions
import com.example.practice.ui.uikit.components.StepsChartCard
import com.example.practice.ui.uikit.components.StepsRecordsCard
import com.example.practice.ui.uikit.components.TodayActivityCard
import com.example.practice.ui.uikit.components.TopBar
import io.github.composegears.valkyrie.Icons
import io.github.composegears.valkyrie.WorkOut
import org.koin.androidx.compose.koinViewModel

@Composable
fun ChartsScreen(
    navController: NavController
) {
    val viewModel: ChartsViewModel = koinViewModel()
    val uiState by viewModel.uiStateEmitter.collectAsState()
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()

    val context = LocalContext.current
    var systemStepsPermissionGranted by remember {
        mutableStateOf<Boolean?>(null)
    }

    val stepsPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        systemStepsPermissionGranted = isGranted

        viewModel.handleUiAction(
            ChartsAction.StepsPermissionChanged(isGranted)
        )

        if (isGranted) {
            StepSyncScheduler.start(context)
        }
    }

    LaunchedEffect(Unit) {
        val isGranted = context.hasStepsPermission()

        systemStepsPermissionGranted = isGranted

        viewModel.handleUiAction(
            ChartsAction.StepsPermissionChanged(isGranted)
        )

        if (isGranted) {
            StepSyncScheduler.start(context)
        }
    }

    var isPermissionPopupDismissed by remember {
        mutableStateOf(false)
    }

    val shouldShowPermissionsPopUp =
        systemStepsPermissionGranted == false && !isPermissionPopupDismissed

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

            Spacer(modifier = Modifier.height(20.dp))

            TodayActivityCard(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .fillMaxWidth(),
                date = uiState.todayStepsUi.date,
                steps = uiState.todayStepsUi.steps,
                km = uiState.todayStepsUi.distance,
                calories = uiState.todayStepsUi.calories,
                goalOfSteps = uiState.todayStepsUi.goalOfSteps,
                goalProgress = uiState.todayStepsUi.goalProgress
            )

            Spacer(modifier = Modifier.height(20.dp))

            StepsRecordsCard(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .fillMaxWidth(),
                records = uiState.stepsRecordsUi
            )
            Spacer(modifier = Modifier.height(30.dp))
        }

        BottomNavigation(
            navController = navController,
            modifier = Modifier.align(Alignment.BottomCenter)
        )

        if (shouldShowPermissionsPopUp) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.6f))
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        // Consume clicks behind the popup.
                    }
                    .padding(horizontal = 20.dp),
                contentAlignment = Alignment.Center
            ) {
                PopUpPermissions(
                    modifier = Modifier
                        .fillMaxWidth()
                        .widthIn(max = 360.dp),
                    text = stringResource(R.string.steps_permission_popup_text),
                    image = rememberVectorPainter(image = Icons.WorkOut),
                    onClickYes = {
                        isPermissionPopupDismissed = true

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                            stepsPermissionLauncher.launch(Manifest.permission.ACTIVITY_RECOGNITION)
                        } else {
                            systemStepsPermissionGranted = true
                            viewModel.handleUiAction(ChartsAction.StepsPermissionChanged(true))
                            StepSyncScheduler.start(context)
                        }
                    },
                    onClickNo = {
                        isPermissionPopupDismissed = true
                    }
                )
            }
        }
    }
}
