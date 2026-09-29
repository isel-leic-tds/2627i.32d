package palbp.demos.tds.isel.puzzle.ui

import palbp.demos.tds.isel.puzzle.domain.Board

/**
 * Used to display a puzzle board.
 * @param board The board to display.
 * @param display The display to use.
 */
fun boardView(board: Board, display: Display) {
    repeat(Board.SIDE) { row ->
        repeat(Board.SIDE) { col ->
            val piece = board[row, col]
            if (piece != null)
                display.show(piece.value.toString() + " ")
        }
        display.newLine()
    }
    display.newLine()
}