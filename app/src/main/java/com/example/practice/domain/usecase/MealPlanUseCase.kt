package com.example.practice.domain.usecase

import com.example.practice.domain.models.MealPlanPreferences
import com.example.practice.domain.repository.MealPlanRepository

class MealPlanUseCase(
    private val repository: MealPlanRepository
) {
    suspend fun saveMealPlan(preferences: MealPlanPreferences) = repository.save(preferences)
}