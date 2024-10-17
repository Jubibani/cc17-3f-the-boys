package com.example.agrichime

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Activities : AppCompatActivity() {

    // UI components for card input form
    private lateinit var nameOnCard: EditText
    private lateinit var cardNumber: EditText
    private lateinit var expiryDate: EditText
    private lateinit var postalCode: EditText
    private lateinit var proceedButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Ensure your layout file is named activity_main.xml

        // Initialize the EditTexts and Button
        nameOnCard = findViewById(R.id.editTextNameOnCard) // Name on Card
        cardNumber = findViewById(R.id.editTextCardNumber) // Card Number
        expiryDate = findViewById(R.id.editTextExpiryDate) // Expiry Date
        postalCode = findViewById(R.id.editTextPostalCode) // Zip/Postal Code
        proceedButton = findViewById(R.id.buttonProceed) // Proceed button

        // Set a click listener on the proceed button
        proceedButton.setOnClickListener { handleProceedButton() }
    }

    // Function to handle Gcash image click
    fun openGcash(view: View) {
        val intent = Intent(this@MainActivity, GcashActivity::class.java)
        startActivity(intent)
    }

    // Function to handle Paypal image click
    fun openPaypal(view: View) {
        val intent = Intent(this@MainActivity, PaypalActivity::class.java)
        startActivity(intent)
    }

    // Function to handle Visa image click
    fun openVisa(view: View) {
        val intent = Intent(this@MainActivity, VisaActivity::class.java)
        startActivity(intent)
    }

    private fun handleProceedButton() {
        // Retrieve input values
        val name = nameOnCard.text.toString().trim()
        val cardNum = cardNumber.text.toString().trim()
        val expiry = expiryDate.text.toString().trim()
        val postal = postalCode.text.toString().trim()

        // Perform basic validation
        if (name.isEmpty() || cardNum.isEmpty() || expiry.isEmpty() || postal.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return
        }

        // Call payment API (Pseudo-implementation, replace with real API call)
        processPayment(name, cardNum, expiry, postal)
    }

    // Dummy method to simulate payment processing
    private fun processPayment(name: String, cardNum: String, expiry: String, postal: String) {
        // Normally you would call an API for payment processing here
        Toast.makeText(this, "Payment Processed for $name", Toast.LENGTH_LONG).show()
    }
}