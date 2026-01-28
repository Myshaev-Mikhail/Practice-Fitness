package com.example.practice.ui.screens.editprofile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.domain.models.UserProfile
import com.example.practice.domain.usecase.GetUserProfileUseCase
import com.example.practice.domain.usecase.SetUserProfileUseCase
import com.example.practice.ui.screens.editprofile.actions.EditProfileAction
import com.example.practice.ui.screens.editprofile.actions.EditProfileSideEffect
import com.example.practice.ui.screens.editprofile.actions.EditProfileState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EditProfileViewModel(
    private val getUserProfile: GetUserProfileUseCase,
    private val updateUserProfile: SetUserProfileUseCase
): ViewModel() {
    private val uiStateFlow = MutableStateFlow(EditProfileState())
    val uiStateEmitter = uiStateFlow.asStateFlow()

    private val sideEffectFlow = MutableStateFlow<EditProfileSideEffect>(EditProfileSideEffect.Empty)
    val sideEffectEmitter = sideEffectFlow.asStateFlow()

    private var originalState: EditProfileState? = null
    private var originalProfile: UserProfile? = null

    init {
        profileData()
    }

    fun handleUiAction(action: EditProfileAction) {
        when (action) {
            is EditProfileAction.AvatarPicked -> {
                uiStateFlow.value = uiStateFlow.value.copy(
                    tempAvatarUri = action.uri
                )
            }

            is EditProfileAction.AvatarConfirmed -> {
                uiStateFlow.value = uiStateFlow.value.copy(
                    avatarUri = action.uri,
                    tempAvatarUri = null
                )
            }

            EditProfileAction.ClearTempAvatar -> {
                uiStateFlow.value = uiStateFlow.value.copy(
                    tempAvatarUri = null
                )
            }

            is EditProfileAction.FullNameChanged -> {
                uiStateFlow.value = uiStateFlow.value.copy(
                    fullName = normalizeText(action.value)
                )
            }

            is EditProfileAction.EmailChanged -> {
                uiStateFlow.value = uiStateFlow.value.copy(
                    email = normalizeText(action.value)
                )
            }

            is EditProfileAction.MobileChanged -> {
                uiStateFlow.value = uiStateFlow.value.copy(
                    mobileNumber = normalizeText(action.value)
                )
            }

            is EditProfileAction.AgeChanged -> {
                uiStateFlow.value = uiStateFlow.value.copy(
                    date = action.value.toIntOrNull()
                )
            }

            is EditProfileAction.WeightChanged -> {
                uiStateFlow.value = uiStateFlow.value.copy(
                    weight = action.value.toFloatOrNull()
                )
            }

            is EditProfileAction.HeightChanged -> {
                uiStateFlow.value = uiStateFlow.value.copy(
                    height = action.value.toIntOrNull()
                )
            }

            is EditProfileAction.SaveProfile -> {
                saveProfile()
            }

            is EditProfileAction.NavigateBack -> {
                if (hasUnsavedChanges()) {
                    sideEffectFlow.value = EditProfileSideEffect.ShowUnsavedChangesDialog
                } else {
                    sideEffectFlow.value = EditProfileSideEffect.ShowNavigateBack
                }
            }
        }
    }

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
                uiStateFlow.value = state
                originalState = state
            }
        }
    }

    fun hasUnsavedChanges(): Boolean {
        val current = uiStateFlow.value
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
            val state = uiStateFlow.value
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

            sideEffectFlow.value = EditProfileSideEffect.ShowNavigateBack
        }
    }

    fun normalizeText(input: String): String {
        return input
            .trim()
            .replace(Regex("\\s+"), " ")
    }

    fun clearSideEffect() {
        sideEffectFlow.value = EditProfileSideEffect.Empty
    }
}