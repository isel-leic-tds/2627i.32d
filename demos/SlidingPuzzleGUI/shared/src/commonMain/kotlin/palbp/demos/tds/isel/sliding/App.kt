package palbp.demos.tds.isel.sliding

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import palbp.demos.tds.isel.sliding.ui.MainScreen
import palbp.demos.tds.isel.sliding.ui.PuzzleScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        println("Running composition")
        var currentRoute: Route by remember { mutableStateOf(Route.MAIN) }
        when (currentRoute) {
            Route.MAIN -> MainScreen(onNavigateTo = {
                println("Navigate to $it. Current screen is $currentRoute")
                currentRoute = it
            })
            Route.PUZZLE -> {
                println("Navigate to ${Route.PUZZLE}. Current screen is $currentRoute")
                PuzzleScreen()
            }
            Route.ABOUT -> {
                println("Navigate to ${Route.ABOUT}. Current screen is $currentRoute")
                /* AboutScreen() */
            }
        }
    }
}