package cheysoff.onlyfanf.main_screens_mutual_ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import cheysoff.onlyfanf.NavigationManager
import cheysoff.onlyfanf.directions.MainNavigation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreensScaffoldViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
//    private val repository: CloudRepository, TODO add repo
) : ViewModel() {
    var state by mutableStateOf(MainScreensScaffoldState())
        private set

    fun processIntent(intent: MainScreensScaffoldIntent) {
        when (intent) {
            MainScreensScaffoldIntent.PressBackButtonIntent -> pressBackButton()
            MainScreensScaffoldIntent.PressFeedButtonIntent -> pressFeedButton()
            MainScreensScaffoldIntent.PressMyStoriesButtonIntent -> pressMyStoriesButton()
            MainScreensScaffoldIntent.PressProfileButtonIntent -> pressProfileButton()
            MainScreensScaffoldIntent.PressSettingsButtonIntent -> pressSettingsButton()
        }
    }

    private fun pressBackButton() {
        navigationManager.navigateUp()
    }

    private fun pressFeedButton() {
        navigationManager.navigate(MainNavigation.MainFeed)
    }

    private fun pressMyStoriesButton() {
        navigationManager.navigate(MainNavigation.MainMyStories)
    }

    private fun pressProfileButton() {
        navigationManager.navigate(MainNavigation.MainProfile)
    }

    private fun pressSettingsButton() {
        navigationManager.navigate(MainNavigation.MainSettings)
    }

}