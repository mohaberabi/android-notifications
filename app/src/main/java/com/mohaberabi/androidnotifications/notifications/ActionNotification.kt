package com.mohaberabi.androidnotifications.notifications

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.mohaberabi.androidnotifications.R
import com.mohaberabi.androidnotifications.notifications.ReplyToMessageReceiver.Companion.REPLY_MESSAGE_BODY_KEY
import com.mohaberabi.androidnotifications.notifications.ReplyToMessageReceiver.Companion.REPLY_MESSAGE_TTL_KEY
import com.mohaberabi.androidnotifications.utils.notificationManager


class ReplyToMessageReceiver : BroadcastReceiver() {
    companion object {

        const val REPLY_MESSAGE_TTL_KEY = "replyMessageKeyTitle"
        const val REPLY_MESSAGE_BODY_KEY = "replyMessageKeyBody"

    }

    override fun onReceive(contenxt: Context?, intent: Intent?) {
        intent?.let { intent ->
            val builder = contenxt?.notificationBuilder()
            val title = intent.getStringExtra(REPLY_MESSAGE_TTL_KEY)
            val body = intent.getStringExtra(REPLY_MESSAGE_BODY_KEY)
            val noti = builder?.setContentText(title)?.setContentText(body)?.build()
            contenxt?.notificationManager?.notify(2020, noti)
        }
    }
}

fun Context.showBasicActionNotification() {

    val intent = Intent(this, ReplyToMessageReceiver::class.java).apply {
        putExtra(REPLY_MESSAGE_TTL_KEY, "Reply to message")
        putExtra(REPLY_MESSAGE_BODY_KEY, "Hey i love kotlin")

    }

    val pendingIntent = PendingIntent.getBroadcast(
        this,
        3,
        intent,
        PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_MUTABLE
    )
    val noti = notificationBuilder()
        .setContentTitle("simple action notification title  ")
        .setContentText("simple action notification body  ")
        .addAction(R.drawable.ic_launcher_foreground, "Reply to message", pendingIntent)
        .build()
    notificationManager.notify(5, noti)
}