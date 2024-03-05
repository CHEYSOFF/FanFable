package cheysoff.fanfable.presentation.screens.loginscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cheysoff.fanfable.R
import cheysoff.fanfable.presentation.screens.loginscreen.components.NextButtonBottomBar
import cheysoff.fanfable.presentation.screens.theme.CongratulationsDescriptionTextStyle
import cheysoff.fanfable.presentation.screens.theme.CongratulationsHeaderTextStyle
import cheysoff.fanfable.presentation.screens.theme.ScreenElementsColor

@Preview
@Composable
fun RegistrationCompleteScreen() {

    Scaffold(
        modifier = Modifier
            .background(ScreenElementsColor)
            .fillMaxSize()
            .padding(start = 26.dp, end = 26.dp, top = 32.dp),
        containerColor = Color.Transparent,
        topBar = { },
        bottomBar = {
            NextButtonBottomBar(
                isButtonEnabled = true,
                buttonText = "Let's start"
            )
        }
    )
    {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(top = 80.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(22.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.completion_picture),
                contentDescription = null
            )
            Text(
                text = "Congratulations!",
                style = CongratulationsHeaderTextStyle,
                textAlign = TextAlign.Center
            )
            Text(
                text = "You have completed \n your registration",
                style = CongratulationsDescriptionTextStyle,
                textAlign = TextAlign.Center
            )
        }
    }

}