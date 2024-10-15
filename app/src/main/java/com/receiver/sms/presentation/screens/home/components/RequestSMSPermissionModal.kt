package com.receiver.sms.presentation.screens.home.components

import android.Manifest
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import com.receiver.sms.presentation.components.CustomBottomSheet
import com.receiver.sms.presentation.components.spacing.VerticalSpacing
import com.receiver.sms.utils.PermissionController
import com.receiver.sms.core.resources.AppColors
import com.receiver.sms.core.resources.AppTextStyle
import kotlinx.coroutines.launch

private val LOG_TAG = "RequestSMSPermissionModalLOG"

@OptIn(ExperimentalMaterialApi::class, ExperimentalPermissionsApi::class)
@Composable
fun RequestSMSPermissionModal(content: @Composable () -> Unit) {
    val sheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val smsReceiverPermissionState =
        rememberPermissionState(Manifest.permission.RECEIVE_SMS)
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    suspend fun requestSMSReceiverPermission() {
        sheetState.hide()
        PermissionController.requestSMSReceiverPermission(context)
    }

    LaunchedEffect(smsReceiverPermissionState.status) {
        if (!PermissionController.checkSMSReceiverIsGrant(context)) {
            sheetState.show()
        }
    }

    CustomBottomSheet(
        sheetState = sheetState,
        body = { content() },
        sheetContent = {
            Column {
                VerticalSpacing()
                Text(
                    text = "The SMS receiver call API app needs access to SMS receiver permission to retrieve SMS information.",
                    style = AppTextStyle().base
                )
                VerticalSpacing(value = 5.dp)
                Button(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    onClick = {
                        scope.launch {
                            requestSMSReceiverPermission()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = AppColors.primary)
                ) {
                    Text(
                        "Accept",
                        style = AppTextStyle().base.copy(color = AppColors.white)
                    )
                }
            }
        },
    )
}

