package com.example.practice.ui.screens.nutrition.meal_plans

import android.widget.Toast
import androidx.compose.ui.res.stringResource
import com.example.practice.R
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practice.FitnessScreen
import com.example.practice.ui.screens.nutrition.meal_plans.actions.MealPlanAction
import com.example.practice.ui.screens.nutrition.meal_plans.actions.MealPlanSideEffect
import com.example.practice.ui.uikit.components.AppButton
import com.example.practice.ui.uikit.components.BottomNavigation
import com.example.practice.ui.uikit.components.TopBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun MealPlanGoalsScreen(
    navController: NavController,
    viewModel: MealPlanViewModel
) {
    val uiState by viewModel.uiStateEmitter.collectAsState()
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(viewModel, lifecycleOwner, context) {
        lifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED) {
            viewModel.uiStateEmitter.collect { state ->
                state.errorMessage?.let { message ->
                    val text = if (message.sectionResIds.isEmpty()) {
                        context.getString(message.messageRes)
                    } else {
                        context.getString(
                            message.messageRes,
                            message.sectionResIds.joinToString(", ") { context.getString(it) }
                        )
                    }
                    Toast.makeText(context, text, Toast.LENGTH_LONG).show()
                    viewModel.clearErrorMessage()
                }
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
            navController.navigate(FitnessScreen.MealPlanGoals.route)
            viewModel.clearSideEffect()
        }

        is MealPlanSideEffect.ShowMealPlanCreated -> {
            // TODO
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
                .padding(horizontal = 16.dp)
        ) {
            uiState.goalsItems.forEach { item ->
                Spacer(modifier = Modifier.height(12.dp))

                MealPlanOptionItem(
                    title = stringResource(item.title),
                    question = stringResource(item.question),
                    items = item.checkboxItem,
                    columns = item.columns,
                    isChecked = { option ->
                        option.answer.isChecked(uiState.preferences)
                    },
                    onItemClick = { option ->
                        viewModel.handleUiAction(option.answer.toClickAction())
                    }
                )

                Spacer(modifier = Modifier.height(12.dp))
            }

            Spacer(modifier = Modifier.height(12.dp))
            AppButton(
                text = stringResource(R.string.meal_plan_create),
                textColor = MaterialTheme.colorScheme.outlineVariant,
                textStyle = MaterialTheme.typography.headlineSmall,
                buttonColor = MaterialTheme.colorScheme.secondary,
            ) {
                viewModel.handleUiAction(MealPlanAction.MealPlanCreatedPressed)
            }

            Spacer(modifier = Modifier.height(12.dp))
        }

        BottomNavigation(
            navController = navController
        )
    }
}
