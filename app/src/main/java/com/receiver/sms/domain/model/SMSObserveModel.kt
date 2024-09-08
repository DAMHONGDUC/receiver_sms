package com.receiver.sms.domain.model

data class SMSObserveModel(
    val id: Int,
    val sender: String,
    val endpoint: String,
    val body: String,
    val header: String,
)