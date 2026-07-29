package com.example.practice.ui.screens.signup

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.domain.usecase.LogInWithGoogleUseCase
import com.example.practice.domain.usecase.SignUpUseCase
import com.example.practice.ui.screens.signup.actions.SignUpAction
import com.example.practice.ui.screens.signup.actions.SignUpSideEffect
import com.example.practice.ui.screens.signup.actions.SignUpState
import com.example.practice.ui.utils.isInternetAvailable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val signUpWithEmailUseCase: SignUpUseCase,
    private val logInWithGoogleUseCase: LogInWithGoogleUseCase,
) : ViewModel() {
    private val uiStateFlow = MutableStateFlow(SignUpState())
    val uiStateEmitter = uiStateFlow.asStateFlow()

    private val sideEffectFlow = MutableStateFlow<SignUpSideEffect>(SignUpSideEffect.Empty)
    val sideEffectEmitter = sideEffectFlow.asStateFlow()

    fun handleUiAction(action: SignUpAction, context: Context? = null) {
        when (action) {
            is SignUpAction.FullNameChanged -> {
                uiStateFlow.value = uiStateFlow.value.copy(fullName = action.value)
            }

            is SignUpAction.EmailChanged -> {
                uiStateFlow.value = uiStateFlow.value.copy(email = action.value)
            }

            is SignUpAction.PasswordChanged -> {
                uiStateFlow.value = uiStateFlow.value.copy(password = action.value)
            }

            is SignUpAction.ConfirmPasswordChanged -> {
                uiStateFlow.value = uiStateFlow.value.copy(confirmPassword = action.value)
            }

            is SignUpAction.EmailSignUpClicked -> {
                if (context != null && !isInternetAvailable(context)) {
                    sideEffectFlow.value = SignUpSideEffect.ShowToast("There is no internet connection")
                    return
                }

                if (uiStateFlow.value.fullName.isEmpty()) {
                    sideEffectFlow.value = SignUpSideEffect.ShowToast("Full name is required")
                } else if (uiStateFlow.value.email.isEmpty()) {
                    sideEffectFlow.value = SignUpSideEffect.ShowToast("Email is required")
                } else if (uiStateFlow.value.password.isEmpty()) {
                    sideEffectFlow.value = SignUpSideEffect.ShowToast("Password is required")
                } else if (uiStateFlow.value.confirmPassword.isEmpty()) {
                    sideEffectFlow.value = SignUpSideEffect.ShowToast("Please confirm your password")
                } else {
                    signUp()
                }
            }

            is SignUpAction.GoogleLogInClicked -> {
                if (context == null) {
                    sideEffectFlow.value = SignUpSideEffect.ShowToast("Google sign-in is unavailable")
                    return
                }

                if (!isInternetAvailable(context)) {
                    sideEffectFlow.value = SignUpSideEffect.ShowToast("There is no internet connection")
                    return
                }

                logInWithGoogle(context)
            }
        }
    }

    private fun signUp() {
        val state = uiStateFlow.value
        if (state.password != state.confirmPassword) {
            sideEffectFlow.value = SignUpSideEffect.ShowToast("Passwords do not match")
            return
        }

        uiStateFlow.value = state.copy(isLoading = true)

        viewModelScope.launch {
            val result = signUpWithEmailUseCase(
                email = state.email,
                password = state.password,
                fullName = state.fullName
            )

            uiStateFlow.value = uiStateFlow.value.copy(isLoading = false)

            result
                .onSuccess {
                    sideEffectFlow.value = SignUpSideEffect.Success
                }
                .onFailure {
                    sideEffectFlow.value =
                        SignUpSideEffect.ShowToast(it.message ?: "Unknown error")
                }
        }
    }

    private fun logInWithGoogle(context: Context) {
        uiStateFlow.value = uiStateFlow.value.copy(isLoading = true)

        viewModelScope.launch {
            val result = logInWithGoogleUseCase(context)
            uiStateFlow.value = uiStateFlow.value.copy(isLoading = false)

            result
                .onSuccess {
                    sideEffectFlow.value = SignUpSideEffect.Success
                }
                .onFailure {
                    sideEffectFlow.value = SignUpSideEffect.ShowToast("Google sign-in failed")
                }
        }
    }

    fun normalizeText(input: String): String {
        return input
            .trim()
            .replace(Regex("\\s+"), " ")
    }

    fun clearSideEffect() {
        sideEffectFlow.value = SignUpSideEffect.Empty
    }
}
