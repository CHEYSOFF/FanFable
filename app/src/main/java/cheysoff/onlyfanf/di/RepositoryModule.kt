package cheysoff.onlyfanf.di

import cheysoff.onlyfanf.data.repository.CloudRepositoryImpl
import cheysoff.onlyfanf.domain.repository.CloudRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun provideCloudRepository(
        cloudDataSourceImpl: CloudRepositoryImpl
    ): CloudRepository
}