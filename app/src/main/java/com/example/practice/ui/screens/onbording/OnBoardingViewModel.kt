package com.example.practice.ui.screens.onbording

import androidx.lifecycle.ViewModel
import com.example.practice.ui.screens.onbording.intents.OnBoardingSideEffect
import com.example.practice.ui.screens.onbording.intents.OnBoardingState
import com.example.practice.ui.screens.onbording.intents.OnboardingAction
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OnboardingViewModel : ViewModel() {
    private val uiState = MutableStateFlow(OnBoardingState())
    val uiStateEmitter = uiState.asStateFlow()

    private val sideEffect =
        MutableStateFlow<OnBoardingSideEffect>(OnBoardingSideEffect.Empty)
    val sideEffectEmitter = sideEffect.asStateFlow()

    fun uiAction(action: OnboardingAction) {
        when (action) {
            OnboardingAction.NextPage -> nextPage()
            OnboardingAction.Skip -> skip()
            OnboardingAction.Finish -> finish()
        }
    }

    private fun nextPage() {
        val next = uiState.value.currentPage + 1

        if (next < uiState.value.totalPages) {
            uiState.update { it.copy(currentPage = next) }
            sideEffect.value = OnBoardingSideEffect.ScrollToPage(next)
        }
    }

    private fun skip() {
        val lastPage = uiState.value.totalPages - 1
        uiState.update { it.copy(currentPage = lastPage) }
        sideEffect.value = OnBoardingSideEffect.ScrollToPage(lastPage)
    }

    private fun finish() {
        sideEffect.value = OnBoardingSideEffect.NavigateToLogin
    }
}