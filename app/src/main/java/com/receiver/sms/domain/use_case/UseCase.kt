package com.receiver.sms.domain.use_case

data class UseCase(
    val insertSMSObserveUC: InsertSMSObserveUseCase,
    val getAllSMSObserveUC: GetAllSMSObserveUseCase,
    val callAPIAfterReceiveSMSUC: CallAPIAfterReceiveSMSUseCase,
    val insertReceiverSMSUC: InsertReceiverSMSUseCase,
    val getReceiverSMSUC: GetReceiverSMSUseCase,
)

