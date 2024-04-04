package cheysoff.onlyfanf.welcomescreen.screens.welcomescreen

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import cheysoff.onlyfanf.StartScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WelcomeScreenViewModel @Inject constructor(
    private val navHostController: NavHostController,
) : ViewModel() {

    fun processIntent(intent: WelcomeScreenIntent) {
        when (intent) {
            WelcomeScreenIntent.PressNextButtonIntent -> navHostController.navigate(StartScreen.StartUserPicker.name)
        }
    }

}