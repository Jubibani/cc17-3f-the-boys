package fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.example.agrichime.R
import com.example.agrichime.ShoppingScreen

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_shopping_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Safely reference the ImageButton and set up the click listener
        val shopButtonHome: ImageButton? = view.findViewById(R.id.shop_button)
        shopButtonHome?.setOnClickListener {
            // Intent to start the ShoppingScreen activity
            val intent = Intent(requireContext(), ShoppingScreen::class.java)
            startActivity(intent)
        }
    }
}
