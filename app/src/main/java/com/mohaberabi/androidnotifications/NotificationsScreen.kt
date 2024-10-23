package com.mohaberabi.androidnotifications

import android.Manifest
import android.widget.Space
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.mohaberabi.androidnotifications.notifications.showBasicActionNotification
import com.mohaberabi.androidnotifications.notifications.showBigPictNotification
import com.mohaberabi.androidnotifications.notifications.showBigTextNotification
import com.mohaberabi.androidnotifications.notifications.showCustomNotification
import com.mohaberabi.androidnotifications.notifications.showGroupedNotification
import com.mohaberabi.androidnotifications.notifications.showInboxNotification
import com.mohaberabi.androidnotifications.notifications.showMediaNotification
import com.mohaberabi.androidnotifications.notifications.showMessageNotifications
import com.mohaberabi.androidnotifications.notifications.showSilentNotification
import com.mohaberabi.androidnotifications.notifications.showSimpleNotification
import com.mohaberabi.androidnotifications.notifications.showUrgentNotification
import com.mohaberabi.androidnotifications.utils.requiresNotificationsChannel


@Composable
fun NotificationsScreen(modifier: Modifier = Modifier) {

    val context = LocalContext.current

    if (requiresNotificationsChannel()) {
        val launcher =
            rememberLauncherForActivityResult(
                contract = ActivityResultContracts.RequestPermission(),
            ) {}
        LaunchedEffect(
            key1 = Unit,
        ) {
            launcher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    }






    Scaffold {

            pading ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(pading)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Button(
                onClick = {
                    context.showSimpleNotification()
                },
            ) {
                Text(text = "Show simple")
            }
            Button(
                onClick = {
                    context.showSilentNotification()
                },
            ) {
                Text(text = "Show silent")
            }
            Button(
                onClick = {
                    context.showUrgentNotification()
                },
            ) {
                Text(text = "Show urgent")
            }
            Button(
                onClick = {
                    context.showGroupedNotification()
                },
            ) {
                Text(text = "Show grouped")
            }
            Button(
                onClick = {
                    context.showBasicActionNotification()
                },
            ) {
                Text(text = "Show simple action")
            }
            Button(
                onClick = {
                    context.showBigTextNotification()
                },
            ) {
                Text(text = "Show big text")
            }
            Button(
                onClick = {
                    context.showBigPictNotification()
                },
            ) {
                Text(text = "Show big pic")
            }
            Button(
                onClick = {
                    context.showInboxNotification()
                },
            ) {
                Text(text = "Show inbox ")
            }
            Button(
                onClick = {
                    context.showMessageNotifications()
                },
            ) {
                Text(text = "Show messaging ")
            }
            Button(
                onClick = {
                    context.showMessageNotifications()
                },
            ) {
                Text(text = "Show with reply  ")
            }
            Button(
                onClick = {
                    context.showMediaNotification()
                },
            ) {
                Text(text = "Show with media  ")
            }
            Button(
                onClick = {
                    context.showCustomNotification()
                },
            ) {
                Text(text = "Show with custom  ")
            }
        }
    }
}