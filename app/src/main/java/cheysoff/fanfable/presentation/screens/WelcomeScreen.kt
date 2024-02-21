package cheysoff.fanfable.presentation.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cheysoff.fanfable.R
import cheysoff.fanfable.presentation.screens.theme.BackgroundColor
import cheysoff.fanfable.presentation.screens.theme.UserChooserEvenCardBackgroundColor
import cheysoff.fanfable.presentation.screens.theme.UserChooserOddCardBackgroundColor
import cheysoff.fanfable.presentation.screens.theme.WelcomeScreenChooseUserChooserTextStyle
import cheysoff.fanfable.presentation.screens.theme.WelcomeScreenChooseUserHeaderTextStyle
import cheysoff.fanfable.presentation.screens.theme.WelcomeScreenDescriptionTextStyle
import cheysoff.fanfable.presentation.screens.theme.WelcomeScreenElementsColor
import cheysoff.fanfable.presentation.screens.theme.WelcomeScreenHeaderTextStyle

class WelcomeScreen {

    @Composable
    fun ShowWelcomeScreen() {
        BottomNextButtonScreen(
            topComposable = {
                Text(
                    text = "HI !",
                    style = WelcomeScreenHeaderTextStyle
                )
            },
            midComposable = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(28.dp)
                ) {

                    Icon(
                        painter = painterResource(id = R.drawable.book_icon),
                        tint = WelcomeScreenElementsColor,
                        contentDescription = null
                    )

                    Text(text = "Welcome to FanFable", style = WelcomeScreenDescriptionTextStyle)
                }
            },
        )
    }

    @Composable
    fun ShowUserChooserScreen() {
        BottomNextButtonScreen(
            topComposable = {
                Text(
                    text = "Who are you?",
                    style = WelcomeScreenChooseUserHeaderTextStyle
                )
            },
            midComposable = { OptionsList() }
        )
    }

    @Composable
    private fun OptionsList() {
        var selectedIndex by remember { mutableIntStateOf(0) }
        val options = listOf("Reader", "Writer")

        LazyColumn(
            modifier = Modifier
                .height(80.dp)
                .fillMaxWidth(0.85f)
                .clip(RoundedCornerShape(5.dp))
        ) {
            itemsIndexed(options) { index, option ->
                OptionItem(
                    text = option,
                    isSelected = index == selectedIndex,
                    rowBackgroundColor =
                    if (index % 2 == 1)
                        UserChooserOddCardBackgroundColor
                    else
                        UserChooserEvenCardBackgroundColor,
                    onSelected = {
                        selectedIndex = index
                        Log.d("cheys", "$selectedIndex $index")
                    }
                )
            }
        }
    }

    @Composable
    private fun OptionItem(
        text: String,
        rowBackgroundColor: Color,
        isSelected: Boolean,
        onSelected: () -> Unit
    ) {
        Column(
            modifier = Modifier.clickable { onSelected() }
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
                Text(text = text, style = WelcomeScreenChooseUserChooserTextStyle)

                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(20.dp)
                        .background(rowBackgroundColor)
                        .border(3.dp, WelcomeScreenElementsColor, CircleShape)
                        .padding(5.dp),
                    contentAlignment = Alignment.Center
                ) {
                    if (isSelected) {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            shape = CircleShape,
                            color = WelcomeScreenElementsColor
                        ) {}
                    }
                }

            }
            Divider()
        }
    }


    @Composable
    private fun BottomNextButtonScreen(
        topComposable: @Composable () -> Unit,
        midComposable: @Composable () -> Unit,
    ) {
        ThreePartsScreen(
            topComposable = topComposable,
            midComposable = midComposable,
            bottomComposable = {
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(60.dp),
                ) {
                    Surface(
                        shape = CircleShape,
                        color = WelcomeScreenElementsColor
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_next_button),
                            tint = BackgroundColor,
                            contentDescription = null
                        )
                    }

                }
            }
        )
    }

    @Composable
    private fun ThreePartsScreen(
        topComposable: @Composable () -> Unit,
        midComposable: @Composable () -> Unit,
        bottomComposable: @Composable () -> Unit
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColor),
            horizontalAlignment = Alignment.CenterHorizontally,


            ) {

            Box(
                modifier = Modifier.weight(0.25f),
                contentAlignment = Alignment.BottomCenter
            ) {
                topComposable()
            }

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.5f),
                contentAlignment = Alignment.Center
            ) {
                midComposable()
            }

            Box(
                modifier = Modifier
                    .weight(0.25f),
                contentAlignment = Alignment.TopCenter
            ) {
                bottomComposable()
            }

        }
    }
}