package cheysoff.onlyfanf.data.mapper

import cheysoff.onlyfanf.data.remote.GenreDto
import cheysoff.onlyfanf.domain.model.GenreModel

fun List<GenreDto>.toGenreModelList(): List<GenreModel> {
    return this.map {
        GenreModel(it.genreName, it.genrePicturePath)
    }
}