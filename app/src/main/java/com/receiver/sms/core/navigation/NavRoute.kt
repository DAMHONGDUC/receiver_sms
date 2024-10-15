package com.receiver.sms.core.navigation

sealed class NavRoute(val route: String) {
    object HomeScreen : NavRoute(route = "HomeScreen")
    object SettingScreen : NavRoute(route = "SettingScreen")
    object CreateObserverScreen : NavRoute(route = "CreateObserverScreen")

}
