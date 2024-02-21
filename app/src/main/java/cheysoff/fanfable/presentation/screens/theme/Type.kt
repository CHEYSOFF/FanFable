package cheysoff.fanfable.presentation.screens.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import cheysoff.fanfable.R

val ViburFontFamily = FontFamily(
    Font(R.font.vibur_regular)
)

val UrbanistFontFamily = FontFamily(
    Font(R.font.urbanist_regular, FontWeight.Normal),
    Font(R.font.urbanist_extra_bold, FontWeight.ExtraBold)
)

val WelcomeScreenHeaderTextSize = 51.sp
val WelcomeScreenDescriptionTextSize = 22.sp

val WelcomeScreenChooseUserChooserTextSize = 18.sp
val WelcomeScreenChooseUserHeaderTextSize = 25.sp

val WelcomeScreenHeaderTextStyle = TextStyle(
    fontFamily = ViburFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = WelcomeScreenHeaderTextSize,
    color = WelcomeScreenElementsColor
)

val WelcomeScreenDescriptionTextStyle = TextStyle(
    fontFamily = UrbanistFontFamily,
    fontWeight = FontWeight.ExtraBold,
    fontSize = WelcomeScreenDescriptionTextSize,
    color = WelcomeScreenElementsColor
)

val WelcomeScreenChooseUserChooserTextStyle = TextStyle(
    fontFamily = UrbanistFontFamily,
    fontWeight = FontWeight.ExtraBold,
    fontSize = WelcomeScreenChooseUserChooserTextSize,
    color = WelcomeScreenElementsColor
)

val WelcomeScreenChooseUserHeaderTextStyle = TextStyle(
    fontFamily = UrbanistFontFamily,
    fontWeight = FontWeight.ExtraBold,
    fontSize = WelcomeScreenChooseUserHeaderTextSize,
    color = WelcomeScreenElementsColor
)

