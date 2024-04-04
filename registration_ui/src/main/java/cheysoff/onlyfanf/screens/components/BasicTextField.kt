package cheysoff.onlyfanf.screens.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import cheysoff.onlyfanf.design_system.R
import cheysoff.onlyfanf.design_system.theme.LocalCustomColorScheme
import cheysoff.onlyfanf.design_system.theme.LoginFieldPlaceHolderTextStyle
import cheysoff.onlyfanf.design_system.theme.LoginFieldTextStyle


@Composable
fun BasicTextField(text: String, onValueChange: (String) -> Unit, textFieldType: TextFieldType) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,

        onValueChange = { newText ->
            onValueChange(newText)
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
            focusedContainerColor = LocalCustomColorScheme.current.loginFieldColor,
            unfocusedContainerColor = LocalCustomColorScheme.current.loginFieldColor
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
                    val image = if (passwordVisible) R.drawable.show_password_icon
                    else R.drawable.dont_show_password_icon

                    val description =
                        if (passwordVisible) "Hide password" else "Show password"

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = painterResource(id = image),
                            contentDescription = description,
                            tint = LocalCustomColorScheme.current.screenElementsColor
                        )
                    }
                }

                TextFieldType.Email -> {}
            }
        }
    )
}
