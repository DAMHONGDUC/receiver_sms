package com.receiver.sms.data.data_source.remote

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.POST
import retrofit2.http.QueryMap
import retrofit2.http.Url

interface ApiService {
    @GET
    suspend fun dynamicGet(
        @Url fullUrl: String,
        @QueryMap queryParams: Map<String, String> = emptyMap(),
        @HeaderMap headers: Map<String, String> = emptyMap()
    ): Response<Any>

    // Dynamic POST request with the full URL
    @POST
    suspend fun dynamicPost(
        @Url fullUrl: String,
        @HeaderMap headers: Map<String, String> = emptyMap(),
        @Body body: Any
    ): Response<Any>
}
