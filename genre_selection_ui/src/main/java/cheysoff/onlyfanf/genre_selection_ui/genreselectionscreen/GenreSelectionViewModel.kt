package cheysoff.onlyfanf.genre_selection_ui.genreselectionscreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cheysoff.onlyfanf.genre_selection_domain.repository.CloudRepository
import cheysoff.onlyfanf.genre_selection_domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GenreSelectionViewModel @Inject constructor(
    private val repository: CloudRepository,
) : ViewModel() {
    var state by mutableStateOf(GenreScreenState())
        private set

    fun loadGenreInfo() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )

            when(val result = repository.getDataFromCloud()) {
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
}