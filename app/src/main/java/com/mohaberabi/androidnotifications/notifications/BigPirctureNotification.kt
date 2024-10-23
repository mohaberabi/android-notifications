package com.mohaberabi.androidnotifications.notifications

import android.content.Context
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat
import com.mohaberabi.androidnotifications.R
import com.mohaberabi.androidnotifications.utils.notificationManager

fun Context.showBigPictNotification() {
    val bigPicture = BitmapFactory.decodeResource(resources, R.drawable.big_pic)
    val bigPicStyle = NotificationCompat.BigPictureStyle()
        .setSummaryText("this is summary")
        .setBigContentTitle("this is the content")
        .bigPicture(bigPicture)
    val notification = notificationBuilder()
        .setContentText("big pic body")
        .setContentTitle("bid pic title")
        .setStyle(bigPicStyle)
        .build()
    notificationManager.notify(10, notification)
}