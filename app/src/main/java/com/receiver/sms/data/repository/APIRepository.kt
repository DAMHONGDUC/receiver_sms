package com.receiver.sms.data.repository

import com.receiver.sms.data.data_source.remote.ApiService
import com.receiver.sms.data.data_source.remote.IAPIDataSource
import com.receiver.sms.domain.model.SMSObserveModel
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

private val LOG_TAG = "APIRepositoryLOG"

class APIRepository @Inject constructor(
) : IAPIDataSource {
    override suspend fun callAPIAfterReceiveSMS(smsObserveModel: SMSObserveModel): Response<ResponseBody> {
        val apiService = RetrofitInstance.create()
        // call API
        val requestBody = mapOf(
            "data" to smsObserveModel.body,
        )
        return apiService.dynamicPost(fullUrl = smsObserveModel.endpoint, body = requestBody)
    }
}

object RetrofitInstance {
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    fun create(): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://placeholder.com") // This is required but will be overridden
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ApiService::class.java)
    }
}