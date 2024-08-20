package com.receiver.sms.domain.model

data class ObserveSMSModel(
    val id: Int,
    val sender: String,
    val message: String,
    val body: String,
    val header: String,
)