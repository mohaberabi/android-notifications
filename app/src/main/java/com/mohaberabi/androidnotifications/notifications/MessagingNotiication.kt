package com.mohaberabi.androidnotifications.notifications

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat
import androidx.core.app.Person
import androidx.core.app.RemoteInput
import com.mohaberabi.androidnotifications.R
import com.mohaberabi.androidnotifications.utils.notificationManager

const val REMOTE_REPLY_KEY = "remoteReplyKey"
fun Context.showMessageNotifications() {
    val replyInput = RemoteInput.Builder(REMOTE_REPLY_KEY)
        .setLabel("Reply to me ,loser")
        .build()

    val intent = Intent(this, ReplyResultReciever::class.java)

    val pendingIntent = PendingIntent.getBroadcast(
        this, 200, intent,
        PendingIntent.FLAG_MUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
    )
    val action =
        NotificationCompat.Action.Builder(
            R.drawable.ic_launcher_foreground,
            "reply to message loooser",
            pendingIntent
        ).addRemoteInput(replyInput)
    val person = Person.Builder()
        .setName("Mohab the loser").build()
    val messageStyle = NotificationCompat.MessagingStyle(person)
        .setConversationTitle("loosing always")
        .addMessage("you will always keep losing haahahahah", System.currentTimeMillis(), person)
    val notification = notificationBuilder()
        .setContentText("body")
        .setContentTitle("title")
        .setStyle(messageStyle)
        .addAction(action.build())
        .build()
    notificationManager.notify(10, notification)
}