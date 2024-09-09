package com.receiver.sms.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.receiver.sms.presentation.components.CustomAppBar
import com.receiver.sms.presentation.components.MainContainer
import com.receiver.sms.presentation.components.Pressable
import com.receiver.sms.presentation.screens.home.components.CreateSMSObserverButton
import com.receiver.sms.presentation.screens.home.components.ListSMSObserver
import com.receiver.sms.presentation.screens.home.components.RequestSMSPermissionModal
import com.receiver.sms.presentation.screens.main.MainViewModel
import com.receiver.sms.utils.resources.AppColors
import com.receiver.sms.utils.resources.AppIconSize
import com.receiver.sms.utils.resources.AppTextStyle

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
                title = "SMS Observer",
                textStyle = AppTextStyle().base.copy(fontWeight = FontWeight.SemiBold),
                enableBack = false,
                elevation = 0.dp,
                topBarAction = {
                    Pressable(onClick = { /*TODO*/ }) {
                        Icon(
                            Icons.Filled.Search,
                            contentDescription = "",
                            tint = AppColors.white,
                            modifier = Modifier
                                .padding(5.dp)
                                .size(AppIconSize().base())
                        )
                    }
                }
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
