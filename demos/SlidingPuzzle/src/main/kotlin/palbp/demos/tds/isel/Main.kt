package palbp.demos.tds.isel

import palbp.demos.tds.isel.puzzle.domain.Board
import palbp.demos.tds.isel.puzzle.ui.ConsoleDisplay
import palbp.demos.tds.isel.puzzle.ui.boardView
import palbp.demos.tds.isel.puzzle.ui.commands.CommandException
import palbp.demos.tds.isel.puzzle.ui.commands.CommandResult
import palbp.demos.tds.isel.puzzle.ui.parse

/**
 * Console application for playing 8-puzzle games.
 * It uses a REPL (Read-Evaluate-Print Loop) to interact with the user.
 *
 * Supported commands:
 * - New -> starts a new game
 * - Move <line> <column> -> Moves, if possible, the tile in the given position
 * - Solve -> automatically solves the puzzle by returning the sequence of moves that solves it
 * - Quit -> exits the application
 * - Help -> Displays all the supported commands
 */
fun main() {
    var board: Board? = null

    while (true) {
        print("Enter a command: ")
        val input = readln()

        // parse
        val (command, args) = parse(input)

        // execute
        try {

            val result = command.execute(board, args)
            board = when(result) {
                CommandResult.Exit -> break
                is CommandResult.Success -> result.board
            }

            // display
            boardView(board = board, display = ConsoleDisplay)

        } catch (e: CommandException) {
            // TODO: Handle command execution errors
        }
    }
}
