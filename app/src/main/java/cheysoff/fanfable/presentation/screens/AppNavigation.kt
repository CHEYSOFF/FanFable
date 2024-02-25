package cheysoff.fanfable.presentation.screens

enum class Screen {
    StartScreen,
    UserPicker,
    Login,
    Registration,
    Main
}

sealed class NavigationItem(val route: String) {
    data object StartScreen : NavigationItem(Screen.StartScreen.name)
    data object UserPicker : NavigationItem(Screen.UserPicker.name)
    data object Login : NavigationItem(Screen.Login.name)
    data object Registration : NavigationItem(Screen.Registration.name)
    data object Main : NavigationItem(Screen.Main.name)
}
