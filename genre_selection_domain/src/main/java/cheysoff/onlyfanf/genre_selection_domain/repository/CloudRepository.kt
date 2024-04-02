package cheysoff.onlyfanf.genre_selection_domain.repository

import cheysoff.onlyfanf.genre_selection_domain.model.GenreModel
import cheysoff.onlyfanf.genre_selection_domain.util.Resource


interface CloudRepository {
    suspend fun getDataFromCloud(): Resource<List<GenreModel>>
}