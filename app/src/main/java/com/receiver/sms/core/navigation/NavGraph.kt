package com.receiver.sms.core.navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.receiver.sms.presentation.screens.create_observer.CreateObserverScreen
import com.receiver.sms.presentation.screens.home.HomeScreen
import com.receiver.sms.presentation.screens.main.MainViewModel
import com.receiver.sms.presentation.screens.setting.SettingScreen

@Composable
fun NavGraph(navController: NavHostController, mainVM: MainViewModel) {
    val coroutineScope = rememberCoroutineScope()

    NavHost(
        navController = navController,
        startDestination = NavRoute.HomeScreen.route,
        enterTransition = {
            slideInHorizontally { it }
        },
        exitTransition =
        {
            slideOutHorizontally { it }
        },
        popEnterTransition = {
            slideInHorizontally { it }
        },
        popExitTransition = {
            slideOutHorizontally {
                it
            }
        },
    ) {
        addHomeScreen(
            navController,
            this,
            mainVM = mainVM
        )
        addSettingScreen(
            navController,
            this,
            mainVM = mainVM
        )
        addCreateObserverScreen(
            navController,
            this,
            mainVM = mainVM
        )
    }
}

private fun addHomeScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    mainVM: MainViewModel
) {
    navGraphBuilder.composable(route = NavRoute.HomeScreen.route) {
        HomeScreen(
            mainVM = mainVM,
            navToCreateObserverScreen = { navController.navigate(NavRoute.CreateObserverScreen.route) }
        )
    }
}

private fun addSettingScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    mainVM: MainViewModel
) {
    navGraphBuilder.composable(route = NavRoute.SettingScreen.route) {
        SettingScreen(
            mainVM = mainVM
        )
    }
}

private fun addCreateObserverScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    mainVM: MainViewModel
) {
    navGraphBuilder.composable(route = NavRoute.CreateObserverScreen.route) {
        CreateObserverScreen(
            mainVM = mainVM,
            onBack = { navController.popBackStack() }
        )
    }
}
