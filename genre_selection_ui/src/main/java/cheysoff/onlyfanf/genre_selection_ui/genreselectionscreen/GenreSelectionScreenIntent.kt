package cheysoff.onlyfanf.genre_selection_ui.genreselectionscreen

sealed class GenreSelectionScreenIntent {
    data class SelectGenreByIdIntent(val id: String) : GenreSelectionScreenIntent()
    data object PressNextButtonIntent : GenreSelectionScreenIntent()
    data object LoadGenresInfoIntent : GenreSelectionScreenIntent()
}