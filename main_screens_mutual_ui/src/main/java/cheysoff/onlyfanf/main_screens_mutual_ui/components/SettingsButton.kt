package cheysoff.onlyfanf.main_screens_mutual_ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cheysoff.onlyfanf.design_system.theme.LocalCustomColorScheme
import cheysoff.onlyfanf.main_screens_mutual_ui.R
import cheysoff.onlyfanf.main_screens_mutual_ui.theme.ButtonsBasicSize
import cheysoff.onlyfanf.main_screens_mutual_ui.theme.ScreenHorizontalPaddingSize

//@Preview
//@Composable
//fun SettingsButton2() {
//    SettingsButton(
//        modifier = Modifier.padding(horizontal = ScreenHorizontalPaddingSize)
//            .size(ButtonsBasicSize)
//            ,
//        onClick = {}
//    )
//
//}

@Composable
fun SettingsButton(modifier: Modifier, onClick: () -> Unit) {
    Button(
        modifier = modifier.size(ButtonsBasicSize),
        onClick = onClick,
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            disabledContentColor = Color.Transparent
        ),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.gear_icon),
            contentDescription = null,
            tint = LocalCustomColorScheme.current.screenElementsColor
        )
    }
}