package cheysoff.onlyfanf.screens.loginscreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import cheysoff.onlyfanf.NavigationManager
import cheysoff.onlyfanf.directions.MainNavigation
import cheysoff.onlyfanf.directions.SignNavigation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val navigationManager: NavigationManager
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
        navigationManager.navigate(MainNavigation.MainFeed)
    }

    private fun pressSubfieldText() {
        navigationManager.navigate(SignNavigation.SignRegistration)
    }

}