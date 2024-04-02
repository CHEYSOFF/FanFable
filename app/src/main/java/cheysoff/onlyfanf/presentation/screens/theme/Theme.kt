package cheysoff.onlyfanf.presentation.screens.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme()

data class CustomColorsPalette(
    val screenElementsColor: Color = Color.Unspecified,
    val backgroundColor: Color = Color.Unspecified,
    val userChooserEvenCardBackgroundColor: Color = Color.Unspecified,
    val userChooserOddCardBackgroundColor: Color = Color.Unspecified,
    val loginFieldColor: Color = Color.Unspecified,
    val inactiveButtonColor: Color = Color.Unspecified,
    val activeButtonColor: Color = Color.Unspecified,
    val nextButtonActiveGradientList: List<Color> = listOf(),
    val nextButtonInactiveGradientList: List<Color> = listOf()
)

val OnLightCustomColorsPalette = CustomColorsPalette(
    screenElementsColor = ScreenElementsColor,
    backgroundColor = BackgroundColor,
    userChooserEvenCardBackgroundColor = UserChooserEvenCardBackgroundColor,
    userChooserOddCardBackgroundColor = UserChooserOddCardBackgroundColor,
    loginFieldColor = LoginFieldColor,
    inactiveButtonColor = InactiveButtonColor,
    activeButtonColor = ActiveButtonColor,
    nextButtonActiveGradientList = NextButtonActiveGradientList,
    nextButtonInactiveGradientList = NextButtonInActiveGradientList

)

val LocalCustomColorScheme = staticCompositionLocalOf { OnLightCustomColorsPalette }

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    val customColorsPalette = OnLightCustomColorsPalette

    CompositionLocalProvider(
        LocalCustomColorScheme provides customColorsPalette
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}