package cheysoff.fanfable.presentation.screens.genreselectionscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cheysoff.fanfable.R
import cheysoff.fanfable.presentation.screens.loginscreen.components.NextButtonBottomBar
import cheysoff.fanfable.presentation.screens.theme.BackgroundColor
import cheysoff.fanfable.presentation.screens.theme.ScreenElementsColor
import cheysoff.fanfable.presentation.screens.theme.SelectGenreHeaderTextStyle

//@Preview
@Composable
fun GenreSelectionScreen(state: GenreScreenState) {
    var isButtonEnabled by rememberSaveable { mutableStateOf(false) }
    val chosenGenres = mutableSetOf<String>()

    Scaffold(
        modifier = Modifier
            .background(ScreenElementsColor)
            .fillMaxSize()
            .padding(start = 26.dp, end = 26.dp, top = 32.dp),
        containerColor = Color.Transparent,
        topBar = {
            Box(modifier = Modifier.padding(bottom = 14.dp)) {
                IconButton(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .size(height = 18.dp, width = 9.dp),
                    onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.return_back_button_icon),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Select your\n favorite genres",
                    minLines = 2,
                    maxLines = 2,
                    textAlign = TextAlign.Center,
                    style = SelectGenreHeaderTextStyle
                )
            }

        },
        bottomBar = {
            NextButtonBottomBar(
                isButtonEnabled = isButtonEnabled,
                buttonText = "Next"
            )
        }
    ) {
        if (state.isLoading) {
            Box(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
            ) {
                CircularProgressIndicator(
                    color = BackgroundColor,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
        state.genres?.let { data ->
            LazyVerticalStaggeredGrid(
                modifier = Modifier.padding(it),
                columns = StaggeredGridCells.Fixed(2),
                verticalItemSpacing = 16.dp,
                horizontalArrangement = Arrangement.spacedBy(16.dp)

            ) {
                items(data) { genre ->
                    val modifier =
                        Modifier
                            .height(110.dp)
                            .fillMaxWidth()
                    ShowGenreCard(genreModel = genre, { isChosen ->
                        if (isChosen) {
                            chosenGenres.add(genre.genreName)
                        } else {
                            chosenGenres.remove(genre.genreName)
                        }

                        isButtonEnabled = chosenGenres.isNotEmpty()
                    }, modifier = modifier)
                }
            }
        }
        state.error?.let { error ->
            Text(
                modifier = Modifier.fillMaxSize(),
                text = error,
                color = Color.Red,
                textAlign = TextAlign.Center,
            )
        }
    }

}
