package cheysoff.onlyfanf.main_screens_mutual_ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cheysoff.onlyfanf.design_system.components. CustomSearchBar
import cheysoff.onlyfanf.design_system.theme.LocalCustomColorScheme
import cheysoff.onlyfanf.main_screens_mutual_ui.theme.SearchBarTextStyle

@Composable
fun MainSearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    onClear: () -> Unit,
    active: Boolean,
    onActiveChange: (Boolean) -> Unit,
    enabled: Boolean = true,
    placeholderText: String = "",
) {
    CustomSearchBar(
        query = query,
        textStyle = SearchBarTextStyle,
        textColor = LocalCustomColorScheme.current.screenElementsColor,
        onQueryChange = onQueryChange,
        onSearch = onSearch,
        onClear = onClear,
        active = active,
        onActiveChange = onActiveChange,
        enabled = enabled,
        placeholderText = placeholderText,
        modifier = Modifier.fillMaxWidth().height(40.dp)
    )
}
