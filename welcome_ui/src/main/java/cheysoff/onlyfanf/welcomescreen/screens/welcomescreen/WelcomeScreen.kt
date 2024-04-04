package cheysoff.onlyfanf.welcomescreen.screens.welcomescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cheysoff.onlyfanf.design_system.R.drawable.book_icon
import cheysoff.onlyfanf.design_system.components.BottomNextButtonScreen
import cheysoff.onlyfanf.design_system.theme.LocalCustomColorScheme
import cheysoff.onlyfanf.design_system.theme.WelcomeScreenDescriptionTextStyle
import cheysoff.onlyfanf.design_system.theme.WelcomeScreenHeaderTextStyle

@Composable
fun ShowWelcomeScreen(onIntentReceived: (WelcomeScreenIntent) -> Unit) {
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
                    painter = painterResource(id = book_icon),
                    tint = LocalCustomColorScheme.current.screenElementsColor,
                    contentDescription = null
                )

                Text(text = "Welcome to OnlyFanf", style = WelcomeScreenDescriptionTextStyle)
            }
        },
        nextButtonOnClick = { onIntentReceived(WelcomeScreenIntent.PressNextButtonIntent) }
    )
}

