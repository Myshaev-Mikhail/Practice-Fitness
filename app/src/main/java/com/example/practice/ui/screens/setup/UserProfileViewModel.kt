package com.example.practice.ui.screens.setup

import androidx.lifecycle.ViewModel
import com.example.practice.ui.screens.setup.intents.UserProfileAction
import com.example.practice.ui.screens.setup.intents.UserProfileSideEffect
import com.example.practice.ui.screens.setup.intents.UserProfileState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class UserProfileViewModel: ViewModel() {
    private val uiState = MutableStateFlow(UserProfileState())
    val uiStateEmitter = uiState.asStateFlow()

    private val sideEffect = MutableStateFlow<UserProfileSideEffect>(UserProfileSideEffect.Empty)
    val sideEffectEmitter = sideEffect.asStateFlow()

    fun uiAction(action: UserProfileAction) {
        when(action) {
            is UserProfileAction.NextScreen -> {
                sideEffect.value = UserProfileSideEffect.ShowGenderScreen
            }
        }
    }

    fun clearSideEffect() {
        sideEffect.value = UserProfileSideEffect.Empty
    }
}