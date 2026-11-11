package com.example.practice.data.local.mealideas

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface MealIdeaDao {
    @Transaction
    @Query("SELECT * FROM meal_ideas ORDER BY sortOrder")
    fun observeMealIdeas(): Flow<List<MealIdeaDetails>>

    @Transaction
    @Query("SELECT * FROM meal_ideas ORDER BY sortOrder")
    suspend fun getMealIdeas(): List<MealIdeaDetails>

    @Upsert
    suspend fun upsertMealIdeas(mealIdeas: List<MealIdeaEntity>)

    @Upsert
    suspend fun upsertMealIdeaRecipes(recipes: List<MealIdeaRecipeEntity>)

    @Query("DELETE FROM meal_idea_recipes")
    suspend fun deleteMealIdeaRecipes()

    @Query("DELETE FROM meal_ideas")
    suspend fun deleteMealIdeas()

    @Query("SELECT * FROM meal_ideas WHERE id = :mealIdeaId")
    suspend fun getMealIdea(mealIdeaId: String): MealIdeaEntity?

    @Query("""
        UPDATE meal_ideas
        SET selectedDate = previousSelectedDate,
            isTried = (previousSelectedDate IS NOT NULL),
            previousSelectedDate = NULL
        WHERE selectedDate = :date
    """)
    suspend fun clearSelectedDate(date: String)

    @Query("""
        UPDATE meal_ideas
        SET previousSelectedDate = selectedDate, selectedDate = :date, isTried = 1
        WHERE id = :mealIdeaId
    """)
    suspend fun markSelectedForDate(mealIdeaId: String, date: String)

    @Query("UPDATE meal_ideas SET selectedDate = NULL, previousSelectedDate = NULL, isTried = 0")
    suspend fun resetTriedFlags()

    @Query("UPDATE meal_ideas SET sortOrder = :sortOrder WHERE id = :mealIdeaId")
    suspend fun updateSortOrder(mealIdeaId: String, sortOrder: Int)

    @Transaction
    suspend fun replaceMealIdeas(mealIdeas: List<MealIdeaDetails>) {
        deleteMealIdeaRecipes()
        deleteMealIdeas()
        upsertMealIdeas(mealIdeas.map { it.mealIdea })
        upsertMealIdeaRecipes(mealIdeas.flatMap { it.recipes })
    }

    @Transaction
    suspend fun selectMealIdeaForDate(mealIdeaId: String, date: String) {
        val mealIdea = getMealIdea(mealIdeaId) ?: return
        if (mealIdea.selectedDate == date) return
        clearSelectedDate(date)
        markSelectedForDate(mealIdeaId, date)
    }

    @Transaction
    suspend fun toggleMealIdeaForDate(mealIdeaId: String, date: String) {
        val mealIdea = getMealIdea(mealIdeaId) ?: return
        clearSelectedDate(date)
        if (mealIdea.selectedDate != date) {
            markSelectedForDate(mealIdeaId, date)
        }
    }

    @Transaction
    suspend fun resetTriedFlagsAndUpdateSortOrder(sortOrderById: Map<String, Int>) {
        resetTriedFlags()
        sortOrderById.forEach { (mealIdeaId, sortOrder) ->
            updateSortOrder(mealIdeaId, sortOrder)
        }
    }
}
