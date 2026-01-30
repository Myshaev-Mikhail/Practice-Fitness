package com.example.practice.ui.screens.passwordsetting

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.domain.usecase.ChangePasswordUseCase
import com.example.practice.ui.screens.passwordsetting.actions.PasswordSettingAction
import com.example.practice.ui.screens.passwordsetting.actions.PasswordSettingSideEffect
import com.example.practice.ui.screens.passwordsetting.actions.PasswordSettingState
import com.example.practice.ui.utils.isInternetAvailable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PasswordSettingViewModel(
    private val changePasswordUseCase: ChangePasswordUseCase
): ViewModel() {
    private val uiStateFlow = MutableStateFlow(PasswordSettingState())
    val uiStateEmitter = uiStateFlow.asStateFlow()

    private val sideEffectFlow = MutableStateFlow<PasswordSettingSideEffect>(PasswordSettingSideEffect.Empty)
    val sideEffectEmitter = sideEffectFlow.asStateFlow()

    fun handleUiAction(action: PasswordSettingAction, context: Context? = null) {
        when (action) {
            is PasswordSettingAction.NavigateBack -> {
                sideEffectFlow.value = PasswordSettingSideEffect.ShowNavigateBack
            }

            is PasswordSettingAction.CurrentPasswordChanged -> {
                uiStateFlow.value = uiStateFlow.value.copy(currentPassword = action.value)
            }

            is PasswordSettingAction.ForgotPasswordClicked -> {
                sideEffectFlow.value = PasswordSettingSideEffect.ShowForgottenPasswordScreen
            }

            is PasswordSettingAction.NewPasswordChanged -> {
                uiStateFlow.value = uiStateFlow.value.copy(newPassword = action.value)
            }

            is PasswordSettingAction.ConfirmNewPasswordChanged -> {
                uiStateFlow.value = uiStateFlow.value.copy(confirmNewPassword = action.value)
            }

            is PasswordSettingAction.ChangePasswordClicked -> {
                if (context != null && !isInternetAvailable(context)) {
                    sideEffectFlow.value = PasswordSettingSideEffect.ShowToast("There is no internet connection")
                    return
                }

                val state = uiStateFlow.value
                if (state.newPassword != state.confirmNewPassword) {
                    sideEffectFlow.value = PasswordSettingSideEffect.ShowToast("The passwords don't match")
                    return
                }

                viewModelScope.launch {
                    val result = changePasswordUseCase(state.currentPassword, state.newPassword)
                    sideEffectFlow.value = if (result.isSuccess) {
                        PasswordSettingSideEffect.ShowToast("Password changed successfully")
                    } else {
                        PasswordSettingSideEffect.ShowToast(result.exceptionOrNull()?.localizedMessage ?: "Error")
                    }
                }
            }
        }
    }

    fun clearSideEffect() {
        sideEffectFlow.value = PasswordSettingSideEffect.Empty
    }
}