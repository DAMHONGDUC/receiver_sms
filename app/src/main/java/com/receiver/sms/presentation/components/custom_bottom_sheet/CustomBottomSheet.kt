package com.receiver.sms.presentation.components.custom_bottom_sheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.receiver.sms.utils.resources.AppBoxModel
import com.receiver.sms.utils.resources.AppColors

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun CustomBottomSheet(
    body: @Composable () -> Unit,
    sheetContent: @Composable () -> Unit,
    sheetState: ModalBottomSheetState
) {
    ModalBottomSheetLayout(
        sheetShape = RoundedCornerShape(
            topEnd = 20.dp,
            topStart = 20.dp,
        ),
        sheetState = sheetState,
        sheetContent = {
            Column(
                modifier = Modifier
                    .padding(AppBoxModel().mainPadding()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(width = 40.dp, height = 7.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(color = AppColors.topControl)
                )
                sheetContent()
            }
        },
        content = { body() }
    )
}