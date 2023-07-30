package com.faytm

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.app.NotificationCompat

private const val NOTIFICATION_CHANNEL_ID = "MyAppChannel"
private const val NOTIFICATION_ID = 1

class FourthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        val scannedData = intent.getStringExtra("SCANNED_DATA")
        val numericInput = intent.getStringExtra("NUMERIC_INPUT")
        val additionalInput = intent.getStringExtra("ADDITIONAL_INPUT")

        val scannedDataTextView = findViewById<TextView>(R.id.scannedDataTextView)
        scannedDataTextView.text = "₹$numericInput Sent To:"

        val numericInputTextView = findViewById<TextView>(R.id.numericInputTextView)
        numericInputTextView.text = "$scannedData"

        //val additionalInputTextView = findViewById<TextView>(R.id.additionalInputTextView)
        //additionalInputTextView.text = "Additional Input: $additionalInput"

        sendNotification(scannedData, numericInput, additionalInput)
    }

    private fun sendNotification(scannedData: String?, numericInput: String?, additionalInput: String?) {
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(NOTIFICATION_CHANNEL_ID, "Transactions", NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        val notificationBuilder = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
            .setSmallIcon(R.mipmap.ic_launcher)
            //.setContentTitle("MyApp Notification")
            //.setContentText("Scanned Data: $scannedData\nNumeric Input: $numericInput\nAdditional Input: $additionalInput")
            .setContentTitle("₹$numericInput Sent To:")
            .setContentText("$scannedData")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build())
    }
}