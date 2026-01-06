package com.example.practice.ui.screens.setpassword

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.data.auth.AuthRepository
import com.example.practice.ui.screens.setpassword.intents.SetPasswordAction
import com.example.practice.ui.screens.setpassword.intents.SetPasswordSideEffect
import com.example.practice.ui.screens.setpassword.intents.SetPasswordState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SetPasswordViewModel(private val oobCode: String) : ViewModel() {
    private val uiState = MutableStateFlow(SetPasswordState())
    val uiStateEmitter = uiState.asStateFlow()

    private val sideEffect = MutableStateFlow<SetPasswordSideEffect>(SetPasswordSideEffect.Empty)
    val sideEffectEmitter = sideEffect.asStateFlow()

    private val authRepository = AuthRepository()

    fun uiAction(action: SetPasswordAction) {
        when (action) {
            is SetPasswordAction.PasswordChanged -> {
                uiState.value = uiState.value.copy(password = action.value)
            }

            is SetPasswordAction.ConfirmPasswordChanged -> {
                uiState.value = uiState.value.copy(confirmPassword = action.value)
            }

            is SetPasswordAction.SubmitClicked -> {
                submit()
            }

            is SetPasswordAction.BackClicked -> {
                sideEffect.value = SetPasswordSideEffect.NavigateBack
            }
        }
    }

    private fun submit() {
        val state = uiState.value

        if (state.password.length < 6) {
            sideEffect.value =
                SetPasswordSideEffect.ShowToast("Пароль минимум 6 символов")
            return
        }

        if (state.password != state.confirmPassword) {
            sideEffect.value =
                SetPasswordSideEffect.ShowToast("Пароли не совпадают")
            return
        }

        uiState.value = state.copy(isLoading = true)

        viewModelScope.launch {
            val result =
                authRepository.confirmResetPassword(oobCode, state.password)

            uiState.value = state.copy(isLoading = false)

            result
                .onSuccess {
                    sideEffect.value =
                        SetPasswordSideEffect.ShowToast("Пароль успешно изменён")
                    sideEffect.value = SetPasswordSideEffect.Success
                }
                .onFailure {
                    sideEffect.value =
                        SetPasswordSideEffect.ShowToast("Ошибка смены пароля")
                }
        }
    }

    fun clearSideEffect() {
        sideEffect.value = SetPasswordSideEffect.Empty
    }
}