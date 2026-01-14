package com.example.practice.ui.screens.login

import android.content.Context
import android.util.Log
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
import com.example.practice.domain.auth.GoogleSignInUseCase

class LogInViewModel : ViewModel() {
    private val uiState = MutableStateFlow(LogInState())
    val uiStateEmitter = uiState.asStateFlow()

    private val sideEffect = MutableStateFlow<LogInSideEffect>(LogInSideEffect.Empty)
    val sideEffectEmitter = sideEffect.asStateFlow()

    val authRepository = AuthRepository()
    private val googleSignInUseCase: GoogleSignInUseCase = GoogleSignInUseCase()

    fun uiAction(action: LogInAction, context: Context? = null) {
        when (action) {
            is LogInAction.EmailChanged -> {
                uiState.value = uiState.value.copy(email = action.value)
            }

            is LogInAction.PasswordChanged -> {
                uiState.value = uiState.value.copy(password = action.value)
            }

            is LogInAction.EmailLogInClicked -> {
                if (uiState.value.email.isEmpty()) {
                    sideEffect.value = LogInSideEffect.ShowToast("Email is required")
                } else if (uiState.value.password.isEmpty()) {
                    sideEffect.value = LogInSideEffect.ShowToast("Password is required")
                } else {
                    logInWithEmail()
                }
            }

            is LogInAction.GoogleLogInClicked -> {
                context?.let {
                    launchGoogleSignIn(it)
                }
            }

            is LogInAction.ForgotPasswordClicked -> {
                sideEffect.value = LogInSideEffect.ShowForgottenPasswordScreen
            }
        }
    }

    private fun logInWithEmail() {
        uiState.value = uiState.value.copy(isLoading = true)

        viewModelScope.launch {
            val result = authRepository.logIn(uiState.value.email, uiState.value.password)

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

    private fun launchGoogleSignIn(context: Context) {
        viewModelScope.launch {
            val result = googleSignInUseCase.execute(context)
            result.onSuccess { idToken ->
                logInWithGoogleToken(idToken)
            }.onFailure { error ->
                sideEffect.value = LogInSideEffect.ShowToast("Google sign-in failed")
                Log.e("LogInViewModel", "Google sign-in failed", error)
            }
        }
    }

    private fun logInWithGoogleToken(idToken: String) {
        uiState.value = uiState.value.copy(isLoading = true)
        viewModelScope.launch {
            val result = authRepository.logInWithGoogle(idToken)
            uiState.value = uiState.value.copy(isLoading = false)
            result.onSuccess {
                sideEffect.value = LogInSideEffect.Success
            }.onFailure { error ->
                sideEffect.value = LogInSideEffect.ShowToast("Google login failed")
            }
        }
    }

    fun clearSideEffect() {
        sideEffect.value = LogInSideEffect.Empty
    }
}