package cheysoff.onlyfanf.data.remote

interface CloudDataSource {
    suspend fun fetchData(): List<GenreDto>
}