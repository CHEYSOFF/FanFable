package cheysoff.onlyfanf.directions

import androidx.navigation.NamedNavArgument
import cheysoff.onlyfanf.NavigationCommand

object StartNavigation {

    val root = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "Start"

    }

    val StartWelcome = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "StartWelcome"

    }

    val StartUserPicker = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "StartUserPicker"
    }

    val StartGenreSelection = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "StartGenreSelection"

    }

    val StartCongratulate = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "StartCongratulate"

    }
}

//enum class StartScreen {
//    StartWelcome,
//    StartUserPicker,
//    StartGenreSelection,
//    StartCongratulate
//}