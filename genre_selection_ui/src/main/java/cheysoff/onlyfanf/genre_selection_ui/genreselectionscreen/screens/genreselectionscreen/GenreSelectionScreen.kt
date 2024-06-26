package cheysoff.onlyfanf.genre_selection_ui.genreselectionscreen.screens.genreselectionscreen

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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cheysoff.onlyfanf.design_system.components. BackButton
import cheysoff.onlyfanf.design_system.theme.LocalCustomColorScheme
import cheysoff.onlyfanf.design_system.theme.SelectGenreHeaderTextStyle
import cheysoff.onlyfanf.genre_selection_ui.genreselectionscreen.components.NextButtonBottomBar
import cheysoff.onlyfanf.genre_selection_ui.genreselectionscreen.screens.genreselectionscreen.components. GenreCard

//@Preview
@Composable
fun GenreSelectionScreen(
    state: GenreScreenState,
    onIntentReceived: (GenreSelectionScreenIntent) -> Unit
) {

    Scaffold(
        modifier = Modifier
            .background(LocalCustomColorScheme.current.screenElementsColor)
            .fillMaxSize()
            .padding(start = 26.dp, end = 26.dp, top = 32.dp),
        containerColor = Color.Transparent,
        topBar = {
            Box(modifier = Modifier.padding(bottom = 14.dp)) {
                BackButton(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .size(30.dp),
                    onClick = { onIntentReceived(GenreSelectionScreenIntent.PressBackButtonIntent) },
                    color = Color.White
                )
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
                isButtonEnabled = state.isButtonAvailable,
                buttonText = "Next",
                onClick = { onIntentReceived(GenreSelectionScreenIntent.PressNextButtonIntent) }
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
                    color = LocalCustomColorScheme.current.backgroundColor,
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
                    GenreCard(
                        genreModel = genre,
                        onClick = {
                            onIntentReceived(GenreSelectionScreenIntent.SelectGenreByIdIntent(genre.id))
                        },
                        modifier = modifier
                    )
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
