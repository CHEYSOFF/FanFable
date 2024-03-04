package cheysoff.fanfable.presentation.screens.genreselectionscreen

import cheysoff.fanfable.domain.model.GenreModel

data class GenreScreenState(
    val genres: List<GenreModel>? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
