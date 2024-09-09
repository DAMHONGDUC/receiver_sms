package com.receiver.sms.domain.use_case

data class UseCase(
    val insertSMSObserveUC: InsertSMSObserveUC,
    val getAllSMSObserveUC: GetAllSMSObserveUC,
    val callAPIAfterReceiveSMSUC: CallAPIAfterReceiveSMSUC,
    val getAllSMSObserveBySenderUC: GetAllSMSObserveBySenderUC,
)

