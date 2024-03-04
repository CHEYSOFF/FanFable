package cheysoff.fanfable.domain.repository

import cheysoff.fanfable.domain.model.GenreModel
import cheysoff.fanfable.domain.util.Resource

//@Singleton
//class CloudRepository @Inject constructor(private val cloudDataSource: CloudDataSource) {
//    suspend fun getDataFromCloud(): Flow<DataState<List<GenreModel>>> {
//        return cloudDataSource.fetchData()
//    }
//}

interface CloudRepository {
    suspend fun getDataFromCloud(): Resource<List<GenreModel>>
}