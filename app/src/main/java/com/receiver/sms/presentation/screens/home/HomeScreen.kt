package com.receiver.sms.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.receiver.sms.presentation.components.app.MainContainer
import com.receiver.sms.presentation.screens.home.components.CreateSMSObserverButton
import com.receiver.sms.presentation.screens.home.components.HomeTopBar
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
        customTopBar = { HomeTopBar() }
    ) {
        RequestSMSPermissionModal {
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(24.dp)
                        .background(color = AppColors.primary)
                )

                CreateSMSObserverButton(onClick = navToCreateObserverScreen)
                ListSMSObserver(listSMSObserver)
            }
        }
    }

}
