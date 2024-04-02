package cheysoff.onlyfanf.di

import cheysoff.onlyfanf.genre_selection_data.data.repository.CloudRepositoryImpl
import cheysoff.onlyfanf.genre_selection_domain.repository.CloudRepository
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