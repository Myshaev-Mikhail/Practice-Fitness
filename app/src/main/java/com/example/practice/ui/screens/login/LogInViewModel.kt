package com.example.practice.ui.screens.login

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.data.repository.AuthError
import com.example.practice.ui.screens.login.actions.LogInAction
import com.example.practice.ui.screens.login.actions.LogInSideEffect
import com.example.practice.ui.screens.login.actions.LogInState
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
    private val uiStateFlow = MutableStateFlow(LogInState())
    val uiStateEmitter = uiStateFlow.asStateFlow()

    private val sideEffectFlow = MutableStateFlow<LogInSideEffect>(LogInSideEffect.Empty)
    val sideEffectEmitter = sideEffectFlow.asStateFlow()

    fun handleUiAction(action: LogInAction, context: Context? = null) {
        when (action) {
            is LogInAction.EmailChanged -> {
                uiStateFlow.value = uiStateFlow.value.copy(email = action.value)
            }

            is LogInAction.PasswordChanged -> {
                uiStateFlow.value = uiStateFlow.value.copy(password = action.value)
            }

            is LogInAction.EmailLogInClicked -> {
                if (context != null && !isInternetAvailable(context)) {
                    sideEffectFlow.value = LogInSideEffect.ShowToast("There is no internet connection")
                    return
                }

                if (uiStateFlow.value.email.isEmpty()) {
                    sideEffectFlow.value = LogInSideEffect.ShowToast("Email is required")
                } else if (uiStateFlow.value.password.isEmpty()) {
                    sideEffectFlow.value = LogInSideEffect.ShowToast("Password is required")
                } else {
                    logInWithEmail()
                }
            }

            is LogInAction.GoogleLogInClicked -> {
                if (context != null && !isInternetAvailable(context)) {
                    sideEffectFlow.value = LogInSideEffect.ShowToast("There is no internet connection")
                    return
                }

                logInWithGoogle()
            }

            is LogInAction.ForgotPasswordClicked -> {
                sideEffectFlow.value = LogInSideEffect.ShowForgottenPasswordScreen
            }
        }
    }

    private fun logInWithEmail() {
        uiStateFlow.value = uiStateFlow.value.copy(isLoading = true)

        viewModelScope.launch {
            val result = logInWithEmailUseCase(
                uiStateFlow.value.email,
                uiStateFlow.value.password
            )

            uiStateFlow.value = uiStateFlow.value.copy(isLoading = false)

            result
                .onSuccess {
                    setFirstSetup.invoke()
                    sideEffectFlow.value = LogInSideEffect.Success
                }
                .onFailure { error ->
                    val message = when (error) {
                        is AuthError.InvalidEmailOrPassword -> "Неверная почта или пароль"
                        is AuthError.Unknown -> error.errorMessage
                        else -> "Ошибка входа"
                    }
                    sideEffectFlow.value = LogInSideEffect.ShowToast(message)
                }
        }
    }

    private fun logInWithGoogle() {
        uiStateFlow.value = uiStateFlow.value.copy(isLoading = true)

        viewModelScope.launch {
            val result = logInWithGoogleUseCase()
            uiStateFlow.value = uiStateFlow.value.copy(isLoading = false)

            result
                .onSuccess {
                    setFirstSetup()
                    sideEffectFlow.value = LogInSideEffect.Success
                }
                .onFailure {
                    sideEffectFlow.value = LogInSideEffect.ShowToast("Google sign-in failed")
                }
        }
    }

    fun clearSideEffect() {
        sideEffectFlow.value = LogInSideEffect.Empty
    }
}