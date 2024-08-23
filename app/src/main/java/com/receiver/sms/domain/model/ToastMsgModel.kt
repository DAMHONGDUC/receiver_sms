package com.receiver.sms.domain.model

import com.dokar.sonner.ToastType

data class ToastMsgModel
    (
    val msg: String,
    val type: ToastType
)