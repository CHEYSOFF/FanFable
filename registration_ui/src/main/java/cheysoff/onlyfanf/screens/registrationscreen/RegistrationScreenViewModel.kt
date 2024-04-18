package cheysoff.onlyfanf.screens.registrationscreen

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
class RegistrationScreenViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val repository: AuthRepository
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
        state = state.copy(loading = true)
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.firebaseSignUpWithEmailAndPassword(
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
        navigationManager.navigate(SignNavigation.SignLogin)
    }
}