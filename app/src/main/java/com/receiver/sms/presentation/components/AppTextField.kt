package com.receiver.sms.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.receiver.sms.presentation.components.spacing.VerticalSpacing
import com.receiver.sms.utils.resources.AppBoxModel
import com.receiver.sms.utils.resources.AppColors
import com.receiver.sms.utils.resources.AppIconSize
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
    shape: Shape = RoundedCornerShape(10.dp),
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onNext: (() -> Unit)? = null
) {
    val mainTextStyle: TextStyle = AppTextStyle().base

    Column(modifier = modifier) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = mainTextStyle,
            placeholder = {
                Text(
                    text = placeholder,
                )
            },
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon ?: {
                if (value.isNotEmpty()) {
                    IconButton(
                        onClick = { onValueChange("") }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Clear",
                            modifier = Modifier.size(AppIconSize().small())
                        )
                    }
                }
            },
            isError = isError,
            shape = shape,
            modifier = Modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = AppColors.gray,
                unfocusedBorderColor = AppColors.gray,
                errorBorderColor = AppColors.error,
            ),
            keyboardOptions = keyboardOptions.copy(
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    onNext?.invoke()
                }
            )
        )
        if (isError && !errorMessage.isNullOrEmpty()) {
            Text(
                text = errorMessage,
                color = AppColors.error,
                style = AppTextStyle().small,
                modifier = Modifier.padding(start = 4.dp, top = 4.dp)
            )
            VerticalSpacing()
        } else {
            VerticalSpacing(value = AppBoxModel().spacing() * 2)
        }
    }
}
