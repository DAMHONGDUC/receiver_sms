package com.receiver.sms.domain.model

import java.time.ZonedDateTime

data class SMSObserveModel(
    val id: Int,
    val sender: String,
    val endpoint: String,
    val body: String,
    val header: String,
    val createdAt: ZonedDateTime,
    val updatedAt: ZonedDateTime,
)