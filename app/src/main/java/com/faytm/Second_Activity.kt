package com.faytm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val scannedData = intent.getStringExtra("SCANNED_DATA")

        val nextButton = findViewById<Button>(R.id.nextButton)
        nextButton.setOnClickListener {
            val numericInputEditText = findViewById<EditText>(R.id.numericInputEditText)
            val numericInput = numericInputEditText.text.toString()
            navigateToThirdScreen(scannedData, numericInput)
        }
    }

    private fun navigateToThirdScreen(scannedData: String?, numericInput: String) {
        val intent = Intent(this, ThirdActivity::class.java)
        intent.putExtra("SCANNED_DATA", scannedData)
        intent.putExtra("NUMERIC_INPUT", numericInput)
        startActivity(intent)
    }
}