package cheysoff.onlyfanf.genre_selection_ui.genreselectionscreen.screens.genreselectionscreen

sealed class GenreSelectionScreenIntent {
    data class SelectGenreByIdIntent(val id: String) : GenreSelectionScreenIntent()
    data object PressNextButtonIntent : GenreSelectionScreenIntent()
    data object PressBackButtonIntent : GenreSelectionScreenIntent()
    data object LoadGenresInfoIntent : GenreSelectionScreenIntent()
}