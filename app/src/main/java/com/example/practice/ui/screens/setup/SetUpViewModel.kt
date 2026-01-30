package com.example.practice.ui.screens.setup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.domain.models.ActivityLevel
import com.example.practice.domain.models.Gender
import com.example.practice.domain.models.UserProfile
import com.example.practice.domain.usecase.SetFirstSetupUseCase
import com.example.practice.domain.usecase.SetUserProfileUseCase
import com.example.practice.ui.screens.setup.actions.SetUpAction
import com.example.practice.ui.screens.setup.actions.SetUpProfile
import com.example.practice.ui.screens.setup.actions.SetUpSideEffect
import com.example.practice.ui.screens.setup.actions.SetUpState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SetUpViewModel(
    private val updateUserProfile: SetUserProfileUseCase,
    private val setFirstSetup: SetFirstSetupUseCase
) : ViewModel() {
    private val uiStateFlow = MutableStateFlow(SetUpState())
    val uiStateEmitter = uiStateFlow.asStateFlow()

    private val sideEffectFlow = MutableStateFlow<SetUpSideEffect>(SetUpSideEffect.Empty)
    val sideEffectEmitter = sideEffectFlow.asStateFlow()

    fun handleUiAction(action: SetUpAction) {
        when (action) {
            SetUpAction.StartSetUp -> {
                sideEffectFlow.value = SetUpSideEffect.ShowGenderScreen
            }

            is SetUpAction.GenderSelected -> {
                uiStateFlow.value = uiStateFlow.value.copy(gender = action.gender)
            }

            is SetUpAction.ContinueClickedGender -> {
                val gender = uiStateFlow.value.gender
                if (gender == null) {
                    sideEffectFlow.value =
                        SetUpSideEffect.ShowToast("Gender is not selected")
                } else {
                    sideEffectFlow.value = SetUpSideEffect.NavigateNext
                }
            }

            is SetUpAction.AgeEntered -> {
                uiStateFlow.value = uiStateFlow.value.copy(age = action.age)
                sideEffectFlow.value = SetUpSideEffect.NavigateNext
            }

            is SetUpAction.WeightEntered -> {
                uiStateFlow.value = uiStateFlow.value.copy(weight = action.weight)
                sideEffectFlow.value = SetUpSideEffect.NavigateNext
            }

            is SetUpAction.HeightEntered -> {
                uiStateFlow.value = uiStateFlow.value.copy(height = action.height)
                sideEffectFlow.value = SetUpSideEffect.NavigateNext
            }

            is SetUpAction.GoalSelected -> {
                uiStateFlow.value = uiStateFlow.value.copy(goal = action.goal.toList())
            }

            is SetUpAction.ContinueClickedGoal -> {
                val goal = uiStateFlow.value.goal
                if (goal == null) {
                    sideEffectFlow.value =
                        SetUpSideEffect.ShowToast("Goal is not selected")
                } else {
                    sideEffectFlow.value = SetUpSideEffect.NavigateNext
                }
            }

            is SetUpAction.ActivitySelected -> {
                uiStateFlow.value = uiStateFlow.value.copy(activityLevel = action.level)
            }

            is SetUpAction.ContinueClickedActivityLevel -> {
                val activityLevel = uiStateFlow.value.activityLevel
                if (activityLevel == null) {
                    sideEffectFlow.value =
                        SetUpSideEffect.ShowToast("Physical activity level is not selected")
                } else {
                    sideEffectFlow.value = SetUpSideEffect.NavigateNext
                }
            }

            is SetUpAction.ProfileChanged -> {
                uiStateFlow.value = uiStateFlow.value.copy(
                    profile = action.profile,
                    isProfileValid = true
                )
            }

            is SetUpAction.AvatarPicked -> {
                uiStateFlow.value = uiStateFlow.value.copy(tempAvatarUri = action.uri)
            }

            is SetUpAction.ClearTempAvatar -> {
                uiStateFlow.value = uiStateFlow.value.copy(tempAvatarUri = null)
            }

            SetUpAction.SaveProfile -> {
                val profile = uiStateFlow.value.profile ?: SetUpProfile()

                if (profile.fullName.isNullOrBlank()) {
                    sideEffectFlow.value = SetUpSideEffect.ShowToast("Full name is required")
                } else if (profile.nickname.isNullOrBlank()) {
                    sideEffectFlow.value = SetUpSideEffect.ShowToast("Nickname is required")
                } else if (profile.email.isNullOrBlank()) {
                    sideEffectFlow.value = SetUpSideEffect.ShowToast("Email is required")
                } else if (profile.mobileNumber.isNullOrBlank()) {
                    sideEffectFlow.value = SetUpSideEffect.ShowToast("Mobile number is required")
                } else {
                    saveProfile()
                }
            }

            SetUpAction.NavigateBack -> {
                sideEffectFlow.value = SetUpSideEffect.NavigateBack
            }
        }
    }

    private fun saveProfile() {
        val profileInput = uiStateFlow.value.profile ?: return
        if (!isProfileValid(profileInput)) {
            sideEffectFlow.value = SetUpSideEffect.ShowToast("All fields must be filled")
            return
        }

        val updatedProfile = UserProfile(
            gender = uiStateFlow.value.gender ?: Gender.MALE,
            age = uiStateFlow.value.age ?: 0,
            weight = uiStateFlow.value.weight ?: 0f,
            height = uiStateFlow.value.height ?: 0,
            goal = uiStateFlow.value.goal ?: emptyList(),
            activityLevel = uiStateFlow.value.activityLevel ?: ActivityLevel.BEGINNER,
            fullName = profileInput.fullName,
            nickname = profileInput.nickname,
            email = profileInput.email,
            mobileNumber = profileInput.mobileNumber,
            avatarUri = uiStateFlow.value.tempAvatarUri ?: profileInput.avatarUri
        )

        viewModelScope.launch {
            updateUserProfile(updatedProfile)
            setFirstSetup()
            sideEffectFlow.value = SetUpSideEffect.NavigateNext
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
        sideEffectFlow.value = SetUpSideEffect.Empty
    }
}