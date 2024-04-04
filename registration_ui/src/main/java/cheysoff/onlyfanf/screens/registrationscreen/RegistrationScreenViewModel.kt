package cheysoff.onlyfanf.screens.registrationscreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import cheysoff.onlyfanf.MainScreen
import cheysoff.onlyfanf.SignScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class RegistrationScreenViewModel @Inject constructor(
    private val navHostController: NavHostController
) : ViewModel() {

    var state by mutableStateOf(RegistrationScreenState())
        private set

    fun processIntent(intent: RegistrationScreenIntent) {
        when (intent) {
            is RegistrationScreenIntent.ChangeEmailFieldTextIntent -> changeEmailText(intent.text)
            is RegistrationScreenIntent.ChangePasswordFieldTextIntent -> changePasswordText(intent.text)
            RegistrationScreenIntent.PressSignUpButtonIntent -> pressSignUpButton()
            RegistrationScreenIntent.PressSubfieldTextIntent -> pressSubfieldText()
        }
    }

    private fun changeEmailText(newText: String) {
        state = state.copy(emailText = newText)
    }

    private fun changePasswordText(newText: String) {
        state = state.copy(passwordText = newText)
    }

    private fun pressSignUpButton() {
        // TODO - check user
        navHostController.navigate(MainScreen.MainFeed.name)
    }


    private fun pressSubfieldText() {
        navHostController.navigate(SignScreen.SignLogin.name)
    }
}