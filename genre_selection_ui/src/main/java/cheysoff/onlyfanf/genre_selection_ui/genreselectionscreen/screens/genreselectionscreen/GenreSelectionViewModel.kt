package cheysoff.onlyfanf.genre_selection_ui.genreselectionscreen.screens.genreselectionscreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cheysoff.onlyfanf.NavigationManager
import cheysoff.onlyfanf.directions.StartNavigation
import cheysoff.onlyfanf.genre_selection_domain.repository.CloudRepository
import cheysoff.onlyfanf.genre_selection_domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GenreSelectionViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val repository: CloudRepository,
) : ViewModel() {
    var state by mutableStateOf(GenreScreenState())
        private set

    init {
        processIntent(GenreSelectionScreenIntent.LoadGenresInfoIntent)
    }

    fun processIntent(intent: GenreSelectionScreenIntent) {
        when (intent) {
            GenreSelectionScreenIntent.PressNextButtonIntent -> pressNextButton()
            is GenreSelectionScreenIntent.SelectGenreByIdIntent -> selectGenreById(intent.id)
            GenreSelectionScreenIntent.LoadGenresInfoIntent -> loadGenreInfo()
            GenreSelectionScreenIntent.PressBackButtonIntent -> pressBackButton()
        }
    }

    private fun pressNextButton() {
        navigationManager.navigate(StartNavigation.StartCongratulate)
    }

    private fun pressBackButton() {
        navigationManager.navigateUp()
    }

    private fun selectGenreById(id: String) {
        if (state.selectedGenresIds.contains(id)) {
            state.selectedGenresIds.remove(id)
        } else {
            state.selectedGenresIds.add(id)
        }
        updateButtonAvailability()
    }

    private fun updateButtonAvailability() {
        state = state.copy(
            isButtonAvailable = state.selectedGenresIds.size >= GENRES_MIN_AMOUNT_SELECTED
        )
    }

    private fun loadGenreInfo() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )

            when (val result = repository.getDataFromCloud()) {
                is Resource.Success -> {
                    state = state.copy(
                        genres = result.data,
                        isLoading = false,
                        error = null
                    )
                }

                is Resource.Error -> {
                    state = state.copy(
                        genres = null,
                        isLoading = false,
                        error = result.message
                    )
                }
            }
        }
    }

    companion object {
        const val GENRES_MIN_AMOUNT_SELECTED = 1;
    }
}