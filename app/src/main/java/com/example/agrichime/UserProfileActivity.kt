package com.example.agrichime

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class UserProfileActivity : AppCompatActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       enableEdgeToEdge()
       setContentView(R.layout.user_profile_screen)

       val toShopButton = findViewById<Button>(R.id.toShopping)
       toShopButton.setOnClickListener {
           val intent = Intent(this, ShoppingScreen::class.java)
           startActivity(intent)

       }

       val editProfileButton = findViewById<Button>(R.id.profileEdit)
       editProfileButton.setOnClickListener {
           val intent = Intent(this, EditProfileActivity::class.java)
           startActivity(intent)
       }
   }
}
