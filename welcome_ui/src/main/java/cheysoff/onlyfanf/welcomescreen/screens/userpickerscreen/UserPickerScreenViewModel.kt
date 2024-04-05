package cheysoff.onlyfanf.welcomescreen.screens.userpickerscreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import cheysoff.onlyfanf.NavigationManager
import cheysoff.onlyfanf.directions.StartNavigation
import cheysoff.onlyfanf.welcomescreen.screens.userpickerscreen.components.UserType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserPickerScreenViewModel @Inject constructor(
    private val navigationManager: NavigationManager
) : ViewModel() {

    var state by mutableStateOf(UserPickerScreenState())
        private set

    fun processIntent(intent: UserPickerScreenIntent) {
        when (intent) {
            UserPickerScreenIntent.PressNextButtonIntent -> pressNextButton()
            is UserPickerScreenIntent.ChangeUserSelectedIntent -> changeSelectedUserType(intent.userType)
        }
    }

    private fun changeSelectedUserType(userType: UserType) {
        state = state.copy(userTypeSelected = userType)
    }

    private fun pressNextButton() {
        navigationManager.navigate(StartNavigation.StartGenreSelection)
//        navHostController.navigate(StartScreen.StartGenreSelection.name)
    }

}