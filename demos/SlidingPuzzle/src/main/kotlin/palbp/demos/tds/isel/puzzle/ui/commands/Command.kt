package palbp.demos.tds.isel.puzzle.ui.commands

import palbp.demos.tds.isel.puzzle.domain.Board

/**
 * Uniform interface for commands
 */
interface Command {

    /**
     * Executes the command, yielding its result
     * @param board the board (if one exists) on which the command is executed
     * @param args the arguments for the command
     * @return the result of the command
     * @throws CommandException if the command fails to execute. Command implementations may throw any of the
     * derived exceptions.
     */
    @Throws(CommandException::class)
    fun execute(board: Board? = null, args: List<String>): CommandResult

    /**
     * Returns the usage information for the command
     * @return the usage information
     */
    fun usage(): String
}

/**
 * Sealed hierarchy used to represent all possible results of a command
 */
sealed interface CommandResult {
    object Exit : CommandResult
    data class Success(val board: Board) : CommandResult
}
