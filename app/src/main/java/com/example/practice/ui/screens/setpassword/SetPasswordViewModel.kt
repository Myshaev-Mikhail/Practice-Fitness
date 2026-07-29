package com.example.practice.ui.screens.setpassword

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.data.repository.AuthRepositoryImpl
import com.example.practice.ui.screens.setpassword.actions.SetPasswordAction
import com.example.practice.ui.screens.setpassword.actions.SetPasswordSideEffect
import com.example.practice.ui.screens.setpassword.actions.SetPasswordState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SetPasswordViewModel(
    private val oobCode: String,
    private val authRepository: AuthRepositoryImpl
) : ViewModel() {
    private val uiStateFlow = MutableStateFlow(SetPasswordState())
    val uiStateEmitter = uiStateFlow.asStateFlow()

    private val sideEffectFlow = MutableStateFlow<SetPasswordSideEffect>(SetPasswordSideEffect.Empty)
    val sideEffectEmitter = sideEffectFlow.asStateFlow()

    fun handleUiAction(action: SetPasswordAction) {
        when (action) {
            is SetPasswordAction.PasswordChanged -> {
                uiStateFlow.value = uiStateFlow.value.copy(password = action.value)
            }

            is SetPasswordAction.ConfirmPasswordChanged -> {
                uiStateFlow.value = uiStateFlow.value.copy(confirmPassword = action.value)
            }

            is SetPasswordAction.SubmitClicked -> {
                submit()
            }

            is SetPasswordAction.BackClicked -> {
                sideEffectFlow.value = SetPasswordSideEffect.NavigateBack
            }
        }
    }

    private fun submit() {
        val state = uiStateFlow.value

        if (state.password.length < 6) {
            sideEffectFlow.value =
                SetPasswordSideEffect.ShowToast("Пароль минимум 6 символов")
            return
        }

        if (state.password != state.confirmPassword) {
            sideEffectFlow.value =
                SetPasswordSideEffect.ShowToast("Пароли не совпадают")
            return
        }

        uiStateFlow.value = state.copy(isLoading = true)

        viewModelScope.launch {
            val result =
                authRepository.confirmResetPassword(oobCode, state.password)

            uiStateFlow.value = state.copy(isLoading = false)

            result
                .onSuccess {
                    sideEffectFlow.value =
                        SetPasswordSideEffect.ShowToast("Пароль успешно изменён")
                    sideEffectFlow.value = SetPasswordSideEffect.Success
                }
                .onFailure {
                    sideEffectFlow.value =
                        SetPasswordSideEffect.ShowToast("Ошибка смены пароля")
                }
        }
    }

    fun clearSideEffect() {
        sideEffectFlow.value = SetPasswordSideEffect.Empty
    }
}