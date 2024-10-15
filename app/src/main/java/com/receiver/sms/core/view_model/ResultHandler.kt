package com.receiver.sms.core.view_model

import retrofit2.HttpException
import java.io.IOException

class ResultHandler {
    suspend fun <T> execute(
        action: suspend () -> T
    ): ViewModelState<T> {
        return try {
            val result = action()
            ViewModelState.Success(result)
        } catch (e: HttpException) {
            ViewModelState.Error("Internet issue: ${e.message()}")
        } catch (e: IOException) {
            ViewModelState.Error("I/O issue: ${e.message}")
        } catch (e: Exception) {
            ViewModelState.Error("Unexpected error: ${e.message}")
        }
    }
}
