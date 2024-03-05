package cheysoff.onlyfanf.domain.repository

import cheysoff.onlyfanf.domain.model.GenreModel
import cheysoff.onlyfanf.domain.util.Resource

//@Singleton
//class CloudRepository @Inject constructor(private val cloudDataSource: CloudDataSource) {
//    suspend fun getDataFromCloud(): Flow<DataState<List<GenreModel>>> {
//        return cloudDataSource.fetchData()
//    }
//}

interface CloudRepository {
    suspend fun getDataFromCloud(): Resource<List<GenreModel>>
}