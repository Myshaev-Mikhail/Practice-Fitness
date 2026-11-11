package com.example.practice.data.local.recipes

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "recipe_meal_types",
    primaryKeys = ["recipeId", "mealType"],
    foreignKeys = [
        ForeignKey(
            entity = RecipeEntity::class,
            parentColumns = ["id"],
            childColumns = ["recipeId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class RecipeMealTypeEntity(
    val recipeId: String,
    val mealType: String
)

@Entity(
    tableName = "recipe_dietary_preferences",
    primaryKeys = ["recipeId", "dietaryPreference"],
    foreignKeys = [
        ForeignKey(
            entity = RecipeEntity::class,
            parentColumns = ["id"],
            childColumns = ["recipeId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class RecipeDietaryPreferenceEntity(
    val recipeId: String,
    val dietaryPreference: String
)

@Entity(
    tableName = "recipe_allergens",
    primaryKeys = ["recipeId", "allergen"],
    foreignKeys = [
        ForeignKey(
            entity = RecipeEntity::class,
            parentColumns = ["id"],
            childColumns = ["recipeId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class RecipeAllergenEntity(
    val recipeId: String,
    val allergen: String
)