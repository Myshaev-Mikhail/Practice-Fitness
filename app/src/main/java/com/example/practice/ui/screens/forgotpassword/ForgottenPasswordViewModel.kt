package com.example.practice.ui.screens.forgotpassword

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.data.auth.AuthRepository
import com.example.practice.ui.screens.forgotpassword.intents.ForgottenPasswordAction
import com.example.practice.ui.screens.forgotpassword.intents.ForgottenPasswordSideEffect
import com.example.practice.ui.screens.forgotpassword.intents.ForgottenPasswordState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ForgottenPasswordViewModel : ViewModel() {
    private val uiState = MutableStateFlow(ForgottenPasswordState())
    val uiStateEmitter = uiState.asStateFlow()

    private val sideEffect = MutableStateFlow<ForgottenPasswordSideEffect>(ForgottenPasswordSideEffect.Empty)
    val sideEffectEmitter = sideEffect.asStateFlow()

    val authRepository = AuthRepository()

    fun uiAction(action: ForgottenPasswordAction, context: Context? = null) {
        when (action) {
            is ForgottenPasswordAction.EmailChanged -> {
                uiState.value = uiState.value.copy(email = action.value)
            }

            is ForgottenPasswordAction.SendClicked -> {
                sendResetEmail()
            }

            is ForgottenPasswordAction.BackClicked -> {
                sideEffect.value = ForgottenPasswordSideEffect.NavigateBack
            }

        }
    }

    private fun sendResetEmail() {
        if (uiState.value.email.isBlank()) {
            sideEffect.value =
                ForgottenPasswordSideEffect.ShowToast("Введите email")
            return
        }
        uiState.value = uiState.value.copy(isLoading = true)

        viewModelScope.launch {
            val result = authRepository.resetPassword(uiState.value.email)
            uiState.value = uiState.value.copy(isLoading = false)

            result
                .onSuccess {
                    sideEffect.value =
                        ForgottenPasswordSideEffect.ShowToast(
                            "Письмо отправлено. Проверьте почту"
                        )
                    sideEffect.value = ForgottenPasswordSideEffect.Success
                }
                .onFailure {
                    sideEffect.value =
                        ForgottenPasswordSideEffect.ShowToast(
                            "Ошибка отправки письма"
                        )
                }
        }
    }

    fun clearSideEffect() {
        sideEffect.value = ForgottenPasswordSideEffect.Empty
    }
}