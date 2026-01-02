package com.example.practice.ui.screens.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.data.auth.AuthRepository
import com.example.practice.ui.screens.signin.intents.SignUpAction
import com.example.practice.ui.screens.signin.intents.SignUpSideEffect
import com.example.practice.ui.screens.signin.intents.SignUpState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignUpViewModel: ViewModel() {
    private val uiState = MutableStateFlow(SignUpState())
    val uiStateEmitter = uiState.asStateFlow()

    private val sideEffect =
        MutableStateFlow<SignUpSideEffect>(SignUpSideEffect.Empty)
    val sideEffectEmitter = sideEffect.asStateFlow()

    private val authRepository = AuthRepository()


    fun uiAction(action: SignUpAction) {
        when (action) {
            is SignUpAction.EmailChanged ->
                uiState.value = uiState.value.copy(email = action.value)

            is SignUpAction.PasswordChanged ->
                uiState.value = uiState.value.copy(password = action.value)

            is SignUpAction.ConfirmPasswordChanged ->
                uiState.value = uiState.value.copy(confirmPassword = action.value)

            SignUpAction.SignUpClicked -> signUp()
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
            val result = authRepository.signUp(state.email, state.password)

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
}