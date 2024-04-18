package cheysoff.onlyfanf.design_system.theme

import androidx.compose.ui.graphics.Color

val DarkPurple = Color(0xff6C2CD4)
//val SaturatedPurple = Color(0xff6132AE)
//val LightPurple = Color(0xff924EF8)
val Violet = Color(0xffB76FFF)
//val Pink = Color(0xffDD91FF)
//val LightPink = Color(0xffFFB4FF)
val White = Color(0xFFFFFFFF)
val Peach = Color(0xFFEE9090)

//val White45 = White.copy(alpha = 0.45f)

val TransparentPurple29 = DarkPurple.copy(alpha = 0.29f)
val TransparentPurple21 = DarkPurple.copy(alpha = 0.21f)
val TransparentPink20 = Color(0x33D9D9D9)

// Text
val LoginFieldTextColor = TransparentPurple29
val RegistrationOrColor = Violet

// Elements
val ScreenElementsColor = DarkPurple

val BackgroundColor = White

val UserChooserEvenCardBackgroundColor = DarkPurple.copy(alpha = 0.04f)
val UserChooserOddCardBackgroundColor = DarkPurple.copy(alpha = 0.14f)

val TextFieldColor = TransparentPink20

val InactiveButtonColor = TransparentPurple21
val ActiveButtonColor = ScreenElementsColor


val NextButtonActiveGradient1 = Color(0xFF6132AE)
val NextButtonActiveGradient2 = Color(0xFF6E3EB3)
val NextButtonActiveGradient3= Color(0xFF945AC8)
val NextButtonActiveGradient4 = Color(0xFFB96EDA)

val NextButtonInActiveGradient1 = Color(0xFF9662EE)
val NextButtonInActiveGradient2 = Color(0xFFB193E2)
val NextButtonInActiveGradient3= Color(0xFFCBB3D6)

val NextButtonActiveGradientList = listOf(
    NextButtonActiveGradient1,
    NextButtonActiveGradient2,
    NextButtonActiveGradient3,
    NextButtonActiveGradient4,
)

val NextButtonInActiveGradientList = listOf(
    NextButtonInActiveGradient1,
    NextButtonInActiveGradient2,
    NextButtonInActiveGradient3,
)