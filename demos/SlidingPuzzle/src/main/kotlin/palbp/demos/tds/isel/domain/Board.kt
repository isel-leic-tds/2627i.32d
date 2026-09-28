package palbp.demos.tds.isel.domain

import palbp.demos.tds.isel.domain.Board.Piece.Companion.LOWER_LIMIT
import palbp.demos.tds.isel.domain.Board.Piece.Companion.UPPER_LIMIT

/**
 * Requirements for the board type
 *
 *  1 - Supports indexing with a linear coordinate (like a list of pieces)
 *  2 - Supports indexing with a rectangular coordinate (like a matrix of pieces)
 *  3 - Has a solved state
 *  4 - Is immutable
 *  5 - Contains the following operations:
 *      5.1 - Move a piece
 *      5.3 - Check if the board is solved
 *      5.6 - Convert to a list of pieces so that it can be iterated (this will be later refactored)
 *      5.7 - Create from a list of pieces
 */

/**
 * Script for the next lecture:
 * 5 - Document the code
 * 6 - Let's start building a console-based UI
 * 7 - Separation of concerns principle, revisited
 * 8 - The UI as a function of the data (the View)
 * 9 - Building a command loop (REPL style)
 */

class Board {

    @JvmInline
    value class Piece(val value: Int) {
        init {
            require(value in LOWER_LIMIT until UPPER_LIMIT)
        }

        companion object {
            const val LOWER_LIMIT = 1
            const val UPPER_LIMIT = SIDE * SIDE

        }
    }

    data class Coordinate(val row: Int, val col: Int) {
        init {
            require(row in 0 until SIDE)
            require(col in 0 until SIDE)
        }
    }

    private val pieces: List<Piece?>

    init {
        val initialList = mutableListOf<Piece>()
        repeat(times = UPPER_LIMIT - LOWER_LIMIT) {
            initialList.add(element = Piece(value = it + 1))
        }
        pieces = initialList.toList() + null
    }

    operator fun get(at: Int): Piece? = pieces[at]

    operator fun get(row: Int, col: Int): Piece? =
        pieces[rectangularToLinear(x = row, y = col)]

    fun getPieceOrNull(row: Int, col: Int): Piece? {
        TODO("Not yet implemented")
    }

    fun isAdjacentToEmptySpace(piece: Piece): Boolean {
        val emptyIndex = getEmptySpaceIndex()
        val (row, column) = linearToRectangular(emptyIndex)

        // TODO: Change this after we study HOFs
        if (row - 1 >= 0) {
            val upPiece = this[row - 1, column]
            if (piece == upPiece)
                return true
        }

        if (row + 1 < SIDE) {
            val downPiece = this[row + 1, column]
            if (piece == downPiece)
                return true
        }

        if (column - 1 >= 0) {
            val leftPiece = this[row, column - 1]
            if (piece == leftPiece)
                return true
        }

        if (column + 1 < SIDE) {
            val rightPiece = this[row, column + 1]
            if (piece == rightPiece)
                return true
        }

        return false
    }

    fun getEmptySpaceIndex(): Int =
        pieces.indexOf(null)

    companion object {
        const val SIDE = 3
    }
}
