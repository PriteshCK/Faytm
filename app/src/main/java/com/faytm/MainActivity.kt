package com.faytm

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.zxing.integration.android.IntentIntegrator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scanButton = findViewById<Button>(R.id.scanButton)
        scanButton.setOnClickListener {
            val integrator = IntentIntegrator(this)
            integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
            //integrator.setPrompt("Scan a QR Code")
            integrator.setPrompt("")
            integrator.setCameraId(0)
            integrator.initiateScan()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            val scannedData = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
            val scannedText = scannedData.contents
            navigateToSecondScreen(scannedText)
        }
    }

    private fun navigateToSecondScreen(scannedData: String) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("SCANNED_DATA", scannedData)
        startActivity(intent)
    }
}