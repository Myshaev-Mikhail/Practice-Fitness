package com.example.practice.ui.screens.login

import androidx.lifecycle.ViewModel
import com.example.practice.ui.screens.login.intents.LogInSideEffect
import com.example.practice.ui.screens.login.intents.LogInState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LogInViewModel: ViewModel() {
    private val uiState = MutableStateFlow(LogInState())
    val uiStateEmitter = uiState.asStateFlow()

    private val sideEffect =
        MutableStateFlow<LogInSideEffect>(LogInSideEffect.Empty)
    val sideEffectEmitter = sideEffect.asStateFlow()
}