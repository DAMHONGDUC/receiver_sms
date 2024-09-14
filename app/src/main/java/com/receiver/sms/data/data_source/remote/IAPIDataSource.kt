package com.receiver.sms.data.data_source.remote

import com.receiver.sms.domain.model.SMSObserveModel
import okhttp3.ResponseBody
import retrofit2.Response

interface IAPIDataSource {
    suspend fun callAPIAfterReceiveSMS(smsObserveModel: SMSObserveModel): Response<ResponseBody>

}