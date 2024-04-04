package cheysoff.onlyfanf.screens.loginscreen

import androidx.compose.runtime.Composable
import cheysoff.onlyfanf.screens.components.SignScreen

@Composable
fun LoginScreen(state: LoginScreenState, onIntentReceived: (LoginScreenIntent) -> Unit) {
    SignScreen(
        subfieldText = "You don't have an account?",
        subfieldClickableText = "Sign up",
        emailText = state.emailText,
        passwordText = state.passwordText,
        onEmailFieldTextChange = { newText ->
            onIntentReceived(
                LoginScreenIntent.ChangeEmailFieldTextIntent(
                    newText
                )
            )
        },
        onPasswordFieldTextChange = { newText ->
            onIntentReceived(
                LoginScreenIntent.ChangePasswordFieldTextIntent(
                    newText
                )
            )
        },
        onButtonClick = { onIntentReceived(LoginScreenIntent.PressLoginButtonIntent) },
        onSubfieldTextClick = { onIntentReceived(LoginScreenIntent.PressSubfieldTextIntent) },
        mainButtonText = "Log in"
    )
}