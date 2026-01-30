package com.example.practice.ui.screens.forgotpassword

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.domain.usecase.ResetPasswordUseCase
import com.example.practice.ui.screens.forgotpassword.actions.ForgottenPasswordAction
import com.example.practice.ui.screens.forgotpassword.actions.ForgottenPasswordSideEffect
import com.example.practice.ui.screens.forgotpassword.actions.ForgottenPasswordState
import com.example.practice.ui.utils.isInternetAvailable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ForgottenPasswordViewModel(
    private val resetPasswordUseCase: ResetPasswordUseCase
) : ViewModel() {
    private val uiStateFlow = MutableStateFlow(ForgottenPasswordState())
    val uiStateEmitter = uiStateFlow.asStateFlow()

    private val sideEffectFlow = MutableStateFlow<ForgottenPasswordSideEffect>(ForgottenPasswordSideEffect.Empty)
    val sideEffectEmitter = sideEffectFlow.asStateFlow()

    fun handleUiAction(action: ForgottenPasswordAction, context: Context? = null) {
        when (action) {
            is ForgottenPasswordAction.EmailChanged -> {
                uiStateFlow.value = uiStateFlow.value.copy(email = action.value)
            }

            is ForgottenPasswordAction.SendClicked -> {
                if (context != null && !isInternetAvailable(context)) {
                    sideEffectFlow.value = ForgottenPasswordSideEffect.ShowToast("There is no internet connection")
                    return
                }

                sendResetEmail()
            }

            is ForgottenPasswordAction.BackClicked -> {
                sideEffectFlow.value = ForgottenPasswordSideEffect.NavigateBack
            }

        }
    }

    private fun sendResetEmail() {
        if (uiStateFlow.value.email.isBlank()) {
            sideEffectFlow.value =
                ForgottenPasswordSideEffect.ShowToast("Введите email")
            return
        }
        uiStateFlow.value = uiStateFlow.value.copy(isLoading = true)

        viewModelScope.launch {
            val result = resetPasswordUseCase(uiStateFlow.value.email)
            uiStateFlow.value = uiStateFlow.value.copy(isLoading = false)

            result
                .onSuccess {
                    sideEffectFlow.value =
                        ForgottenPasswordSideEffect.ShowToast(
                            "Письмо отправлено. Проверьте почту"
                        )
                    sideEffectFlow.value = ForgottenPasswordSideEffect.Success
                }
                .onFailure {
                    sideEffectFlow.value =
                        ForgottenPasswordSideEffect.ShowToast(
                            "Ошибка отправки письма"
                        )
                }
        }
    }

    fun clearSideEffect() {
        sideEffectFlow.value = ForgottenPasswordSideEffect.Empty
    }
}