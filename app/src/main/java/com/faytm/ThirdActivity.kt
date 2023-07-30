package com.faytm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val scannedData = intent.getStringExtra("SCANNED_DATA")
        val numericInput = intent.getStringExtra("NUMERIC_INPUT")

        val submitButton = findViewById<Button>(R.id.submitButton)
        submitButton.setOnClickListener {
            val additionalInputEditText = findViewById<EditText>(R.id.additionalInputEditText)
            val additionalInput = additionalInputEditText.text.toString()
            navigateToFourthScreen(scannedData, numericInput, additionalInput)
        }
    }

    private fun navigateToFourthScreen(scannedData: String?, numericInput: String?, additionalInput: String) {
        val intent = Intent(this, FourthActivity::class.java)
        intent.putExtra("SCANNED_DATA", scannedData)
        intent.putExtra("NUMERIC_INPUT", numericInput)
        intent.putExtra("ADDITIONAL_INPUT", additionalInput)
        startActivity(intent)
    }
}