package com.receiver.sms.presentation.screens.main

import androidx.lifecycle.ViewModel
import com.receiver.sms.domain.model.ToastMsgModel
import com.receiver.sms.domain.use_case.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val useCase: UseCase
) : ViewModel() {
    private val _toastMsgModel = MutableStateFlow<ToastMsgModel?>(null)
    val toastMsgModel: StateFlow<ToastMsgModel?> = _toastMsgModel

    fun setToast(toastMsgModel: ToastMsgModel) {
        _toastMsgModel.value = toastMsgModel
    }

    fun clearToast() {
        _toastMsgModel.value = null
    }
}