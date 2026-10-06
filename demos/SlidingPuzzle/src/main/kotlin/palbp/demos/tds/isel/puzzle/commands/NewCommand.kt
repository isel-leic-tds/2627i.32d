package palbp.demos.tds.isel.puzzle.commands

import palbp.demos.tds.isel.puzzle.domain.Board

/**
 * Implementation of the new command
 */
class NewCommand : Command {
    override fun execute() = CommandResult.Success(Board())
}