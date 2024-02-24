package cheysoff.fanfable.presentation.screens

enum class Screen {
    StartScreen,
    UserPicker,
    Login,
    Registration,
    Feed,
    MyStories,
    Profile
}

sealed class NavigationItem(val route: String) {
    data object StartScreen : NavigationItem(Screen.StartScreen.name)
    data object UserPicker : NavigationItem(Screen.UserPicker.name)
    data object Login : NavigationItem(Screen.Login.name)
    data object Registration : NavigationItem(Screen.Registration.name)
    data object Feed : NavigationItem(Screen.Feed.name)
    data object MyStories : NavigationItem(Screen.MyStories.name)
    data object Profile : NavigationItem(Screen.Profile.name)
}
