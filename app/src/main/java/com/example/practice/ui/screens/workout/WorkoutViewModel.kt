package com.example.practice.ui.screens.workout

import androidx.lifecycle.ViewModel
import com.example.practice.R
import com.example.practice.ui.screens.workout.intents.WorkoutAction
import com.example.practice.ui.screens.workout.intents.WorkoutFilter
import com.example.practice.ui.screens.workout.intents.WorkoutCardItem
import com.example.practice.ui.screens.workout.intents.WorkoutHeadCardItem
import com.example.practice.ui.screens.workout.intents.WorkoutSideEffect
import com.example.practice.ui.screens.workout.intents.WorkoutState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class WorkoutViewModel: ViewModel() {
    private val uiState = MutableStateFlow(WorkoutState())
    val uiStateEmitter = uiState.asStateFlow()

    private val sideEffect = MutableStateFlow<WorkoutSideEffect>(WorkoutSideEffect.Empty)
    val sideEffectEmitter = sideEffect.asStateFlow()

    init {
        loadFavorites()
    }

    fun uiAction(action: WorkoutAction) {
        when (action) {
            is WorkoutAction.SelectFilter -> {
                applyFilter(action.filter)
            }

            is WorkoutAction.NavigationNext -> {
                sideEffect.value = WorkoutSideEffect.ShowNavigationNext(action.filter)
            }
        }
    }

    private fun headerFor(filter: WorkoutFilter): WorkoutHeadCardItem {
        return when (filter) {
            WorkoutFilter.BEGINNER -> WorkoutHeadCardItem(
                badgeText = "dumbbell step up",
                timeText = "12 Minutes",
                caloriesText = "120 Cal",
                mainImage = R.mipmap.woman_working_out_gym_2_1,
                title = "Let's Go Beginner",
                subtitle = "Explore Different Workout Styles"
            )

            WorkoutFilter.INTERMEDIATE -> WorkoutHeadCardItem(
                badgeText = "Intermediate level",
                timeText = "20 Minutes",
                caloriesText = "250 Cal",
                mainImage = R.mipmap.woman_helping_man_gym_2,
                title = "Keep raising your level",
                subtitle = "Explore Intermediate Workouts"
            )

            WorkoutFilter.ADVANCED -> WorkoutHeadCardItem(
                badgeText = "Advanced",
                timeText = "30 Minutes",
                caloriesText = "400 Cal",
                mainImage = R.mipmap.woman_helping_man_gym_5,
                title = "Unlock Your Potential",
                subtitle = "Explore Advanced Fitness Routines"
            )
        }
    }

    private fun applyFilter(filter: WorkoutFilter) {

        val filtered = when (filter) {
            WorkoutFilter.BEGINNER ->
                items.filterIsInstance<WorkoutCardItem.Beginner>()
                    .take(5)

            WorkoutFilter.INTERMEDIATE ->
                items.filterIsInstance<WorkoutCardItem.Intermediate>()
                    .take(5)

            WorkoutFilter.ADVANCED ->
                items.filterIsInstance<WorkoutCardItem.Advanced>()
                    .take(5)
        }

        uiState.value = uiState.value.copy(
            selectedFilter = filter,
            visibleItems = filtered,
            workoutHeadCardItem = headerFor(filter)
        )
    }

    private fun loadFavorites() {
        val defaultFilter = WorkoutFilter.BEGINNER

        uiState.value = uiState.value.copy(
            selectedFilter = defaultFilter,
            allItems = items,
            visibleItems = items
                .filterIsInstance<WorkoutCardItem.Beginner>()
                .take(5),
            workoutHeadCardItem = headerFor(defaultFilter)
        )
    }

    fun clearSideEffect() {
        sideEffect.value = WorkoutSideEffect.Empty
    }

    companion object {
        val items = listOf(
            WorkoutCardItem.Beginner(
                id = 1,
                title = "Upper Body",
                duration = "60 Minutes",
                calories = "1320 Kcal",
                exercises = "5 Exercises",
                imageRes = R.mipmap.woman_helping_man_gym_1,
                isFavorite = true
            ),
            WorkoutCardItem.Beginner(
                id = 2,
                title = "Pull Out",
                duration = "30 Minutes",
                calories = "1210 Kcal",
                exercises = "10 Exercises",
                imageRes = R.mipmap.woman_helping_man_gym_3,
                isFavorite = false
            ),
            WorkoutCardItem.Beginner(
                id = 3,
                title = "Loop band Exercises",
                duration = "45 Minutes",
                calories = "785 Kcal",
                exercises = "5 Exercises",
                imageRes = R.mipmap.woman_helping_man_gym_1_2,
                isFavorite = true
            ),
            WorkoutCardItem.Beginner(
                id = 4,
                title = "dumbbell step up",
                duration = "12 Minutes",
                calories = "1385 Kcal",
                exercises = "3 Exercises",
                imageRes = R.mipmap.woman_working_out_gym_2_1,
                isFavorite = false
            ),
            WorkoutCardItem.Beginner(
                id = 5,
                title = "Split Strength Training",
                duration = "12 Minutes",
                calories = "1250 Kcal",
                exercises = "5 Exercises",
                imageRes = R.mipmap.full_shot_woman_lifting_her_leg_1,
                isFavorite = false
            ),

            WorkoutCardItem.Intermediate(
                id = 6,
                title = "Split Strength Training",
                duration = "12 Minutes",
                calories = "1250 Kcal",
                exercises = "5 Exercises",
                imageRes = R.mipmap.full_shot_woman_lifting_her_leg_1,
                isFavorite = false
            ),
            WorkoutCardItem.Intermediate(
                id = 7,
                title = "Split Strength Training",
                duration = "12 Minutes",
                calories = "1250 Kcal",
                exercises = "5 Exercises",
                imageRes = R.mipmap.full_shot_woman_lifting_her_leg_1,
                isFavorite = false
            ),
            WorkoutCardItem.Intermediate(
                id = 8,
                title = "Split Strength Training",
                duration = "12 Minutes",
                calories = "1250 Kcal",
                exercises = "5 Exercises",
                imageRes = R.mipmap.full_shot_woman_lifting_her_leg_1,
                isFavorite = false
            ),
            WorkoutCardItem.Intermediate(
                id = 9,
                title = "Split Strength Training",
                duration = "12 Minutes",
                calories = "1250 Kcal",
                exercises = "5 Exercises",
                imageRes = R.mipmap.full_shot_woman_lifting_her_leg_1,
                isFavorite = false
            ),
            WorkoutCardItem.Intermediate(
                id = 10,
                title = "Split Strength Training",
                duration = "12 Minutes",
                calories = "1250 Kcal",
                exercises = "5 Exercises",
                imageRes = R.mipmap.full_shot_woman_lifting_her_leg_1,
                isFavorite = false
            ),
            WorkoutCardItem.Advanced(
                id = 11,
                title = "Split Strength Training",
                duration = "12 Minutes",
                calories = "1250 Kcal",
                exercises = "5 Exercises",
                imageRes = R.mipmap.full_shot_woman_lifting_her_leg_1,
                isFavorite = false
            ),
            WorkoutCardItem.Advanced(
                id = 12,
                title = "Split Strength Training",
                duration = "12 Minutes",
                calories = "1250 Kcal",
                exercises = "5 Exercises",
                imageRes = R.mipmap.full_shot_woman_lifting_her_leg_1,
                isFavorite = false
            ),
            WorkoutCardItem.Advanced(
                id = 13,
                title = "Split Strength Training",
                duration = "12 Minutes",
                calories = "1250 Kcal",
                exercises = "5 Exercises",
                imageRes = R.mipmap.full_shot_woman_lifting_her_leg_1,
                isFavorite = false
            ),
            WorkoutCardItem.Advanced(
                id = 14,
                title = "Split Strength Training",
                duration = "12 Minutes",
                calories = "1250 Kcal",
                exercises = "5 Exercises",
                imageRes = R.mipmap.full_shot_woman_lifting_her_leg_1,
                isFavorite = false
            ),
            WorkoutCardItem.Advanced(
                id = 15,
                title = "Split Strength Training",
                duration = "12 Minutes",
                calories = "1250 Kcal",
                exercises = "5 Exercises",
                imageRes = R.mipmap.full_shot_woman_lifting_her_leg_1,
                isFavorite = false
            ),
        )
    }
}