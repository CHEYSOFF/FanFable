package cheysoff.onlyfanf.my_stories_ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MyStoriesScreenViewModel() : ViewModel() {
    var state by mutableStateOf(MyStoriesScreenState())
        private set
}