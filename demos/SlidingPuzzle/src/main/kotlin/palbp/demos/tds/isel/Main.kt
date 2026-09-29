package palbp.demos.tds.isel

import palbp.demos.tds.isel.puzzle.domain.Board
import palbp.demos.tds.isel.puzzle.ui.ConsoleDisplay
import palbp.demos.tds.isel.puzzle.ui.boardView

/**
 * Console application for playing 8-puzzle games.
 *
 * Supported commands:
 * - new -> starts a new game
 * - move <line> <column> -> Moves, if possible, the tile in the givem position
 * - solve -> automatically solves the puzzle by returning the sequence of moves that solves it
 * - quit -> exits the application
 * - help -> Displays all the supported commands
 */
fun main() {
    var board = Board()

    while (true) {
        val input = readln()

        // parse
        // ...
        // val command: Command = parse(input)

        // execute
        // board = command.execute(...)

        // display
        boardView(board = board, display = ConsoleDisplay)
    }
}