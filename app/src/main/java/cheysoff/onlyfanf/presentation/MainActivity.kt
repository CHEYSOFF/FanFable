package cheysoff.onlyfanf.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navOptions
import cheysoff.onlyfanf.NavigationCommand
import cheysoff.onlyfanf.NavigationManager
import cheysoff.onlyfanf.design_system.theme.MyApplicationTheme
import cheysoff.onlyfanf.directions.BasicNavigation
import cheysoff.onlyfanf.directions.MainNavigation
import cheysoff.onlyfanf.directions.SignNavigation
import cheysoff.onlyfanf.directions.StartNavigation
import cheysoff.onlyfanf.genre_selection_ui.genreselectionscreen.screens.genreselectionscreen.GenreSelectionScreen
import cheysoff.onlyfanf.genre_selection_ui.genreselectionscreen.screens.genreselectionscreen.GenreSelectionViewModel
import cheysoff.onlyfanf.genre_selection_ui.genreselectionscreen.screens.registrationcompletescreen.RegistrationCompleteScreen
import cheysoff.onlyfanf.genre_selection_ui.genreselectionscreen.screens.registrationcompletescreen.RegistrationCompleteViewModel
import cheysoff.onlyfanf.main_screens_mutual_ui.MainScreensScaffoldViewModel
import cheysoff.onlyfanf.my_stories_ui.MyStoriesScreen
import cheysoff.onlyfanf.my_stories_ui.MyStoriesScreenViewModel
import cheysoff.onlyfanf.screens.loginscreen.LoginScreen
import cheysoff.onlyfanf.screens.loginscreen.LoginScreenViewModel
import cheysoff.onlyfanf.screens.registrationscreen.RegistrationScreen
import cheysoff.onlyfanf.screens.registrationscreen.RegistrationScreenViewModel
import cheysoff.onlyfanf.welcomescreen.screens.userpickerscreen.UserPickerScreen
import cheysoff.onlyfanf.welcomescreen.screens.userpickerscreen.UserPickerScreenViewModel
import cheysoff.onlyfanf.welcomescreen.screens.welcomescreen.WelcomeScreen
import cheysoff.onlyfanf.welcomescreen.screens.welcomescreen.WelcomeScreenViewModel
import com.google.firebase.FirebaseApp
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: GenreSelectionViewModel by viewModels()

    @Inject
    lateinit var navigationManager: NavigationManager

    @Inject
    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FirebaseApp.initializeApp(this)


        setContent {
            MyApplicationTheme {
//                val navController = rememberNavController()
                LaunchedEffect(navigationManager.commands) {
                    navigationManager.commands.collect { command: NavigationCommand ->
                        when (command) {
                            BasicNavigation.Up -> navController.navigateUp()
                            else ->
                                if (command.destination.isNotEmpty()) {
                                    navController.navigate(
                                        route = command.destination,
                                        navOptions = navOptions {
                                            launchSingleTop = true
//                                        popUpTo(SignNavigation.root.destination) {
//                                            inclusive = false
//                                        }
                                        }
                                    )
                                }
                        }
                    }
                }


//            var userType = UserType.READER
                NavHost(
                    navController = navController,
                    startDestination = StartNavigation.root.destination
                ) {

                    navigation(
                        route = StartNavigation.root.destination,
                        startDestination = StartNavigation.StartWelcome.destination
                    ) {

                        composable(StartNavigation.StartWelcome.destination) {
                            val viewModel =
                                it.sharedViewModel<WelcomeScreenViewModel>(navController)
                            WelcomeScreen { intent ->
                                viewModel.processIntent(intent)
                            }
                        }
                        composable(StartNavigation.StartUserPicker.destination) {
                            val viewModel =
                                it.sharedViewModel<UserPickerScreenViewModel>(navController)
                            UserPickerScreen(viewModel.state) { intent ->
                                viewModel.processIntent(intent)
                            }
                        }
                        composable(StartNavigation.StartGenreSelection.destination) {
                            val viewModel =
                                it.sharedViewModel<GenreSelectionViewModel>(navController)

//                            LaunchedEffect(navController) {
//                                viewModel.processIntent(GenreSelectionScreenIntent.LoadGenresInfoIntent)
//                            }

                            GenreSelectionScreen(viewModel.state) { intent ->
                                viewModel.processIntent(intent)
                            }
                        }
                        composable(StartNavigation.StartCongratulate.destination) {
                            val viewModel =
                                it.sharedViewModel<RegistrationCompleteViewModel>(navController)

                            RegistrationCompleteScreen { intent ->
                                viewModel.processIntent(intent)
                            }
                        }
                    }

                    navigation(
                        route = SignNavigation.root.destination,
                        startDestination = SignNavigation.SignRegistration.destination
                    ) {

                        composable(SignNavigation.SignRegistration.destination) {
                            val viewModel =
                                it.sharedViewModel<RegistrationScreenViewModel>(navController)

                            RegistrationScreen(viewModel.state) { intent ->
                                viewModel.processIntent(intent)
                            }
                        }
                        composable(SignNavigation.SignLogin.destination) {
                            val viewModel =
                                it.sharedViewModel<LoginScreenViewModel>(navController)

                            LoginScreen(viewModel.state) { intent ->
                                viewModel.processIntent(intent)
                            }
                        }
                        composable(SignNavigation.SignForgotPassword.destination) {

                        }
                    }

                    navigation(
                        route = MainNavigation.root.destination,
                        startDestination = MainNavigation.MainMyStories.destination
                    ) {
                        composable(MainNavigation.MainFeed.destination) {

                        }
                        composable(MainNavigation.MainMyStories.destination) {
                            val scaffoldViewModel =
                                it.sharedViewModel<MainScreensScaffoldViewModel>(navController)
                            val storiesViewModel =
                                it.sharedViewModel<MyStoriesScreenViewModel>(navController)
                            MyStoriesScreen(mainScreensScaffoldState = scaffoldViewModel.state,
                                mainScreensScaffoldOnIntentReceived = { intent ->
                                    scaffoldViewModel.processIntent(intent)
                                },
                                myStoriesScreenState = storiesViewModel.state,
                                myStoriesOnIntentReceived = { intent ->
                                    TODO()
                                })
                        }
                        composable(MainNavigation.MainProfile.destination) {

                        }
                    }


//                composable(GlobalNavigationItem.GlobalStart.route) {
//                    WelcomeScreen(navController = navController)
//                }
//                composable(GlobalNavigationItem.UserPicker.route) {
//                    UserPickerScreen(navController = navController) { newType ->
//                        userType = newType
//                    }
//                }
//                composable(GlobalNavigationItem.GlobalMain.route) {
//                    when (userType) {
//                        UserType.READER, UserType.BOTH -> BottomBar(
//                            navController = navController,
//                            selectedItem = BottomBarItem.Feed
//                        )
//
//                        UserType.WRITER -> BottomBar(
//                            navController = navController,
//                            selectedItem = BottomBarItem.MyStories
//                        )
//                    }
//
//                }
                }
            }
        }


    }
}

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(navController: NavController): T {
    val navGraphRoute = destination.parent?.route ?: return hiltViewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return hiltViewModel(parentEntry)
}
