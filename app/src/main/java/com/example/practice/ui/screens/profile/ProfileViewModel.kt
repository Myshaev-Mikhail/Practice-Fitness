package com.example.practice.ui.screens.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.data.datastore.UserProfileDataStore
import com.example.practice.ui.screens.profile.intents.ProfileAction
import com.example.practice.ui.screens.profile.intents.ProfileSideEffect
import com.example.practice.ui.screens.profile.intents.ProfileState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.String

class ProfileViewModel(
    private val userProfileDataStore: UserProfileDataStore
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
                sideEffect.value = ProfileSideEffect.ShowProfileEditingScreen
            }
            is ProfileAction.NavigateFavorite -> {
                sideEffect.value = ProfileSideEffect.ShowFavoriteScreen
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

    private fun profileData() {
        viewModelScope.launch {
            userProfileDataStore.profileFlow.collect { profile ->
                uiState.value = uiState.value.copy(
                    fullName = profile.fullName,
                    email = profile.email,
                    weight = profile.weight,
                    age = profile.age,
                    height = profile.height,
                    avatarUri = profile.avatarUri
                )
            }
        }
    }

    fun clearSideEffect() {
        sideEffect.value = ProfileSideEffect.Empty
    }
}