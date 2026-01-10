package com.example.practice.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.data.datastore.UserProfileDataStore
import com.example.practice.ui.screens.home.intents.HomeAction
import com.example.practice.ui.screens.home.intents.HomeSideEffect
import com.example.practice.ui.screens.home.intents.HomeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val userProfileDataStore: UserProfileDataStore
) : ViewModel() {
    private val uiState = MutableStateFlow(HomeState())
    val uiStateEmitter = uiState.asStateFlow()

    private val sideEffect = MutableStateFlow<HomeSideEffect>(HomeSideEffect.Empty)
    val sideEffectEmitter = sideEffect.asStateFlow()

    init {
        observeUserProfile()
    }

    private fun observeUserProfile() {
        viewModelScope.launch {
            userProfileDataStore.profileFlow.collect { profile ->
                uiState.value = uiState.value.copy(
                    nickname = profile.nickname
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
        }
    }


    fun clearSideEffect() {
        sideEffect.value = HomeSideEffect.Empty
    }
}