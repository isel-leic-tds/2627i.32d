package palbp.demos.tds.isel.puzzle.ui.commands

import palbp.demos.tds.isel.puzzle.domain.Board

/**
 * Implementation of the new command
 */
class NewCommand : Command {

    /**
     * Executes the new command. Any arguments passed to the command are ignored.
     * @return the result of the command
     */
    override fun execute(board: Board?, args: List<String>) = CommandResult.Success(Board())

    /**
     * Returns the usage information for the new command
     * @return the usage information
     */
    override fun usage(): String = "New -> starts a new game"
}