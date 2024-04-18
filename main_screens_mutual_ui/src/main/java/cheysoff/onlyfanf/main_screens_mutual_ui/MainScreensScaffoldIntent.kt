package cheysoff.onlyfanf.main_screens_mutual_ui

sealed class MainScreensScaffoldIntent {
    data object PressFeedButtonIntent : MainScreensScaffoldIntent()
    data object PressMyStoriesButtonIntent : MainScreensScaffoldIntent()
    data object PressProfileButtonIntent : MainScreensScaffoldIntent()
    data object PressSettingsButtonIntent : MainScreensScaffoldIntent()
    data object PressBackButtonIntent : MainScreensScaffoldIntent()
}