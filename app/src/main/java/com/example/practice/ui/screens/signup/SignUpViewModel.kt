package com.example.practice.ui.screens.signup

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.data.auth.AuthRepository
import com.example.practice.domain.auth.GoogleSignInUseCase
import com.example.practice.ui.screens.signup.intents.SignUpAction
import com.example.practice.ui.screens.signup.intents.SignUpSideEffect
import com.example.practice.ui.screens.signup.intents.SignUpState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel() {
    private val uiState = MutableStateFlow(SignUpState())
    val uiStateEmitter = uiState.asStateFlow()

    private val sideEffect = MutableStateFlow<SignUpSideEffect>(SignUpSideEffect.Empty)
    val sideEffectEmitter = sideEffect.asStateFlow()

    private val authRepository = AuthRepository()
    private val googleSignInUseCase: GoogleSignInUseCase = GoogleSignInUseCase()

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
                signUp()
            }

            is SignUpAction.GoogleLogInClicked -> {
                context?.let {
                    launchGoogleSignIn(it)
                }
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
            val result = authRepository.signUp(
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

    private fun launchGoogleSignIn(context: Context) {
        viewModelScope.launch {
            val result = googleSignInUseCase.execute(context)
            result.onSuccess { idToken ->
                logInWithGoogleToken(idToken)
            }.onFailure { error ->
                sideEffect.value = SignUpSideEffect.ShowToast("Google sign-in failed")
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
                sideEffect.value = SignUpSideEffect.Success
            }.onFailure { error ->
                sideEffect.value = SignUpSideEffect.ShowToast("Google login failed")
            }
        }
    }
}