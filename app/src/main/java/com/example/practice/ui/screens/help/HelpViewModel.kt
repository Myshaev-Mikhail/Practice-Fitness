package com.example.practice.ui.screens.help

import androidx.lifecycle.ViewModel
import com.example.practice.ui.screens.help.actions.HelpAction
import com.example.practice.ui.screens.help.actions.HelpSideEffect
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HelpViewModel: ViewModel() {
    private val sideEffectFlow = MutableStateFlow<HelpSideEffect>(HelpSideEffect.Empty)
    val sideEffectEmitter = sideEffectFlow.asStateFlow()

    fun handleUiAction(action: HelpAction) {
        when (action) {
            is HelpAction.NavigateBack -> {
                sideEffectFlow.value = HelpSideEffect.ShowNavigateBack
            }

            is HelpAction.NavigateTelegram -> {
                sideEffectFlow.value = HelpSideEffect.ShowNavigateTelegram
            }

            is HelpAction.NavigateEmail -> {
                sideEffectFlow.value = HelpSideEffect.ShowNavigateEmail
            }
        }
    }

    fun clearSideEffect() {
        sideEffectFlow.value = HelpSideEffect.Empty
    }
}