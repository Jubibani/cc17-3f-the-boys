package com.example.agrichime

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import fragments.HomeFragment
import fragments.MessageFragment
import fragments.NotificationFragment
import fragments.ShoppingCartFragment
import fragments.SocialMediaFragment

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNav: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Ensure this is properly defined elsewhere
        setContentView(R.layout.activity_main)

        // Ensure the window insets are handled properly
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Load the initial fragment (HomeFragment)
        loadFragment(HomeFragment())

        // Initialize the BottomNavigationView
        bottomNav = findViewById(R.id.bottomNav)

        // Set up item selection listener for the bottom navigation bar
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.shopping_cart -> {
                    loadFragment(ShoppingCartFragment())
                    true
                }
                R.id.message -> {
                    loadFragment(MessageFragment())
                    true
                }
                R.id.notification -> {
                    loadFragment(NotificationFragment())
                    true
                }
                else -> false
            }
        }

        val socialMediaButton: ImageButton = findViewById(R.id.social_media)
        val dashboardScreenButton: ImageButton = findViewById(R.id.dashboard) // Correct the ID here

        socialMediaButton.setOnClickListener { view ->
            when (view.id) {
                R.id.social_media -> {
                    loadFragment(SocialMediaFragment())

                    // Change visibility of the Bottom Navigation View
                    // Hide the Bottom Navigation View with animation
                    bottomNav.animate()
                        .translationY(bottomNav.height.toFloat())
                        .alpha(0f)
                        .setDuration(300) // Duration of the hide animation
                        .withEndAction {
                            bottomNav.visibility = View.GONE // Make it gone after the animation
                        }


                    // Create the color animation from the current color to green
                    val colorFrom = ContextCompat.getColor(this, android.R.color.transparent) // Start from transparent or the original color
                    val colorTo = ContextCompat.getColor(this, R.color.green) // End with green
                    val colorAnimator = ObjectAnimator.ofArgb(
                        socialMediaButton,
                        "colorFilter",
                        colorFrom,
                        colorTo
                    )

                    // Set animation duration and evaluator for smooth transition
                    colorAnimator.duration = 500 // 500ms for a smooth transition
                    colorAnimator.setEvaluator(ArgbEvaluator()) // Ensures the color transition is smooth
                    colorAnimator.addUpdateListener { animator ->
                        val colorValue = animator.animatedValue as Int
                        socialMediaButton.setColorFilter(colorValue, PorterDuff.Mode.SRC_IN)
                    }

                    // Start the color animation
                    colorAnimator.start()

                    // Change the dashboard color to green (using a color tint)
                    dashboardScreenButton.setColorFilter(
                        ContextCompat.getColor(this, R.color.gray),
                        android.graphics.PorterDuff.Mode.SRC_IN
                    )
                }
            }
        }

        dashboardScreenButton.setOnClickListener { view ->
            when (view.id) {
                R.id.dashboard -> {
                    loadFragment(HomeFragment())

                    // Change visibility of the Bottom Navigation View
                    // Unhide the Bottom Navigation View with animation
                    bottomNav.visibility = View.VISIBLE // Set visibility to visible first
                    bottomNav.translationY = bottomNav.height.toFloat() // Start from the bottom (hidden state)
                    bottomNav.alpha = 0f // Start with 0 alpha (fully transparent)

                    bottomNav.animate()
                        .translationY(0f) // Animate to its original position
                        .alpha(1f) // Fade in
                        .setDuration(300) // Duration of the show animation


                    // Create the color animation from the current color to green
                    val colorFrom = ContextCompat.getColor(this, android.R.color.transparent) // Start from transparent or the original color
                    val colorTo = ContextCompat.getColor(this, R.color.green) // End with green
                    val colorAnimator = ObjectAnimator.ofArgb(
                        dashboardScreenButton,
                        "colorFilter",
                        colorFrom,
                        colorTo
                    )

                    // Set animation duration and evaluator for smooth transition
                    colorAnimator.duration = 500 // 500ms for a smooth transition
                    colorAnimator.setEvaluator(ArgbEvaluator()) // Ensures the color transition is smooth
                    colorAnimator.addUpdateListener { animator ->
                        val colorValue = animator.animatedValue as Int
                        dashboardScreenButton.setColorFilter(colorValue, PorterDuff.Mode.SRC_IN)
                    }

                    // Start the color animation
                    colorAnimator.start()

                    // Change the dashboard color to green (using a color tint)
                    socialMediaButton.setColorFilter(
                        ContextCompat.getColor(this, R.color.gray),
                        android.graphics.PorterDuff.Mode.SRC_IN
                    )
                }
            }
        }

//        socialMediaButton.setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        }


    }

    // Function to load fragments into the container
    private fun loadFragment(fragment: Fragment) {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.container)

        // Fade out current fragment
        currentFragment?.view?.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_out))

        // Load new fragment with fade in
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null) // Optional: add to back stack
        transaction.commit()

        // After the fragment is added, start fade in animation
        fragment.view?.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_in))
    }

}
