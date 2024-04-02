package cheysoff.onlyfanf.presentation.screens.loginscreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cheysoff.onlyfanf.R
import cheysoff.onlyfanf.presentation.screens.theme.BackgroundColor
import cheysoff.onlyfanf.presentation.screens.theme.ContinueWithoutRegistrationTextStyle
import cheysoff.onlyfanf.presentation.screens.theme.HaveAccountLogInTextStyle
import cheysoff.onlyfanf.presentation.screens.theme.HaveAccountTextStyle
import cheysoff.onlyfanf.presentation.screens.theme.LocalCustomColorScheme
import cheysoff.onlyfanf.presentation.screens.theme.LoginFieldPlaceHolderTextStyle
import cheysoff.onlyfanf.presentation.screens.theme.LoginFieldTextStyle
import cheysoff.onlyfanf.presentation.screens.theme.Peach
import cheysoff.onlyfanf.presentation.screens.theme.RegistrationOrTextStyle
import cheysoff.onlyfanf.presentation.screens.theme.SignUpButtonTextStyle
import cheysoff.onlyfanf.presentation.screens.theme.WelcomeScreenHeaderTextStyle
import cheysoff.onlyfanf.presentation.screens.welcomescreen.components.ThreePartsScreen

@Preview
@Composable
fun RegistrationScreen() {
    var enteredEmail = ""
    var enteredPassword = ""

    var isButtonActive by rememberSaveable { mutableStateOf(false) }

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
        ) {


            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
            ) {
                BasicTextField({ email -> enteredEmail = email }, TextFieldType.Email)

                Surface(modifier = Modifier.padding(top = 18.dp)) {
                    BasicTextField(
                        { password ->
                            enteredPassword = password
                            isButtonActive = !isButtonActive // TODO: DELETE
                        },
                        TextFieldType.Password
                    )
                }


                Row(modifier = Modifier
                    .padding(top = 11.dp, start = 10.dp)
                    .clickable { }) {
                    Text(text = "Already have an account? ", style = HaveAccountTextStyle)
                    Text(modifier = Modifier.drawBehind(strokeWidthPx = 1f, linePadding = 0f, color = Peach), text = "Log in", style = HaveAccountLogInTextStyle)
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 33.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                val buttonColor = if (isButtonActive) LocalCustomColorScheme.current.activeButtonColor else LocalCustomColorScheme.current.inactiveButtonColor
                Button(
                    modifier = Modifier.size(height = 49.dp, width = 129.dp),
                    enabled = isButtonActive,
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(30.dp),
                    border = BorderStroke(
                        width = 4.dp,
                        color = buttonColor
                    ),
                    colors = ButtonDefaults.buttonColors(containerColor = LocalCustomColorScheme.current.backgroundColor,
                        contentColor = LocalCustomColorScheme.current.activeButtonColor,
                        disabledContainerColor = BackgroundColor,
                        disabledContentColor = LocalCustomColorScheme.current.inactiveButtonColor)
                ) {
                    Text(
                        text = "Sign up",
                        style = SignUpButtonTextStyle,
                        color = buttonColor,
                        textAlign = TextAlign.Center
                    )
                }

                Text(
                    modifier = Modifier.padding(top = 14.dp),
                    text = "or",
                    style = RegistrationOrTextStyle
                )

                Text(
                    modifier = Modifier
                        .padding(top = 14.dp)
                        .drawBehind(strokeWidthPx = 7f, linePadding = 2f, color = LocalCustomColorScheme.current.screenElementsColor)
                        .clickable {  },
                    text = "Continue without an account",
                    style = ContinueWithoutRegistrationTextStyle
                )
            }
        }
    }, bottomComposable = {})
}

@Composable
private fun BasicTextField(onValueChange: (String) -> Unit, textFieldType: TextFieldType) {
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

private fun Modifier.drawBehind(strokeWidthPx: Float, linePadding: Float, color: Color): Modifier {
    return this.drawBehind {
        val verticalOffset = size.height - 2.sp.toPx() + linePadding
        drawLine(
            color = color,
            strokeWidth = strokeWidthPx,
            start = Offset(0f, verticalOffset),
            end = Offset(size.width, verticalOffset)
        )
    }
}

enum class TextFieldType {
    Email,
    Password
}