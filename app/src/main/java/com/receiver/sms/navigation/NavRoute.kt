package com.receiver.sms.navigation

sealed class NavRoute(val route: String) {
    object HomeScreen : NavRoute(route = "HomeScreen")
    object SettingScreen : NavRoute(route = "SettingScreen")

}
