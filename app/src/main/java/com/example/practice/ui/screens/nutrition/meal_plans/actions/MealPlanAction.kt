package com.example.practice.ui.screens.nutrition.meal_plans.actions

import com.example.practice.domain.models.Allergy
import com.example.practice.domain.models.CalorieGoal
import com.example.practice.domain.models.CookingTime
import com.example.practice.domain.models.DietaryPreference
import com.example.practice.domain.models.MealType
import com.example.practice.domain.models.ServingsOption

sealed class MealPlanAction {
    data object NavigateBackPressed : MealPlanAction()
    data object NavigationNextPressed : MealPlanAction()
    data object StartMealPlanPressed : MealPlanAction()
    data object MealPlanCreatedPressed : MealPlanAction()
    data class DietaryPreferenceClicked(val value: DietaryPreference) : MealPlanAction()
    data class AllergyClicked(val value: Allergy) : MealPlanAction()
    data class MealTypeClicked(val value: MealType) : MealPlanAction()
    data class CalorieGoalClicked(val value: CalorieGoal) : MealPlanAction()
    data class CookingTimeClicked(val value: CookingTime) : MealPlanAction()
    data class ServingsOptionClicked(val value: ServingsOption) : MealPlanAction()
}
