package com.example.practice.ui.screens.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.domain.models.UserProfile
import com.example.practice.domain.usecase.GetUserProfileUseCase
import com.example.practice.domain.usecase.NotificationSettingsUseCase
import com.example.practice.domain.usecase.SetUserProfileUseCase
import com.example.practice.ui.screens.profile.actions.ProfileAction
import com.example.practice.ui.screens.profile.actions.ProfileSideEffect
import com.example.practice.ui.screens.profile.actions.ProfileState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val getUserProfile: GetUserProfileUseCase,
    private val setUserProfile: SetUserProfileUseCase,
    private val notificationSettings: NotificationSettingsUseCase
): ViewModel() {
    private val uiStateFlow = MutableStateFlow(ProfileState())
    val uiStateEmitter = uiStateFlow.asStateFlow()

    private val sideEffectFlow = MutableStateFlow<ProfileSideEffect>(ProfileSideEffect.Empty)
    val sideEffectEmitter = sideEffectFlow.asStateFlow()

    private var originalProfile: UserProfile? = null

    init {
        profileData()
    }

    fun handleUiAction(action: ProfileAction) {
        when(action) {
            is ProfileAction.NavigateBack -> {
                sideEffectFlow.value = ProfileSideEffect.ShowNavigateBack
            }
            is ProfileAction.NavigateProfileEditing -> {
                sideEffectFlow.value = ProfileSideEffect.ShowEditProfileScreen
            }
            is ProfileAction.NavigateFavorite -> {
                sideEffectFlow.value = ProfileSideEffect.ShowFavoritesScreen
            }
            is ProfileAction.NavigatePrivacyPolicy -> {
                sideEffectFlow.value = ProfileSideEffect.ShowPrivacyPolicyScreen
            }
            is ProfileAction.NavigateSettings -> {
                sideEffectFlow.value = ProfileSideEffect.ShowSettingsScreen
            }
            is ProfileAction.NavigateHelp -> {
                sideEffectFlow.value = ProfileSideEffect.ShowHelpScreen
            }
            is ProfileAction.NavigateLogout -> {
                logoutAccount()
            }
            else -> {}
        }
    }

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
                uiStateFlow.value = state
            }
        }
    }

    private fun logoutAccount() {
        viewModelScope.launch {
            try {
                setUserProfile.clear()
                notificationSettings.clear()
                sideEffectFlow.value = ProfileSideEffect.ShowLogoutScreen
            } catch (e: Exception) {
                sideEffectFlow.value = ProfileSideEffect.ShowError(e)
            }
        }
    }

    fun clearSideEffect() {
        sideEffectFlow.value = ProfileSideEffect.Empty
    }
}