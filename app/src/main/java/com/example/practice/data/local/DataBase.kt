package com.example.practice.data.local

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.practice.data.local.mealideas.MealIdeaDao
import com.example.practice.data.local.mealideas.MealIdeaEntity
import com.example.practice.data.local.mealideas.MealIdeaRecipeEntity
import com.example.practice.data.local.recipes.RecipeAllergenEntity
import com.example.practice.data.local.recipes.RecipeDao
import com.example.practice.data.local.recipes.RecipeDietaryPreferenceEntity
import com.example.practice.data.local.recipes.RecipeEntity
import com.example.practice.data.local.recipes.RecipeIngredients
import com.example.practice.data.local.recipes.RecipeMealTypeEntity
import com.example.practice.data.local.recipes.RecipeSteps

@Database(
    entities = [
        DailyStepsEntity::class,
        RecipeEntity::class,
        RecipeIngredients::class,
        RecipeSteps::class,
        RecipeMealTypeEntity::class,
        RecipeAllergenEntity::class,
        RecipeDietaryPreferenceEntity::class,
        MealIdeaEntity::class,
        MealIdeaRecipeEntity::class
    ],
    version = 5,
    exportSchema = true,
    autoMigrations = [
        AutoMigration(from = 1, to = 2),
        AutoMigration(from = 2, to = 3),
        AutoMigration(from = 3, to = 4),
        AutoMigration(from = 4, to = 5)
    ]
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun dailySteps(): DailyStepsDao
    abstract fun recipe(): RecipeDao
    abstract fun mealIdeas(): MealIdeaDao
}
