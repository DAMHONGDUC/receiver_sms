//package com.receiver.sms.presentation.components.app
//
//import androidx.compose.foundation.layout.RowScope
//import androidx.compose.foundation.layout.size
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.automirrored.filled.ArrowBack
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBar
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.unit.Dp
//import androidx.compose.ui.unit.dp
//import com.receiver.sms.core.resources.AppColors
//import com.receiver.sms.core.resources.AppIconSize
//import com.receiver.sms.core.resources.AppTextStyle
//
//@Composable
//fun CustomTopBar(
//    onBack: () -> Unit = {},
//    enableBack: Boolean = true,
//    title: String,
//    bg: Color = AppColors.primary,
//    mainColor: Color = AppColors.white,
//    elevation: Dp = 5.dp,
//    textStyle: TextStyle = AppTextStyle().xLarge,
//    topBarAction: @Composable() (RowScope.() -> Unit) = {}
//) {
//    TopAppBar(
//        colors = bg,
//        navigationIcon = if (enableBack) {
//            {
//                IconButton(onClick = onBack) {
//                    Icon(
//                        modifier = Modifier
//                            .size(AppIconSize.base),
//                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
//                        contentDescription = "backIcon",
//                        tint = mainColor
//                    )
//                }
//            }
//        } else null,
//        elevation = elevation,
//        title = {
//            Text(
//                title,
//                style = textStyle.copy(
//                    color = mainColor
//                )
//            )
//        },
//        actions = topBarAction
//    )
//}