package com.example.myapplication

class CredentialsManager {
    fun isValidEmail(email: String?): Boolean {
        if (email.isNullOrEmpty()) return false
        val emailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()
        return emailRegex.matches(email)
    }

    fun isValidPassword(password: String?): Boolean {
        return !password.isNullOrEmpty()
    }
}