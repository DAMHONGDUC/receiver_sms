package com.receiver.sms.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.receiver.sms.presentation.components.spacing.VerticalSpacing
import com.receiver.sms.utils.resources.AppBoxModel
import com.receiver.sms.utils.resources.AppColors
import com.receiver.sms.utils.resources.AppTextStyle

@Composable
fun AppTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    modifier: Modifier = Modifier,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    errorMessage: String? = null,
    borderRadius: Dp = 12.dp,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onNext: (() -> Unit)? = null
) {
    val mainTextStyle: TextStyle = AppTextStyle().base
    val modifierBorder: Modifier = if (isError) Modifier.border(
        width = 1.dp,
        color = AppColors.error,
        shape = RoundedCornerShape(borderRadius)
    ) else Modifier

    Column(modifier = modifier) {
        Box(
            modifier = modifierBorder
                .fillMaxWidth()
                .background(AppColors.textFieldBG, shape = RoundedCornerShape(borderRadius))
                .padding(AppBoxModel().mainPadding())
        ) {
            BasicTextField(
                modifier = Modifier.fillMaxWidth(),
                value = value,
                onValueChange = onValueChange,
                textStyle = mainTextStyle,
                decorationBox = { innerTextField ->
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            style = mainTextStyle
                        )
                    }
                    innerTextField()
                },
                keyboardOptions = keyboardOptions.copy(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { onNext?.invoke() }
                )
            )
        }
        if (isError && !errorMessage.isNullOrEmpty()) {
            Text(
                text = errorMessage,
                color = AppColors.error,
                style = AppTextStyle().small,
                modifier = Modifier.padding(start = 4.dp, top = 4.dp)
            )
        }
        VerticalSpacing(value = AppBoxModel().spacing() * 2)
    }
}
