package com.receiver.sms.domain.repositories

import com.receiver.sms.domain.model.SMSObserveModel
import okhttp3.ResponseBody
import retrofit2.Response

interface SubmitSMSRepository {
    suspend fun callAPIAfterReceiveSMS(smsObserveModel: SMSObserveModel): Response<ResponseBody>

}