package com.receiver.sms.domain.use_case

data class UseCase(
    val insertReceiverSMS: InsertReceiverSMSUseCase,
    val getReceiverSMS: GetReceiverSMSUseCase,
)

