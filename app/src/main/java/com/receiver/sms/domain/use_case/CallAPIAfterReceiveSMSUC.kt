package com.receiver.sms.domain.use_case

import com.receiver.sms.data.repositories_impl.SMSObserveRepositoryImpl
import com.receiver.sms.data.repositories_impl.SubmitSMSRepositoryImpl
import com.receiver.sms.domain.model.ReceiverSMSModel
import com.receiver.sms.domain.model.SMSObserveModel
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

private val LOG_TAG = "CallAPIAfterReceiveSMSUCLOG"

class CallAPIAfterReceiveSMSUC(
    private val smsObserveRepository: SMSObserveRepositoryImpl,
    private val submitSMSRepository: SubmitSMSRepositoryImpl
) {
    suspend operator fun invoke(receiverSMSModel: ReceiverSMSModel): Result<Unit> {
        return try {
            val listSMSObserveBySender: List<SMSObserveModel> =
                smsObserveRepository.getAllSMSObserveBySender(receiverSMSModel.sender)

            coroutineScope {
                listSMSObserveBySender.map { smsObserveModel ->
                    async {
                        val response = submitSMSRepository.callAPIAfterReceiveSMS(smsObserveModel)

                        if (response.isSuccessful) {
                            // Extract and log the details
                            val statusCode =
                                response.code()
                            val responseHeaders =
                                response.headers().toMultimap()
                            val responseBody = response.body()
                                ?.string()
                            val requestUrl =
                                response.raw().request.url.toString()
                            val requestHeaders =
                                response.raw().request.headers.toMultimap()
                            val queryParamsSent =
                                response.raw().request.url.query
                            // Log or handle the extracted information
                            println("Status Code: $statusCode")
                            println("Request URL: $requestUrl")
                            println("Query Params: $queryParamsSent")
                            println("Request Headers: $requestHeaders")
                            println("Response Headers: $responseHeaders")
                            println("Response Body: $responseBody")
                        } else {
                            println("Error: ${response.code()} - ${response.message()}")
                        }
                    }
                }.awaitAll()
            }

            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}