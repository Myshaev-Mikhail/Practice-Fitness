package com.example.practice.ui.screens.help

import androidx.lifecycle.ViewModel
import com.example.practice.ui.screens.help.intents.HelpAction
import com.example.practice.ui.screens.help.intents.HelpSideEffect
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HelpViewModel: ViewModel() {
    private val sideEffect = MutableStateFlow<HelpSideEffect>(HelpSideEffect.Empty)
    val sideEffectEmitter = sideEffect.asStateFlow()

    fun uiAction(action: HelpAction) {
        when (action) {
            is HelpAction.NavigateBack -> {
                sideEffect.value = HelpSideEffect.ShowNavigateBack
            }

            is HelpAction.NavigateTelegram -> {
                sideEffect.value = HelpSideEffect.ShowNavigateTelegram
            }

            is HelpAction.NavigateEmail -> {
                sideEffect.value = HelpSideEffect.ShowNavigateEmail
            }
        }
    }

    fun clearSideEffect() {
        sideEffect.value = HelpSideEffect.Empty
    }
}