package cheysoff.onlyfanf.screens.loginscreen

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
class LoginScreenViewModel @Inject constructor(
    private val navHostController: NavHostController
) : ViewModel() {

    var state by mutableStateOf(LoginScreenState())
        private set

    fun processIntent(intent: LoginScreenIntent) {
        when (intent) {
            is LoginScreenIntent.ChangeEmailFieldTextIntent -> changeEmailText(intent.text)
            is LoginScreenIntent.ChangePasswordFieldTextIntent -> changePasswordText(intent.text)
            LoginScreenIntent.PressLoginButtonIntent -> pressLoginButton()
            LoginScreenIntent.PressSubfieldTextIntent -> pressSubfieldText()
        }
    }

    private fun changeEmailText(newText: String) {
        state = state.copy(emailText = newText)
    }

    private fun changePasswordText(newText: String) {
        state = state.copy(passwordText = newText)
    }

    private fun pressLoginButton() {
        navHostController.navigate(MainScreen.MainFeed.name)
    }

    private fun pressSubfieldText() {
        navHostController.navigate(SignScreen.SignRegistration.name)
    }

}