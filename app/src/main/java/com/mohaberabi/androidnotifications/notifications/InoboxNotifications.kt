package com.mohaberabi.androidnotifications.notifications

import android.content.Context
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat
import com.mohaberabi.androidnotifications.R
import com.mohaberabi.androidnotifications.utils.notificationManager


fun Context.showInboxNotification() {
    val inboxStyle = NotificationCompat.InboxStyle()
        .setSummaryText("this is summary")
        .setBigContentTitle("this is the content")
        .addLine("First line ")
        .addLine("second line ")
        .addLine("third line ")
    val notification = notificationBuilder()
        .setContentText("inbox body")
        .setContentTitle("inbox  title")
        .setStyle(inboxStyle)
        .build()
    notificationManager.notify(11, notification)
}
