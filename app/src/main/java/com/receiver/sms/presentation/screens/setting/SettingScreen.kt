package com.receiver.sms.presentation.screens.setting

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.receiver.sms.presentation.components.MainContainer
import com.receiver.sms.presentation.screens.main.MainViewModel

@Composable
fun SettingScreen(mainVM: MainViewModel) {
    MainContainer {
        Text("SettingScreen")
    }
}