package palbp.demos.tds.isel.sliding.ui

import androidx.compose.runtime.Composable

@Composable
fun PuzzleScreen() {
    PuzzleView(
        onPieceClick = {
            println("Piece clicked: $it")
        }
    )
}