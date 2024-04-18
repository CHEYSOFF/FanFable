package cheysoff.onlyfanf.my_stories_domain.models

data class StorySnippetModel (
    val name: String,
    val pagesAmount: Int,
    val photoUri: String,
    val pinned: Boolean = false,
)