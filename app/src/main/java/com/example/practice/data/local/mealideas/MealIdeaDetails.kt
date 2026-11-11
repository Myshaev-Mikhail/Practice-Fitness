package com.example.practice.data.local.mealideas

import androidx.room.Embedded
import androidx.room.Relation

data class MealIdeaDetails(
    @Embedded
    val mealIdea: MealIdeaEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "mealIdeaId"
    )
    val recipes: List<MealIdeaRecipeEntity>
)
