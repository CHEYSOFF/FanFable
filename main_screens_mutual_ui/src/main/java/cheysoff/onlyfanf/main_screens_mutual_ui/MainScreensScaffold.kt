package cheysoff.onlyfanf.main_screens_mutual_ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainScreensScaffold(
    state: MainScreensScaffoldState,
    onIntentReceived: (MainScreensScaffoldIntent) -> Unit,
    leftButton: @Composable (modifier: Modifier) -> Unit = {},
    rightButton: @Composable (modifier: Modifier) -> Unit = {},
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(
                leftButton = leftButton,
                rightButton = rightButton
            )
        },
        bottomBar = {
            BottomBar(
                onClickMap = mapOf(
                    Pair(
                        BottomBarItem.Feed
                    ) {
                        onIntentReceived(MainScreensScaffoldIntent.PressFeedButtonIntent)
                    },
                    Pair(
                        BottomBarItem.MyStories
                    ) {
                        onIntentReceived(MainScreensScaffoldIntent.PressMyStoriesButtonIntent)
                    },
                    Pair(
                        BottomBarItem.Profile
                    ) {
                        onIntentReceived(MainScreensScaffoldIntent.PressProfileButtonIntent)
                    }
                ),
                selectedItem = state.selectedItem
            )
        }
    ) { paddingValues ->
        content(paddingValues)
    }
}

