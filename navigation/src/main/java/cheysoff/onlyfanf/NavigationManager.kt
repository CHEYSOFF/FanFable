package cheysoff.onlyfanf

import cheysoff.onlyfanf.directions.BasicNavigation
import kotlinx.coroutines.flow.MutableStateFlow

class NavigationManager {

    var commands = MutableStateFlow<NavigationCommand>(BasicNavigation.Default)

    fun navigate(
        directions: NavigationCommand
    ) {
        commands.value = directions
    }

    fun navigateUp() {
        commands.value = BasicNavigation.Up
    }

}