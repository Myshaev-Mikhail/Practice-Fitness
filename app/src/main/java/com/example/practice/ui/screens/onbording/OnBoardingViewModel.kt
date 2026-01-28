package com.example.practice.ui.screens.onbording

import androidx.lifecycle.ViewModel
import com.example.practice.ui.screens.onbording.actions.OnBoardingSideEffect
import com.example.practice.ui.screens.onbording.actions.OnBoardingState
import com.example.practice.ui.screens.onbording.actions.OnboardingAction
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OnboardingViewModel : ViewModel() {
    private val uiStateFlow = MutableStateFlow(OnBoardingState())
    val uiStateEmitter = uiStateFlow.asStateFlow()

    private val sideEffectFlow = MutableStateFlow<OnBoardingSideEffect>(OnBoardingSideEffect.Empty)
    val sideEffectEmitter = sideEffectFlow.asStateFlow()

    fun handleUiAction(action: OnboardingAction) {
        when (action) {
            OnboardingAction.NextPage -> nextPage()
            OnboardingAction.Skip -> skip()
            OnboardingAction.Finish -> finish()
        }
    }

    private fun nextPage() {
        val next = uiStateFlow.value.currentPage + 1

        if (next < uiStateFlow.value.totalPages) {
            uiStateFlow.update { it.copy(currentPage = next) }
            sideEffectFlow.value = OnBoardingSideEffect.ScrollToPage(next)
        }
    }

    private fun skip() {
        val lastPage = uiStateFlow.value.totalPages - 1
        uiStateFlow.update { it.copy(currentPage = lastPage) }
        sideEffectFlow.value = OnBoardingSideEffect.ScrollToPage(lastPage)
    }

    private fun finish() {
        sideEffectFlow.value = OnBoardingSideEffect.NavigateToLogin
    }

    fun updateCurrentPage(page: Int) {
        uiStateFlow.update { it.copy(currentPage = page) }
    }
}