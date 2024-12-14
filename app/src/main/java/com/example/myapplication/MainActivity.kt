package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {

    private val credentialsManager = CredentialsManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val textView = findViewById<TextView>(R.id.registerNow)
        textView.setOnClickListener {
            // Create an intent to start SecondActivity
            val intent = Intent(this, RegisterActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }

        val emailInput: EditText = findViewById(R.id.email)
        val passwordInput: EditText = findViewById(R.id.password)
        val validateButton: Button = findViewById(R.id.nextButton)
        val resultTextView: TextView = findViewById(R.id.status)

        validateButton.setOnClickListener {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()
            val isEmailValid = credentialsManager.isValidEmail(email)
            val isPasswordValid = credentialsManager.isValidPassword(password)

            resultTextView.text = when {
                !isEmailValid -> "Invalid email format"
                !isPasswordValid -> "Password cannot be empty"
                else -> "Valid credentials"
            }
        }
    }
}

