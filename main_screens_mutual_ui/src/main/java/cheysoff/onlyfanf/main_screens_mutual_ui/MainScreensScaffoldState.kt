package cheysoff.onlyfanf.main_screens_mutual_ui

data class MainScreensScaffoldState (
    val selectedItem: BottomBarItem = BottomBarItem.Feed,
    val backButton: Boolean = false,
    val settingsButton: Boolean = true,
)