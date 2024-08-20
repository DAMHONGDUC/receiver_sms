package com.receiver.sms.domain.use_case

data class UseCase(
    val insertObserveSMS: InsertObserveSMSUseCase,
    val getAllObserveSMS: GetAllObserveSMSUseCase,
)

