package com.receiver.sms.data.repositories_impl

import com.receiver.sms.data.data_source.remote.APIService
import com.receiver.sms.domain.model.SMSObserveModel
import com.receiver.sms.domain.repositories.SubmitSMSRepository
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

private val LOG_TAG = "APIRepositoryLOG"

class SubmitSMSRepositoryImpl @Inject constructor(
    private val apiService: APIService,
) : SubmitSMSRepository {
    override suspend fun callAPIAfterReceiveSMS(smsObserveModel: SMSObserveModel): Response<ResponseBody> {
        // call API
        val requestBody = mapOf(
            "data" to smsObserveModel.body,
        )
        return apiService.dynamicPost(fullUrl = smsObserveModel.endpoint, body = requestBody)
    }
}