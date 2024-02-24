package cheysoff.fanfable.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cheysoff.fanfable.presentation.screens.NavigationItem
import cheysoff.fanfable.presentation.screens.ShowUserPickerScreen
import cheysoff.fanfable.presentation.screens.ShowWelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = NavigationItem.StartScreen.route) {
                composable(NavigationItem.StartScreen.route) {
                    ShowWelcomeScreen(navController = navController)
                }
                composable(NavigationItem.UserPicker.route) {
                    ShowUserPickerScreen(navController = navController)
                }
                composable(NavigationItem.Feed.route) {
                    Surface(modifier = Modifier.fillMaxSize(), color = Color.Red) {

                    }
                }
                composable(NavigationItem.MyStories.route) {
                    Surface(modifier = Modifier.fillMaxSize(), color = Color.Blue) {

                    }
                }
            }

        }
    }
}