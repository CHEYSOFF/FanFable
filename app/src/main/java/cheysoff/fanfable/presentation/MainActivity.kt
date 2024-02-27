package cheysoff.fanfable.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cheysoff.fanfable.presentation.screens.NavigationItem
import cheysoff.fanfable.presentation.screens.ShowUserPickerScreen
import cheysoff.fanfable.presentation.screens.ShowWelcomeScreen
import cheysoff.fanfable.presentation.screens.UserType
import cheysoff.fanfable.presentation.screens.components.BottomBar
import cheysoff.fanfable.presentation.screens.components.BottomBarItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
