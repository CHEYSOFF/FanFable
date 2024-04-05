package cheysoff.onlyfanf

import cheysoff.onlyfanf.directions.StartNavigation
import kotlinx.coroutines.flow.MutableStateFlow

class NavigationManager {

    var commands = MutableStateFlow<NavigationCommand>(StartNavigation.Default)

    fun navigate(
        directions: NavigationCommand
    ) {
        commands.value = directions
    }

}