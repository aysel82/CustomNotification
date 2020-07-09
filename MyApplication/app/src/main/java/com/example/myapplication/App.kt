package com.example.myapplication

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class App : Application() {

    val channelId1 = "CHANNEL_1"

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val name1: CharSequence = "Channel 1"
            val description1 = "This is Channel 1"
            val importance1 = NotificationManager.IMPORTANCE_HIGH

            val channel1 = NotificationChannel(channelId1, name1, importance1)
            channel1.description = description1
 
            var notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel1)
        }
    }
}