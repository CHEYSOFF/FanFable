package cheysoff.onlyfanf.genre_selection_ui.genreselectionscreen

import cheysoff.onlyfanf.genre_selection_domain.model.GenreModel

data class GenreScreenState(
    val genres: List<GenreModel>? = null,
    val selectedGenresIds: MutableSet<String> = mutableSetOf(),
    val isButtonAvailable: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null
)
