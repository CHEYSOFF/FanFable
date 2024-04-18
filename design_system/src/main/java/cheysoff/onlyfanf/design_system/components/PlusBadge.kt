package cheysoff.onlyfanf.design_system.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cheysoff.onlyfanf.design_system.R
import cheysoff.onlyfanf.design_system.theme.LocalCustomColorScheme

@Composable
fun PlusBadge(modifier: Modifier) {
    Surface(
        modifier = modifier.clip(CircleShape),
        color = LocalCustomColorScheme.current.screenElementsColor
    ) {
        Icon(
            modifier = Modifier
                .fillMaxSize()
                .padding(3.dp),
            painter = painterResource(id = R.drawable.plus_icon),
            tint = LocalCustomColorScheme.current.backgroundColor,
            contentDescription = null
        )
    }
}