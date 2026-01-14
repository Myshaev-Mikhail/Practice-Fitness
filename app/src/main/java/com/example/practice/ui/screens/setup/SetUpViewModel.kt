package com.example.practice.ui.screens.setup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.data.datastore.UserProfileDataStore
import com.example.practice.ui.screens.setup.intents.SetUpAction
import com.example.practice.ui.screens.setup.intents.SetUpProfile
import com.example.practice.ui.screens.setup.intents.SetUpSideEffect
import com.example.practice.ui.screens.setup.intents.SetUpState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SetUpViewModel(
    private val dataStore: UserProfileDataStore
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
                    saveAndNext {
                        dataStore.setGender(gender)
                    }
                }
            }

            is SetUpAction.AgeEntered -> saveAndNext {
                dataStore.setAge(action.age)
                uiState.value = uiState.value.copy(age = action.age)
            }

            is SetUpAction.WeightEntered -> saveAndNext {
                dataStore.setWeight(action.weight)
                uiState.value = uiState.value.copy(weight = action.weight)
            }

            is SetUpAction.HeightEntered -> saveAndNext {
                dataStore.setHeight(action.height)
                uiState.value = uiState.value.copy(height = action.height)
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
                    saveAndNext {
                        dataStore.setGoal(goal)
                    }
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
                    saveAndNext {
                        dataStore.setActivity(activityLevel)
                    }
                }
            }

            is SetUpAction.ProfileChanged -> {
                uiState.value = uiState.value.copy(
                    profile = action.profile,
                    isProfileValid = true
                )
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
                    viewModelScope.launch {
                        dataStore.setProfile(profile)
                        dataStore.setFirstSetupCompleted()
                        sideEffect.value = SetUpSideEffect.NavigateNext
                    }
                }
            }


            SetUpAction.NavigateBack -> {
                sideEffect.value = SetUpSideEffect.NavigateBack
            }
        }
    }

    private fun saveAndNext(block: suspend () -> Unit) {
        viewModelScope.launch {
            block()
            sideEffect.value = SetUpSideEffect.NavigateNext
        }
    }

    private fun isProfileValid(profile: SetUpProfile?): Boolean {
        if (profile == null) return false

        return profile.fullName?.isNotBlank() == true &&
                profile.nickname?.isNotBlank() == true &&
                profile.email?.isNotBlank() == true &&
                profile.mobileNumber?.isNotBlank() == true
    }


    fun clearSideEffect() {
        sideEffect.value = SetUpSideEffect.Empty
    }
}