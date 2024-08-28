package com.receiver.sms.presentation.screens.main

import android.content.BroadcastReceiver
import android.content.IntentFilter
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.compose.rememberNavController
import com.dokar.sonner.rememberToasterState
import com.receiver.sms.navigation.NavGraph
import com.receiver.sms.presentation.components.CustomToast
import com.receiver.sms.utils.AppConstants
import com.receiver.sms.utils.receiver.SmsReceiver
import com.receiver.sms.utils.resources.AppColors
import com.receiver.sms.utils.theme.AppTheme
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun MainScreen(
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    mainVM: MainViewModel = hiltViewModel(),
) {
    val navController = rememberNavController()
    val context = LocalContext.current
    val toaster = rememberToasterState()
    val toastMsgModel = mainVM.toastMsgModel.collectAsState().value
    lateinit var smsReceiver: BroadcastReceiver

    fun registerSMSReceiver() {
        smsReceiver = SmsReceiver()

        ContextCompat.registerReceiver(
            context,
            smsReceiver,
            IntentFilter().apply {
                AppConstants.SMS_INTENT
            },
            ContextCompat.RECEIVER_NOT_EXPORTED
        )
    }

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { source, event ->
            when (event) {
                Lifecycle.Event.ON_CREATE -> {
                    registerSMSReceiver()
                }

                Lifecycle.Event.ON_DESTROY -> {
                    context.unregisterReceiver(smsReceiver)
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
            toaster.show(toastMsgModel.msg, type = toastMsgModel.type, duration = 2000.milliseconds)
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