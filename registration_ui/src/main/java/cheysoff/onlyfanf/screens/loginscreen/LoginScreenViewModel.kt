package cheysoff.onlyfanf.screens.loginscreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cheysoff.onlyfanf.NavigationManager
import cheysoff.onlyfanf.directions.MainNavigation
import cheysoff.onlyfanf.directions.SignNavigation
import cheysoff.onlyfanf.repository.AuthRepository
import cheysoff.onlyfanf.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val repository: AuthRepository
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
        state = state.copy(loading = true)
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.firebaseSignInWithEmailAndPassword(
                state.emailText,
                state.passwordText
            )) {
                is Resource.Error -> state = state.copy(
                    loading = false,
                    error = result.message
                )

                is Resource.Success -> {
                    state = state.copy(
                        loading = false,
                        error = ""
                    )
                    navigationManager.navigate(MainNavigation.root)
                }
            }
        }
    }

    private fun pressSubfieldText() {
        navigationManager.navigate(SignNavigation.SignRegistration)
    }

}