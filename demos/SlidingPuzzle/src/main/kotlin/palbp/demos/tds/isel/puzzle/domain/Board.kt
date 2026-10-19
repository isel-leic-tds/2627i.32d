package palbp.demos.tds.isel.puzzle.domain

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
            require(isValid(row, col))
        }

        /**
         * Returns the list of neighboring coordinates.
         * @return the list of neighboring coordinates.
         */
        fun neighbors(): List<Coordinate> = buildList {
            createOrNull(row, col - 1)?.let { add(it) }
            createOrNull(row, col + 1)?.let { add(it) }
            createOrNull(row - 1, col)?.let { add(it) }
            createOrNull(row + 1, col)?.let { add(it) }
        }

        companion object {
            /**
             * Returns true if the given coordinates are valid for this board.
             * @param row the row to check
             * @param col the column to check
             * @return true if the coordinates are valid, false otherwise
             */
            private fun isValid(row: Int, col: Int) = row in 0 until SIDE && col in 0 until SIDE

            /**
             * Creates a new coordinate with the given row and column, or null if the coordinates are invalid.
             * @param row the row
             * @param col the column
             * @return a new coordinate with the given row and column, or null if the coordinates are invalid
             */
            fun createOrNull(row: Int, col: Int) = if (isValid(row, col)) Coordinate(row, col) else null
        }
    }

    /**
     * The list of pieces comprising the puzzle. Null represents the empty space.
     */
    private val pieces: List<Piece?>

    /**
     * Initializes a new board with the solved configuration.
     */
    constructor() : this(pieces = (1..<UPPER_LIMIT).map { Piece(it) } + null)

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
        if (row in 0 until SIDE && col in 0 until SIDE) {
            pieces[rectangularToLinear(row, col)]
        } else throw IndexOutOfBoundsException("Invalid coordinates")

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
        return isAdjacentToEmptySpace(pieces.indexOf(piece).toRectangular())
    }

    /**
     * Checks if the given coordinate is adjacent to the empty space.
     * @param coordinate the coordinate to check
     * @return true if the coordinate is adjacent to the empty space, false otherwise
     */
    fun isAdjacentToEmptySpace(coordinate: Coordinate): Boolean {
        val (row, column) = coordinate
        val (emptyRow, emptyColumn) = getEmptySpaceCoordinate()

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
     * Returns the coordinate of the empty space.
     * @return the coordinate of the empty space
     */
    fun getEmptySpaceCoordinate() = getEmptySpaceIndex().toRectangular()

    /**
     * Moves the specified piece to the empty space.
     * @param piece the piece to move
     * @return a new board with the piece moved to the empty space, or the same board if the move was illegal.
     */
    fun move(piece: Piece): Board = movePieceAt(pieces.indexOf(piece).toRectangular())

    /**
     * Returns the coordinate of the specified piece.
     * @param it the piece to get the coordinate for
     * @return the coordinate of the piece, or null if the piece is not on the board
     */
    fun getCoordinate(it: Piece): Coordinate = pieces.indexOf(it).toRectangular()

    /**
     * Moves the piece at the specified coordinate to the empty space.
     * @param at the coordinate of the piece to move
     * @return a new board with the piece moved to the empty space, or the same board if the move was illegal.
     */
    fun movePieceAt(at: Coordinate): Board {
        val pieceIndex = at.toLinear()
        val emptySpaceIndex = getEmptySpaceIndex()

        return if (isAdjacentToEmptySpace(at)) {
            val newBoardPieces = pieces.toMutableList()
            newBoardPieces[emptySpaceIndex] = pieces[pieceIndex]
            newBoardPieces[pieceIndex] = null
            Board(newBoardPieces)
        } else {
            this
        }
    }

    /**
     * Checks whether the board is solved or not.
     * @return true if the board is solved, false otherwise
     */
    fun isSolved(): Boolean {
        return pieces == solved.pieces
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

        /**
         * An 8-puzzle is solvable if the number of inversions is even.
         * NOTE: this is a simplification that applies to the 8-puzzle with the blank space in the bottom-right corner.
         * For a detailed explanation of the solvability rule, see:
         * https://www.geeksforgeeks.org/check-instance-8-puzzle-solvable/
         */
        fun createRandom(): Board {
            val shuffled = (1..<UPPER_LIMIT).shuffled().toMutableList()
            val solvable = if (shuffled.isSolvable()) {
                shuffled
            } else {
                shuffled.swapInversion()
            }
            return Board(solvable.map { Piece(it) } + null)
        }
    }

    // Canonical methods

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Board

        return pieces == other.pieces
    }

    override fun hashCode() = pieces.hashCode()

    override fun toString() = pieces.joinToString(" ")
}
