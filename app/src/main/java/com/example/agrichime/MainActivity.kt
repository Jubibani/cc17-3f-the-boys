package com.example.agrichime

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
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

        bottomNav = findViewById(R.id.bottomNav)
        val socialMediaButton: ImageButton = findViewById(R.id.social_media)
        val dashboardScreenButton: ImageButton = findViewById(R.id.dashboard)

        // on ready
        loadFragment(HomeFragment())

        dashboardScreenButton.animate()
            .translationY(-25f) // Adjust the translation value (e.g., 25 pixels upwards)
            .setDuration(300) // Set the duration of the animation
            .start()

        // bottom nav
        bottomNav.let {

            bottomNav.visibility = View.VISIBLE // Make it visible first before animating

            bottomNav.animate()
                .translationY(0f) // Move it back to its original position
                .alpha(1f) // Set alpha to fully visible
                .setDuration(300) // Duration of the show animation
                .start()
        }


        //bottom navigation bar
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


        //buttons
        socialMediaButton.setOnClickListener { view ->
            when (view.id) {
                R.id.social_media -> {

                    loadFragment(SocialMediaFragment())

                    //move the button
                    dashboardScreenButton.animate()
                        .translationY(-0f)
                        .setDuration(300)

                    socialMediaButton.animate()
                        ?.translationY(-25f)
                        ?.setDuration(300)
                        ?.start()

                    // Initial color animation from gray to green
                    val SocialMediacolorFrom = ContextCompat.getColor(this, R.color.gray)
                    val SocialMediacolorTo = ContextCompat.getColor(this, R.color.green)

                    val SocialMediaColorAnimator = ObjectAnimator.ofArgb(
                        socialMediaButton,
                        "colorFilter",
                        SocialMediacolorFrom,
                        SocialMediacolorTo,

                    )

                    // Set animation duration and evaluator for smooth transition
                    SocialMediaColorAnimator.duration = 500 // 500ms for a smooth transition
                    SocialMediaColorAnimator.setEvaluator(ArgbEvaluator()) // Ensures the color transition is smooth
                    SocialMediaColorAnimator.addUpdateListener { animator ->
                        val colorValue = animator.animatedValue as Int
                        socialMediaButton.setColorFilter(colorValue, PorterDuff.Mode.SRC_IN)
                    }

                    // Start the color animation
                    SocialMediaColorAnimator.start()

                    // Initial color animation from gray to green
                    val dashBoardcolorFrom = ContextCompat.getColor(this, R.color.green)
                    val dashBoardcolorTo = ContextCompat.getColor(this, R.color.gray)


                    val dashBoardColorAnimator = ObjectAnimator.ofArgb(
                        dashboardScreenButton,
                        "colorFilter",
                        dashBoardcolorFrom,
                        dashBoardcolorTo,

                        )

                    // Set animation duration and evaluator for smooth transition
                    dashBoardColorAnimator.duration = 500 // 500ms for a smooth transition
                    dashBoardColorAnimator.setEvaluator(ArgbEvaluator()) // Ensures the color transition is smooth
                    dashBoardColorAnimator.addUpdateListener { animator ->
                        val colorValue = animator.animatedValue as Int
                        dashboardScreenButton.setColorFilter(colorValue, PorterDuff.Mode.SRC_IN)
                    }

                    // Start the color animation
                    dashBoardColorAnimator.start()

                    // bottom nav
                    bottomNav.let {

                        bottomNav.animate()
                            .translationY(bottomNav.height.toFloat())
                            .alpha(0f)
                            .setDuration(300)
                            .withEndAction {
                                bottomNav.visibility = View.GONE
                            }
                    }
                }
            }
        }

        dashboardScreenButton.setOnClickListener { view ->
            when (view.id) {
                R.id.dashboard -> {
                    loadFragment(HomeFragment())

                    //move the button
                    socialMediaButton.animate()
                        ?.translationY(0f)
                        ?.setDuration(300)
                        ?.start()

                    dashboardScreenButton.animate()
                        ?.translationY(-25f)
                        ?.setDuration(300)
                        ?.start()


                    // Initial color animation from gray to green
                    val SocialMediacolorFrom = ContextCompat.getColor(this, R.color.green)
                    val SocialMediacolorTo = ContextCompat.getColor(this, R.color.gray)

                    val SocialMediaColorAnimator = ObjectAnimator.ofArgb(
                        socialMediaButton,
                        "colorFilter",
                        SocialMediacolorFrom,
                        SocialMediacolorTo,

                        )

                    // Set animation duration and evaluator for smooth transition
                    SocialMediaColorAnimator.duration = 500 // 500ms for a smooth transition
                    SocialMediaColorAnimator.setEvaluator(ArgbEvaluator()) // Ensures the color transition is smooth
                    SocialMediaColorAnimator.addUpdateListener { animator ->
                        val colorValue = animator.animatedValue as Int
                        socialMediaButton.setColorFilter(colorValue, PorterDuff.Mode.SRC_IN)
                    }

                    // Start the color animation
                    SocialMediaColorAnimator.start()

                    // Initial color animation from gray to green
                    val dashBoardcolorFrom = ContextCompat.getColor(this, R.color.gray)
                    val dashBoardcolorTo = ContextCompat.getColor(this, R.color.green)


                    val dashBoardColorAnimator = ObjectAnimator.ofArgb(
                        dashboardScreenButton,
                        "colorFilter",
                        dashBoardcolorFrom,
                        dashBoardcolorTo,

                        )

                    // Set animation duration and evaluator for smooth transition
                    dashBoardColorAnimator.duration = 500 // 500ms for a smooth transition
                    dashBoardColorAnimator.setEvaluator(ArgbEvaluator()) // Ensures the color transition is smooth
                    dashBoardColorAnimator.addUpdateListener { animator ->
                        val colorValue = animator.animatedValue as Int
                        dashboardScreenButton.setColorFilter(colorValue, PorterDuff.Mode.SRC_IN)
                    }

                    // Start the color animation
                    dashBoardColorAnimator.start()


                    // bottom nav
                    bottomNav.let {

                        bottomNav.visibility = View.VISIBLE

                        bottomNav.animate()
                            .translationY(0f)
                            .alpha(1f)
                            .setDuration(300)
                            .start()
                    }

                }
            }
        }

    }

    // Function to load fragments into the container
    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }

}
