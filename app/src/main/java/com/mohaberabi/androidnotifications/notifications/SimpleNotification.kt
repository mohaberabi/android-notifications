package com.mohaberabi.androidnotifications.notifications

import android.content.Context
import androidx.core.app.NotificationCompat
import com.mohaberabi.androidnotifications.R
import com.mohaberabi.androidnotifications.notifications.base.AppNotificationChannel
import com.mohaberabi.androidnotifications.utils.grantedNotificationPermission
import com.mohaberabi.androidnotifications.utils.notificationManager

fun Context.notificationBuilder(
    channelId: String? = null,
) = NotificationCompat.Builder(
    this,
    channelId ?: AppNotificationChannel.Default.id
).setSmallIcon(R.drawable.ic_launcher_foreground)

fun Context.showSimpleNotification(
    title: String = "example title",
    body: String = "example body"
) {
    val notification = notificationBuilder()
        .setContentTitle(title)
        .setContentText(body)
        .build()

    if (grantedNotificationPermission()) {
        notificationManager.notify(1, notification)
    }
}

