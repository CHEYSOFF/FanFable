package cheysoff.onlyfanf.presentation.screens.welcomescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cheysoff.onlyfanf.R
import cheysoff.onlyfanf.presentation.screens.NavigationItem
import cheysoff.onlyfanf.presentation.screens.welcomescreen.components.BottomNextButtonScreen
import cheysoff.onlyfanf.presentation.screens.theme.ScreenElementsColor
import cheysoff.onlyfanf.presentation.screens.theme.WelcomeScreenDescriptionTextStyle
import cheysoff.onlyfanf.presentation.screens.theme.WelcomeScreenHeaderTextStyle

@Composable
fun ShowWelcomeScreen(navController: NavController) {
    BottomNextButtonScreen(
        topComposable = {
            Text(
                text = "HI !",
                style = WelcomeScreenHeaderTextStyle
            )
        },
        midComposable = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(28.dp)
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.book_icon),
                    tint = ScreenElementsColor,
                    contentDescription = null
                )

                Text(text = "Welcome to OnlyFanf", style = WelcomeScreenDescriptionTextStyle)
            }
        },
        nextButtonOnClick = { navController.navigate(NavigationItem.UserPicker.route) }
    )
}

