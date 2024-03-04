package cheysoff.fanfable.data.repository

import cheysoff.fanfable.data.mapper.toGenreModelList
import cheysoff.fanfable.data.remote.CloudDataSource
import cheysoff.fanfable.domain.model.GenreModel
import cheysoff.fanfable.domain.repository.CloudRepository
import cheysoff.fanfable.domain.util.Resource
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