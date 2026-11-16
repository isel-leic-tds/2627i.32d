package palbp.demos.tds.isel.sliding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(onNavigateTo: (Route) -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
    ) {
        Button(onClick = { onNavigateTo(Route.PUZZLE) }) {
            Text(text = "New Puzzle")
        }
        Button(onClick = { onNavigateTo(Route.PUZZLE) }) {
            Text(text = "Continue Puzzle")
        }
        Button(onClick = { onNavigateTo(Route.ABOUT) }) {
            Text(text = "About")
        }
    }
}