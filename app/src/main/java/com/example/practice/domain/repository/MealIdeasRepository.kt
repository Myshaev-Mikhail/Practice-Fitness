package com.example.practice.domain.repository

import com.example.practice.domain.models.MealIdea
import kotlinx.coroutines.flow.Flow

interface MealIdeasRepository {
    fun observeMealIdeas(): Flow<List<MealIdea>>
    suspend fun getMealIdeas(): List<MealIdea>
    suspend fun replaceMealIdeas(mealIdeas: List<MealIdea>)
    suspend fun selectMealIdeaForDate(mealIdeaId: String, date: String)
    suspend fun toggleMealIdeaForDate(mealIdeaId: String, date: String)
    suspend fun resetTriedFlagsAndUpdateSortOrder(sortOrderById: Map<String, Int>)
}
