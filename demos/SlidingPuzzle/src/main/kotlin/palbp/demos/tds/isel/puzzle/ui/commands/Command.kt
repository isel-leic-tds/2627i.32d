package palbp.demos.tds.isel.puzzle.ui.commands

import palbp.demos.tds.isel.puzzle.domain.Board

/**
 * Uniform interface for commands
 */
interface Command {

    /**
     * Executes the command, yielding its result
     * @param context the context in which the command is executed
     * @param args the arguments for the command
     * @return the result of the command
     * @throws CommandException if the command fails to execute. Command implementations may throw any of the
     * derived exceptions.
     */
    @Throws(CommandException::class)
    fun execute(context: CommandContext, args: List<String>): CommandResult

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

    /**
     * The application should exit
     */
    object Exit : CommandResult

    /**
     * The command was successful and yielded a new board
     * @param board the new board
     */
    data class BoardResult(val board: Board) : CommandResult

    /**
     * The command was successful and yielded text to be displayed as a result
     * @param value the text to be displayed
     */
    data class TextResult(val value: String) : CommandResult
}
