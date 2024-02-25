package cheysoff.fanfable.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cheysoff.fanfable.presentation.screens.components.BottomNextButtonScreen
import cheysoff.fanfable.presentation.screens.theme.ScreenElementsColor
import cheysoff.fanfable.presentation.screens.theme.UserChooserEvenCardBackgroundColor
import cheysoff.fanfable.presentation.screens.theme.UserChooserOddCardBackgroundColor
import cheysoff.fanfable.presentation.screens.theme.WelcomeScreenChooseUserChooserTextStyle
import cheysoff.fanfable.presentation.screens.theme.WelcomeScreenChooseUserHeaderTextStyle

@Composable
fun ShowUserPickerScreen(navController: NavController, onClick: (UserType) -> Unit) {
    var selectedUserType by remember { mutableStateOf(UserType.READER) }

    BottomNextButtonScreen(
        topComposable = {
            Text(
                text = "Who are you?",
                style = WelcomeScreenChooseUserHeaderTextStyle
            )
        },
        midComposable = {
            OptionsList(
                chosenOption = selectedUserType
            ) { newSelectedType ->
                selectedUserType = newSelectedType
            }
        },
        nextButtonOnClick = {
            onClick(selectedUserType)
            navController.navigate(NavigationItem.Main.route)
        }
//        {
//            navController.navigate(
//                when (selectedUserType) {
//                    UserType.READER -> NavigationItem.Feed.route
//                    UserType.WRITER -> NavigationItem.MyStories.route
//                }
//            )
//        }
    )
}

@Composable
private fun OptionsList(chosenOption: UserType, onSelected: (UserType) -> Unit) {


    LazyColumn(
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth(0.85f)
            .clip(RoundedCornerShape(5.dp))
    ) {
        itemsIndexed(UserType.entries.toTypedArray()) { index, option ->
            OptionItem(
                type = option,
                isSelected = option == chosenOption,
                rowBackgroundColor =
                if (index % 2 == 1)
                    UserChooserOddCardBackgroundColor
                else
                    UserChooserEvenCardBackgroundColor,
                onSelected = onSelected
            )
        }
    }
}

@Composable
private fun OptionItem(
    type: UserType,
    rowBackgroundColor: Color,
    isSelected: Boolean,
    onSelected: (UserType) -> Unit
) {
    Column(
        modifier = Modifier.clickable { onSelected(type) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(rowBackgroundColor)
                .padding(horizontal = 18.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = type.name,
                style = WelcomeScreenChooseUserChooserTextStyle
            )

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(20.dp)
                    .background(rowBackgroundColor)
                    .border(3.dp, ScreenElementsColor, CircleShape)
                    .padding(5.dp),
                contentAlignment = Alignment.Center
            ) {
                if (isSelected) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        shape = CircleShape,
                        color = ScreenElementsColor
                    ) {}
                }
            }

        }
        Divider()
    }
}

enum class UserType {
    READER,
    WRITER
}