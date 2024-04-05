package cheysoff.onlyfanf.directions

import androidx.navigation.NamedNavArgument
import cheysoff.onlyfanf.NavigationCommand

object SignNavigation {

    val root = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "Sign"

    }

    val SignRegistration = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "SignRegistration"

    }

    val SignLogin = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "SignLogin"
    }

    val SignForgotPassword = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "SignForgotPassword"

    }
}

//enum class SignScreen {
//    SignRegistration,
//    SignLogin,
//    SignForgotPassword
//}



//sealed class SignNavigationItem(val route: String) {
//    data object SignRegistration : SignNavigationItem(SignScreen.SignRegistration.name)
//    data object SignLogin : SignNavigationItem(SignScreen.SignLogin.name)
//    data object SignForgotPassword : SignNavigationItem(SignScreen.SignForgotPassword.name)
//}