package cheysoff.onlyfanf.my_stories_ui

import cheysoff.onlyfanf.my_stories_domain.models.StorySnippetModel

data class MyStoriesScreenState (
    val data: List<StorySnippetModel> = listOf(),
    val loading: Boolean = false
)