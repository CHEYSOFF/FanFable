package cheysoff.onlyfanf.design_system.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import cheysoff.onlyfanf.design_system.theme.LocalCustomColorScheme

@Composable
fun CustomSearchBar(
    query: String,
    textStyle: TextStyle,
    textColor: Color,
    onQueryChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    onClear: () -> Unit,
    active: Boolean,
    onActiveChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    placeholderText: String = "",
) {

    val focusRequester = remember { FocusRequester() }

    val focusManager = LocalFocusManager.current

    BasicTextField(
        value = query,
        onValueChange = onQueryChange,
        textStyle = textStyle.copy(
            color = textColor
        ),
        enabled = enabled,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = { onSearch(query) }),
        singleLine = true,
        modifier = modifier
            .focusRequester(focusRequester)
            .onFocusChanged { onActiveChange(it.isFocused) }
            .semantics {
                onClick {
                    focusRequester.requestFocus()
                    true
                }
            },
        decorationBox = { innerTextField ->
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(size = 10.dp))
                    .background(LocalCustomColorScheme.current.textFieldColor)
                    .padding(horizontal = 8.dp, vertical = 4.dp)

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                ) {
                    Box {
                        if (query.isEmpty()) {
                            Text(
                                text = placeholderText,
                                style = textStyle,
                                color = textColor
                            )
                        }
                        innerTextField()
                    }
                    Button(
                        onClick = onClear,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            disabledContentColor = Color.Transparent
                        ),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Icon(
                            Icons.Default.Clear,
                            contentDescription = "clear icon",
                            modifier = Modifier
                                .padding(12.dp),
                            tint = MaterialTheme.colorScheme.primary,
                        )
                    }


                }
            }
        }
    )
    LaunchedEffect(active) {
        if (!active) {
            focusManager.clearFocus()
        }
    }

}