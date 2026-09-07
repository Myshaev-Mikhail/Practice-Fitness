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
import kotlinx.coroutines.delay

@Composable
fun MealPlanLoadingScreen(
    navController: NavController,
    viewModel: MealPlanViewModel
) {
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()

    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        delay(5000L)
        isLoading = false
        delay(2000L)
        // TODO: Navigate to the meal plan result screen.
        navController.navigate(FitnessScreen.Home.route)
        viewModel.clearSideEffect()
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

        is MealPlanSideEffect.ShowMealPlanCreated -> {
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
            Loading(
                isLoading = isLoading
            )

            Text(
                text = "Creating a plan for you",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.secondary
            )
        }

        BottomNavigation(
            navController = navController
        )
    }
}
