package com.receiver.sms.data.data_source.remote

import retrofit2.http.POST

interface APIService {
    @POST("")
    suspend fun callAPIAfterReceiveSMS()
}