package com.receiver.sms.data.repository

import com.receiver.sms.data.data_source.remote.APIService
import com.receiver.sms.data.data_source.remote.IAPIDataSource
import com.receiver.sms.domain.model.SMSObserveModel
import javax.inject.Inject

class APIRepository @Inject constructor(
    private val apiService: APIService,
) : IAPIDataSource {
    override suspend fun callAPIAfterReceiveSMS(smsObserveModel: SMSObserveModel) {
        apiService.callAPIAfterReceiveSMS()
    }
}