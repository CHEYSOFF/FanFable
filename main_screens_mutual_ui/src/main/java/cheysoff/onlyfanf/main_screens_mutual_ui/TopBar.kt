package cheysoff.onlyfanf.main_screens_mutual_ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cheysoff.onlyfanf.main_screens_mutual_ui.theme.OnlyFanfTextLogoTextStyle
import cheysoff.onlyfanf.main_screens_mutual_ui.theme.TopBarBasicSize

@Composable
fun TopBar(
    leftButton: @Composable (modifier: Modifier) -> Unit,
    rightButton: @Composable (modifier: Modifier) -> Unit
) {
    TopBar(
        Modifier
            .fillMaxWidth()
            .height(TopBarBasicSize),
        leftButton,
        rightButton
    )
}

@Composable
fun TopBar(
    modifier: Modifier,
    leftButton: @Composable (modifier: Modifier) -> Unit,
    rightButton: @Composable (modifier: Modifier) -> Unit
) {
    Box(modifier = modifier) {
        leftButton(Modifier.align(Alignment.CenterStart))
        OnlyFanfTextLogo(Modifier.align(Alignment.Center))
        rightButton(Modifier.align(Alignment.CenterEnd))
    }
}

@Composable
private fun OnlyFanfTextLogo(modifier: Modifier) {
    Text(
        modifier = modifier,
        text = "OnlyFanf",
        style = OnlyFanfTextLogoTextStyle
    )
}

