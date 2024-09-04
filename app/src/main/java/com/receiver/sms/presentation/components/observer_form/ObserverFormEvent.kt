package com.receiver.sms.presentation.components.observer_form

data class ObserverFormState(
    val observerSender: String = "",
    val body: String = "",
    val endPoint: String = "",
    val header: String? = null,
    val params: String? = null,
    // error
    val observerSenderError: String? = null,
    val bodyError: String? = null,
)
