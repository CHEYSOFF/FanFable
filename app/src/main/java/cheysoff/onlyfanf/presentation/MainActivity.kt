package cheysoff.onlyfanf.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import cheysoff.onlyfanf.GlobalScreen
import cheysoff.onlyfanf.MainScreen
import cheysoff.onlyfanf.SignScreen
import cheysoff.onlyfanf.StartScreen
import cheysoff.onlyfanf.genre_selection_ui.genreselectionscreen.GenreSelectionViewModel
import cheysoff.onlyfanf.welcomescreen.screens.userpickerscreen.ShowUserPickerScreen
import cheysoff.onlyfanf.welcomescreen.screens.userpickerscreen.UserPickerScreenViewModel
import cheysoff.onlyfanf.welcomescreen.screens.welcomescreen.ShowWelcomeScreen
import cheysoff.onlyfanf.welcomescreen.screens.welcomescreen.WelcomeScreenViewModel
import com.google.firebase.FirebaseApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: GenreSelectionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FirebaseApp.initializeApp(this)
        viewModel.loadGenreInfo()

//        setContent {
//            MyApplicationTheme {
//                GenreSelectionScreen(state = viewModel.state)
//            }
//        }


        setContent {
            val navController = rememberNavController()
//            var userType = UserType.READER
            NavHost(
                navController = navController,
                startDestination = GlobalScreen.GlobalStart.name
            ) {

                navigation(
                    route = GlobalScreen.GlobalStart.name,
                    startDestination = StartScreen.StartWelcome.name
                ) {
                    composable(StartScreen.StartWelcome.name) {
                        val viewModel = it.sharedViewModel<WelcomeScreenViewModel>(navController)
                        ShowWelcomeScreen { intent ->
                            viewModel.processIntent(intent)
                        }
                    }
                    composable(StartScreen.StartUserPicker.name) {
                        val viewModel = it.sharedViewModel<UserPickerScreenViewModel>(navController)
                        ShowUserPickerScreen(viewModel.state) { intent ->
                            viewModel.processIntent(intent)
                        }
                    }
                    composable(StartScreen.StartGenreSelection.name) {

                    }
                    composable(StartScreen.StartCongratulate.name) {

                    }
                }

                navigation(
                    route = GlobalScreen.GlobalRegistration.name,
                    startDestination = SignScreen.SignRegistration.name
                ) {
                    composable(SignScreen.SignRegistration.name) {

                    }
                    composable(SignScreen.SignLogin.name) {

                    }
                    composable(SignScreen.SignForgotPassword.name) {

                    }
                }

                navigation(
                    route = GlobalScreen.GlobalMain.name,
                    startDestination = MainScreen.MainFeed.name
                ) {
                    composable(MainScreen.MainFeed.name) {

                    }
                    composable(MainScreen.MainMyStories.name) {

                    }
                    composable(MainScreen.MainProfile.name) {

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

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(navController: NavController): T {
    val navGraphRoute = destination.parent?.route ?: return viewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return viewModel(parentEntry)
}
