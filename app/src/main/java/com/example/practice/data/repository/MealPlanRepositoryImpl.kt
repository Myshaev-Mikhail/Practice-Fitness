package com.example.practice.data.repository

import com.example.practice.data.datastore.MealPlanDataStore
import com.example.practice.domain.models.MealPlanPreferences
import com.example.practice.domain.repository.MealPlanRepository

class MealPlanRepositoryImpl(
    private val dataStore: MealPlanDataStore
) : MealPlanRepository {
    override val preferencesFlow = dataStore.mealPlanFlow

    override suspend fun save(preferences: MealPlanPreferences) {
        dataStore.save(preferences)
    }
}