package com.example.practice.ui.screens.nutrition.meal_plans

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practice.FitnessScreen
import com.example.practice.R
import com.example.practice.ui.screens.nutrition.meal_plans.actions.MealPlanSideEffect
import com.example.practice.ui.uikit.components.BottomNavigation
import com.example.practice.ui.uikit.components.Loading
import com.example.practice.ui.uikit.components.TopBar

@Composable
fun MealPlanLoadingScreen(
    navController: NavController,
    viewModel: MealPlanViewModel
) {
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()
    val uiState by viewModel.uiStateEmitter.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.saveMealPlan()
    }

    LaunchedEffect(uiState.isCreated) {
        if (uiState.isCreated) {
            navController.navigate(FitnessScreen.MealIdeas.route) {
                popUpTo(FitnessScreen.YourPlan.route) {
                    inclusive = true
                }
                launchSingleTop = true
            }
        }
    }

    when (sideEffect) {
        is MealPlanSideEffect.Empty -> {
            // Nothing
        }

        is MealPlanSideEffect.ShowNavigateBack -> {
            navController.popBackStack()
            viewModel.clearSideEffect()
        }

        is MealPlanSideEffect.ShowNavigationNext -> {
            // Nothing
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(top = 40.dp)
    ) {
        TopBar(
            navController = navController,
            title = stringResource(R.string.meal_plan_title)
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val errorMessage = uiState.errorMessage

            if (errorMessage == null) {
                Loading(isLoading = true)

                Text(
                    text = stringResource(R.string.meal_plan_creating),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.secondary,
                    textAlign = TextAlign.Center
                )
            } else {
                Text(
                    text = stringResource(errorMessage.messageRes),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = stringResource(
                        if (errorMessage.messageRes == R.string.meal_plan_save_error) {
                            R.string.meal_plan_error_description
                        } else {
                            R.string.meal_plan_adjust_preferences
                        }
                    ),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center
                )
            }
        }

        BottomNavigation(
            navController = navController
        )
    }
}
