package com.mohaberabi.androidnotifications

import android.app.Application
import android.app.NotificationManager
import androidx.core.content.getSystemService
import com.mohaberabi.androidnotifications.notifications.base.AppNotificationChannel
import com.mohaberabi.androidnotifications.notifications.base.toAndroidNotificationChannel
import com.mohaberabi.androidnotifications.utils.requiresNotificationsChannel

class AndroidNotificationsApp : Application() {


    override fun onCreate() {
        super.onCreate()
        initNotificationsChannel()
    }


    private fun initNotificationsChannel() {
        val notificationManager = getSystemService<NotificationManager>()!!
        if (requiresNotificationsChannel()) {
            val channels = AppNotificationChannel.entries.map {
                it.toAndroidNotificationChannel()
            }
            notificationManager.createNotificationChannels(channels)
        }
    }


}