package cheysoff.onlyfanf.genre_selection_data.data.mapper

import cheysoff.onlyfanf.genre_selection_data.data.remote.GenreDto
import cheysoff.onlyfanf.genre_selection_domain.model.GenreModel

fun List<GenreDto>.toGenreModelList(): List<GenreModel> {
    return this.map {
        GenreModel(
            it.id,
            it.genreName,
            it.genrePicturePath
        )
    }
}