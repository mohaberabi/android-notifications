package com.mohaberabi.androidnotifications.notifications.base

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.annotation.RequiresApi


enum class AppNotificationChannel(

    val id: String,
    val label: String,
    val description: String? = null,
    val importance: Int = NotificationManager.IMPORTANCE_DEFAULT,
) {


    Default(
        "default",
        "default channel",
    ),

    Silent(
        id = "silent",
        label = "silent  channel",
        importance = NotificationManager.IMPORTANCE_LOW,
    ),
    Urgent(
        id = "urgent",
        label = "urgent  channel",
        importance = NotificationManager.IMPORTANCE_HIGH,
    ),

}


@RequiresApi(Build.VERSION_CODES.O)
fun AppNotificationChannel.toAndroidNotificationChannel(
) = NotificationChannel(
    id,
    label,
    importance,
)

