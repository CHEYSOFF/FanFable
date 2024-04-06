package cheysoff.onlyfanf.design_system.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import cheysoff.onlyfanf.design_system.R

val ViburFontFamily = FontFamily(
    Font(R.font.vibur_regular)
)

val UrbanistFontFamily = FontFamily(
    Font(R.font.urbanist_regular, FontWeight.Normal),
    Font(R.font.urbanist_bold, FontWeight.Bold),
    Font(R.font.urbanist_extra_bold, FontWeight.ExtraBold)
)

val WelcomeScreenHeaderTextSize = 55.sp
val WelcomeScreenDescriptionTextSize = 22.sp

val WelcomeScreenChooseUserChooserTextSize = 20.sp
val WelcomeScreenChooseUserHeaderTextSize = 25.sp

val BottomBarTextSize = 18.sp

val LoginFieldTextSize = 15.sp

val HaveAccountTextSize = 15.sp

val SignUpTextSize = 19.sp

val RegistrationOrTextSize = 20.sp

val ContinueWithoutRegistrationTextSize = 17.sp

val SelectGenreHeaderTextSize = 28.sp
val GenreTypeTextSize = 15.sp

val NextButtonTextSize = 20.sp

val CongratulationsHeaderTextSize = 35.sp
val CongratulationsDescriptionTextSize = 24.sp

val WelcomeScreenHeaderTextStyle = TextStyle(
    fontFamily = ViburFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = WelcomeScreenHeaderTextSize,
    color = ScreenElementsColor
)

val WelcomeScreenDescriptionTextStyle = TextStyle(
    fontFamily = UrbanistFontFamily,
    fontWeight = FontWeight.ExtraBold,
    fontSize = WelcomeScreenDescriptionTextSize,
    color = ScreenElementsColor
)

val WelcomeScreenChooseUserChooserTextStyle = TextStyle(
    fontFamily = UrbanistFontFamily,
    fontWeight = FontWeight.ExtraBold,
    fontSize = WelcomeScreenChooseUserChooserTextSize,
    color = ScreenElementsColor
)

val HiHeaderTextStyle = TextStyle(
    fontFamily = UrbanistFontFamily,
    fontWeight = FontWeight.ExtraBold,
    fontSize = WelcomeScreenChooseUserHeaderTextSize,
    color = ScreenElementsColor
)

val BottomBarTextStyle = TextStyle(
    fontFamily = UrbanistFontFamily,
    fontWeight = FontWeight.ExtraBold,
    fontSize = BottomBarTextSize,
    color = ScreenElementsColor
)

val LoginFieldPlaceHolderTextStyle = TextStyle(
    fontFamily = UrbanistFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = LoginFieldTextSize,
    color = LoginFieldTextColor,
    letterSpacing = (2f).sp
)

val LoginFieldTextStyle = TextStyle(
    fontFamily = UrbanistFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = LoginFieldTextSize,
    color = ScreenElementsColor,
    letterSpacing = (2f).sp
)

val HaveAccountTextStyle = TextStyle(
    fontFamily = UrbanistFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = HaveAccountTextSize,
    color = ScreenElementsColor,
//    letterSpacing = (2f).sp
)

val HaveAccountLogInTextStyle = TextStyle(
    fontFamily = UrbanistFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = HaveAccountTextSize,
    color = Peach,
//    letterSpacing = (2f).sp
)

val SignUpButtonTextStyle = TextStyle(
    fontFamily = UrbanistFontFamily,
    fontWeight = FontWeight.ExtraBold,
    fontSize = SignUpTextSize,
)

val RegistrationOrTextStyle = TextStyle(
    fontFamily = UrbanistFontFamily,
    fontWeight = FontWeight.ExtraBold,
    fontSize = RegistrationOrTextSize,
    color = RegistrationOrColor
)

val ContinueWithoutRegistrationTextStyle = TextStyle(
    fontFamily = UrbanistFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = ContinueWithoutRegistrationTextSize,
    color = ScreenElementsColor,
)

val SelectGenreHeaderTextStyle = TextStyle(
    fontFamily = UrbanistFontFamily,
    fontWeight = FontWeight.ExtraBold,
    fontSize = SelectGenreHeaderTextSize,
    color = Color.White,
)

val GenreTypeTextStyle = TextStyle(
    fontFamily = UrbanistFontFamily,
    fontWeight = FontWeight.ExtraBold,
    fontSize = GenreTypeTextSize,
    color = ScreenElementsColor,
)

val NextButtonTextStyle = TextStyle(
    fontFamily = UrbanistFontFamily,
    fontWeight = FontWeight.ExtraBold,
    fontSize = NextButtonTextSize,
    color = BackgroundColor,
)

val CongratulationsHeaderTextStyle = TextStyle(
    fontFamily = UrbanistFontFamily,
    fontWeight = FontWeight.ExtraBold,
    fontSize = CongratulationsHeaderTextSize,
    color = BackgroundColor,
)

val CongratulationsDescriptionTextStyle = TextStyle(
    fontFamily = UrbanistFontFamily,
    fontWeight = FontWeight.ExtraBold,
    fontSize = CongratulationsDescriptionTextSize,
    color = BackgroundColor,
)

val Typography = Typography()
