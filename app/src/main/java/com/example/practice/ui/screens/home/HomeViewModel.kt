package com.example.practice.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.domain.models.UserProfile
import com.example.practice.domain.usecase.GetUserProfileUseCase
import com.example.practice.ui.screens.home.actions.HomeAction
import com.example.practice.ui.screens.home.actions.HomeSideEffect
import com.example.practice.ui.screens.home.actions.HomeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getUserProfile: GetUserProfileUseCase
) : ViewModel() {
    private val uiStateFlow = MutableStateFlow(HomeState())
    val uiStateEmitter = uiStateFlow.asStateFlow()

    private val sideEffectFlow = MutableStateFlow<HomeSideEffect>(HomeSideEffect.Empty)
    val sideEffectEmitter = sideEffectFlow.asStateFlow()

    init {
        observeUserProfile()
    }

    private var originalProfile: UserProfile? = null

    private fun observeUserProfile() {
        viewModelScope.launch {
            getUserProfile().collect { profile ->
                originalProfile = profile
                uiStateFlow.value = uiStateFlow.value.copy(
                    nickname = profile.nickname.orEmpty()
                )
            }
        }
    }

    fun handleUiAction(action: HomeAction) {
        when(action) {
            is HomeAction.Search -> {
                sideEffectFlow.value = HomeSideEffect.ShowSearchScreen
            }
            is HomeAction.Notification -> {
                sideEffectFlow.value = HomeSideEffect.ShowNotificationScreen
            }
            is HomeAction.Profile -> {
                sideEffectFlow.value = HomeSideEffect.ShowProfileScreen
            }
            is HomeAction.ProgressTracking -> {
                sideEffectFlow.value = HomeSideEffect.ShowProgressTrackingScreen
            }
            is HomeAction.Nutrition -> {
                sideEffectFlow.value = HomeSideEffect.ShowNutritionScreen
            }
            is HomeAction.Community -> {
                sideEffectFlow.value = HomeSideEffect.ShowCommunityScreen
            }
            is HomeAction.WorkoutSeeAll -> {
                sideEffectFlow.value = HomeSideEffect.ShowWorkoutSeeAll
            }
        }
    }

    fun clearSideEffect() {
        sideEffectFlow.value = HomeSideEffect.Empty
    }
}