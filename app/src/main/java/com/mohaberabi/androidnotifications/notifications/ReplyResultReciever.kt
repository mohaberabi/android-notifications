package com.mohaberabi.androidnotifications.notifications

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.RemoteInput
import com.mohaberabi.androidnotifications.notifications.ReplyToMessageReceiver.Companion
import com.mohaberabi.androidnotifications.utils.notificationManager


class ReplyResultReciever : BroadcastReceiver() {

    override fun onReceive(contenxt: Context?, intent: Intent?) {
        intent?.let { intent ->
            val result = RemoteInput.getResultsFromIntent(intent)
            val reply = result?.getCharSequence(REMOTE_REPLY_KEY)
            val builder = contenxt?.notificationBuilder()
            val body = intent.getStringExtra(reply.toString())
            val noti = builder?.setContentText("your replied")?.setContentText(body)?.build()
            contenxt?.notificationManager?.notify(5, noti)
        }
    }
}