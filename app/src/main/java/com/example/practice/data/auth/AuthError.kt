package com.example.practice.data.auth

sealed class AuthError: Throwable() {
    data object InvalidEmailOrPassword : AuthError()
    data class Unknown(val errorMessage: String) : AuthError()
}