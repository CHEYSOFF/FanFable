package cheysoff.fanfable.presentation.screens.genreselectionscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cheysoff.fanfable.R
import cheysoff.fanfable.presentation.screens.theme.BackgroundColor
import cheysoff.fanfable.presentation.screens.theme.NextButtonGradient1
import cheysoff.fanfable.presentation.screens.theme.NextButtonGradient2
import cheysoff.fanfable.presentation.screens.theme.NextButtonGradient3
import cheysoff.fanfable.presentation.screens.theme.NextButtonGradient4
import cheysoff.fanfable.presentation.screens.theme.NextButtonTextStyle
import cheysoff.fanfable.presentation.screens.theme.ScreenElementsColor
import cheysoff.fanfable.presentation.screens.theme.SelectGenreHeaderTextStyle

//@Preview
@Composable
fun GenreSelectionScreen(state: GenreScreenState) {
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
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                color = ScreenElementsColor
            ) {
                GradientButton(
                    onClick = { /* Handle button click */ },
                    modifier = Modifier
                        .padding(horizontal = 25.dp, vertical = 30.dp)
                        .fillMaxSize(),
                    colors = listOf(
                        NextButtonGradient1,
                        NextButtonGradient2,
                        NextButtonGradient3,
                        NextButtonGradient4,
                    )
                ) {
                    Text(
                        text = "Next",
                        style = NextButtonTextStyle,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    ) {
        if (state.isLoading) {
            Box(modifier = Modifier
                .padding(it)
                .fillMaxSize()) {
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

@Composable
fun GradientButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: List<Color>,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(42.dp)
            )
            .clip(RoundedCornerShape(42.dp))
            .background(
                brush = Brush.verticalGradient(colors = colors),
                shape = RoundedCornerShape(42.dp)
            ),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        content = content
    )
}
