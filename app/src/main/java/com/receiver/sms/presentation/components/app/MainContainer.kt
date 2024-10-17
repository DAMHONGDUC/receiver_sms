//package com.receiver.sms.presentation.components.app
//
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Scaffold
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.Dp
//import com.receiver.sms.core.resources.AppBoxModel
//import com.receiver.sms.core.resources.AppColors
//
//@Composable
//fun MainContainer(
//    paddingHorizontal: Dp = AppBoxModel.padding,
//    paddingVertical: Dp = AppBoxModel.padding,
//    topBarTitle: String = "",
//    onBack: () -> Unit = {},
//    enableBack: Boolean = true,
//    customTopBar: @Composable() (() -> Unit)? = null,
//    content: @Composable () -> Unit,
//) {
//    Scaffold(
//        backgroundColor = AppColors.background,
//        modifier = Modifier.fillMaxSize(),
//        topBar = customTopBar ?: {
//            CustomTopBar(
//                bg = AppColors.background,
//                mainColor = AppColors.mainContent,
//                title = topBarTitle,
//                onBack = onBack,
//                enableBack = enableBack
//            )
//        }) { padding ->
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(padding)
//                .padding(horizontal = paddingHorizontal, vertical = paddingVertical)
//        ) {
//            content()
//        }
//    }
//}
//
//
