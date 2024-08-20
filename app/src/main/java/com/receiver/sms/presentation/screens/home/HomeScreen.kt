package com.receiver.sms.presentation.screens.home

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.receiver.sms.presentation.components.app_container.AppContainer

private val LOG_TAG = "HomeScreenLOG"

@Composable
fun HomeScreen() {
    Scaffold { paddingValues ->
        AppContainer {
            Text(text = "HomeScreen")
        }
    }
}

@SuppressLint("Range")
fun getSmsList(context: Context): List<SmsMessage> {
    val smsList = mutableListOf<SmsMessage>()
    val contentResolver = context.contentResolver
    val cursor = contentResolver.query(
        Uri.parse("content://sms/inbox"),
        null,
        null,
        null,
        null
    )

    cursor?.use {
        while (cursor.moveToNext()) {
            val address = cursor.getString(cursor.getColumnIndex("address"))
            val body = cursor.getString(cursor.getColumnIndex("body"))
            smsList.add(SmsMessage(address, body))
        }
    }
    return smsList
}

data class SmsMessage(val address: String, val body: String)

@Composable
fun SmsItem(sms: SmsMessage) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = "From: ${sms.address}")
        Text(text = sms.body)
    }
}