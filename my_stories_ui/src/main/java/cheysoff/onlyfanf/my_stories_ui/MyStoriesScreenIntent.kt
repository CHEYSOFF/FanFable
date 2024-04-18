package cheysoff.onlyfanf.my_stories_ui

sealed class MyStoriesScreenIntent {
    data object SearchIntent : MyStoriesScreenIntent()
    data class SearchTextChangeIntent(val text: String) : MyStoriesScreenIntent()
    data object PressAddWorkButtonIntent : MyStoriesScreenIntent()
    data object PressAddListButtonIntent : MyStoriesScreenIntent()
    data object PressAddFollowOtherAuthorsButtonIntent : MyStoriesScreenIntent()
    data class ExpandWorkByIdIntent(val id: String) : MyStoriesScreenIntent()
    data class PinWorkByIdIntent(val id: String) : MyStoriesScreenIntent()
}