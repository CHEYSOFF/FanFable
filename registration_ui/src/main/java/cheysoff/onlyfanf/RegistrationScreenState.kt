package cheysoff.onlyfanf

data class RegistrationScreenState (
    val isLoading: Boolean = false,
    val error: String? = null,
    val emailTextFieldText: String = "",
    val passwordTextFieldText: String = "",
)