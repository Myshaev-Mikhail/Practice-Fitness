package com.example.practice.data.repository

import com.example.practice.data.local.mealideas.MealIdeaDao
import com.example.practice.data.local.mealideas.toDetails
import com.example.practice.data.local.mealideas.toDomain
import com.example.practice.domain.models.MealIdea
import com.example.practice.domain.repository.MealIdeasRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MealIdeasRepositoryImpl(
    private val dao: MealIdeaDao
) : MealIdeasRepository {
    override fun observeMealIdeas(): Flow<List<MealIdea>> {
        return dao.observeMealIdeas()
            .map { ideas ->
                ideas.map { it.toDomain() }
            }
    }

    override suspend fun getMealIdeas(): List<MealIdea> {
        return dao.getMealIdeas()
            .map { it.toDomain() }
    }

    override suspend fun replaceMealIdeas(mealIdeas: List<MealIdea>) {
        dao.replaceMealIdeas(mealIdeas.map { it.toDetails() })
    }

    override suspend fun selectMealIdeaForDate(mealIdeaId: String, date: String) {
        dao.selectMealIdeaForDate(mealIdeaId, date)
    }

    override suspend fun toggleMealIdeaForDate(mealIdeaId: String, date: String) {
        dao.toggleMealIdeaForDate(mealIdeaId, date)
    }

    override suspend fun resetTriedFlagsAndUpdateSortOrder(sortOrderById: Map<String, Int>) {
        dao.resetTriedFlagsAndUpdateSortOrder(sortOrderById)
    }
}
