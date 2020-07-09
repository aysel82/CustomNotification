package com.example.myapplication.ui

import android.os.Bundle
import android.widget.RemoteViews
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.myapplication.App
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var notificationManager: NotificationManagerCompat
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        notificationManager = NotificationManagerCompat.from(this)

        binding.btnSendNotification.setOnClickListener {
            sendNotification()
        }
    }

    private fun sendNotification() {
        //custom notification
        val contentView: RemoteViews = RemoteViews(
            packageName,
            R.layout.notification_layout
        )

        contentView.setImageViewResource(
            R.id.imgVwLogo,
            R.drawable.ic_baseline_android_24
        );
        contentView.setTextViewText(R.id.txtVwAppName, "My App")
        contentView.setTextViewText(R.id.txtVwTitle, "Custom Notification")
        contentView.setTextViewText(R.id.txtVwText, "My custom notification...")

        val notification = NotificationCompat.Builder(this, App().channelId1)
            .setSmallIcon(R.drawable.ic_baseline_android_24)
            .setCustomContentView(contentView)
            .setCustomBigContentView(contentView)
            .build()
        notificationManager.notify(1, notification)
    }
}