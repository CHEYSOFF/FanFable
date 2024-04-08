package cheysoff.onlyfanf

import cheysoff.onlyfanf.directions.BasicNavigation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class NavigationManager(private val externalScope: CoroutineScope) {

    var commands = MutableSharedFlow<NavigationCommand>()

    fun navigate(
        directions: NavigationCommand
    ) {
        externalScope.launch {
            commands.emit(directions)
        }
//        commands.tryEmit(directions)
//        commands.value = directions
    }

    fun navigateUp() {
        externalScope.launch {
            commands.emit(BasicNavigation.Up)
        }
//        commands.value = BasicNavigation.Up
    }

}