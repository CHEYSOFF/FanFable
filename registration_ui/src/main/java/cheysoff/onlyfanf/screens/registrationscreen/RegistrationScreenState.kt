package cheysoff.onlyfanf.screens.registrationscreen

data class RegistrationScreenState (
    val emailText: String = "",
    val passwordText: String = "",
    val loading: Boolean = false,
    val error: String? = null,
)