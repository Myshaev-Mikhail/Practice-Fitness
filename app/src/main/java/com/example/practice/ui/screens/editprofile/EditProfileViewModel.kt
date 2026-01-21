package com.example.practice.ui.screens.editprofile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.domain.models.UserProfile
import com.example.practice.domain.usecase.GetUserProfileUseCase
import com.example.practice.domain.usecase.UpdateUserProfileUseCase
import com.example.practice.ui.screens.editprofile.intents.EditProfileAction
import com.example.practice.ui.screens.editprofile.intents.EditProfileSideEffect
import com.example.practice.ui.screens.editprofile.intents.EditProfileState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EditProfileViewModel(
    private val getUserProfile: GetUserProfileUseCase,
    private val updateUserProfile: UpdateUserProfileUseCase
): ViewModel() {
    private val uiState = MutableStateFlow(EditProfileState())
    val uiStateEmitter = uiState.asStateFlow()

    private val sideEffect = MutableStateFlow<EditProfileSideEffect>(EditProfileSideEffect.Empty)
    val sideEffectEmitter = sideEffect.asStateFlow()

    private var originalState: EditProfileState? = null

    init {
        profileData()
    }

    fun uiAction(action: EditProfileAction) {
        when (action) {
            is EditProfileAction.AvatarPicked -> {
                uiState.value = uiState.value.copy(
                    tempAvatarUri = action.uri
                )
            }

            is EditProfileAction.AvatarConfirmed -> {
                uiState.value = uiState.value.copy(
                    avatarUri = action.uri,
                    tempAvatarUri = null
                )
            }

            EditProfileAction.ClearTempAvatar -> {
                uiState.value = uiState.value.copy(
                    tempAvatarUri = null
                )
            }

            is EditProfileAction.FullNameChanged -> {
                uiState.value = uiState.value.copy(
                    fullName = normalizeText(action.value)
                )
            }

            is EditProfileAction.EmailChanged -> {
                uiState.value = uiState.value.copy(
                    email = normalizeText(action.value)
                )
            }

            is EditProfileAction.MobileChanged -> {
                uiState.value = uiState.value.copy(
                    mobileNumber = normalizeText(action.value)
                )
            }

            is EditProfileAction.AgeChanged -> {
                uiState.value = uiState.value.copy(
                    date = action.value.toIntOrNull()
                )
            }

            is EditProfileAction.WeightChanged -> {
                uiState.value = uiState.value.copy(
                    weight = action.value.toFloatOrNull()
                )
            }

            is EditProfileAction.HeightChanged -> {
                uiState.value = uiState.value.copy(
                    height = action.value.toIntOrNull()
                )
            }

            is EditProfileAction.SaveProfile -> {
                saveProfile()
            }

            is EditProfileAction.NavigateBack -> {
                if (hasUnsavedChanges()) {
                    sideEffect.value = EditProfileSideEffect.ShowUnsavedChangesDialog
                } else {
                    sideEffect.value = EditProfileSideEffect.ShowNavigateBack
                }
            }
        }
    }

    private var originalProfile: UserProfile? = null

    private fun profileData() {
        viewModelScope.launch {
            getUserProfile().first().let { profile ->
                originalProfile = profile
                val state = EditProfileState(
                    avatarUri = profile.avatarUri,
                    fullName = profile.fullName.orEmpty(),
                    email = profile.email.orEmpty(),
                    mobileNumber = profile.mobileNumber.orEmpty(),
                    date = profile.age,
                    weight = profile.weight,
                    height = profile.height,
                    isProfileValid = true
                )
                uiState.value = state
                originalState = state
            }
        }
    }

    fun hasUnsavedChanges(): Boolean {
        val current = uiState.value
        val original = originalState ?: return false

        return current.avatarUri != original.avatarUri ||
                current.fullName != original.fullName ||
                current.email != original.email ||
                current.mobileNumber != original.mobileNumber ||
                current.date != original.date ||
                current.weight != original.weight ||
                current.height != original.height
    }

    private fun saveProfile() {
        viewModelScope.launch {
            val state = uiState.value
            val current = originalProfile ?: return@launch

            updateUserProfile(
                current.copy(
                    gender = originalProfile!!.gender,
                    goal = originalProfile!!.goal,
                    activityLevel = originalProfile!!.activityLevel,
                    age = state.date ?: 0,
                    weight = state.weight ?: 0f,
                    height = state.height ?: 0,
                    fullName = state.fullName,
                    email = state.email,
                    mobileNumber = state.mobileNumber,
                    avatarUri = state.avatarUri
                )
            )

            sideEffect.value = EditProfileSideEffect.ShowNavigateBack
        }
    }

    fun normalizeText(input: String): String {
        return input
            .trim()
            .replace(Regex("\\s+"), " ")
    }

    fun clearSideEffect() {
        sideEffect.value = EditProfileSideEffect.Empty
    }
}