package com.example.practice.ui.screens.onbording.intents

sealed class OnBoardingSideEffect {
    data class ScrollToPage(val page: Int) : OnBoardingSideEffect()
    data object NavigateToLogin : OnBoardingSideEffect()
    data object Empty : OnBoardingSideEffect()
}