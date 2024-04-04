package cheysoff.onlyfanf.screens.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cheysoff.onlyfanf.design_system.components.ThreePartsScreen
import cheysoff.onlyfanf.design_system.theme.BackgroundColor
import cheysoff.onlyfanf.design_system.theme.ContinueWithoutRegistrationTextStyle
import cheysoff.onlyfanf.design_system.theme.HaveAccountLogInTextStyle
import cheysoff.onlyfanf.design_system.theme.HaveAccountTextStyle
import cheysoff.onlyfanf.design_system.theme.LocalCustomColorScheme
import cheysoff.onlyfanf.design_system.theme.Peach
import cheysoff.onlyfanf.design_system.theme.RegistrationOrTextStyle
import cheysoff.onlyfanf.design_system.theme.SignUpButtonTextStyle
import cheysoff.onlyfanf.design_system.theme.WelcomeScreenHeaderTextStyle

@Composable
fun SignScreen(
    subfieldText: String,
    subfieldClickableText: String,
    emailText: String,
    passwordText: String,
    onEmailFieldTextChange: (String) -> Unit,
    onPasswordFieldTextChange: (String) -> Unit,
    onSubfieldTextClick: () -> Unit,
    onButtonClick: () -> Unit,
    mainButtonText: String
) {

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
                verticalArrangement = Arrangement.spacedBy(18.dp)
            ) {
                BasicTextField(
                    text = emailText,
                    onValueChange = onEmailFieldTextChange,
                    textFieldType = TextFieldType.Email
                )

                BasicTextField(
                    text = passwordText,
                    onValueChange = onPasswordFieldTextChange,
                    textFieldType = TextFieldType.Password
                )

                Row(modifier = Modifier
                    .padding(top = 11.dp, start = 10.dp)
                    .clickable { onSubfieldTextClick.invoke() }) {
                    Text(text = subfieldText, style = HaveAccountTextStyle)
                    Text(
                        modifier = Modifier.drawBehind(
                            strokeWidthPx = 1f,
                            linePadding = 0f,
                            color = Peach
                        ), text = " $subfieldClickableText", style = HaveAccountLogInTextStyle
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 33.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                val buttonColor =LocalCustomColorScheme.current.activeButtonColor
                Button(
                    modifier = Modifier.size(height = 49.dp, width = 129.dp),
                    enabled = true,
                    onClick = onButtonClick,
                    shape = RoundedCornerShape(30.dp),
                    border = BorderStroke(
                        width = 4.dp,
                        color = buttonColor
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = LocalCustomColorScheme.current.backgroundColor,
                        contentColor = LocalCustomColorScheme.current.activeButtonColor,
                        disabledContainerColor = BackgroundColor,
                        disabledContentColor = LocalCustomColorScheme.current.inactiveButtonColor
                    )
                ) {
                    Text(
                        text = mainButtonText,
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
                        .drawBehind(
                            strokeWidthPx = 7f,
                            linePadding = 2f,
                            color = LocalCustomColorScheme.current.screenElementsColor
                        )
                        .clickable { },
                    text = "Continue without an account",
                    style = ContinueWithoutRegistrationTextStyle
                )
            }
        }
    }, bottomComposable = {})
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