package com.example.practice.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.domain.models.UserProfile
import com.example.practice.domain.usecase.GetUserProfileUseCase
import com.example.practice.ui.screens.home.intents.HomeAction
import com.example.practice.ui.screens.home.intents.HomeSideEffect
import com.example.practice.ui.screens.home.intents.HomeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getUserProfile: GetUserProfileUseCase
) : ViewModel() {
    private val uiState = MutableStateFlow(HomeState())
    val uiStateEmitter = uiState.asStateFlow()

    private val sideEffect = MutableStateFlow<HomeSideEffect>(HomeSideEffect.Empty)
    val sideEffectEmitter = sideEffect.asStateFlow()

    init {
        observeUserProfile()
    }

    private var originalProfile: UserProfile? = null

    private fun observeUserProfile() {
        viewModelScope.launch {
            getUserProfile().collect { profile ->
                originalProfile = profile
                uiState.value = uiState.value.copy(
                    nickname = profile.nickname.orEmpty()
                )
            }
        }
    }

    fun uiAction(action: HomeAction) {
        when(action) {
            is HomeAction.Search -> {
                sideEffect.value = HomeSideEffect.ShowSearchScreen
            }
            is HomeAction.Notification -> {
                sideEffect.value = HomeSideEffect.ShowNotificationScreen
            }
            is HomeAction.Profile -> {
                sideEffect.value = HomeSideEffect.ShowProfileScreen
            }
            is HomeAction.ProgressTracking -> {
                sideEffect.value = HomeSideEffect.ShowProgressTrackingScreen
            }
            is HomeAction.Nutrition -> {
                sideEffect.value = HomeSideEffect.ShowNutritionScreen
            }
            is HomeAction.Community -> {
                sideEffect.value = HomeSideEffect.ShowCommunityScreen
            }
            is HomeAction.WorkoutSeeAll -> {
                sideEffect.value = HomeSideEffect.ShowWorkoutSeeAll
            }
        }
    }

    fun clearSideEffect() {
        sideEffect.value = HomeSideEffect.Empty
    }
}