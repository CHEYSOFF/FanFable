package cheysoff.onlyfanf.di

import cheysoff.onlyfanf.NavigationManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {

//    @Provides
//    @Singleton
//    fun provideNavController(@ApplicationContext context: Context) = NavHostController(context).apply {
//        navigatorProvider.addNavigator(ComposeNavigator())
//        navigatorProvider.addNavigator(DialogNavigator())
//    }

    @Singleton
    @Provides
    fun providesNavigationManager() = NavigationManager()
}