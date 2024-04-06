package cheysoff.onlyfanf.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import cheysoff.onlyfanf.NavigationCommand
import cheysoff.onlyfanf.NavigationManager
import cheysoff.onlyfanf.design_system.theme.MyApplicationTheme
import cheysoff.onlyfanf.directions.BasicNavigation
import cheysoff.onlyfanf.directions.MainNavigation
import cheysoff.onlyfanf.directions.SignNavigation
import cheysoff.onlyfanf.directions.StartNavigation
import cheysoff.onlyfanf.genre_selection_ui.genreselectionscreen.screens.genreselectionscreen.GenreSelectionScreenIntent
import cheysoff.onlyfanf.genre_selection_ui.genreselectionscreen.screens.genreselectionscreen.GenreSelectionViewModel
import cheysoff.onlyfanf.genre_selection_ui.genreselectionscreen.screens.genreselectionscreen.ShowGenreSelectionScreen
import cheysoff.onlyfanf.genre_selection_ui.genreselectionscreen.screens.registrationcompletescreen.RegistrationCompleteViewModel
import cheysoff.onlyfanf.genre_selection_ui.genreselectionscreen.screens.registrationcompletescreen.ShowRegistrationCompleteScreen
import cheysoff.onlyfanf.screens.loginscreen.LoginScreenViewModel
import cheysoff.onlyfanf.screens.loginscreen.ShowLoginScreen
import cheysoff.onlyfanf.screens.registrationscreen.RegistrationScreenViewModel
import cheysoff.onlyfanf.screens.registrationscreen.ShowRegistrationScreen
import cheysoff.onlyfanf.welcomescreen.screens.userpickerscreen.ShowUserPickerScreen
import cheysoff.onlyfanf.welcomescreen.screens.userpickerscreen.UserPickerScreenViewModel
import cheysoff.onlyfanf.welcomescreen.screens.welcomescreen.ShowWelcomeScreen
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
                navigationManager.commands.collectAsState().value.also { command: NavigationCommand ->
                    when (command) {
                        BasicNavigation.Up -> navController.navigateUp()
                        else ->
                            if (command.destination.isNotEmpty()) {
                                navController.navigate(command.destination)
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
                            ShowWelcomeScreen { intent ->
                                viewModel.processIntent(intent)
                            }
                        }
                        composable(StartNavigation.StartUserPicker.destination) {
                            val viewModel =
                                it.sharedViewModel<UserPickerScreenViewModel>(navController)
                            ShowUserPickerScreen(viewModel.state) { intent ->
                                viewModel.processIntent(intent)
                            }
                        }
                        composable(StartNavigation.StartGenreSelection.destination) {
                            val viewModel =
                                it.sharedViewModel<GenreSelectionViewModel>(navController)

                            LaunchedEffect(Unit) {
                                viewModel.processIntent(GenreSelectionScreenIntent.LoadGenresInfoIntent)
                            }

                            ShowGenreSelectionScreen(viewModel.state) { intent ->
                                viewModel.processIntent(intent)
                            }
                        }
                        composable(StartNavigation.StartCongratulate.destination) {
                            val viewModel =
                                it.sharedViewModel<RegistrationCompleteViewModel>(navController)

                            ShowRegistrationCompleteScreen { intent ->
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

                            ShowRegistrationScreen(viewModel.state) { intent ->
                                viewModel.processIntent(intent)
                            }
                        }
                        composable(SignNavigation.SignLogin.destination) {
                            val viewModel =
                                it.sharedViewModel<LoginScreenViewModel>(navController)

                            ShowLoginScreen(viewModel.state) { intent ->
                                viewModel.processIntent(intent)
                            }
                        }
                        composable(SignNavigation.SignForgotPassword.destination) {

                        }
                    }

                    navigation(
                        route = MainNavigation.root.destination,
                        startDestination = MainNavigation.MainFeed.destination
                    ) {
                        composable(MainNavigation.MainFeed.destination) {

                        }
                        composable(MainNavigation.MainMyStories.destination) {

                        }
                        composable(MainNavigation.MainProfile.destination) {

                        }
                    }


//                composable(GlobalNavigationItem.GlobalStart.route) {
//                    ShowWelcomeScreen(navController = navController)
//                }
//                composable(GlobalNavigationItem.UserPicker.route) {
//                    ShowUserPickerScreen(navController = navController) { newType ->
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
