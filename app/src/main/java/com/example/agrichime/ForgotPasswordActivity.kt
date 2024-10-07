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
import kotlinx.coroutines.delay

class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.forgot_password_screen)

        //reset password button

        val resetPWButton = findViewById<Button>(R.id.forgotPasswordButton)
        resetPWButton.setOnClickListener {

            val enteredEmail = findViewById<EditText>(R.id.forgotPWemailAddress).text.toString()
            val tempForgotPWemail = "agrichimetheboys@gmail.com"


            if (enteredEmail == tempForgotPWemail) {
                val resetSuccessPrompt = findViewById<TextView>(R.id.resetSuccessPrompt)
                resetSuccessPrompt.visibility = View.VISIBLE

                //hide resetSuccessPrompt after 2.5 secs
                Handler(Looper.getMainLooper()).postDelayed({
                    resetSuccessPrompt.visibility = View.GONE
                }, 2500)

                // go back to login screen if successfull
                Handler(Looper.getMainLooper()).postDelayed({
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }, 2000)

            }
            else {
                val resetFailPrompt = findViewById<TextView>(R.id.resetFailPrompt)
                resetFailPrompt.visibility = View.VISIBLE

                //hide resetFailPrompt after 2.5 secs
                Handler(Looper.getMainLooper()).postDelayed({
                    resetFailPrompt.visibility = View.GONE
                }, 2500)
            }
        }
    }
        }



