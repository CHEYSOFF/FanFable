package cheysoff.onlyfanf.main_screens_mutual_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
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
import cheysoff.onlyfanf.design_system.R.drawable.feed_icon
import cheysoff.onlyfanf.design_system.R.drawable.feed_icon_selected
import cheysoff.onlyfanf.design_system.R.drawable.my_stories_icon
import cheysoff.onlyfanf.design_system.R.drawable.my_stories_icon_selected
import cheysoff.onlyfanf.design_system.R.drawable.profile_icon
import cheysoff.onlyfanf.design_system.R.drawable.profile_icon_selected
import cheysoff.onlyfanf.design_system.theme.BottomBarTextStyle


@Composable
fun BottomBar(onClickMap: Map<BottomBarItem, () -> Unit>, selectedItem: BottomBarItem) {
    var rememberedSelectedItem by remember { mutableStateOf(selectedItem) }

    NavigationBar(
        modifier = Modifier
            .fillMaxWidth(),
        containerColor = Color.White,
    ) {
        for (item in BottomBarItem.entries) {

            NavigationBarItem(
                selected = false,
                onClick = {
                    onClickMap[item]?.invoke()
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
        BottomBarItem.Feed -> if (bottomBarItem == selectedItem) feed_icon_selected else feed_icon
        BottomBarItem.MyStories -> if (bottomBarItem == selectedItem) my_stories_icon_selected else my_stories_icon
        BottomBarItem.Profile -> if (bottomBarItem == selectedItem) profile_icon_selected else profile_icon
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