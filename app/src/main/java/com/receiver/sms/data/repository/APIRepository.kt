package com.receiver.sms.data.repository

import com.receiver.sms.data.data_source.remote.APIService
import com.receiver.sms.data.data_source.remote.IAPIDataSource
import com.receiver.sms.domain.model.ReceiverSMSModel
import javax.inject.Inject

private val LOG_TAG = "APIRepositoryLOG"

class APIRepository @Inject constructor(
    private val apiService: APIService,
) : IAPIDataSource {
    override suspend fun callAPIAfterReceiveSMS(receiverSMSModel: ReceiverSMSModel) {
//        apiService.callAPIAfterReceiveSMS()
    }
}