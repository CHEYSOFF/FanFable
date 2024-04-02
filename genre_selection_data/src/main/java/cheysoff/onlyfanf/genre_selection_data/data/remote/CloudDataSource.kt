package cheysoff.onlyfanf.genre_selection_data.data.remote

interface CloudDataSource {
    suspend fun fetchData(): List<GenreDto>
}