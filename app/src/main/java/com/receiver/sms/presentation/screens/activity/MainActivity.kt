package com.receiver.sms.presentation.screens.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.receiver.sms.presentation.screens.main.MainScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
//    private lateinit var smsReceiver: SmsReceiver
//    private val SMS_PERMISSIONS_REQUEST_CODE = 1
//    private val PERMISSIONS_STORAGE = arrayOf<String>(
//        Manifest.permission.READ_SMS,
//        Manifest.permission.RECEIVE_SMS,
//    )
    //    @Inject
//    lateinit var useCase: UseCase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        // register receiver
//        registerSMSReceiver()
        setContent {
            MainScreen()
        }
    }
    //    private fun requestSmsPermissions() {
//        if (ContextCompat.checkSelfPermission(
//                this,
//                Manifest.permission.RECEIVE_SMS
//            ) != PackageManager.PERMISSION_GRANTED ||
//            ContextCompat.checkSelfPermission(
//                this,
//                Manifest.permission.READ_SMS
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            ActivityCompat.requestPermissions(
//                this,
//                PERMISSIONS_STORAGE,
//                SMS_PERMISSIONS_REQUEST_CODE
//            )
//        } else {
//            // Permissions already granted, you can proceed with your SMS-related functionality
//        }
//    }
//    private fun registerSMSReceiver() {
//        smsReceiver = SmsReceiver()
//
//        ContextCompat.registerReceiver(
//            this,
//            smsReceiver,
//            IntentFilter().apply {
//                "SmsMessage.intent.MAIN"
//            },
//            ContextCompat.RECEIVER_NOT_EXPORTED
//        )
//    }
//
//    override fun onDestroy() {
//        unregisterReceiver(smsReceiver)
//        super.onDestroy()
//    }
}

