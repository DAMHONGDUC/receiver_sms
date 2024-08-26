package com.receiver.sms.data.data_source.remote

import com.receiver.sms.domain.model.ReceiverSMSModel

interface IAPIDataSource {
    suspend fun callAPIAfterReceiveSMS(receiverSMSModel: ReceiverSMSModel)

}