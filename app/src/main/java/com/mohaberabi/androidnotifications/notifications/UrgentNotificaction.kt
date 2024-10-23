package com.mohaberabi.androidnotifications.notifications

import android.content.Context
import com.mohaberabi.androidnotifications.notifications.base.AppNotificationChannel
import com.mohaberabi.androidnotifications.utils.notificationManager


fun Context.showUrgentNotification() {


    val notification = notificationBuilder(
        channelId = AppNotificationChannel.Urgent.id
    ).setContentText("urgent notification body")
        .setContentTitle("urgent notification title")
        .build()

    notificationManager.notify(3, notification)

}