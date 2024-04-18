package cheysoff.onlyfanf.welcomescreen.screens.userpickerscreen

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cheysoff.onlyfanf.design_system.components.BottomNextButtonScreen
import cheysoff.onlyfanf.design_system.theme.HiHeaderTextStyle
import cheysoff.onlyfanf.design_system.theme.LocalCustomColorScheme
import cheysoff.onlyfanf.design_system.theme.WelcomeScreenChooseUserChooserTextStyle
import cheysoff.onlyfanf.welcomescreen.screens.userpickerscreen.components.UserType

@Composable
fun UserPickerScreen(
    state: UserPickerScreenState,
    onIntentReceived: (UserPickerScreenIntent) -> Unit
) {

    BottomNextButtonScreen(
        topComposable = {
            Text(
                text = "Who are you?",
                style = HiHeaderTextStyle
            )
        },
        midComposable = {
            OptionsList(
                chosenOption = state.userTypeSelected
            ) { newSelectedType ->
                onIntentReceived(UserPickerScreenIntent.ChangeUserSelectedIntent(newSelectedType))
            }
        },
        nextButtonOnClick = {
            onIntentReceived(UserPickerScreenIntent.PressNextButtonIntent)
        }
    )
}

@Composable
private fun OptionsList(chosenOption: UserType, onSelected: (UserType) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .height(120.dp)
            .fillMaxWidth(0.85f)
            .clip(RoundedCornerShape(5.dp)),
        userScrollEnabled = false
    ) {
        itemsIndexed(UserType.entries.toTypedArray()) { index, option ->
            OptionItem(
                type = option,
                isSelected = option == chosenOption,
                rowBackgroundColor =
                if (index % 2 == 1)
                    LocalCustomColorScheme.current.userChooserOddCardBackgroundColor
                else
                    LocalCustomColorScheme.current.userChooserEvenCardBackgroundColor,
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
                text = when (type) {
                    UserType.READER -> "Reader"
                    UserType.WRITER -> "Writer"
                    UserType.BOTH -> "I'm Reader and Writer"
                },
                style = WelcomeScreenChooseUserChooserTextStyle
            )

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(20.dp)
                    .background(rowBackgroundColor)
                    .border(3.dp, LocalCustomColorScheme.current.screenElementsColor, CircleShape)
                    .padding(5.dp),
                contentAlignment = Alignment.Center
            ) {
                if (isSelected) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        shape = CircleShape,
                        color = LocalCustomColorScheme.current.screenElementsColor
                    ) {}
                }
            }

        }
        Divider()
    }
}
