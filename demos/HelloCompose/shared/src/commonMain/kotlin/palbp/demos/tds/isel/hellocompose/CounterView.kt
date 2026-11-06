package palbp.demos.tds.isel.hellocompose

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val spacing = 16.dp
private val buttonTextSize = 30.sp

@Composable
fun CounterView(value: Int, increment: () -> Unit, decrement: () -> Unit) {
    println("Counter composed")
    Column(modifier = Modifier.fillMaxSize().padding(all = spacing)) {
        Text(
            text = value.toString(),
            textAlign = TextAlign.Center,
            fontSize = 54.sp,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(spacing))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = increment) {
                Text(text = "+", fontSize = buttonTextSize)
            }
            Spacer(modifier = Modifier.width(spacing))
            Button(onClick = decrement) {
                Text(text = "-", fontSize = buttonTextSize)
            }
        }
    }
}

@Composable
@Preview
fun CounterViewPreview() {
    MaterialTheme {
        CounterView(value = 0, increment = { }, decrement = { })
    }
}