package com.receiver.sms.presentation.screens.home.components

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.receiver.sms.presentation.components.custom_bottom_sheet.CustomBottomSheet
import com.receiver.sms.presentation.components.spacing.VerticalSpacing
import com.receiver.sms.utils.resources.AppColors
import com.receiver.sms.utils.resources.AppTextStyle
import kotlinx.coroutines.launch

private val LOG_TAG = "RequestSMSPermissionModalLOG"

@OptIn(ExperimentalMaterialApi::class, ExperimentalPermissionsApi::class)
@Composable
fun RequestSMSPermissionModal(content: @Composable () -> Unit) {
    val sheetState =
        rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val smsReceiverPermissionState = rememberPermissionState(
        android.Manifest.permission.RECEIVE_SMS
    )
    val scope = rememberCoroutineScope()

    suspend fun requestSMSReceiverPermission() {
        sheetState.hide()
        smsReceiverPermissionState.launchPermissionRequest()
    }

    LaunchedEffect(Unit) {
        if (!smsReceiverPermissionState.status.isGranted) {
            sheetState.show()
        }
    }



    CustomBottomSheet(
        sheetState = sheetState,
        body = { content() },
        sheetContent = {
            VerticalSpacing()
            Text(
                text = "strings.permission.overlayPermission",
                style = AppTextStyle().base
            )
            VerticalSpacing(value = 5.dp)
            Button(
                onClick = {
                    scope.launch {
                        requestSMSReceiverPermission()
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = AppColors.primary)
            ) {
                Text(
                    " strings.permission.openSetting",
                    style = AppTextStyle().base.copy(color = AppColors.white)
                )
            }
        },
    )
}
