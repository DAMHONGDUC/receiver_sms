package com.receiver.sms

import android.Manifest
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.compose.rememberNavController
import com.receiver.sms.navigation.NavGraph
import com.receiver.sms.utils.resources.AppColors
import com.receiver.sms.utils.theme.AppTheme

class MainActivity : ComponentActivity() {
    private lateinit var smsReceiver: SmsReceiver
    private val SMS_PERMISSIONS_REQUEST_CODE = 1
    private val PERMISSIONS_STORAGE = arrayOf<String>(
        Manifest.permission.READ_SMS,
        Manifest.permission.RECEIVE_SMS,
    )

    override fun onResume() {
        super.onResume()
        requestSmsPermissions()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // register receiver
        registerSMSReceiver()

        setContent {
            val navController = rememberNavController()
            AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = AppColors.surface
                ) {
                    NavGraph(navController = navController)
                }
            }
        }
    }

    private fun requestSmsPermissions() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.RECEIVE_SMS
            ) != PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_SMS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                PERMISSIONS_STORAGE,
                SMS_PERMISSIONS_REQUEST_CODE
            )
        } else {
            // Permissions already granted, you can proceed with your SMS-related functionality
        }
    }

    private fun registerSMSReceiver() {
        smsReceiver = SmsReceiver()

        ContextCompat.registerReceiver(
            this,
            smsReceiver,
            IntentFilter().apply {
                "SmsMessage.intent.MAIN"
            },
            ContextCompat.RECEIVER_NOT_EXPORTED
        )
    }

    override fun onDestroy() {
        unregisterReceiver(smsReceiver)
        super.onDestroy()
    }

}

