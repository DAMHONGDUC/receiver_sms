package com.receiver.sms.presentation.screens.home

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

private val LOG_TAG = "HomeScreenLOG"

@Composable
fun HomeScreen() {
    val context = LocalContext.current
    val smsList = remember { mutableStateOf(listOf<SmsMessage>()) }

    LaunchedEffect(Unit) {
        smsList.value = getSmsList(context)
        Log.d(LOG_TAG, smsList.value.toString())
    }

    Scaffold { paddingValues ->
        LazyColumn {
            items(smsList.value) { sms ->
                SmsItem(sms)
            }
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