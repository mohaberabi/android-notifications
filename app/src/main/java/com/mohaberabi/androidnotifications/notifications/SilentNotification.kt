package com.mohaberabi.androidnotifications.notifications

import android.content.Context
import com.mohaberabi.androidnotifications.notifications.base.AppNotificationChannel
import com.mohaberabi.androidnotifications.utils.notificationManager


fun Context.showSilentNotification() {


    val notification = notificationBuilder(
        channelId = AppNotificationChannel.Silent.id
    ).setContentTitle("silent notification title")
        .setContentText("silent notification bdy")
        .build()


    notificationManager.notify(2, notification)

}