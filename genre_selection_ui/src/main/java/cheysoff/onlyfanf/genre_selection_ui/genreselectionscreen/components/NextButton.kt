package cheysoff.onlyfanf.genre_selection_ui.genreselectionscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cheysoff.onlyfanf.design_system.theme.LocalCustomColorScheme
import cheysoff.onlyfanf.design_system.theme.NextButtonTextStyle

@Composable
fun NextButtonBottomBar(isButtonEnabled: Boolean, buttonText: String, onClick: () -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        color = LocalCustomColorScheme.current.screenElementsColor
    ) {
        NextButton(
            onClick = onClick,
            enabled = isButtonEnabled,
            buttonText = buttonText
        )
    }
}

@Composable
fun NextButton(
    onClick: () -> Unit,
    enabled: Boolean,
    buttonText: String
) {
    GradientButton(
        onClick = onClick,
        enabled = enabled,
        modifier = Modifier
            .padding(horizontal = 25.dp, vertical = 30.dp)
            .fillMaxSize(),
        colors = if (enabled) LocalCustomColorScheme.current.nextButtonActiveGradientList else LocalCustomColorScheme.current.nextButtonInactiveGradientList
    ) {
        Text(
            text = buttonText,
            style = NextButtonTextStyle,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun GradientButton(
    onClick: () -> Unit,
    enabled: Boolean,
    modifier: Modifier = Modifier,
    colors: List<Color>,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(42.dp)
            )
            .clip(RoundedCornerShape(42.dp))
            .background(
                brush = Brush.verticalGradient(colors = colors),
                shape = RoundedCornerShape(42.dp)
            ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            disabledContentColor = Color.Transparent
        ),
        content = content
    )
}