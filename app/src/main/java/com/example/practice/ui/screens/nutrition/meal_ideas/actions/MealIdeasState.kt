package com.example.practice.ui.screens.nutrition.meal_ideas.actions

data class MealIdeasState(
    val mealIdeaCards: List<MealIdeaCardUi> = emptyList(),
    val selectedMealIdea: MealIdeaDetailsUi? = null,
    val isDetailsLoading: Boolean = false,
    val errorMessage: String? = null
)

data class MealIdeaCardUi(
    val id: String,
    val dishes: List<MealIdeaDishUi>,
    val totalCalories: Int,
    val totalTimeMinutes: Int,
    val todayState: MealIdeaTodayStateUi
)

data class MealIdeaDishUi(
    val recipeId: String,
    val mealType: MealTypeUi,
    val nameRu: String,
    val nameEn: String,
    val imagePath: String,
    val calories: Int,
    val timeMinutes: Int,
    val snackAddition: Boolean = false
)

data class MealIdeaDetailsUi(
    val id: String,
    val totalCalories: Int,
    val totalTimeMinutes: Int,
    val todayState: MealIdeaTodayStateUi,
    val dishes: List<RecipeFullUi>
)

data class RecipeFullUi(
    val recipeId: String,
    val mealType: MealTypeUi,
    val nameRu: String,
    val nameEn: String,
    val descriptionRu: String,
    val descriptionEn: String,
    val imagePath: String,
    val calories: Int,
    val timeMinutes: Int,
    val ingredients: List<RecipeIngredientUi>,
    val steps: List<RecipeStepUi>,
    val batchServings: Int? = null,
    val servingDescriptionRu: String? = null,
    val servingDescriptionEn: String? = null,
    val snackAddition: Boolean = false
)

data class RecipeIngredientUi(
    val recipeId: String,
    val position: Int,
    val nameIngredientsRu: String,
    val nameIngredientsEn: String,
    val amount: Double?,
    val ingredientUnit: IngredientUnitUi?,
    val noteRu: String?,
    val noteEn: String?
)

data class RecipeStepUi(
    val recipeId: String,
    val position: Int,
    val textRu: String,
    val textEn: String
)

enum class MealTypeUi {
    Breakfast,
    Lunch,
    Dinner,
    Snacks
}

enum class MealIdeaTodayStateUi {
    NotSelected,
    SelectedToday,
    SelectedPastDay
}

enum class IngredientUnitUi {
    Milliliter,
    Gram,
    Piece,
    Teaspoon,
    Tablespoon,
    Cup,
    Clove
}
