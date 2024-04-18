package cheysoff.onlyfanf.genre_selection_ui.genreselectionscreen.screens.genreselectionscreen.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cheysoff.onlyfanf.design_system.components.PlusBadge

@Composable
fun GenrePlusBadge() {
    PlusBadge(
        modifier = Modifier
            .padding(horizontal = 9.dp, vertical = 14.dp)
            .size(20.dp)
    )
}