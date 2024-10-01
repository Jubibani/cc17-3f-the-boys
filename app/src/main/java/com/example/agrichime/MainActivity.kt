package com.example.agrichime

import android.content.Intent
import android.os.Bundle
import android.widget.Button
<<<<<<< HEAD
import android.widget.EditText
=======
import android.widget.RelativeLayout
>>>>>>> 9915dd0f7a874541d3cdf9f4d7a674161ef36946
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

<<<<<<< HEAD
class LogInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.loginMain)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val usernameTemporary = "agrichimetheboys"
        val passwordTemporary = "sagulaymaybuhay"
        val forgotPassword = findViewById<TextView>(R.id.forgotPassword)
        forgotPassword.setOnClickListener {TODO ("connect to forgot password page") }
        val signUpLink = findViewById<TextView>(R.id.signUpLink)
        signUpLink.setOnClickListener { TODO("connect to sign up page") }
        val loginButton = findViewById<Button>(R.id.loginButton)
        loginButton.setOnClickListener {
            val enteredUsername = findViewById<EditText>(R.id.loginEmail).text.toString()
            val enteredPassword = findViewById<EditText>(R.id.loginPassword).text.toString()

            if (enteredUsername == usernameTemporary && enteredPassword == passwordTemporary) {

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

}
}
=======
>>>>>>> 9915dd0f7a874541d3cdf9f4d7a674161ef36946

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
