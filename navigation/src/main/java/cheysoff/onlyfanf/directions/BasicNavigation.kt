package cheysoff.onlyfanf.directions

import androidx.navigation.NamedNavArgument
import cheysoff.onlyfanf.NavigationCommand

object BasicNavigation {

    val Default = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = ""
    }

    val Up = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "Up"

    }


}