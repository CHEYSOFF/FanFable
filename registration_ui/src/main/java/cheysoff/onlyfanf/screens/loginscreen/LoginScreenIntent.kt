package cheysoff.onlyfanf.screens.loginscreen

sealed class LoginScreenIntent {
    data class ChangeEmailFieldTextIntent(val text: String) : LoginScreenIntent()
    data class ChangePasswordFieldTextIntent(val text: String) : LoginScreenIntent()
    data object PressLoginButtonIntent : LoginScreenIntent()
    data object PressSubfieldTextIntent : LoginScreenIntent()
}