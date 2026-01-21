package com.example.practice.ui.screens.setup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.domain.models.ActivityLevel
import com.example.practice.domain.models.Gender
import com.example.practice.domain.models.UserProfile
import com.example.practice.domain.usecase.SetFirstSetupUseCase
import com.example.practice.domain.usecase.UpdateUserProfileUseCase
import com.example.practice.ui.screens.setup.intents.SetUpAction
import com.example.practice.ui.screens.setup.intents.SetUpProfile
import com.example.practice.ui.screens.setup.intents.SetUpSideEffect
import com.example.practice.ui.screens.setup.intents.SetUpState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SetUpViewModel(
    private val updateUserProfile: UpdateUserProfileUseCase,
    private val setFirstSetup: SetFirstSetupUseCase
) : ViewModel() {
    private val uiState = MutableStateFlow(SetUpState())
    val uiStateEmitter = uiState.asStateFlow()

    private val sideEffect =
        MutableStateFlow<SetUpSideEffect>(SetUpSideEffect.Empty)
    val sideEffectEmitter = sideEffect.asStateFlow()

    fun uiAction(action: SetUpAction) {
        when (action) {
            SetUpAction.StartSetUp -> {
                sideEffect.value = SetUpSideEffect.ShowGenderScreen
            }

            is SetUpAction.GenderSelected -> {
                uiState.value = uiState.value.copy(gender = action.gender)
            }

            is SetUpAction.ContinueClickedGender -> {
                val gender = uiState.value.gender
                if (gender == null) {
                    sideEffect.value =
                        SetUpSideEffect.ShowToast("Gender is not selected")
                } else {
                    sideEffect.value = SetUpSideEffect.NavigateNext
                }
            }

            is SetUpAction.AgeEntered -> {
                uiState.value = uiState.value.copy(age = action.age)
                sideEffect.value = SetUpSideEffect.NavigateNext
            }

            is SetUpAction.WeightEntered -> {
                uiState.value = uiState.value.copy(weight = action.weight)
                sideEffect.value = SetUpSideEffect.NavigateNext
            }

            is SetUpAction.HeightEntered -> {
                uiState.value = uiState.value.copy(height = action.height)
                sideEffect.value = SetUpSideEffect.NavigateNext
            }

            is SetUpAction.GoalSelected -> {
                uiState.value = uiState.value.copy(goal = action.goal.toList())
            }

            is SetUpAction.ContinueClickedGoal -> {
                val goal = uiState.value.goal
                if (goal == null) {
                    sideEffect.value =
                        SetUpSideEffect.ShowToast("Goal is not selected")
                } else {
                    sideEffect.value = SetUpSideEffect.NavigateNext
                }
            }

            is SetUpAction.ActivitySelected -> {
                uiState.value = uiState.value.copy(activityLevel = action.level)
            }

            is SetUpAction.ContinueClickedActivityLevel -> {
                val activityLevel = uiState.value.activityLevel
                if (activityLevel == null) {
                    sideEffect.value =
                        SetUpSideEffect.ShowToast("Physical activity level is not selected")
                } else {
                    sideEffect.value = SetUpSideEffect.NavigateNext
                }
            }

            is SetUpAction.ProfileChanged -> {
                uiState.value = uiState.value.copy(
                    profile = action.profile,
                    isProfileValid = true
                )
            }

            is SetUpAction.AvatarPicked -> {
                uiState.value = uiState.value.copy(tempAvatarUri = action.uri)
            }

            is SetUpAction.ClearTempAvatar -> {
                uiState.value = uiState.value.copy(tempAvatarUri = null)
            }

            SetUpAction.SaveProfile -> {
                val profile = uiState.value.profile ?: SetUpProfile()

                if (profile.fullName.isNullOrBlank()) {
                    sideEffect.value = SetUpSideEffect.ShowToast("Full name is required")
                } else if (profile.nickname.isNullOrBlank()) {
                    sideEffect.value = SetUpSideEffect.ShowToast("Nickname is required")
                } else if (profile.email.isNullOrBlank()) {
                    sideEffect.value = SetUpSideEffect.ShowToast("Email is required")
                } else if (profile.mobileNumber.isNullOrBlank()) {
                    sideEffect.value = SetUpSideEffect.ShowToast("Mobile number is required")
                } else {
                    saveProfile()
                }
            }

            SetUpAction.NavigateBack -> {
                sideEffect.value = SetUpSideEffect.NavigateBack
            }
        }
    }

    private fun saveProfile() {
        val profileInput = uiState.value.profile ?: return
        if (!isProfileValid(profileInput)) {
            sideEffect.value = SetUpSideEffect.ShowToast("All fields must be filled")
            return
        }

        val updatedProfile = UserProfile(
            gender = uiState.value.gender ?: Gender.MALE,
            age = uiState.value.age ?: 0,
            weight = uiState.value.weight ?: 0f,
            height = uiState.value.height ?: 0,
            goal = uiState.value.goal ?: emptyList(),
            activityLevel = uiState.value.activityLevel ?: ActivityLevel.BEGINNER,
            fullName = profileInput.fullName,
            nickname = profileInput.nickname,
            email = profileInput.email,
            mobileNumber = profileInput.mobileNumber,
            avatarUri = uiState.value.tempAvatarUri ?: profileInput.avatarUri
        )

        viewModelScope.launch {
            updateUserProfile(updatedProfile)
            setFirstSetup()
            sideEffect.value = SetUpSideEffect.NavigateNext
        }
    }

    fun isProfileValid(profile: SetUpProfile): Boolean =
        profile.fullName?.isNotBlank() == true &&
                profile.nickname?.isNotBlank() == true &&
                profile.email?.isNotBlank() == true &&
                profile.mobileNumber?.isNotBlank() == true

    fun normalizeText(input: String): String {
        return input
            .trim()
            .replace(Regex("\\s+"), " ")
    }

    fun clearSideEffect() {
        sideEffect.value = SetUpSideEffect.Empty
    }
}