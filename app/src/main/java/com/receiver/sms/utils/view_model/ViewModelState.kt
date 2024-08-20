package com.receiver.sms.utils.view_model

sealed class ViewModelState<out T> {
    object Empty : ViewModelState<Nothing>()
    object Loading : ViewModelState<Nothing>()
    class Success<out T>(val data: T) : ViewModelState<T>()
    class Error(val message: String) : ViewModelState<Nothing>()
}