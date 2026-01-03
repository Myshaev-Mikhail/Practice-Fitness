package com.example.practice.ui.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.data.auth.AuthError
import com.example.practice.data.auth.AuthRepository
import com.example.practice.ui.screens.login.intents.LogInAction
import com.example.practice.ui.screens.login.intents.LogInSideEffect
import com.example.practice.ui.screens.login.intents.LogInState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LogInViewModel : ViewModel() {
    private val uiState = MutableStateFlow(LogInState())
    val uiStateEmitter = uiState.asStateFlow()

    private val sideEffect = MutableStateFlow<LogInSideEffect>(LogInSideEffect.Empty)
    val sideEffectEmitter = sideEffect.asStateFlow()

    val authRepository = AuthRepository()

    fun uiAction(action: LogInAction) {
        when (action) {
            is LogInAction.EmailChanged -> {
                uiState.value = uiState.value.copy(email = action.value)
            }

            is LogInAction.PasswordChanged -> {
                uiState.value = uiState.value.copy(password = action.value)
            }

            is LogInAction.LogInClicked -> {
                logIn()
            }
        }
    }

    private fun logIn() {
        val state = uiState.value

        uiState.value = state.copy(isLoading = true)

        viewModelScope.launch {
            val result = authRepository.logIn(state.email, state.password)

            uiState.value = uiState.value.copy(isLoading = false)

            result
                .onSuccess { sideEffect.value = LogInSideEffect.Success }
                .onFailure { error ->
                    val message = when (error) {
                        is AuthError.InvalidEmailOrPassword -> "Неверная почта или пароль"
                        is AuthError.Unknown -> error.errorMessage
                        else -> "Ошибка входа"
                    }
                    sideEffect.value = LogInSideEffect.ShowToast(message)
                }
        }
    }
}