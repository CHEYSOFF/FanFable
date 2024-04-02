package cheysoff.onlyfanf.presentation.screens.welcomescreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cheysoff.onlyfanf.R
import cheysoff.onlyfanf.presentation.screens.theme.LocalCustomColorScheme

@Composable
fun BottomNextButtonScreen(
    topComposable: @Composable () -> Unit,
    midComposable: @Composable () -> Unit,
    nextButtonOnClick: () -> Unit,
) {
    ThreePartsScreen(
        topComposable = topComposable,
        midComposable = midComposable,
        bottomComposable = {
            IconButton(
                onClick = nextButtonOnClick,
                modifier = Modifier
                    .size(60.dp),
            ) {
                Surface(
                    shape = CircleShape,
                    color = LocalCustomColorScheme.current.screenElementsColor
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_next_button),
                        tint = LocalCustomColorScheme.current.backgroundColor,
                        contentDescription = null
                    )
                }

            }
        }
    )
}

@Composable
fun ThreePartsScreen(
    topComposable: @Composable () -> Unit,
    midComposable: @Composable () -> Unit,
    bottomComposable: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LocalCustomColorScheme.current.backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,


        ) {

        Box(
            modifier = Modifier.weight(0.25f),
            contentAlignment = Alignment.BottomCenter
        ) {
            topComposable()
        }

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.5f),
            contentAlignment = Alignment.Center
        ) {
            midComposable()
        }

        Box(
            modifier = Modifier
                .weight(0.25f),
            contentAlignment = Alignment.TopCenter
        ) {
            bottomComposable()
        }

    }
}