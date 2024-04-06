package cheysoff.onlyfanf.genre_selection_ui.genreselectionscreen.screens.registrationcompletescreen

sealed class RegistrationCompleteScreenIntent {
    data object PressNextButtonIntent : RegistrationCompleteScreenIntent()
}