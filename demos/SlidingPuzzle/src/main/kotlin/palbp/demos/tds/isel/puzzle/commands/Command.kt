package palbp.demos.tds.isel.puzzle.commands

import palbp.demos.tds.isel.puzzle.domain.Board

/**
 * Uniform interface for commands
 */
interface Command {

    /**
     * Executes the command, yielding its result
     * @return the result of the command
     * @throws CommandException if the command fails to execute
     */
    @Throws(CommandException::class)
    fun execute(): CommandResult
}

/**
 * Sealed hierarchy used to represent all possible results of a command
 */
sealed interface CommandResult {
    object Exit : CommandResult
    data class Success(val board: Board) : CommandResult
}
