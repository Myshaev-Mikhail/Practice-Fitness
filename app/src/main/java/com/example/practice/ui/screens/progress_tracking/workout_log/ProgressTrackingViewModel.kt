package com.example.practice.ui.screens.progress_tracking.workout_log

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.domain.models.UserProfile
import com.example.practice.domain.usecase.GetUserProfileUseCase
import com.example.practice.ui.screens.progress_tracking.charts.actions.ChartsSideEffect
import com.example.practice.ui.screens.progress_tracking.workout_log.actions.ProgressTrackingAction
import com.example.practice.ui.screens.progress_tracking.workout_log.actions.ProgressTrackingSideEffect
import com.example.practice.ui.screens.progress_tracking.workout_log.actions.ProgressTrackingState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class ProgressTrackingViewModel(
    private val getUserProfile: GetUserProfileUseCase
): ViewModel() {
    private val uiStateFlow = MutableStateFlow(ProgressTrackingState())
    val uiStateEmitter = uiStateFlow.asStateFlow()

    private val sideEffectFlow = MutableStateFlow<ProgressTrackingSideEffect>(ProgressTrackingSideEffect.Empty)
    val sideEffectEmitter = sideEffectFlow.asStateFlow()

    private var originalProfile: UserProfile? = null

    init {
        profileData()
    }

    fun handleUiAction(action: ProgressTrackingAction) {
        when(action) {
            is ProgressTrackingAction.ChartsPressed -> {
                sideEffectFlow.value = ProgressTrackingSideEffect.ShowCharts
            }
        }
    }

    private fun profileData() {
        viewModelScope.launch {
            getUserProfile().first().let { profile ->
                originalProfile = profile
                val state = ProgressTrackingState(
                    fullName = profile.fullName,
                    weight = profile.weight,
                    age = profile.age,
                    height = profile.height,
                    avatarUri = profile.avatarUri
                )
                uiStateFlow.value = state
            }
        }
    }

    fun clearSideEffect() {
        sideEffectFlow.value = ProgressTrackingSideEffect.Empty
    }
}