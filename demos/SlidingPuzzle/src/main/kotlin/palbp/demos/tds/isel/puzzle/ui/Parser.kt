package palbp.demos.tds.isel.puzzle.ui

import palbp.demos.tds.isel.puzzle.ui.commands.*

/**
 * Produces the command that corresponds to the given input
 * @param input the input to be parsed
 * @return the corresponding command
 * @throws UnknownCommandException if the input does not correspond to a known command
 */
@Throws(UnknownCommandException::class)
fun parse(input: String): Pair<Command, List<String>> {
    val parts = input.trim()
        .split(" ")
        .filter { it.isNotBlank() }

    if (parts.isEmpty()) {
        throw UnknownCommandException("No command provided")
    }

    val parsedCommand = when (val command = parts[0].lowercase()) {
        "new" -> NewCommand()
        "quit" -> QuitCommand()
        "move" -> MoveCommand()
        "solve" -> SolveCommand()
        "help" -> HelpCommand()
        else -> throw UnknownCommandException("Unknown command: $command")
    }
    return Pair(parsedCommand, parts.drop(n = 1))
}
