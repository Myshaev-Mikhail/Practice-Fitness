package com.example.practice.ui.screens.onbording.actions

sealed class OnBoardingSideEffect {
    data class ScrollToPage(val page: Int) : OnBoardingSideEffect()
    data object NavigateToLogin : OnBoardingSideEffect()
    data object Empty : OnBoardingSideEffect()
}