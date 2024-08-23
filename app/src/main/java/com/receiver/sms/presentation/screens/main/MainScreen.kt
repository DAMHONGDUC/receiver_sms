package com.receiver.sms.presentation.screens.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.compose.rememberNavController
import com.dokar.sonner.rememberToasterState
import com.receiver.sms.navigation.NavGraph
import com.receiver.sms.presentation.components.custom_toast.CustomToast
import com.receiver.sms.utils.resources.AppColors
import com.receiver.sms.utils.theme.AppTheme

@Composable
fun MainScreen(
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    mainVM: MainViewModel = hiltViewModel(),
    ) {
    val navController = rememberNavController()
    val toaster = rememberToasterState()
    val toastMsgModel = mainVM.toastMsgModel.collectAsState().value

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { source, event ->
            when (event) {
                Lifecycle.Event.ON_CREATE -> {

                }

                Lifecycle.Event.ON_RESUME -> {

                }

                Lifecycle.Event.ON_DESTROY -> {

                }

                else -> {
                    // do nothing
                }
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    LaunchedEffect(toastMsgModel) {
        if (toastMsgModel != null) {
            toaster.show(toastMsgModel.msg, type = toastMsgModel.type)
            mainVM.clearToast()
        }
    }

    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = AppColors.surface
        ) {
            CustomToast(state = toaster)
            NavGraph(
                navController = navController,
                mainVM = mainVM
            )
        }
    }
}