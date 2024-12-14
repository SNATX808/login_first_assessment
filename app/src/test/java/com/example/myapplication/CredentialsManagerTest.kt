package com.example.myapplication

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class CredentialsManagerTest {

    private val credentialsManager = CredentialsManager()

    @Test
    fun testEmptyEmail() {
        assertFalse(credentialsManager.isValidEmail(""))
    }

    @Test
    fun testWrongFormatEmail() {
        assertFalse(credentialsManager.isValidEmail("invalid-email"))
        assertFalse(credentialsManager.isValidEmail("missing@domain"))
        assertFalse(credentialsManager.isValidEmail("missing.domain@"))
    }

    @Test
    fun testWellFormattedEmail() {
        assertTrue(credentialsManager.isValidEmail("user@example.com"))
        assertTrue(credentialsManager.isValidEmail("name.surname@example.co.uk"))
    }

    @Test
    fun testEmptyPassword() {
        assertFalse(credentialsManager.isValidPassword(""))
    }

    @Test
    fun testFilledPassword() {
        assertTrue(credentialsManager.isValidPassword("securePassword123"))
    }
}