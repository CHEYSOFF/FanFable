package cheysoff.onlyfanf.genre_selection_ui.genreselectionscreen.screens.registrationcompletescreen

import androidx.lifecycle.ViewModel
import cheysoff.onlyfanf.NavigationManager
import cheysoff.onlyfanf.directions.SignNavigation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationCompleteViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
) : ViewModel() {

    fun processIntent(intent: RegistrationCompleteScreenIntent) {
        when (intent) {
            RegistrationCompleteScreenIntent.PressNextButtonIntent -> navigationManager.navigate(
                SignNavigation.SignRegistration
            )
        }
    }
}