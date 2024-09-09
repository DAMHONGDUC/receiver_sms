package com.receiver.sms.data.repository

import android.util.Log
import com.receiver.sms.data.data_source.remote.IAPIDataSource
import com.receiver.sms.domain.model.SMSObserveModel
import javax.inject.Inject

private val LOG_TAG = "APIRepositoryLOG"

class APIRepository @Inject constructor(
) : IAPIDataSource {
    override suspend fun callAPIAfterReceiveSMS(smsObserveModel: SMSObserveModel) {
        Log.d(LOG_TAG, smsObserveModel.toString())
//        apiService.callAPIAfterReceiveSMS(smsObserveModel)
    }
}