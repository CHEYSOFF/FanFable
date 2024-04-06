package cheysoff.onlyfanf.design_system.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cheysoff.onlyfanf.design_system.R
import cheysoff.onlyfanf.design_system.theme.LocalCustomColorScheme

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
            Button(
                onClick = nextButtonOnClick,
                modifier = Modifier
                    .size(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LocalCustomColorScheme.current.screenElementsColor
                ),
                contentPadding = PaddingValues(0.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_next_button),
                    tint = LocalCustomColorScheme.current.backgroundColor,
                    contentDescription = null
                )
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