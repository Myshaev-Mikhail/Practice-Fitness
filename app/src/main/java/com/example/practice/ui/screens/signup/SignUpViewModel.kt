package com.example.practice.ui.screens.signup

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.domain.usecase.LogInWithGoogleUseCase
import com.example.practice.domain.usecase.SignUpUseCase
import com.example.practice.ui.screens.signup.intents.SignUpAction
import com.example.practice.ui.screens.signup.intents.SignUpSideEffect
import com.example.practice.ui.screens.signup.intents.SignUpState
import com.example.practice.ui.utils.isInternetAvailable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val signUpWithEmailUseCase: SignUpUseCase,
    private val logInWithGoogleUseCase: LogInWithGoogleUseCase,
) : ViewModel() {
    private val uiState = MutableStateFlow(SignUpState())
    val uiStateEmitter = uiState.asStateFlow()

    private val sideEffect = MutableStateFlow<SignUpSideEffect>(SignUpSideEffect.Empty)
    val sideEffectEmitter = sideEffect.asStateFlow()

    fun uiAction(action: SignUpAction, context: Context? = null) {
        when (action) {
            is SignUpAction.FullNameChanged -> {
                uiState.value = uiState.value.copy(fullName = action.value)
            }

            is SignUpAction.EmailChanged -> {
                uiState.value = uiState.value.copy(email = action.value)
            }

            is SignUpAction.PasswordChanged -> {
                uiState.value = uiState.value.copy(password = action.value)
            }

            is SignUpAction.ConfirmPasswordChanged -> {
                uiState.value = uiState.value.copy(confirmPassword = action.value)
            }

            is SignUpAction.EmailSignUpClicked -> {
                if (context != null && !isInternetAvailable(context)) {
                    sideEffect.value = SignUpSideEffect.ShowToast("There is no internet connection")
                    return
                }

                if (uiState.value.fullName.isEmpty()) {
                    sideEffect.value = SignUpSideEffect.ShowToast("Full name is required")
                } else if (uiState.value.email.isEmpty()) {
                    sideEffect.value = SignUpSideEffect.ShowToast("Email is required")
                } else if (uiState.value.password.isEmpty()) {
                    sideEffect.value = SignUpSideEffect.ShowToast("Password is required")
                } else if (uiState.value.confirmPassword.isEmpty()) {
                    sideEffect.value = SignUpSideEffect.ShowToast("Please confirm your password")
                } else {
                    signUp()
                }
            }

            is SignUpAction.GoogleLogInClicked -> {
                if (context != null && !isInternetAvailable(context)) {
                    sideEffect.value = SignUpSideEffect.ShowToast("There is no internet connection")
                    return
                }

                logInWithGoogle()
            }
        }
    }

    private fun signUp() {
        val state = uiState.value
        if (state.password != state.confirmPassword) {
            sideEffect.value = SignUpSideEffect.ShowToast("Passwords do not match")
            return
        }

        uiState.value = state.copy(isLoading = true)

        viewModelScope.launch {
            val result = signUpWithEmailUseCase(
                email = state.email,
                password = state.password,
                fullName = state.fullName
            )

            uiState.value = uiState.value.copy(isLoading = false)

            result
                .onSuccess {
                    sideEffect.value = SignUpSideEffect.Success
                }
                .onFailure {
                    sideEffect.value =
                        SignUpSideEffect.ShowToast(it.message ?: "Unknown error")
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
                    sideEffect.value = SignUpSideEffect.Success
                }
                .onFailure {
                    sideEffect.value = SignUpSideEffect.ShowToast("Google sign-in failed")
                }
        }
    }

    fun normalizeText(input: String): String {
        return input
            .trim()
            .replace(Regex("\\s+"), " ")
    }

    fun clearSideEffect() {
        sideEffect.value = SignUpSideEffect.Empty
    }
}