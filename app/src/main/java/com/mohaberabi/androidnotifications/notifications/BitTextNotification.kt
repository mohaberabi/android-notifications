package com.mohaberabi.androidnotifications.notifications

import android.content.Context
import androidx.core.app.NotificationCompat
import com.mohaberabi.androidnotifications.R
import com.mohaberabi.androidnotifications.utils.notificationManager


fun Context.showBigTextNotification() {
    val bigTextStyle = NotificationCompat.BigTextStyle()
        .setSummaryText("this is summary")
        .setBigContentTitle("this is the content")
        .bigText(getString(R.string.big_text))
    val notification = notificationBuilder()
        .setContentText("big text body")
        .setContentTitle("bid text title")
        .setStyle(bigTextStyle)
        .build()
    notificationManager.notify(9, notification)
}