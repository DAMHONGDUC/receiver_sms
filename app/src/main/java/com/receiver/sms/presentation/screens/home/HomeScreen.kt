package com.rmyhal.containertransform

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.receiver.sms.core.resources.AppBoxModel
import com.receiver.sms.core.resources.AppColors
import com.receiver.sms.presentation.screens.home.FakeSearchBar
import com.receiver.sms.presentation.screens.home.HomeFloatingButton
import com.receiver.sms.presentation.screens.home.HomeViewModel
import com.receiver.sms.presentation.screens.home.components.ListSMSObserver

@Composable
fun HomeScreen(modifier: Modifier = Modifier, homeVM: HomeViewModel = hiltViewModel()) {
    val listSMSObserver = homeVM.listSMSObserver.collectAsState().value

    Scaffold(
        containerColor = AppColors.mainBG,
        content = { padding ->
            Box {
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(
                            horizontal = AppBoxModel.padding,
                            vertical = AppBoxModel.halfSpacing
                        ),
                ) {
                    FakeSearchBar()

                    ListSMSObserver(listSMSObserver)
                }
                HomeFloatingButton(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                )
            }
        },
    )
}

