package com.receiver.sms.core.translations

data class CommonStrings(
    val create: String,
)

data class PermissionStrings(
    val smsPermission: String,
    val openSetting: String,
)

data class ObserveFormStrings(
    val observedPhoneNumberTitle: String,
    val observedPhoneNumberHint: String,
    val endpointTitle: String,
    val endpointHint: String,
    val bodyTitle: String,
    val bodyHint: String,
)

data class CreateObserveScreen(
    val title: String,
)

data class Strings(
    val common: CommonStrings,
    val permission: PermissionStrings,
    val observeForm: ObserveFormStrings,
    val createObserveScreen: CreateObserveScreen,
)
