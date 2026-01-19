package com.example.practice.ui.screens.passwordsetting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.data.auth.AuthRepository
import com.example.practice.ui.screens.passwordsetting.intents.PasswordSettingAction
import com.example.practice.ui.screens.passwordsetting.intents.PasswordSettingSideEffect
import com.example.practice.ui.screens.passwordsetting.intents.PasswordSettingState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PasswordSettingViewModel: ViewModel() {
    private val uiState = MutableStateFlow(PasswordSettingState())
    val uiStateEmitter = uiState.asStateFlow()

    private val sideEffect = MutableStateFlow<PasswordSettingSideEffect>(PasswordSettingSideEffect.Empty)
    val sideEffectEmitter = sideEffect.asStateFlow()

    private val authRepository = AuthRepository()

    fun uiAction(action: PasswordSettingAction) {
        when (action) {
            is PasswordSettingAction.NavigateBack -> {
                sideEffect.value = PasswordSettingSideEffect.ShowNavigateBack
            }

            is PasswordSettingAction.CurrentPasswordChanged -> {
                uiState.value = uiState.value.copy(currentPassword = action.value)
            }

            is PasswordSettingAction.ForgotPasswordClicked -> {
                sideEffect.value = PasswordSettingSideEffect.ShowForgottenPasswordScreen
            }

            is PasswordSettingAction.NewPasswordChanged -> {
                uiState.value = uiState.value.copy(newPassword = action.value)
            }

            is PasswordSettingAction.ConfirmNewPasswordChanged -> {
                uiState.value = uiState.value.copy(confirmNewPassword = action.value)
            }

            is PasswordSettingAction.ChangePasswordClicked -> {
                val state = uiState.value
                if (state.newPassword != state.confirmNewPassword) {
                    sideEffect.value = PasswordSettingSideEffect.ShowToast("The passwords don't match")
                    return
                }

                viewModelScope.launch {
                    val result = authRepository.changePassword(state.currentPassword, state.newPassword)
                    sideEffect.value = if (result.isSuccess) {
                        PasswordSettingSideEffect.ShowToast("Password changed successfully")
                    } else {
                        PasswordSettingSideEffect.ShowToast(result.exceptionOrNull()?.localizedMessage ?: "Error")
                    }
                }
            }
        }
    }

    fun clearSideEffect() {
        sideEffect.value = PasswordSettingSideEffect.Empty
    }
}