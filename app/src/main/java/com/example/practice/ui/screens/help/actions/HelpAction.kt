package com.example.practice.ui.screens.help.actions

sealed class HelpAction {
    data object NavigateBack : HelpAction()
    data object NavigateTelegram : HelpAction()
    data object NavigateEmail : HelpAction()
}