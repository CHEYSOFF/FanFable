package cheysoff.onlyfanf.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cheysoff.onlyfanf.NavigationItem
import cheysoff.onlyfanf.components.BottomBar
import cheysoff.onlyfanf.components.BottomBarItem
import cheysoff.onlyfanf.genre_selection_ui.genreselectionscreen.GenreSelectionViewModel
import cheysoff.onlyfanf.welcomescreen.ShowUserPickerScreen
import cheysoff.onlyfanf.welcomescreen.ShowWelcomeScreen
import cheysoff.onlyfanf.welcomescreen.UserType
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
            var userType = UserType.READER
            NavHost(
                navController = navController,
                startDestination = NavigationItem.StartScreen.route
            ) {
                composable(NavigationItem.StartScreen.route) {
                    ShowWelcomeScreen(navController = navController)
                }
                composable(NavigationItem.UserPicker.route) {
                    ShowUserPickerScreen(navController = navController) { newType ->
                        userType = newType
                    }
                }
                composable(NavigationItem.Main.route) {
                    when (userType) {
                        UserType.READER, UserType.BOTH -> BottomBar(
                            navController = navController,
                            selectedItem = BottomBarItem.Feed
                        )

                        UserType.WRITER -> BottomBar(
                            navController = navController,
                            selectedItem = BottomBarItem.MyStories
                        )
                    }

                }
//                composable(NavigationItem.MyStories.route) {
//                    BottomBar(navController = navController, selectedItem = BottomBarItem.MyStories)
//                }
//                composable(NavigationItem.Profile.route) {
//                    BottomBar(navController = navController, selectedItem = BottomBarItem.Profile)
//                }
            }
        }


    }


}
