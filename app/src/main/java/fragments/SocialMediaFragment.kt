package fragments

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.agrichime.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class SocialMediaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_social_media, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Access the ImageButton from the MainActivity
        val socialMediaButton: ImageButton? = activity?.findViewById(R.id.social_media)
        val dashBoardScreenButton: ImageButton? = activity?.findViewById(R.id.dashboard)
        val bottomNav: BottomNavigationView? = activity?.findViewById(R.id.bottomNav)

        // Immediately when the fragment is loaded, transition the color to green
        socialMediaButton?.let {
            // Initial color animation from gray to green
            val colorFrom = ContextCompat.getColor(requireContext(), R.color.gray) // Start from gray
            val colorTo = ContextCompat.getColor(requireContext(), R.color.green) // End with green
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
        }

        // Immediately when the fragment is loaded, transition the color to green
        dashBoardScreenButton?.let {
            // Initial color animation from gray to green
            val colorFrom = ContextCompat.getColor(requireContext(), R.color.green) // Start from green
            val colorTo = ContextCompat.getColor(requireContext(), R.color.gray) // End with gray
            val colorAnimator = ObjectAnimator.ofArgb(
                dashBoardScreenButton,
                "colorFilter",
                colorFrom,
                colorTo
            )

            // Set animation duration and evaluator for smooth transition
            colorAnimator.duration = 500 // 500ms for a smooth transition
            colorAnimator.setEvaluator(ArgbEvaluator()) // Ensures the color transition is smooth
            colorAnimator.addUpdateListener { animator ->
                val colorValue = animator.animatedValue as Int
                dashBoardScreenButton.setColorFilter(colorValue, PorterDuff.Mode.SRC_IN)
            }

            // Start the color animation
            colorAnimator.start()
        }

        // Immediately when the fragment is loaded, hide the Bottom Navigation View
        bottomNav?.let {
            // Hide the Bottom Navigation View with animation
            bottomNav.animate()
                .translationY(bottomNav.height.toFloat())
                .alpha(0f)
                .setDuration(300) // Duration of the hide animation
                .withEndAction {
                    bottomNav.visibility = View.GONE // Make it gone after the animation
                }
        }
    }
}
