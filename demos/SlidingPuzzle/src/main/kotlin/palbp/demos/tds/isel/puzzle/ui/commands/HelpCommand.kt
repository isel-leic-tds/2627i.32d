package palbp.demos.tds.isel.puzzle.ui.commands

import palbp.demos.tds.isel.puzzle.ui.commands.CommandResult.TextResult

/**
 * Displays the list of supported commands.
 */
class HelpCommand : Command {

    override fun execute(context: CommandContext, args: List<String>): CommandResult {
        val result = buildString {
            appendLine("Available commands:")
            context.supportedCommands.forEach { command ->
                appendLine("  ${command.usage()}")
            }
        }
        return TextResult(result)
    }


    override fun usage(): String = "Help -> Displays the help message"
}