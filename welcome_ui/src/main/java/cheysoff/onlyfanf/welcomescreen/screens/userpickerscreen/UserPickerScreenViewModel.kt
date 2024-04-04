package cheysoff.onlyfanf.welcomescreen.screens.userpickerscreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import cheysoff.onlyfanf.StartScreen
import cheysoff.onlyfanf.welcomescreen.screens.userpickerscreen.components.UserType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserPickerScreenViewModel @Inject constructor(
    private val navHostController: NavHostController
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
        navHostController.navigate(StartScreen.StartGenreSelection.name)
    }

}