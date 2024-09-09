package com.receiver.sms.data.data_source.remote

import com.receiver.sms.domain.model.SMSObserveModel
import com.receiver.sms.utils.EndPoint
import retrofit2.http.POST

interface APIService {
    @POST(EndPoint.PRODUCTS)
    suspend fun callAPIAfterReceiveSMS(smsObserveModel: SMSObserveModel)
}