package com.receiver.sms.presentation.screens.create_observer

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.receiver.sms.presentation.screens.main.MainViewModel
import tech.devscast.validable.EmailValidable
import tech.devscast.validable.core.rememberValidator

@Composable
fun CreateObserverScreen(mainVM: MainViewModel) {
    val emailField = remember { EmailValidable("aaaaaa") }
    // pass all fields to the withValidable method
    val validator = rememberValidator(emailField)
    val context = LocalContext.current

    Column {
        TextField(
            value = emailField.value,
            onValueChange = { emailField.value = it }, // update the text
            isError = emailField.hasError(), // check if the field is not valid
        )

        AnimatedVisibility(visible = emailField.hasError()) {
            Text(
                text = emailField.errorMessage ?: "",
                modifier = Modifier.fillMaxWidth(),
                style = LocalTextStyle.current.copy(color = MaterialTheme.colors.error)
            )
        }

        Button(
            // a state to check if all fields are valid, without submitting the form
            enabled = validator.isValid,
            onClick = {
                validator.validate {
                    // will be executed if all fields are valid
                    Toast.makeText(context, "All fields are valid", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        ) {
            Text(text = "Submit")
        }
    }

}


