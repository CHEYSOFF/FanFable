package cheysoff.onlyfanf.main_screens_mutual_ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cheysoff.onlyfanf.design_system.theme.ScreenElementsColor
import cheysoff.onlyfanf.design_system.theme.UrbanistFontFamily

val ButtonsBasicSize = 50.dp
val TopBarBasicSize = 70.dp

val ScreenHorizontalPaddingSize = 26.dp

val OnlyFanfTextLogoTextSize = 24.sp

val SearchBarTextSize = 24.sp

val OnlyFanfTextLogoTextStyle = TextStyle(
    fontFamily = UrbanistFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = OnlyFanfTextLogoTextSize,
    color = ScreenElementsColor
)


val SearchBarTextStyle = TextStyle(
    fontFamily = UrbanistFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = SearchBarTextSize,
    color = ScreenElementsColor
)