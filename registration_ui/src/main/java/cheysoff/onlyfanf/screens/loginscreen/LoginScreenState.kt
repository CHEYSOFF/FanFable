package cheysoff.onlyfanf.screens.loginscreen

data class LoginScreenState (
    val emailText: String = "",
    val passwordText: String = "",
    val loading: Boolean = false,
    val error: String? = null, // TODO - add error beneath button
)