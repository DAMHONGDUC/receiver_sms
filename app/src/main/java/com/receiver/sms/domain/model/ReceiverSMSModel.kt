package com.receiver.sms.domain.model

data class ReceiverSMSModel(
    val sender: String,
    val body: String,
    val timestamp: String
)