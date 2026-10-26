package palbp.demos.tds.isel

import palbp.demos.tds.isel.puzzle.ui.ConsoleDisplay
import palbp.demos.tds.isel.puzzle.ui.displayBoard
import palbp.demos.tds.isel.puzzle.ui.commands.*
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
 *  3.1 - Start with motivation to introduce the "Context-based" approach
 *  3.2 - Prepare for a new result type. The sum type will contain Exit, BoardResult, HelpResult
 *  3.3 - Implement the Context and modify the command execution to use it and update the tests accordingly
 * 4 - Implement the solve command
 */
fun main() {

    var context = CommandContext(
        supportedCommands = listOf(NewCommand(), MoveCommand(), SolveCommand(), HelpCommand(), QuitCommand())
    )

    while (true) {

        print("Enter command >> ")
        val input = readln()

        try {
            val (command, args) = parse(input)

            when(val result = command.execute(context, args)) {
                is CommandResult.BoardResult -> {
                    displayBoard(board = result.board, display = ConsoleDisplay)
                    context = context.copy(board = result.board)
                }
                is CommandResult.TextResult -> {
                    println(result.value)
                }
                CommandResult.Exit -> break
            }
        }
        catch (e: InvalidCommandArgumentsException) {
            println("Error: Invalid command arguments.")
            println("Usage: ${e.command.usage()}")
        }
        catch (e: UnknownCommandException) {
            println("Error: Command not found. Type 'Help' for a list of supported commands.")
            println("Error message is: ${e.message}")
        }
    }
}