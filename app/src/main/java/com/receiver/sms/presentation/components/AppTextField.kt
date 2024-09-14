package com.receiver.sms.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.receiver.sms.presentation.components.spacing.HorizontalSpacing
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
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    errorMessage: String? = null,
    borderRadius: Dp = 12.dp,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onNext: (() -> Unit)? = null,
    title: String? = null
) {
    val mainTextStyle: TextStyle = AppTextStyle().base
    val focusRequester = remember { FocusRequester() }
    val interactionSource = remember { MutableInteractionSource() }

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(
                    indication = null,
                    interactionSource = interactionSource,
                    onClick = { focusRequester.requestFocus() }
                )
                .border(
                    width = 1.dp,
                    color = if (isError) AppColors.error else AppColors.border,
                    shape = RoundedCornerShape(borderRadius)
                )
                .background(AppColors.textFieldBG, shape = RoundedCornerShape(borderRadius))
                .padding(
                    AppBoxModel().mainPadding(),
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // leading icon
            if (leadingIcon != null) {
                leadingIcon.invoke()
                HorizontalSpacing(value = 4.dp)
            }

            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                if (title != null) {
                    Text(
                        text = title,
                        style = AppTextStyle().small.copy(
                            fontWeight = FontWeight.Normal,
                            color = AppColors.subTextColor
                        )
                    )
                    VerticalSpacing(value = AppBoxModel().haftMainPadding())
                }

                BasicTextField(
                    modifier = Modifier
                        .focusRequester(focusRequester), // Attach focusRequester
                    value = value,
                    onValueChange = onValueChange,
                    textStyle = mainTextStyle,
                    decorationBox = { innerTextField ->
                        if (value.isEmpty()) {
                            Text(
                                text = placeholder,
                                style = mainTextStyle.copy(color = AppColors.textFieldPH)
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
            // clear icon
            if (value.isNotEmpty()) {
                Pressable(
                    onClick = { onValueChange("") }
                ) {
                    Box(
                        modifier = Modifier
                            .size(AppIconSize().small())
                            .clip(RoundedCornerShape(50))
                            .background(AppColors.gray)
                            .padding(2.5.dp),
                    )
                    {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Clear text",
                            tint = AppColors.white,
                            modifier = Modifier.size(AppIconSize().base())
                        )
                    }
                }
                Spacer(modifier = Modifier.width(5.dp))
            }
            // trailing icon
            if (trailingIcon != null) {
                HorizontalSpacing(value = 4.dp)
                trailingIcon.invoke()
            }
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


