package cheysoff.fanfable.data.remote

interface CloudDataSource {
    suspend fun fetchData(): List<GenreDto>
}