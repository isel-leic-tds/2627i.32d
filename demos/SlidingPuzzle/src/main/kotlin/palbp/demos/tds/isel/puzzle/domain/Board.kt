package palbp.demos.tds.isel.puzzle.domain

import palbp.demos.tds.isel.puzzle.domain.Board.Piece.Companion.LOWER_LIMIT
import palbp.demos.tds.isel.puzzle.domain.Board.Piece.Companion.UPPER_LIMIT

/**
 * Represents the puzzle board. Instances of this class are immutable.
 */
class Board : Iterable<Board.Piece?> {

    /**
     * Represents the pieces of the puzzle. The piece value must be in the interval [LOWER_LIMIT, UPPER_LIMIT[
     * @property value the piece value
     * @constructor Creates a new piece with the given value. Throws IllegalArgumentException if the value is not in
     * the valid range.
     * @throws IllegalArgumentException if the value is not in the valid range
     */
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

    /**
     * Represents rectangular coordinates in the puzzle.
     * @property row the row, in the range [0, SIDE[
     * @property col the column, in the range [0, SIDE[
     * @constructor Creates a new coordinate with the given row and column. Throws IllegalArgumentException if the
     * coordinates are not in the valid range.
     * @throws IllegalArgumentException if the coordinates are not in the valid range
     */
    data class Coordinate(val row: Int, val col: Int) {
        init {
            require(row in 0 until SIDE)
            require(col in 0 until SIDE)
        }
    }

    /**
     * The list of pieces comprising the puzzle. Null represents the empty space.
     */
    private val pieces: List<Piece?>

    /**
     * Initializes a new board with the solved configuration.
     */
    constructor(): this(pieces = (1..< UPPER_LIMIT).map { Board.Piece(it) } + null)

    /**
     * Initializes a new board with the given list of pieces.
     * @param pieces the list of pieces to initialize the board with
     */
    constructor(pieces: List<Piece?>) {
        this.pieces = pieces
    }

    /**
     * Returns the piece at the specified linear index, or null if the index corresponds to the empty space.
     * @param at the linear index in the range [0, pieces.size[
     * @return the piece at the specified index, or null if the index corresponds to the empty space
     * @throws IndexOutOfBoundsException if the specified index isn't in the valid range
     */
    @Throws(IndexOutOfBoundsException::class)
    operator fun get(at: Int): Piece? = pieces[at]

    /**
     * Returns the piece at the specified rectangular coordinates, or null if the coordinates correspond to the empty space.
     * @param row the row, in the range [0, SIDE[
     * @param col the column, in the range [0, SIDE[
     * @return the piece at the specified coordinates, or null if the coordinates correspond to the empty space
     * @throws IndexOutOfBoundsException if the specified index isn't in the valid range
     */
    @Throws(IllegalArgumentException::class)
    operator fun get(row: Int, col: Int): Piece? =
        if (row in 0 until SIDE && col in 0 until SIDE) { pieces[rectangularToLinear(row, col)] }
        else throw IndexOutOfBoundsException("Invalid coordinates")

    /**
     * Gets the piece at the specified rectangular coordinates, or null if the coordinates are out of bounds or
     * correspond to the empty space.
     * @param row the row, in the range [0, SIDE[
     * @param col the column, in the range [0, SIDE[
     * @return the piece at the specified coordinates, or null if the coordinates are out of bounds or correspond
     * to the empty space
     */
    fun getPieceOrNull(row: Int, col: Int): Piece? =
        if (row in 0 until SIDE && col in 0 until SIDE) this[row, col]
        else null

    /**
     * Checks if the given piece is adjacent to the empty space.
     * @param piece the piece to check
     * @return true if the piece is adjacent to the empty space, false otherwise
     */
    fun isAdjacentToEmptySpace(piece: Piece): Boolean {
        val (row, column) = linearToRectangular(pieces.indexOf(piece))
        val (emptyRow, emptyColumn) = linearToRectangular(getEmptySpaceIndex())

        return row == emptyRow && column == emptyColumn - 1 ||      // Left
                row == emptyRow && column == emptyColumn + 1 ||     // Right
                row == emptyRow - 1 && column == emptyColumn ||     // Up
                row == emptyRow + 1 && column == emptyColumn        // Down
    }

    /**
     * Returns the index of the empty space in the piece list.
     * @return the index of the empty space
     */
    fun getEmptySpaceIndex(): Int = pieces.indexOf(null)

    /**
     * Returns a list of all pieces in the board, including the empty space. The position of the piece in this list
     * corresponds to its position in the board (considering the linear indexing).
     * @return a list of all pieces in the board, including the empty space which is represented as null.
     */
    fun toList(): List<Piece?> = pieces.toList()

    /**
     * Moves the specified piece to the empty space.
     * @param piece the piece to move
     * @return a new board with the piece moved to the empty space, or the same board if the move was illegal.
     */
    fun move(piece: Piece): Board {
        val pieceIndex = pieces.indexOf(piece)
        val emptySpaceIndex = getEmptySpaceIndex()

        return if (isAdjacentToEmptySpace(piece)) {
            val newBoardPieces = pieces.toMutableList()
            newBoardPieces[emptySpaceIndex] = piece
            newBoardPieces[pieceIndex] = null
            Board(newBoardPieces)
        }
        else {
            this
        }
    }

    /**
     * Checks whether the board is solved or not.
     * @return true if the board is solved, false otherwise
     */
    fun isSolved(): Boolean {
        return pieces == solved
    }

    /**
     * Returns an iterator over the pieces in the board. This is a requirement for the [Iterable] interface.
     * @return an iterator over the pieces in the board
     */
    override fun iterator(): Iterator<Piece?> = pieces.iterator()

    companion object {

        /**
         * The board side
         */
        const val SIDE = 3

        /**
         * The solved board configuration.
         */
        val solved = Board()
    }
}
