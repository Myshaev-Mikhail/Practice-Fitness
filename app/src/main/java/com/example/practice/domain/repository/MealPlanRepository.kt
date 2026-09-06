package com.example.practice.domain.repository

import com.example.practice.domain.models.MealPlanPreferences
import kotlinx.coroutines.flow.Flow

interface MealPlanRepository {
    val preferencesFlow: Flow<MealPlanPreferences>
    suspend fun save(preferences: MealPlanPreferences)
}