package cheysoff.onlyfanf.main_screens_mutual_ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cheysoff.onlyfanf.design_system.components.BackButton
import cheysoff.onlyfanf.design_system.theme.LocalCustomColorScheme
import cheysoff.onlyfanf.main_screens_mutual_ui.theme.ButtonsBasicSize

@Composable
fun TopBarBackButton(modifier: Modifier, onClick: () -> Unit) {
    BackButton(
        modifier = modifier.size(ButtonsBasicSize),
        onClick = onClick,
        color = LocalCustomColorScheme.current.screenElementsColor
    )
}

@Composable
fun TopBarBackButton(onClick: () -> Unit) {
    TopBarBackButton(
        modifier = Modifier.size(ButtonsBasicSize),
        onClick = onClick
    )
}
