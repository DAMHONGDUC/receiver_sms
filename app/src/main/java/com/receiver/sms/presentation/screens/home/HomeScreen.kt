package com.rmyhal.containertransform

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.hilt.navigation.compose.hiltViewModel
import com.receiver.sms.core.resources.AppBoxModel
import com.receiver.sms.core.resources.AppColors
import com.receiver.sms.core.resources.AppIconSize
import com.receiver.sms.presentation.components.spacing.VerticalSpacing
import com.receiver.sms.presentation.screens.home.HomeViewModel
import com.receiver.sms.presentation.screens.home.components.FakeSearchBar
import com.receiver.sms.presentation.screens.home.components.ListSMSObserver

private val LOG_TAG = "HomeScreenLOG"

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeVM: HomeViewModel = hiltViewModel(),
    navToCreateObserverScreen: () -> Unit
) {
    val listSMSObserver = homeVM.listSMSObserver.collectAsState().value

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                containerColor = AppColors.primary,
                onClick = { navToCreateObserverScreen() },
                modifier = Modifier
                    .size(AppIconSize.superLarge),
                content = {
                    Icon(
                        painter = rememberVectorPainter(Icons.Filled.Add),
                        contentDescription = null,
                        tint = AppColors.white,
                        modifier = Modifier.size(AppIconSize.base)
                    )
                }
            )
        },
        containerColor = AppColors.mainBG,
        content = { padding ->
            Box {
                Column(
                    modifier = modifier
                        .fillMaxSize(),
                ) {
                    FakeSearchBar(
                        modifier = Modifier.padding(
                            horizontal = AppBoxModel.padding,
                            vertical = AppBoxModel.halfSpacing
                        )
                    )

                    VerticalSpacing()

                    ListSMSObserver(listSMSObserver)
                }
            }
        },
    )
}

