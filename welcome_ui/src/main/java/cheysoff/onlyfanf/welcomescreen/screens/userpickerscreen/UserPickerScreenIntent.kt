package cheysoff.onlyfanf.welcomescreen.screens.userpickerscreen

import cheysoff.onlyfanf.welcomescreen.screens.userpickerscreen.components.UserType

sealed class UserPickerScreenIntent {
    data object PressNextButtonIntent : UserPickerScreenIntent()
    data class ChangeUserSelectedIntent(val userType: UserType) : UserPickerScreenIntent()
}