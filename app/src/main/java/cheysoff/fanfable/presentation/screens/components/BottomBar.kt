package cheysoff.fanfable.presentation.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cheysoff.fanfable.R
import cheysoff.fanfable.presentation.screens.theme.BottomBarTextStyle


@Composable
fun BottomBar(navController: NavController, selectedItem: BottomBarItem) {
    var rememberedSelectedItem by remember { mutableStateOf(selectedItem) }

    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        containerColor = Color.White,
    ) {
        for (item in BottomBarItem.entries) {

            NavigationBarItem(
                selected = false,
                onClick = {
                    rememberedSelectedItem = item
                },
                icon = {
                    Image(
                        modifier = Modifier.size(28.dp),
                        painter = painterResource(
                            id = getIconResId(
                                bottomBarItem = item,
                                selectedItem = rememberedSelectedItem
                            )
                        ),
                        contentDescription = null,
                        contentScale = ContentScale.FillHeight,
                    )
                },
                label = {
                    Text(
                        text = item.name.addSpaceBeforeCapitalLetters(),
                        style = BottomBarTextStyle
                    )
                },
                alwaysShowLabel = true
            )
        }
    }
}

fun getIconResId(bottomBarItem: BottomBarItem, selectedItem: BottomBarItem): Int {
    return when (bottomBarItem) {
        BottomBarItem.Feed -> if (bottomBarItem == selectedItem) R.drawable.feed_icon_selected else R.drawable.feed_icon
        BottomBarItem.MyStories -> if (bottomBarItem == selectedItem) R.drawable.my_stories_icon_selected else R.drawable.my_stories_icon
        BottomBarItem.Profile -> if (bottomBarItem == selectedItem) R.drawable.profile_icon_selected else R.drawable.profile_icon
    }
}

fun String.addSpaceBeforeCapitalLetters(): String {
    return this.replace(Regex("(\\p{Lu})"), " $1").trim()
}

enum class BottomBarItem {
    Feed,
    MyStories,
    Profile
}