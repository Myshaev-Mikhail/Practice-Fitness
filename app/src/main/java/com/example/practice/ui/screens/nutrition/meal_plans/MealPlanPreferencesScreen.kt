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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.practice.FitnessScreen
import com.example.practice.domain.models.MealPlanPreferences
import com.example.practice.ui.screens.nutrition.meal_plans.actions.CheckboxItem
import com.example.practice.ui.screens.nutrition.meal_plans.actions.MealPlanAction
import com.example.practice.ui.screens.nutrition.meal_plans.actions.MealPlanAnswer
import com.example.practice.ui.screens.nutrition.meal_plans.actions.MealPlanSideEffect
import com.example.practice.ui.uikit.components.AppButton
import com.example.practice.ui.uikit.components.BottomNavigation
import com.example.practice.ui.uikit.components.CircleCheckbox
import com.example.practice.ui.uikit.components.TopBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun MealPlanPreferencesScreen(
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
            uiState.preferencesItems.forEach { item ->
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
                text = stringResource(R.string.next),
                textColor = MaterialTheme.colorScheme.outlineVariant,
                textStyle = MaterialTheme.typography.headlineSmall,
                buttonColor = MaterialTheme.colorScheme.secondary,
            ) {
                viewModel.handleUiAction(MealPlanAction.NavigationNextPressed)
            }

            Spacer(modifier = Modifier.height(12.dp))
        }

        BottomNavigation(
            navController = navController
        )
    }
}


@Composable
fun MealPlanOptionItem(
    title: String,
    question: String,
    items: List<CheckboxItem>,
    columns: Int,
    isChecked: (CheckboxItem) -> Boolean,
    onItemClick: (CheckboxItem) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.secondary
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = question,
            style = MaterialTheme.typography.titleSmall.copy(fontSize = 16.sp),
            color = MaterialTheme.colorScheme.outline
        )

        Spacer(modifier = Modifier.height(8.dp))

        val rowCount = (items.size + columns - 1) / columns

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            repeat(rowCount) { rowIndex ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    repeat(columns) { columnIndex ->
                        val item = items.getOrNull(rowIndex + columnIndex * rowCount)
                        if (item == null) {
                            Spacer(modifier = Modifier.weight(1f))
                        } else {
                            Row(
                                modifier = Modifier.weight(1f),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                CircleCheckbox(
                                    modifier = Modifier.size(32.dp),
                                    checked = isChecked(item),
                                    onCheckedChange = {
                                        onItemClick(item)
                                    },
                                    text = stringResource(item.label)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

fun MealPlanAnswer.isChecked(p: MealPlanPreferences): Boolean =
    when (this) {
        is MealPlanAnswer.Dietary -> value in p.dietaryPreferences.orEmpty()
        is MealPlanAnswer.Allergen -> value in p.allergens.orEmpty()
        is MealPlanAnswer.Meal -> value in p.mealTypes
        is MealPlanAnswer.Calories -> value == p.calorieGoal
        is MealPlanAnswer.Cooking -> value == p.cookingTime
        is MealPlanAnswer.Servings -> value == p.servings
    }

fun MealPlanAnswer.toClickAction(): MealPlanAction =
    when (this) {
        is MealPlanAnswer.Dietary -> MealPlanAction.DietaryPreferenceClicked(value)
        is MealPlanAnswer.Allergen -> MealPlanAction.AllergyClicked(value)
        is MealPlanAnswer.Meal -> MealPlanAction.MealTypeClicked(value)
        is MealPlanAnswer.Calories -> MealPlanAction.CalorieGoalClicked(value)
        is MealPlanAnswer.Cooking -> MealPlanAction.CookingTimeClicked(value)
        is MealPlanAnswer.Servings -> MealPlanAction.ServingsOptionClicked(value)
    }
