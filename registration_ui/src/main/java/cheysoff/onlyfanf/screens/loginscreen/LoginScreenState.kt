package cheysoff.onlyfanf.screens.loginscreen

data class LoginScreenState (
    val emailText: String = "",
    val passwordText: String = "",
    val error: String? = null, // TODO - add error beneath button
)