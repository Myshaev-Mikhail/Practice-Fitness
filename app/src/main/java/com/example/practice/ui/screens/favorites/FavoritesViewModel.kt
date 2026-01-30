package com.example.practice.ui.screens.favorites

import androidx.lifecycle.ViewModel
import com.example.practice.R
import com.example.practice.ui.screens.favorites.actions.FavoritesAction
import com.example.practice.ui.screens.favorites.actions.FavoritesFilter
import com.example.practice.ui.screens.favorites.actions.FavoritesItem
import com.example.practice.ui.screens.favorites.actions.FavoritesState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FavoritesViewModel: ViewModel() {
    private val uiStateFlow = MutableStateFlow(FavoritesState())
    val uiStateEmitter = uiStateFlow.asStateFlow()

    init {
        loadFavorites()
    }

    fun handleUiAction(action: FavoritesAction) {
        when (action) {
            is FavoritesAction.SelectFilter -> {
               applyFilter(action.filter)
            }
        }
    }

    private fun loadFavorites() {
        uiStateFlow.value = uiStateFlow.value.copy(
            allItems = items,
            visibleItems = items
        )
    }

    private fun applyFilter(filter: FavoritesFilter) {
        val filtered = when (filter) {
            FavoritesFilter.ALL -> uiStateFlow.value.allItems
            FavoritesFilter.VIDEO ->
                uiStateFlow.value.allItems.filterIsInstance<FavoritesItem.Workout>()
            FavoritesFilter.ARTICLE ->
                uiStateFlow.value.allItems.filterIsInstance<FavoritesItem.Article>()
        }

        uiStateFlow.value = uiStateFlow.value.copy(
            selectedFilter = filter,
            visibleItems = filtered
        )
    }

    companion object {
        val items = listOf(
            FavoritesItem.Workout(
                id = "1",
                title = "Upper Body",
                duration = "60 Minutes",
                calories = "1320 Kcal",
                exercises = "5 Exercises",
                imageRes = R.mipmap.woman_helping_man_gym_1,
                isFavorite = true
            ),
            FavoritesItem.Workout(
                id = "2",
                title = "Pull Out",
                duration = "30 Minutes",
                calories = "1210 Kcal",
                exercises = "10 Exercises",
                imageRes = R.mipmap.woman_helping_man_gym_3,
                isFavorite = false
            ),
            FavoritesItem.Workout(
                id = "3",
                title = "Loop band Exercises",
                duration = "45 Minutes",
                calories = "785 Kcal",
                exercises = "5 Exercises",
                imageRes = R.mipmap.woman_helping_man_gym_1_2,
                isFavorite = true
            ),
            FavoritesItem.Workout(
                id = "4",
                title = "dumbbell step up",
                duration = "12 Minutes",
                calories = "1385 Kcal",
                exercises = "3 Exercises",
                imageRes = R.mipmap.woman_working_out_gym_2_1,
                isFavorite = false
            ),
            FavoritesItem.Workout(
                id = "5",
                title = "Split Strength Training",
                duration = "12 Minutes",
                calories = "1250 Kcal",
                exercises = "5 Exercises",
                imageRes = R.mipmap.full_shot_woman_lifting_her_leg_1,
                isFavorite = false
            ),

            FavoritesItem.Article(
                id = "6",
                title = "Boost Energy And Vitality",
                isDescriptor = true,
                description = "Incorporating physical exercise into your daily routine can boost...",
                duration = "",
                calories = "",
                imageRes = R.mipmap.woman_helping_man_gym_2,
            ),
            FavoritesItem.Article(
                id = "7",
                title = "Avocado and egg toast",
                isDescriptor = false,
                description = "",
                duration = "15 Minutes",
                calories = "150 Cal",
                imageRes = R.mipmap.woman_helping_man_gym_4,
            ),
            FavoritesItem.Article(
                id = "8",
                title = "Lower Body Blast",
                isDescriptor = true,
                description = "A lower body blast is a high-intensity workout focused on targeting...",
                duration = "",
                calories = "",
                imageRes = R.mipmap.woman_helping_man_gym_5,
            ),
            FavoritesItem.Article(
                id = "9",
                title = "fruit smoothie",
                isDescriptor = false,
                description = "",
                duration = "12 Minutes",
                calories = "120 Cal",
                imageRes = R.mipmap.woman_helping_man_gym_6,
            ),
            FavoritesItem.Article(
                id = "10",
                title = "Hydrate Properly",
                isDescriptor = true,
                description = "Stay hydrated before, during, and after your workouts to optimize...",
                duration = "",
                calories = "",
                imageRes = R.mipmap.woman_helping_man_gym_7,
            ),
        )
    }
}