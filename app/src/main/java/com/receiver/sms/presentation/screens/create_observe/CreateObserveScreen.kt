package com.receiver.sms.presentation.screens.create_observe

import android.os.Build
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import cafe.adriel.lyricist.LocalStrings
import com.receiver.sms.core.resources.AppBoxModel
import com.receiver.sms.core.resources.AppColors
import com.receiver.sms.core.resources.AppIconSize
import com.receiver.sms.core.resources.AppTextStyle
import com.receiver.sms.presentation.components.CustomScrollView
import com.receiver.sms.presentation.components.button.PrimaryButton
import com.receiver.sms.presentation.components.observer_form.ObserverForm
import com.receiver.sms.presentation.components.spacing.HorizontalSpacing

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CreateObserveScreen(
    createObserverVM: CreateObserveViewModel = hiltViewModel(),
    onBack: () -> Unit
) {
    val tr = LocalStrings.current

    BackHandler {
        onBack()
    }

    Scaffold(
        containerColor = AppColors.mainBG,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = AppColors.mainBG
                ),
                title = {
                    Text(text = "Create Observer", style = AppTextStyle().base)
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            modifier = Modifier
                                .size(AppIconSize.base),
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "backIcon",
                            tint = AppColors.iconColor
                        )
                    }
                },
                actions = {
                    PrimaryButton(
                        contentPadding = 2.dp,
                        onClick = {
                            createObserverVM.onSubmit(
                                onSuccess = {
                                    onBack()
                                },
                                showResult = { toastMsgModel ->
//                        mainVM.setToast(toastMsgModel)
                                }
                            )
                        },
                        text = tr.common.create
                    )
                    HorizontalSpacing()
                }
            )
        },
        content = { padding ->
            CustomScrollView(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(padding)
                    .padding(AppBoxModel.padding),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ObserverForm(state = createObserverVM.state, createObserverVM = createObserverVM)
            }
        }
    )

}


