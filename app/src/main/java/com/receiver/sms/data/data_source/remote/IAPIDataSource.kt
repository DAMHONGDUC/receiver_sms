package com.receiver.sms.data.data_source.remote

import com.receiver.sms.domain.model.SMSObserveModel

interface IAPIDataSource {
    suspend fun callAPIAfterReceiveSMS(smsObserveModel: SMSObserveModel)

}