package cheysoff.onlyfanf.my_stories_ui

import androidx.compose.runtime.Composable
import cheysoff.onlyfanf.main_screens_mutual_ui.MainScreensScaffold
import cheysoff.onlyfanf.main_screens_mutual_ui.MainScreensScaffoldIntent
import cheysoff.onlyfanf.main_screens_mutual_ui.MainScreensScaffoldState
import cheysoff.onlyfanf.main_screens_mutual_ui.components.SettingsButton
import cheysoff.onlyfanf.main_screens_mutual_ui.components.TopBarBackButton

@Composable
fun MyStoriesScreen(
    mainScreensScaffoldState: MainScreensScaffoldState,
    mainScreensScaffoldOnIntentReceived: (MainScreensScaffoldIntent) -> Unit,
    myStoriesScreenState: MyStoriesScreenState,
    myStoriesOnIntentReceived: (MyStoriesScreenIntent) -> Unit
) {
    MainScreensScaffold(
        onIntentReceived = mainScreensScaffoldOnIntentReceived,
        state = mainScreensScaffoldState,
        leftButton = { modifier ->
            if (mainScreensScaffoldState.backButton) {
                TopBarBackButton(
                    modifier = modifier,
                    onClick = { mainScreensScaffoldOnIntentReceived(MainScreensScaffoldIntent.PressBackButtonIntent) })
            }
        },
        rightButton = { modifier ->
            if (mainScreensScaffoldState.settingsButton) {
                SettingsButton(
                    modifier = modifier,
                    onClick = { mainScreensScaffoldOnIntentReceived(MainScreensScaffoldIntent.PressSettingsButtonIntent) })
            }
        }
    ) {

    }
}