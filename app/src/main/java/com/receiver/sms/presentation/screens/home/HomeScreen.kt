package com.receiver.sms.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.receiver.sms.presentation.components.app_container.AppContainer

private val LOG_TAG = "HomeScreenLOG"

@Composable
fun HomeScreen() {
    fun createSMSObserve() {

    }

    Scaffold { paddingValues ->
        AppContainer {
            Column {
                Button(onClick = { createSMSObserve() }) {
                    Text("Create observe")
                }
                Text(text = "HomeScreen")
            }
        }
    }
}
