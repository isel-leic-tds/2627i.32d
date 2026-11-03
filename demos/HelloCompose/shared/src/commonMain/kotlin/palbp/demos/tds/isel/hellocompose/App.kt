package palbp.demos.tds.isel.hellocompose

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun App() {
    MaterialTheme {
        Greeting(
            text = "SLB O MAIOR!!!",
            modifier = Modifier.border(
                width = 3.dp,
                color = Color.Red
            )
        )
    }
}

@Composable
fun Greeting(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontSize = 32.sp,
        modifier = modifier.padding(24.dp)
    )
}

@Composable
@Preview
fun GreetingPreview() {
    MaterialTheme {
        Greeting("MAIOR")
    }
}