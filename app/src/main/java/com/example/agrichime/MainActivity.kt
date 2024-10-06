package com.example.agrichime

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LogInScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.loginMain)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //val errorMessage = "Invalid username or password"
        val forgotPassword = findViewById<TextView>(R.id.forgotPassword)
        forgotPassword.setOnClickListener { TODO ("connect to forgot password page") }

        val signUpLink = findViewById<TextView>(R.id.signUpLink)
        signUpLink.setOnClickListener { TODO("connect to sign up page") }

        //login button, username, and password
        val loginButton = findViewById<Button>(R.id.loginButton)
        loginButton.setOnClickListener {
            val enteredUsername = findViewById<EditText>(R.id.loginEmail).text.toString()
            val enteredPassword = findViewById<EditText>(R.id.loginPassword).text.toString()
            val usernameTemporary = "agrichimetheboys"
            val passwordTemporary = "sagulaymaybuhay"

            if (enteredUsername == usernameTemporary && enteredPassword == passwordTemporary) {

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            else {
                //display error message
                val errorMessage = findViewById<TextView>(R.id.errorMessage)
                errorMessage.visibility = View.VISIBLE
            }
        }

}
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val socialMediaButton = findViewById<Button>(R.id.button2)

        socialMediaButton.setOnClickListener {
            val intent = Intent(this, SocialMediaScreen::class.java)
            startActivity(intent)
        }
    }
}
