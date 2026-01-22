package com.example.practice.ui.screens.login

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.data.repository.AuthError
import com.example.practice.ui.screens.login.intents.LogInAction
import com.example.practice.ui.screens.login.intents.LogInSideEffect
import com.example.practice.ui.screens.login.intents.LogInState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.example.practice.domain.usecase.LogInWithGoogleUseCase
import com.example.practice.domain.usecase.LogInWithEmailUseCase
import com.example.practice.domain.usecase.SetFirstSetupUseCase
import com.example.practice.ui.utils.isInternetAvailable

class LogInViewModel(
    private val logInWithEmailUseCase: LogInWithEmailUseCase,
    private val logInWithGoogleUseCase: LogInWithGoogleUseCase,
    private val setFirstSetup: SetFirstSetupUseCase
) : ViewModel() {
    private val uiState = MutableStateFlow(LogInState())
    val uiStateEmitter = uiState.asStateFlow()

    private val sideEffect = MutableStateFlow<LogInSideEffect>(LogInSideEffect.Empty)
    val sideEffectEmitter = sideEffect.asStateFlow()

    fun uiAction(action: LogInAction, context: Context? = null) {
        when (action) {
            is LogInAction.EmailChanged -> {
                uiState.value = uiState.value.copy(email = action.value)
            }

            is LogInAction.PasswordChanged -> {
                uiState.value = uiState.value.copy(password = action.value)
            }

            is LogInAction.EmailLogInClicked -> {
                if (context != null && !isInternetAvailable(context)) {
                    sideEffect.value = LogInSideEffect.ShowToast("There is no internet connection")
                    return
                }

                if (uiState.value.email.isEmpty()) {
                    sideEffect.value = LogInSideEffect.ShowToast("Email is required")
                } else if (uiState.value.password.isEmpty()) {
                    sideEffect.value = LogInSideEffect.ShowToast("Password is required")
                } else {
                    logInWithEmail()
                }
            }

            is LogInAction.GoogleLogInClicked -> {
                if (context != null && !isInternetAvailable(context)) {
                    sideEffect.value = LogInSideEffect.ShowToast("There is no internet connection")
                    return
                }

                logInWithGoogle()
            }

            is LogInAction.ForgotPasswordClicked -> {
                sideEffect.value = LogInSideEffect.ShowForgottenPasswordScreen
            }
        }
    }

    private fun logInWithEmail() {
        uiState.value = uiState.value.copy(isLoading = true)

        viewModelScope.launch {
            val result = logInWithEmailUseCase(
                uiState.value.email,
                uiState.value.password
            )

            uiState.value = uiState.value.copy(isLoading = false)

            result
                .onSuccess {
                    setFirstSetup.invoke()
                    sideEffect.value = LogInSideEffect.Success
                }
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

    private fun logInWithGoogle() {
        uiState.value = uiState.value.copy(isLoading = true)

        viewModelScope.launch {
            val result = logInWithGoogleUseCase()
            uiState.value = uiState.value.copy(isLoading = false)

            result
                .onSuccess {
                    setFirstSetup()
                    sideEffect.value = LogInSideEffect.Success
                }
                .onFailure {
                    sideEffect.value = LogInSideEffect.ShowToast("Google sign-in failed")
                }
        }
    }

    fun clearSideEffect() {
        sideEffect.value = LogInSideEffect.Empty
    }
}