package com.example.myapplication

import org.junit.Assert.assertEquals
import org.junit.Test

class CredentialsManagerTest {

    // Test empty email
    @Test
    fun givenEmptyPassword_thenReturnFalse() {
        val credentialsManager = CredentialsManager()

        val isEmailValid = credentialsManager.isEmailValid("")

        assertEquals(false, isEmailValid)
    }

//     Test wrong email format
//     Test proper email
//
//     Test empty password
//     Test filled password
}