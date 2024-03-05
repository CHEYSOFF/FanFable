package cheysoff.onlyfanf.presentation.screens.genreselectionscreen

import cheysoff.onlyfanf.domain.model.GenreModel

data class GenreScreenState(
    val genres: List<GenreModel>? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
