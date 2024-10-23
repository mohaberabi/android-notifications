package com.mohaberabi.androidnotifications.notifications

import android.content.Context
import android.widget.RemoteViews
import com.mohaberabi.androidnotifications.R
import com.mohaberabi.androidnotifications.utils.notificationManager


fun Context.showCustomNotification() {

    val small = RemoteViews(packageName, R.layout.small_noti)
    val expanded = RemoteViews(packageName, R.layout.custom_noti)
    val notification = notificationBuilder()
        .setCustomContentView(small)
        .setCustomBigContentView(expanded)
        .build()
    notificationManager.notify(20, notification)
}