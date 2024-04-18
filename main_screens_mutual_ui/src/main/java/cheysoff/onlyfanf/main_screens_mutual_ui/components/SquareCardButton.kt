package cheysoff.onlyfanf.main_screens_mutual_ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import cheysoff.onlyfanf.design_system.components.PlusBadge

@Composable
fun AspectCard(
    modifier: Modifier,
    ratio: Float,
    content: @Composable () -> Unit,
    badge: @Composable (modifier: Modifier) -> Unit = {}
) {
    Box(
        modifier = modifier.aspectRatio(ratio),
//        contentAlignment = Alignment.Center
    ) {
        content()
        badge(Modifier.align(Alignment.BottomEnd))
    }
}

@Composable
fun SquareCard(modifier: Modifier, content: @Composable () -> Unit) {
    AspectCard(modifier = modifier, ratio = 1f, content = content)
}

@Composable
fun SquareCardWithBadge(
    modifier: Modifier,
    content: @Composable () -> Unit,
    badge: @Composable (modifier: Modifier) -> Unit = {}
) {
    AspectCard(modifier = modifier, ratio = 1f, content = content)
}

@Composable
fun RectangleCard(modifier: Modifier, content: @Composable () -> Unit) {
    AspectCard(modifier = modifier, ratio = 2f, content = content)
}

@Composable
fun CommonPlusBadge() {
    PlusBadge(
        Modifier
            .fillMaxWidth(0.2f)
            .aspectRatio(1f)
    )
}

@Composable
fun PhotoTextSquareCardWithBadge(text: String, photoUri: String) {
    SquareCardWithBadge(
        modifier = Modifier.fillMaxWidth(0.5f),
        content = {
            Column(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxSize()
                    .clip(RoundedCornerShape(9.dp)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {

            }
        },
        badge = {
            CommonPlusBadge()
        }
    )
}

