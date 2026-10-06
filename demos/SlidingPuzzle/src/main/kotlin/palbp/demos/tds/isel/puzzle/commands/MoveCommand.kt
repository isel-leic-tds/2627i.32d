package palbp.demos.tds.isel.puzzle.commands

import palbp.demos.tds.isel.puzzle.domain.Board

class MoveCommand(
    private val board: Board,
    private val row: Int,
    private val col: Int
) : Command {

    @Throws(InvalidMoveCoordinatesException::class, PieceNotMoveableException::class)
    override fun execute(): CommandResult {
        if (row < 0 || row >= Board.SIDE || col < 0 || col >= Board.SIDE) {
            throw InvalidMoveCoordinatesException("Invalid move: ($row, $col)")
        }

        val piece = board[row, col] ?: throw PieceNotMoveableException("No piece to move at ($row, $col)")
        return CommandResult.Success(board.move(piece))
    }
}
