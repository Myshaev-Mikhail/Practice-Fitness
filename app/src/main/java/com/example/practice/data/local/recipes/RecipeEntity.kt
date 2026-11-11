package com.example.practice.data.local.recipes

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.practice.domain.models.IngredientUnit

@Entity(tableName = "recipes")
data class RecipeEntity(
    @PrimaryKey
    val id: String,
    val nameRu: String,
    val nameEn: String,
    val descriptionRu: String,
    val descriptionEn: String,
    val imagePath: String,
    val caloriesPerServing: Int,
    val totalTimeMinutes: Int,
    val allergensVerified: Boolean,
    val batchServings: Int?,
    val servingDescriptionRu: String?,
    val servingDescriptionEn: String?,
    val snackAddition: Boolean?,
    val completeTimeKnown: Boolean?,
    val catalogVersion: String?
)

@Entity(
    tableName = "recipe_ingredients",
    primaryKeys = ["recipeId", "position"],
    foreignKeys = [
        ForeignKey(
            entity = RecipeEntity::class,
            parentColumns = ["id"],
            childColumns = ["recipeId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class RecipeIngredients(
    val recipeId: String,
    val position: Int,
    val nameIngredientsRu: String,
    val nameIngredientsEn: String,
    val amount: Double?,
    val ingredientUnit: IngredientUnit?,
    val noteRu: String?,
    val noteEn: String?
)

@Entity(
    tableName = "recipe_steps",
    primaryKeys = ["recipeId", "position"],
    foreignKeys = [
        ForeignKey(
            entity = RecipeEntity::class,
            parentColumns = ["id"],
            childColumns = ["recipeId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class RecipeSteps(
    val recipeId: String,
    val position: Int,
    val textRu: String,
    val textEn: String
)
