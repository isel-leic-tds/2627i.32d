package palbp.demos.tds.isel.puzzle.ui.commands

import palbp.demos.tds.isel.puzzle.domain.Board
import palbp.demos.tds.isel.puzzle.ui.commands.CommandResult.BoardResult

/**
 * Implementation of the Move command
 */
class MoveCommand: Command {

    /**
     * Executes the move command
     * @param context the context in which the command is executed
     * @param args the arguments for the command
     * @return the result of the command
     * @throws InvalidCommandArgumentsException if the command arguments are invalid.
     * @throws InvalidMoveCoordinatesException if the move coordinates are invalid, that is, the row or column are out of bounds.
     * @throws PieceNotMoveableException if the piece at the specified coordinates is not moveable
     * @throws IllegalArgumentException if a board was not received. The move command requires a board to be provided.
     */
    @Throws(CommandException::class)
    override fun execute(context: CommandContext, args: List<String>): CommandResult {

        requireNotNull(context.board) { "Must have a board for move command" }

        if (args.size != 2) {
            throw InvalidCommandArgumentsException(this, "Move command requires exactly 2 arguments")
        }

        val row = args[0].toIntOrNull() ?: throw InvalidCommandArgumentsException(this, "Invalid row argument for move command")
        val col = args[1].toIntOrNull() ?: throw InvalidCommandArgumentsException(this, "Invalid col argument for move command")

        if (row < 0 || row >= Board.SIDE || col < 0 || col >= Board.SIDE) {
            throw InvalidMoveCoordinatesException("Invalid move: ($row, $col)")
        }

        val piece = context.board[row, col]
        if (piece == null || !context.board.isAdjacentToEmptySpace(piece))
            throw PieceNotMoveableException("No piece to move at ($row, $col)")

        return BoardResult(context.board.move(piece))
    }

    /**
     * Returns the usage information for the move command
     * @return the usage information
     */
    override fun usage(): String = "Move <line> <col> -> moves the piece at (<line>, <col>) on the board"
}
