package com.receiver.sms.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.receiver.sms.presentation.components.CustomAppBar
import com.receiver.sms.presentation.components.MainContainer
import com.receiver.sms.presentation.screens.home.components.CreateSMSObserverButton
import com.receiver.sms.presentation.screens.home.components.ListSMSObserver
import com.receiver.sms.presentation.screens.home.components.RequestSMSPermissionModal
import com.receiver.sms.presentation.screens.main.MainViewModel
import com.receiver.sms.utils.resources.AppColors

private val LOG_TAG = "HomeScreenLOG"

@Composable
fun HomeScreen(
    homeVM: HomeViewModel = hiltViewModel(),
    mainVM: MainViewModel,
    navToCreateObserverScreen: () -> Unit
) {
    val listSMSObserver = homeVM.listSMSObserver.collectAsState().value

    LaunchedEffect(Unit) {
        homeVM.getAllSMSObserve()
    }

    MainContainer(
        paddingVertical = 0.dp,
        paddingHorizontal = 0.dp,
        topBarTitle = "Home",
        enableBack = false,
        customTopBar = {
            CustomAppBar(
                bg = AppColors.primary,
                mainColor = AppColors.white,
                title = "Home",
                enableBack = false,
                elevation = 0.dp
            )
        }
    ) {
        RequestSMSPermissionModal {
            Column {
                CreateSMSObserverButton(onClick = navToCreateObserverScreen)
                ListSMSObserver(listSMSObserver)
            }
        }
    }

}
