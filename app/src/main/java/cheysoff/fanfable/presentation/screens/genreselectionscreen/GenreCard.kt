package cheysoff.fanfable.presentation.screens.genreselectionscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cheysoff.fanfable.R
import cheysoff.fanfable.domain.model.GenreModel
import cheysoff.fanfable.presentation.screens.theme.BackgroundColor
import cheysoff.fanfable.presentation.screens.theme.GenreTypeTextStyle
import cheysoff.fanfable.presentation.screens.theme.ScreenElementsColor
import coil.compose.AsyncImage
import coil.request.ImageRequest

//@Preview
@Composable
fun ShowGenreCard(
    genreModel: GenreModel,
    onClick: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    var isChosen by rememberSaveable { mutableStateOf(false) }
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(6.dp),
        color = BackgroundColor,
        shadowElevation = 5.dp,
        onClick = {
            isChosen = !isChosen
            onClick(isChosen)
        }
    ) {

        if (isChosen) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = genreModel.genreName, style = GenreTypeTextStyle)
                Icon(
                    modifier = Modifier.size(40.dp),
                    painter = painterResource(id = R.drawable.chosen_icon),
                    tint = ScreenElementsColor,
                    contentDescription = null
                )
            }
        } else {
            Row(
                modifier = Modifier.padding(horizontal = 9.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = genreModel.genreName, style = GenreTypeTextStyle)
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(genreModel.genrePicturePath)
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 2.dp),
                    alignment = Alignment.CenterEnd
                )
            }
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomStart
            ) {
                Surface(
                    modifier = Modifier
                        .padding(horizontal = 9.dp, vertical = 14.dp)
                        .size(20.dp)
                        .clip(CircleShape),
                    color = ScreenElementsColor
                ) {
                    Icon(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(3.dp),
                        painter = painterResource(id = R.drawable.plus_icon),
                        tint = BackgroundColor,
                        contentDescription = null
                    )
                }
            }
        }
    }
}