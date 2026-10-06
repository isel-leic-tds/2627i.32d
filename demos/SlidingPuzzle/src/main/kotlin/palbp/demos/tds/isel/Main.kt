package palbp.demos.tds.isel

import palbp.demos.tds.isel.puzzle.commands.Command
import palbp.demos.tds.isel.puzzle.commands.CommandResult
import palbp.demos.tds.isel.puzzle.commands.NewCommand
import palbp.demos.tds.isel.puzzle.domain.Board
import palbp.demos.tds.isel.puzzle.ui.ConsoleDisplay
import palbp.demos.tds.isel.puzzle.ui.boardView

/**
 * Console application for playing 8-puzzle games.
 * It uses a REPL (Read-Evaluate-Print Loop) to interact with the user.
 *
 * Supported commands:
 * - new -> starts a new game
 * - move <line> <column> -> Moves, if possible, the tile in the given position
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
        val command: Command = NewCommand() // To be removed

        // execute
        board = when(val result = command.execute()) {
            CommandResult.Exit -> break
            is CommandResult.Success -> result.board
        }

        // display
        boardView(board = board, display = ConsoleDisplay)
    }
}
