package cheysoff.onlyfanf.screens.registrationscreen

import androidx.compose.runtime.Composable
import cheysoff.onlyfanf.screens.components.SignScreen

@Composable
fun ShowRegistrationScreen(state: RegistrationScreenState, onIntentReceived: (RegistrationScreenIntent) -> Unit) {
    SignScreen(
        subfieldText = "Already have an account?",
        subfieldClickableText = "Log in",
        emailText = state.emailText,
        passwordText = state.passwordText,
        onEmailFieldTextChange = { newText ->
            onIntentReceived(
                RegistrationScreenIntent.ChangeEmailFieldTextIntent(
                    newText
                )
            )
        },
        onPasswordFieldTextChange = { newText ->
            onIntentReceived(
                RegistrationScreenIntent.ChangePasswordFieldTextIntent(
                    newText
                )
            )
        },
        onButtonClick = { onIntentReceived(RegistrationScreenIntent.PressSignUpButtonIntent) },
        onSubfieldTextClick = { onIntentReceived(RegistrationScreenIntent.PressSubfieldTextIntent) },
        mainButtonText = "Sign up"
    )
}
