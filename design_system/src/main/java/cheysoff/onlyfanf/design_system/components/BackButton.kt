package cheysoff.onlyfanf.design_system.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cheysoff.onlyfanf.design_system.R


@Composable
fun BackButton(modifier: Modifier, onClick: () -> Unit, color: Color) {
    Button(
        modifier = modifier,
        onClick = onClick,
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            disabledContentColor = Color.Transparent
        ),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.return_back_button_icon),
            contentDescription = null,
            tint = color
        )
    }

}

