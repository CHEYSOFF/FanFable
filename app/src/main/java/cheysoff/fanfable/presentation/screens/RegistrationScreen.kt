package cheysoff.fanfable.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cheysoff.fanfable.R
import cheysoff.fanfable.presentation.screens.components.ThreePartsScreen
import cheysoff.fanfable.presentation.screens.theme.HaveAccountLogInTextStyle
import cheysoff.fanfable.presentation.screens.theme.HaveAccountTextStyle
import cheysoff.fanfable.presentation.screens.theme.LoginFieldColor
import cheysoff.fanfable.presentation.screens.theme.LoginFieldPlaceHolderTextStyle
import cheysoff.fanfable.presentation.screens.theme.LoginFieldTextStyle
import cheysoff.fanfable.presentation.screens.theme.ScreenElementsColor
import cheysoff.fanfable.presentation.screens.theme.WelcomeScreenHeaderTextStyle

@Preview
@Composable
fun RegistrationScreen() {
    var enteredEmail = ""
    var enteredPassword = ""
    ThreePartsScreen(topComposable = {
        Text(
            text = "HI !", style = WelcomeScreenHeaderTextStyle
        )
    }, midComposable = {
        Column(
            modifier = Modifier
                .padding(top = 54.dp)
                .fillMaxHeight()
                .fillMaxWidth(0.8f),
            horizontalAlignment = Alignment.Start,
        ) {
            BasicTextField({ email -> enteredEmail = email }, TextFieldType.Email)

            Surface(modifier = Modifier.padding(top = 18.dp)) {
                BasicTextField({ password -> enteredPassword = password }, TextFieldType.Password)
            }


            Row(modifier = Modifier.padding(top = 11.dp, start = 10.dp).clickable {  }) {
                Text(text = "Already have an account? ", style = HaveAccountTextStyle)
                Text(text = "Log in", style = HaveAccountLogInTextStyle)
            }
        }
    }, bottomComposable = {})
}

@Composable
fun BasicTextField(onValueChange: (String) -> Unit, textFieldType: TextFieldType) {
    var value by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,

        onValueChange = {
            value = it
            onValueChange(value)
        },
        singleLine = true,

        placeholder = {
            Text(
                text = when (textFieldType) {
                    TextFieldType.Email -> "E-mail"
                    TextFieldType.Password -> "Password (0-9, Aa)"
                }, style = LoginFieldPlaceHolderTextStyle
            )
        },

        keyboardOptions = KeyboardOptions(
            keyboardType = when (textFieldType) {
                TextFieldType.Email -> KeyboardType.Email
                TextFieldType.Password -> KeyboardType.Password
            }
        ),

        textStyle = LoginFieldTextStyle,

        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            focusedContainerColor = LoginFieldColor,
            unfocusedContainerColor = LoginFieldColor
        ),

        shape = RoundedCornerShape(12.dp),

        visualTransformation =
        when (textFieldType) {
            TextFieldType.Password ->
                if (passwordVisible) VisualTransformation.None
                else PasswordVisualTransformation(
                    '\u25CF'
                )

            TextFieldType.Email -> VisualTransformation.None
        },

        trailingIcon = {
            when (textFieldType) {
                TextFieldType.Password -> {
                    val image = if (passwordVisible) R.drawable.dont_show_password_icon
                    else R.drawable.dont_show_password_icon

                    val description = if (passwordVisible) "Hide password" else "Show password"

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = painterResource(id = image),
                            contentDescription = description,
                            tint = ScreenElementsColor
                        )
                    }
                }

                TextFieldType.Email -> {}
            }
        }
    )
}

enum class TextFieldType {
    Email,
    Password
}