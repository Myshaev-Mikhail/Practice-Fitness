package com.example.practice.data.local.mealideas

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.practice.data.local.recipes.RecipeEntity

@Entity(tableName = "meal_ideas")
data class MealIdeaEntity(
    @PrimaryKey
    val id: String,
    val totalCalories: Int,
    val totalTimeMinutes: Int,
    val selectedDate: String?,
    val isTried: Boolean,
    val sortOrder: Int,
    val createdAtMillis: Long,
    val previousSelectedDate: String? = null
)

@Entity(
    tableName = "meal_idea_recipes",
    primaryKeys = ["mealIdeaId", "position"],
    foreignKeys = [
        ForeignKey(
            entity = MealIdeaEntity::class,
            parentColumns = ["id"],
            childColumns = ["mealIdeaId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = RecipeEntity::class,
            parentColumns = ["id"],
            childColumns = ["recipeId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index("mealIdeaId"),
        Index("recipeId")
    ]
)
data class MealIdeaRecipeEntity(
    val mealIdeaId: String,
    val recipeId: String,
    val mealType: String,
    val position: Int
)
