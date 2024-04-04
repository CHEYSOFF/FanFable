package cheysoff.onlyfanf.screens.registrationscreen

sealed class RegistrationScreenIntent {
    data class ChangeEmailFieldTextIntent(val text: String) : RegistrationScreenIntent()
    data class ChangePasswordFieldTextIntent(val text: String) : RegistrationScreenIntent()
    data object PressSignUpButtonIntent : RegistrationScreenIntent()
    data object PressSubfieldTextIntent : RegistrationScreenIntent()
}