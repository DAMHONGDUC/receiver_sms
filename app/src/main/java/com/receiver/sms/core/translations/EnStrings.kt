package warehouse.barcode.app.utils.translations

import cafe.adriel.lyricist.LyricistStrings
import com.receiver.sms.core.translations.CommonStrings
import com.receiver.sms.core.translations.CreateObserveScreen
import com.receiver.sms.core.translations.ObserveFormStrings
import com.receiver.sms.core.translations.PermissionStrings
import com.receiver.sms.core.translations.Strings

@LyricistStrings(languageTag = Locales.EN, default = true)
internal val EnStrings = Strings(
    common = CommonStrings(create = "Create"),
    permission = PermissionStrings(
        smsPermission = "App needs access to SMS receiver permission to retrieve SMS information.",
        openSetting = "Open Setting"
    ),
    observeForm = ObserveFormStrings(
        observedPhoneNumberTitle = "Observed phone number",
        observedPhoneNumberHint = "Enter observed phone number",
        endpointTitle = "Endpoint",
        endpointHint = "Enter your endpoint", bodyTitle = "Body",
        bodyHint = "Enter your body"
    ),
    createObserveScreen = CreateObserveScreen(title = "Create SMS Observe")
)
