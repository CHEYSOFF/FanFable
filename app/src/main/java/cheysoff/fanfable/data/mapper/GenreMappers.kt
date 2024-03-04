package cheysoff.fanfable.data.mapper

import cheysoff.fanfable.data.remote.GenreDto
import cheysoff.fanfable.domain.model.GenreModel

fun List<GenreDto>.toGenreModelList(): List<GenreModel> {
    return this.map {
        GenreModel(it.genreName, it.genrePicturePath)
    }
}