package com.example.practice.ui.screens.forgotpassword.intents

sealed class ForgottenPasswordAction {
    data class EmailChanged(val value: String) : ForgottenPasswordAction()
    data object SendClicked : ForgottenPasswordAction()
    data object BackClicked : ForgottenPasswordAction()
}