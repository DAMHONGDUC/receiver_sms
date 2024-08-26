package com.receiver.sms.domain.model

data class ReceiverSMSModel(
    val id: String,
    val sender: String,
    val body: String,
)