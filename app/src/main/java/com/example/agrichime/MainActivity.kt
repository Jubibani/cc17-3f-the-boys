package com.example.agrichime

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import fragments.SignUpFragment

class LoginActivity : AppCompatActivity() {
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
        forgotPassword.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        val signUpLink = findViewById<TextView>(R.id.signUpLink)
        signUpLink.setOnClickListener {
            val intent = Intent(this, SignUpFragment::class.java)
            startActivity(intent)
        }

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
            } else {
                //display error message
                val errorMessage = findViewById<TextView>(R.id.errorMessage)
                errorMessage.visibility = View.VISIBLE
                // make TextView disappear after 2.5 secs.
                Handler(Looper.getMainLooper()).postDelayed({
                    errorMessage.visibility = View.GONE
                }, 2500)
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


        //val socialMediaButton = findViewById<Button>(R.id.button2)

        /*socialMediaButton.setOnClickListener {
            val intent = Intent(this, SocialMediaScreen::class.java)
            startActivity(intent)
        }*/
    }
}
