package palbp.demos.tds.isel.puzzle.ui.commands

import palbp.demos.tds.isel.puzzle.domain.Board

/**
 * Displays the list of supported commands.
 * TODO: Discuss the transition to CommandContext as an argument for the execute method.
 */
class HelpCommand : Command {

    override fun execute(board: Board?, args: List<String>): CommandResult {
        TODO("Not yet implemented")
    }

    override fun usage(): String {
        TODO("Not yet implemented")
    }
}