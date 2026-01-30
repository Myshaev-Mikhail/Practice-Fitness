package com.example.practice.ui.screens.privacypolicy

import androidx.lifecycle.ViewModel
import com.example.practice.ui.screens.privacypolicy.actions.PrivacyPolicyAction
import com.example.practice.ui.screens.privacypolicy.actions.PrivacyPolicySideEffect
import com.example.practice.ui.screens.privacypolicy.actions.PrivacyPolicyState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class PrivacyPolicyViewModel: ViewModel() {
    private val uiStateFlow = MutableStateFlow(PrivacyPolicyState())
    val uiStateEmitter = uiStateFlow.asStateFlow()

    private val sideEffectFlow = MutableStateFlow<PrivacyPolicySideEffect>(PrivacyPolicySideEffect.Empty)
    val sideEffectEmitter = sideEffectFlow.asStateFlow()

    fun handleUiAction(action: PrivacyPolicyAction) {
        when (action) {
            is PrivacyPolicyAction.NavigateBack -> {
                sideEffectFlow.value = PrivacyPolicySideEffect.NavigateBack
            }
        }
    }

    fun clearSideEffect() {
        sideEffectFlow.value = PrivacyPolicySideEffect.Empty
    }
}