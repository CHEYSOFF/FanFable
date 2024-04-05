package cheysoff.onlyfanf.directions

import androidx.navigation.NamedNavArgument
import cheysoff.onlyfanf.NavigationCommand

object AppNavigation {

    val root = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "App"

    }

    val AppStart = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "AppStart"

    }

    val AppRegistration = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "AppRegistration"
    }

    val AppMain = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "AppMain"

    }
}

//enum class GlobalScreen {
//    GlobalStart,
////    UserPicker,
////    Login,
//    GlobalRegistration,
//    GlobalMain
//}

//sealed class GlobalNavigationItem(val route: String) {
//    data object GlobalStart : GlobalNavigationItem(GlobalScreen.GlobalStart.name)
////    data object UserPicker : NavigationItem(Screen.UserPicker.name)
////    data object Login : NavigationItem(Screen.Login.name)
//    data object GlobalRegistration : GlobalNavigationItem(GlobalScreen.GlobalRegistration.name)
//    data object GlobalMain : GlobalNavigationItem(GlobalScreen.GlobalMain.name)
//}

