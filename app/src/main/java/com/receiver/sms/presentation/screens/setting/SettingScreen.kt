package com.receiver.sms.presentation.screens.setting

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.receiver.sms.presentation.screens.main.MainViewModel

@Composable
fun SettingScreen(mainVM: MainViewModel) {
    Scaffold { paddingValues ->
        Column {
            Text("SettingScreen")
        }
    }
}