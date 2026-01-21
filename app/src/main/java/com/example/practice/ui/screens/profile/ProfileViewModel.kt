package com.example.practice.ui.screens.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.domain.models.UserProfile
import com.example.practice.domain.usecase.GetUserProfileUseCase
import com.example.practice.ui.screens.profile.intents.ProfileAction
import com.example.practice.ui.screens.profile.intents.ProfileSideEffect
import com.example.practice.ui.screens.profile.intents.ProfileState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val getUserProfile: GetUserProfileUseCase
): ViewModel() {
    private val uiState = MutableStateFlow(ProfileState())
    val uiStateEmitter = uiState.asStateFlow()

    private val sideEffect = MutableStateFlow<ProfileSideEffect>(ProfileSideEffect.Empty)
    val sideEffectEmitter = sideEffect.asStateFlow()

    init {
        profileData()
    }

    fun uiAction(action: ProfileAction) {
        when(action) {
            is ProfileAction.NavigateBack -> {
                sideEffect.value = ProfileSideEffect.ShowNavigateBack
            }
            is ProfileAction.NavigateProfileEditing -> {
                sideEffect.value = ProfileSideEffect.ShowEditProfileScreen
            }
            is ProfileAction.NavigateFavorite -> {
                sideEffect.value = ProfileSideEffect.ShowFavoritesScreen
            }
            is ProfileAction.NavigatePrivacyPolicy -> {
                sideEffect.value = ProfileSideEffect.ShowPrivacyPolicyScreen
            }
            is ProfileAction.NavigateSettings -> {
                sideEffect.value = ProfileSideEffect.ShowSettingsScreen
            }
            is ProfileAction.NavigateSupport -> {
                sideEffect.value = ProfileSideEffect.ShowSupportScreen
            }
            is ProfileAction.NavigateLogout -> {
                sideEffect.value = ProfileSideEffect.ShowLogoutScreen
            }
            else -> {}
        }
    }

    private var originalProfile: UserProfile? = null

    private fun profileData() {
        viewModelScope.launch {
            getUserProfile().first().let { profile ->
                originalProfile = profile
                val state = ProfileState(
                    fullName = profile.fullName,
                    email = profile.email,
                    weight = profile.weight,
                    age = profile.age,
                    height = profile.height,
                    avatarUri = profile.avatarUri
                )
                uiState.value = state
            }
        }
    }

    fun clearSideEffect() {
        sideEffect.value = ProfileSideEffect.Empty
    }
}