package cheysoff.onlyfanf.di

import cheysoff.onlyfanf.data.remote.CloudDataSource
import cheysoff.onlyfanf.data.remote.FirebaseCloudDataSource
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
}