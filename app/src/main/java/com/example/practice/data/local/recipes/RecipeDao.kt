package com.example.practice.data.local.recipes

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {
    @Query("SELECT * FROM recipes ORDER BY id")
    fun observeRecipes(): Flow<List<RecipeEntity>>

    @Query("SELECT id FROM recipes WHERE catalogVersion = :catalogVersion")
    suspend fun getImportedRecipeIds(catalogVersion: String): List<String>

    @Query("SELECT * FROM recipes WHERE id = :recipeId")
    suspend fun getRecipeById(recipeId: String): RecipeEntity?

    @Query("SELECT id FROM recipes ORDER BY id")
    suspend fun getRecipeIds(): List<String>

    @Query("""
        SELECT recipes.* FROM recipes
        INNER JOIN recipe_meal_types ON recipes.id = recipe_meal_types.recipeId
        WHERE recipe_meal_types.mealType = :mealType
        ORDER BY recipes.id
    """)
    suspend fun getRecipesByMealType(mealType: String): List<RecipeEntity>

    @Query("SELECT * FROM recipe_ingredients WHERE recipeId = :recipeId ORDER BY position")
    suspend fun getIngredients(recipeId: String): List<RecipeIngredients>

    @Query("SELECT * FROM recipe_steps WHERE recipeId = :recipeId ORDER BY position")
    suspend fun getSteps(recipeId: String): List<RecipeSteps>

    @Query("SELECT * FROM recipe_meal_types WHERE recipeId = :recipeId ORDER BY mealType")
    suspend fun getMealTypes(recipeId: String): List<RecipeMealTypeEntity>

    @Query("SELECT * FROM recipe_dietary_preferences WHERE recipeId = :recipeId ORDER BY dietaryPreference")
    suspend fun getDietaryPreferences(recipeId: String): List<RecipeDietaryPreferenceEntity>

    @Query("SELECT * FROM recipe_allergens WHERE recipeId = :recipeId ORDER BY allergen")
    suspend fun getAllergens(recipeId: String): List<RecipeAllergenEntity>

    @Transaction
    suspend fun getRecipeDetails(recipeId: String): RecipeDetails? {
        val recipe = getRecipeById(recipeId) ?: return null
        return RecipeDetails(
            recipe = recipe,
            ingredients = getIngredients(recipeId),
            steps = getSteps(recipeId),
            mealTypes = getMealTypes(recipeId),
            dietaryPreferences = getDietaryPreferences(recipeId),
            allergens = getAllergens(recipeId)
        )
    }

    @Transaction
    suspend fun getAllRecipeDetails(): List<RecipeDetails> {
        return getRecipeIds().mapNotNull { getRecipeDetails(it) }
    }

    @Upsert
    suspend fun upsertRecipe(recipe: RecipeEntity)

    @Upsert
    suspend fun upsertIngredients(ingredients: List<RecipeIngredients>)

    @Upsert
    suspend fun upsertSteps(steps: List<RecipeSteps>)

    @Upsert
    suspend fun upsertMealTypes(mealTypes: List<RecipeMealTypeEntity>)

    @Upsert
    suspend fun upsertDietaryPreferences(preferences: List<RecipeDietaryPreferenceEntity>)

    @Upsert
    suspend fun upsertAllergens(allergens: List<RecipeAllergenEntity>)

    @Query("DELETE FROM recipe_ingredients WHERE recipeId = :recipeId")
    suspend fun deleteIngredients(recipeId: String)

    @Query("DELETE FROM recipe_steps WHERE recipeId = :recipeId")
    suspend fun deleteSteps(recipeId: String)

    @Query("DELETE FROM recipe_meal_types WHERE recipeId = :recipeId")
    suspend fun deleteMealTypes(recipeId: String)

    @Query("DELETE FROM recipe_dietary_preferences WHERE recipeId = :recipeId")
    suspend fun deleteDietaryPreferences(recipeId: String)

    @Query("DELETE FROM recipe_allergens WHERE recipeId = :recipeId")
    suspend fun deleteAllergens(recipeId: String)

    @Transaction
    suspend fun saveRecipes(recipes: List<RecipeDetails>) {
        for (details in recipes) {
            val id = details.recipe.id
            require(details.ingredients.all { it.recipeId == id })
            require(details.steps.all { it.recipeId == id })
            require(details.mealTypes.all { it.recipeId == id })
            require(details.dietaryPreferences.all { it.recipeId == id })
            require(details.allergens.all { it.recipeId == id })

            upsertRecipe(details.recipe)
            // Replace child rows so removed ingredients, steps and tags do not survive an update.
            deleteIngredients(id)
            deleteSteps(id)
            deleteMealTypes(id)
            deleteDietaryPreferences(id)
            deleteAllergens(id)
            upsertIngredients(details.ingredients)
            upsertSteps(details.steps)
            upsertMealTypes(details.mealTypes)
            upsertDietaryPreferences(details.dietaryPreferences)
            upsertAllergens(details.allergens)
        }
    }
}
