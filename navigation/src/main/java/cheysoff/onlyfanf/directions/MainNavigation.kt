package cheysoff.onlyfanf.directions

import androidx.navigation.NamedNavArgument
import cheysoff.onlyfanf.NavigationCommand

object MainNavigation {

    val root = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "Main"

    }

    val MainFeed = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "MainFeed"

    }

    val MainMyStories = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "MainMyStories"
    }

    val MainProfile = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "MainProfile"

    }

    val MainSettings = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "MainSettings"

    }
}

//enum class MainScreen {
//    MainFeed,
//    MainMyStories,
//    MainProfile
//}