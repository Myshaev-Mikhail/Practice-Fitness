package com.example.practice.ui.screens.nutrition.meal_plans.actions

import androidx.annotation.StringRes

import com.example.practice.domain.models.Allergy
import com.example.practice.domain.models.CalorieGoal
import com.example.practice.domain.models.CookingTime
import com.example.practice.domain.models.DietaryPreference
import com.example.practice.domain.models.MealPlanPreferences
import com.example.practice.domain.models.MealType
import com.example.practice.domain.models.ServingsOption

data class MealPlanState(
    val preferencesItems: List<MealPlanOption> = emptyList(),
    val goalsItems: List<MealPlanOption> = emptyList(),
    val preferences: MealPlanPreferences = MealPlanPreferences(),
    val isSaving: Boolean = false,
    val errorMessage: MealPlanMessage? = null
)

data class MealPlanOption(
    @StringRes val title: Int,
    @StringRes val question: Int,
    val checkboxItem: List<CheckboxItem>,
    val columns: Int = 2
)
sealed interface MealPlanAnswer {
    data class Dietary(val value: DietaryPreference) : MealPlanAnswer
    data class Allergen(val value: Allergy) : MealPlanAnswer
    data class Meal(val value: MealType) : MealPlanAnswer
    data class Calories(val value: CalorieGoal) : MealPlanAnswer
    data class Cooking(val value: CookingTime) : MealPlanAnswer
    data class Servings(val value: ServingsOption) : MealPlanAnswer
}

data class CheckboxItem(
    val answer: MealPlanAnswer,
    @StringRes val label: Int
)

data class MealPlanMessage(
    @StringRes val messageRes: Int,
    val sectionResIds: List<Int> = emptyList()
)
