package com.example.practice.ui.screens.workoutrounds

import androidx.lifecycle.ViewModel
import com.example.practice.R
import com.example.practice.ui.screens.workout.intents.WorkoutFilter
import com.example.practice.ui.screens.workoutrounds.intents.WorkoutBadgeItem
import com.example.practice.ui.screens.workoutrounds.intents.WorkoutHeadCardItem
import com.example.practice.ui.screens.workoutrounds.intents.WorkoutRoundsAction
import com.example.practice.ui.screens.workoutrounds.intents.WorkoutRoundsFilter
import com.example.practice.ui.screens.workoutrounds.intents.WorkoutRoundsSideEffect
import com.example.practice.ui.screens.workoutrounds.intents.WorkoutRoundsState
import io.github.composegears.valkyrie.Icons
import io.github.composegears.valkyrie.PlayOff
import io.github.composegears.valkyrie.PlayOn
import io.github.composegears.valkyrie.TimeDefault
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class WorkoutRoundsViewModel: ViewModel() {
    private val uiState = MutableStateFlow(WorkoutRoundsState())
    val uiStateEmitter = uiState.asStateFlow()

    private val sideEffect = MutableStateFlow<WorkoutRoundsSideEffect>(WorkoutRoundsSideEffect.Empty)
    val sideEffectEmitter = sideEffect.asStateFlow()

    init {
        uiState.value = uiState.value.copy(
            allItems = badgeItems
        )
    }

    fun uiAction(action: WorkoutRoundsAction) {
        when (action) {
            is WorkoutRoundsAction.NavigationNext -> {
                sideEffect.value = WorkoutRoundsSideEffect.ShowNavigationNext
            }
        }
    }

    fun setFilter(filter: WorkoutFilter) {
        val mapped = when (filter) {
            WorkoutFilter.BEGINNER -> WorkoutRoundsFilter.BEGINNER
            WorkoutFilter.INTERMEDIATE -> WorkoutRoundsFilter.INTERMEDIATE
            WorkoutFilter.ADVANCED -> WorkoutRoundsFilter.ADVANCED
        }
        applyFilter(mapped)
    }

    private fun applyFilter(filter: WorkoutRoundsFilter) {

        val items = when (filter) {
            WorkoutRoundsFilter.BEGINNER ->
                uiState.value.allItems.filterIsInstance<WorkoutBadgeItem.Beginner>()

            WorkoutRoundsFilter.INTERMEDIATE ->
                uiState.value.allItems.filterIsInstance<WorkoutBadgeItem.Intermediate>()

            WorkoutRoundsFilter.ADVANCED ->
                uiState.value.allItems.filterIsInstance<WorkoutBadgeItem.Advanced>()
        }

        uiState.value = uiState.value.copy(
            selectedFilter = filter,
            visibleItems = items,
            workoutHeadCardItem = headerFor(filter)
        )
    }

    private fun headerFor(filter: WorkoutRoundsFilter): WorkoutHeadCardItem =
        when (filter) {
            WorkoutRoundsFilter.BEGINNER -> WorkoutHeadCardItem(
                badgeText = "Beginner",
                timeText = "12 Minutes",
                caloriesText = "120 Cal",
                mainImage = R.mipmap.woman_working_out_gym_2_1,
                title = "Let's Start",
                subtitle = "Beginner Workout"
            )

            WorkoutRoundsFilter.INTERMEDIATE -> WorkoutHeadCardItem(
                badgeText = "Intermediate",
                timeText = "20 Minutes",
                caloriesText = "250 Cal",
                mainImage = R.mipmap.woman_helping_man_gym_2,
                title = "Push Further",
                subtitle = "Intermediate Level"
            )

            WorkoutRoundsFilter.ADVANCED -> WorkoutHeadCardItem(
                badgeText = "Advanced",
                timeText = "30 Minutes",
                caloriesText = "400 Cal",
                mainImage = R.mipmap.woman_helping_man_gym_5,
                title = "No Limits",
                subtitle = "Advanced Training"
            )
        }

    fun clearSideEffect() {
        sideEffect.value = WorkoutRoundsSideEffect.Empty
    }

    companion object {
        val badgeItems = listOf(
            WorkoutBadgeItem.Beginner(
                id = 1,
                icon = Icons.PlayOff,
                titleText = "Dumbbell Rows",
                subtitleIcon = Icons.TimeDefault,
                subtitleText = "00:30",
                trailingTopText = "3x"
            ),
            WorkoutBadgeItem.Beginner(
                id = 2,
                icon = Icons.PlayOff,
                titleText = "Russian Twists",
                subtitleIcon = Icons.TimeDefault,
                subtitleText = "00:15",
                trailingTopText = "2x"
            ),
            WorkoutBadgeItem.Beginner(
                id = 3,
                icon = Icons.PlayOn,
                titleText = "Squats",
                subtitleIcon = Icons.TimeDefault,
                subtitleText = "00:30",
                trailingTopText = "2x"
            ),
            WorkoutBadgeItem.Beginner(
                id = 4,
                icon = Icons.PlayOff,
                titleText = "Tabata Intervals",
                subtitleIcon = Icons.TimeDefault,
                subtitleText = "00:10",
                trailingTopText = "2x"
            ),
            WorkoutBadgeItem.Beginner(
                id = 5,
                icon = Icons.PlayOff,
                titleText = "Bicycle Crunches",
                subtitleIcon = Icons.TimeDefault,
                subtitleText = "00:10",
                trailingTopText = "4x"
            ),
            WorkoutBadgeItem.Beginner(
                id = 6,
                icon = Icons.PlayOff,
                titleText = "Russian Twists",
                subtitleIcon = Icons.TimeDefault,
                subtitleText = "00:15",
                trailingTopText = "2x"
            ),

            WorkoutBadgeItem.Intermediate(
                id = 7,
                icon = Icons.PlayOff,
                titleText = "Plank",
                subtitleIcon = Icons.TimeDefault,
                subtitleText = "00:30",
                trailingTopText = "3x"
            ),
            WorkoutBadgeItem.Intermediate(
                id = 8,
                icon = Icons.PlayOff,
                titleText = "Russian Twists",
                subtitleIcon = Icons.TimeDefault,
                subtitleText = "00:15",
                trailingTopText = "2x"
            ),
            WorkoutBadgeItem.Intermediate(
                id = 9,
                icon = Icons.PlayOn,
                titleText = "Squats",
                subtitleIcon = Icons.TimeDefault,
                subtitleText = "00:30",
                trailingTopText = "2x"
            ),
            WorkoutBadgeItem.Intermediate(
                id = 10,
                icon = Icons.PlayOff,
                titleText = "Tabata Intervals",
                subtitleIcon = Icons.TimeDefault,
                subtitleText = "00:10",
                trailingTopText = "2x"
            ),
            WorkoutBadgeItem.Intermediate(
                id = 11,
                icon = Icons.PlayOff,
                titleText = "Bicycle Crunches",
                subtitleIcon = Icons.TimeDefault,
                subtitleText = "00:10",
                trailingTopText = "4x"
            ),
            WorkoutBadgeItem.Intermediate(
                id = 12,
                icon = Icons.PlayOff,
                titleText = "Russian Twists",
                subtitleIcon = Icons.TimeDefault,
                subtitleText = "00:15",
                trailingTopText = "2x"
            ),

            WorkoutBadgeItem.Advanced(
                id = 13,
                icon = Icons.PlayOff,
                titleText = "Burpees",
                subtitleIcon = Icons.TimeDefault,
                subtitleText = "01:00",
                trailingTopText = "5x"
            ),
            WorkoutBadgeItem.Advanced(
                id = 14,
                icon = Icons.PlayOff,
                titleText = "Russian Twists",
                subtitleIcon = Icons.TimeDefault,
                subtitleText = "00:15",
                trailingTopText = "2x"
            ),
            WorkoutBadgeItem.Advanced(
                id = 15,
                icon = Icons.PlayOn,
                titleText = "Squats",
                subtitleIcon = Icons.TimeDefault,
                subtitleText = "00:30",
                trailingTopText = "2x"
            ),
            WorkoutBadgeItem.Advanced(
                id = 16,
                icon = Icons.PlayOff,
                titleText = "Tabata Intervals",
                subtitleIcon = Icons.TimeDefault,
                subtitleText = "00:10",
                trailingTopText = "2x"
            ),
            WorkoutBadgeItem.Advanced(
                id = 17,
                icon = Icons.PlayOff,
                titleText = "Bicycle Crunches",
                subtitleIcon = Icons.TimeDefault,
                subtitleText = "00:10",
                trailingTopText = "4x"
            ),
            WorkoutBadgeItem.Advanced(
                id = 18,
                icon = Icons.PlayOff,
                titleText = "Russian Twists",
                subtitleIcon = Icons.TimeDefault,
                subtitleText = "00:15",
                trailingTopText = "2x"
            ),
        )
    }
}