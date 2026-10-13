package palbp.demos.tds.isel.puzzle.ui.commands

import palbp.demos.tds.isel.puzzle.domain.Board

/**
 * Implementation of the Move command
 */
class MoveCommand: Command {

    /**
     * Executes the move command
     * @param board the board on which the command is executed
     * @param args the arguments for the command
     * @return the result of the command
     * @throws InvalidMoveCoordinatesException if the move coordinates are invalid
     * @throws PieceNotMoveableException if the piece at the specified coordinates is not moveable
     * @throws IllegalArgumentException if any of the arguments are invalid
     */
    @Throws(InvalidMoveCoordinatesException::class, PieceNotMoveableException::class)
    override fun execute(board: Board?, args: List<String>): CommandResult {
        if (args.size != 2) {
            throw IllegalArgumentException("Move command requires exactly 2 arguments")
        }

        val board = board ?: throw IllegalArgumentException("Must have a board for move command")
        val row = args[0].toIntOrNull() ?: throw IllegalArgumentException("Invalid row argument for move command")
        val col = args[1].toIntOrNull() ?: throw IllegalArgumentException("Invalid col argument for move command")

        if (row < 0 || row >= Board.SIDE || col < 0 || col >= Board.SIDE) {
            throw InvalidMoveCoordinatesException("Invalid move: ($row, $col)")
        }

        val piece = board[row, col]
        if (piece == null || !board.isAdjacentToEmptySpace(piece))
            throw PieceNotMoveableException("No piece to move at ($row, $col)")

        return CommandResult.Success(board.move(piece))
    }

    /**
     * Returns the usage information for the move command
     * @return the usage information
     */
    override fun usage(): String = "Move <line> <col> -> moves the piece at (<line>, <col>) on the board"
}
