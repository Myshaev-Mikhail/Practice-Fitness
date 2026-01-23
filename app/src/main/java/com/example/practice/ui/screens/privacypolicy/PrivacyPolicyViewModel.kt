package com.example.practice.ui.screens.privacypolicy

import androidx.lifecycle.ViewModel
import com.example.practice.ui.screens.privacypolicy.intents.PrivacyPolicyAction
import com.example.practice.ui.screens.privacypolicy.intents.PrivacyPolicySideEffect
import com.example.practice.ui.screens.privacypolicy.intents.PrivacyPolicyState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class PrivacyPolicyViewModel: ViewModel() {
    private val uiState = MutableStateFlow(PrivacyPolicyState())
    val uiStateEmitter = uiState.asStateFlow()

    private val sideEffect = MutableStateFlow<PrivacyPolicySideEffect>(PrivacyPolicySideEffect.Empty)
    val sideEffectEmitter = sideEffect.asStateFlow()

    fun uiAction(action: PrivacyPolicyAction) {
        when (action) {
            is PrivacyPolicyAction.NavigateBack -> {
                sideEffect.value = PrivacyPolicySideEffect.NavigateBack
            }
        }
    }

    fun clearSideEffect() {
        sideEffect.value = PrivacyPolicySideEffect.Empty
    }
}