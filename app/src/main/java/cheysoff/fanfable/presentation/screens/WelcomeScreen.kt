package cheysoff.fanfable.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cheysoff.fanfable.R
import cheysoff.fanfable.presentation.screens.components.BottomNextButtonScreen
import cheysoff.fanfable.presentation.screens.theme.WelcomeScreenDescriptionTextStyle
import cheysoff.fanfable.presentation.screens.theme.WelcomeScreenElementsColor
import cheysoff.fanfable.presentation.screens.theme.WelcomeScreenHeaderTextStyle

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
                    tint = WelcomeScreenElementsColor,
                    contentDescription = null
                )

                Text(text = "Welcome to FanFable", style = WelcomeScreenDescriptionTextStyle)
            }
        },
        nextButtonOnClick = { navController.navigate(NavigationItem.UserPicker.route) }
    )
}

