package cheysoff.onlyfanf.genre_selection_data.data.repository

import cheysoff.onlyfanf.genre_selection_data.data.mapper.toGenreModelList
import cheysoff.onlyfanf.genre_selection_data.data.remote.CloudDataSource
import cheysoff.onlyfanf.genre_selection_domain.model.GenreModel
import cheysoff.onlyfanf.genre_selection_domain.repository.CloudRepository
import cheysoff.onlyfanf.genre_selection_domain.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CloudRepositoryImpl @Inject constructor(private val dataSource: CloudDataSource) :
    CloudRepository {
    override suspend fun getDataFromCloud(): Resource<List<GenreModel>> {
        return withContext(Dispatchers.IO) {
            try {
                Resource.Success(
                    data = dataSource.fetchData().toGenreModelList()
                )
            } catch (e: Exception) {
                e.printStackTrace()
                Resource.Error(e.message ?: "Unknown error")
            }
        }
    }
}