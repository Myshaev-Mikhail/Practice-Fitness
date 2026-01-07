package com.example.practice.ui.screens.setup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.data.datastore.UserProfileDataStore
import com.example.practice.ui.screens.setup.intents.SetUpAction
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

            is SetUpAction.GenderSelected -> saveAndNext {
                dataStore.saveGender(action.gender)
                uiState.value = uiState.value.copy(gender = action.gender)
                println("Гендер :${action.gender}")
            }

            is SetUpAction.AgeEntered -> saveAndNext {
                dataStore.saveAge(action.age)
                uiState.value = uiState.value.copy(age = action.age)
                println("Возраст :${action.age}")
            }

            is SetUpAction.WeightEntered -> saveAndNext {
                dataStore.saveWeight(action.weight)
                uiState.value = uiState.value.copy(weight = action.weight)
                println("Вес :${action.weight}")
            }

            is SetUpAction.HeightEntered -> saveAndNext {
                dataStore.saveHeight(action.height)
                uiState.value = uiState.value.copy(height = action.height)
            }

            is SetUpAction.GoalSelected -> saveAndNext {
                dataStore.saveGoal(action.goal)
                uiState.value = uiState.value.copy(goal = action.goal)
            }

            is SetUpAction.ActivitySelected -> saveAndNext {
                dataStore.saveActivity(action.level)
                uiState.value = uiState.value.copy(activityLevel = action.level)
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

    fun clearSideEffect() {
        sideEffect.value = SetUpSideEffect.Empty
    }
}