package palbp.demos.tds.isel.sliding.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

const val SIDE = 3

@Composable
fun PuzzleView(
    onPieceClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        repeat(times = SIDE) { row ->
            Row {
                repeat(times = SIDE) { column ->
                    val value = row * SIDE + (column + 1)
                    if (value < SIDE * SIDE)
                        PieceView(value = value, onClick = { onPieceClick(value) })
                    if (column < SIDE - 1)
                        Spacer(modifier = Modifier.size(4.dp))
                }
            }

            if (row < SIDE - 1)
                Spacer(modifier = Modifier.size(4.dp))
        }
    }
}

@Composable
@Preview
fun PuzzleViewPreview() {
    PuzzleView(
        onPieceClick = {}
    )
}
