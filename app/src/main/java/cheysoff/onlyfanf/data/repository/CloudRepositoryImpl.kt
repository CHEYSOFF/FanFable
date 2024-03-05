package cheysoff.onlyfanf.data.repository

import cheysoff.onlyfanf.data.mapper.toGenreModelList
import cheysoff.onlyfanf.data.remote.CloudDataSource
import cheysoff.onlyfanf.domain.model.GenreModel
import cheysoff.onlyfanf.domain.repository.CloudRepository
import cheysoff.onlyfanf.domain.util.Resource
import javax.inject.Inject

class CloudRepositoryImpl @Inject constructor(private val dataSource: CloudDataSource) :
    CloudRepository {
    override suspend fun getDataFromCloud(): Resource<List<GenreModel>> {
        return try {
            Resource.Success(
                data = dataSource.fetchData().toGenreModelList()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "Unknown error")
        }
    }
}