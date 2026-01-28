package com.example.practice.ui.screens.help.actions

sealed class HelpSideEffect {
    data object ShowNavigateBack : HelpSideEffect()
    data object ShowNavigateTelegram : HelpSideEffect()
    data object ShowNavigateEmail : HelpSideEffect()
    data object Empty : HelpSideEffect()
}