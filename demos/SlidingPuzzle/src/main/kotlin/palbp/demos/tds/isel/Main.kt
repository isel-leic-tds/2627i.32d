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

/**
 * Script for the next lecture:
 * 1 - Revisit the code base. Start at the main function and trace the execution of each command
 * 2 - Implement error handling for invalid commands and arguments
 * 3 - Implement the Help command to display all supported commands
 *  3.1 - Start with motivation to introduce the "Context based" approach
 *  3.2 - Prepare for a new result type. The sum type will contain Exit, BoardResult, HelpResult
 *  3.3 - Implement the Context and modify the command execution to use it and update the tests accordingly
 * 4 - Implement the solve command
 */
fun main() {
    var board: Board? = null

    while (true) {
        print("Enter a command: ")
        val input = readln()

        val (command, args) = parse(input)

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
            println("Error: ${e.message}")
        }
    }
}
