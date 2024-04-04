package cheysoff.onlyfanf

enum class SignScreen {
    SignRegistration,
    SignLogin,
    SignForgotPassword
}



//sealed class SignNavigationItem(val route: String) {
//    data object SignRegistration : SignNavigationItem(SignScreen.SignRegistration.name)
//    data object SignLogin : SignNavigationItem(SignScreen.SignLogin.name)
//    data object SignForgotPassword : SignNavigationItem(SignScreen.SignForgotPassword.name)
//}