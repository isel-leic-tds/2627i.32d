package palbp.demos.tds.isel.puzzle.ui.commands

import palbp.demos.tds.isel.puzzle.domain.Board

/**
 * The quit command implementation
 */
class QuitCommand : Command {

    /**
     * Executes the quit command. Any arguments passed to the command are ignored.
     * @return the result of the command
     */
    override fun execute(context: CommandContext, args: List<String>) = CommandResult.Exit

    /**
     * Returns the usage information for the quit command
     * @return the usage information
     */
    override fun usage(): String = "Quit -> exits the application"
}