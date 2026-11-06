package palbp.demos.tds.isel.hellocompose

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        var counter by remember { mutableStateOf(value = Counter(0)) }
        CounterView(
            value = counter.value,
            increment = {
                counter = counter.inc()
                Thread.sleep(20_000)
            },
            decrement = { counter = counter.dec() }
        )
    }
}

