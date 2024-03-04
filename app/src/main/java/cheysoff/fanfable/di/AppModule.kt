package cheysoff.fanfable.di

import cheysoff.fanfable.data.remote.CloudDataSource
import cheysoff.fanfable.data.remote.FirebaseCloudDataSource
import cheysoff.fanfable.data.repository.CloudRepositoryImpl
import cheysoff.fanfable.domain.repository.CloudRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideCloudDataSource(): CloudDataSource {
        return FirebaseCloudDataSource()
    }

    @Singleton
    @Provides
    fun provideCloudRepository(cloudDataSource: CloudDataSource): CloudRepository {
        return CloudRepositoryImpl(cloudDataSource)
    }
}