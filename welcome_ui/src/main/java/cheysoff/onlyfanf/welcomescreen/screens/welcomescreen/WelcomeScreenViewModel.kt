package cheysoff.onlyfanf.welcomescreen.screens.welcomescreen

import androidx.lifecycle.ViewModel
import cheysoff.onlyfanf.NavigationManager
import cheysoff.onlyfanf.directions.StartNavigation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WelcomeScreenViewModel @Inject constructor(
    private val navigationManager: NavigationManager
) : ViewModel() {

    fun processIntent(intent: WelcomeScreenIntent) {
        when (intent) {
            WelcomeScreenIntent.PressNextButtonIntent -> navigationManager.navigate(StartNavigation.StartUserPicker)
        }
    }

}