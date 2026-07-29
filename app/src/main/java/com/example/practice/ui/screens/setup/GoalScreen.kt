package com.example.practice.ui.screens.setup

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practice.FitnessScreen
import com.example.practice.R
import com.example.practice.domain.models.Goal
import com.example.practice.ui.screens.setup.actions.SetUpAction
import com.example.practice.ui.screens.setup.actions.SetUpSideEffect
import com.example.practice.ui.utils.localizedAppText
import com.example.practice.ui.uikit.components.AppOutlinedButton
import com.example.practice.ui.uikit.components.AppToggleCheckBox
import io.github.composegears.valkyrie.Arrow
import io.github.composegears.valkyrie.Icons
import org.koin.androidx.compose.koinViewModel

@Composable
fun GoalScreen(
    navController: NavController,
    viewModel: SetUpViewModel
) {
    val state by viewModel.uiStateEmitter.collectAsState()
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()

    val context = LocalContext.current
    val selectedGoals = state.goal?.toSet() ?: emptySet()

    LaunchedEffect(sideEffect) {
        when (sideEffect) {
            is SetUpSideEffect.NavigateNext -> {
                viewModel.clearSideEffect()
                navController.navigate(FitnessScreen.ActivityLevel.route)
            }

            is SetUpSideEffect.NavigateBack -> {
                viewModel.clearSideEffect()
                navController.popBackStack()
            }

            is SetUpSideEffect.ShowToast -> {
                Toast.makeText(
                    context,
                    context.localizedAppText((sideEffect as SetUpSideEffect.ShowToast).text),
                    Toast.LENGTH_SHORT
                ).show()
                viewModel.clearSideEffect()
            }

            else -> Unit
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(45.dp))
        Row(
            modifier = Modifier
                .align(Alignment.Start)
                .clickable {
                    viewModel.handleUiAction(SetUpAction.NavigateBack)
                }
        ) {
            Spacer(modifier = Modifier.width(24.dp))
            Image(
                painter = rememberVectorPainter(Icons.Arrow),
                contentDescription = null,
                modifier = Modifier
                    .size(11.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = stringResource(R.string.back),
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall,
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = stringResource(R.string.setup_goal_title),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = stringResource(R.string.setup_goal_description),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.labelLarge,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.tertiary)
                .padding(24.dp)
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                AppToggleCheckBox(
                    text = stringResource(R.string.lose_weight),
                    isSelected = selectedGoals.contains(Goal.LOSE_WEIGHT),
                    onClick = {
                        val updatedGoals =
                            if (selectedGoals.contains(Goal.LOSE_WEIGHT)) {
                                selectedGoals - Goal.LOSE_WEIGHT
                            } else {
                                selectedGoals + Goal.LOSE_WEIGHT
                            }

                        viewModel.handleUiAction(SetUpAction.GoalSelected(updatedGoals))
                    },
                )
                Spacer(modifier = Modifier.height(12.dp))
                AppToggleCheckBox(
                    text = stringResource(R.string.gain_weight),
                    isSelected = selectedGoals.contains(Goal.GAIN_WEIGHT),
                    onClick = {
                        val updatedGoals =
                            if (selectedGoals.contains(Goal.GAIN_WEIGHT)) {
                                selectedGoals - Goal.GAIN_WEIGHT
                            } else {
                                selectedGoals + Goal.GAIN_WEIGHT
                            }

                        viewModel.handleUiAction(SetUpAction.GoalSelected(updatedGoals))
                    },
                )
                Spacer(modifier = Modifier.height(12.dp))
                AppToggleCheckBox(
                    text = stringResource(R.string.muscle_mass_gain),
                    isSelected = selectedGoals.contains(Goal.MUSCLE_MASS_GAIN),
                    onClick = {
                        val updatedGoals =
                            if (selectedGoals.contains(Goal.MUSCLE_MASS_GAIN)) {
                                selectedGoals - Goal.MUSCLE_MASS_GAIN
                            } else {
                                selectedGoals + Goal.MUSCLE_MASS_GAIN
                            }

                        viewModel.handleUiAction(SetUpAction.GoalSelected(updatedGoals))
                    },
                )
                Spacer(modifier = Modifier.height(12.dp))
                AppToggleCheckBox(
                    text = stringResource(R.string.shape_body),
                    isSelected = selectedGoals.contains(Goal.SHAPE_BODY),
                    onClick = {
                        val updatedGoals =
                            if (selectedGoals.contains(Goal.SHAPE_BODY)) {
                                selectedGoals - Goal.SHAPE_BODY
                            } else {
                                selectedGoals + Goal.SHAPE_BODY
                            }

                        viewModel.handleUiAction(SetUpAction.GoalSelected(updatedGoals))
                    },
                )
                Spacer(modifier = Modifier.height(12.dp))
                AppToggleCheckBox(
                    text = stringResource(R.string.others),
                    isSelected = selectedGoals.contains(Goal.OTHERS),
                    onClick = {
                        val updatedGoals =
                            if (selectedGoals.contains(Goal.OTHERS)) {
                                selectedGoals - Goal.OTHERS
                            } else {
                                selectedGoals + Goal.OTHERS
                            }

                        viewModel.handleUiAction(SetUpAction.GoalSelected(updatedGoals))
                    },
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
        AppOutlinedButton(
            modifier = Modifier
                .width(180.dp)
                .padding(vertical = 4.dp),
            text = stringResource(R.string.continue_button),
            textStyle = MaterialTheme.typography.titleLarge,
        ) {
            viewModel.handleUiAction(SetUpAction.ContinueClickedGoal)
        }
    }
}
