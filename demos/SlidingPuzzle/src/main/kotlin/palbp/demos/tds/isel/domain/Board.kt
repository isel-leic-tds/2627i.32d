package palbp.demos.tds.isel.domain


/**
 * Requirements for the board type
 *
 *  1 - Supports indexing with a linear coordinate (like a list of pieces)
 *  2 - Supports indexing with a rectangular coordinate (like a matrix of pieces)
 *  3 - Has a solved state
 *  4 - Is immutable
 *  5 - Contains the following operations:
 *      5.1 - Move a piece
 *      5.2 - Check if a piece can move (is adjacent to the empty space)
 *      5.3 - Check if the board is solved
 *      5.4 - Get the empty space position
 *      5.5 - Get the piece at a given position
 *      5.6 - Convert to a list of pieces so that it can be iterated (this will be later refactored)
 *      5.7 - Create from a list of pieces
 */
class Board() {

    private val pieces: List<Piece?>

    init {
        val initialList = mutableListOf<Piece>()
        repeat(times = Piece.UPPER_LIMIT) {
            initialList.add(element = Piece(value = it + 1))
        }
        pieces = initialList.toList()
    }

    operator fun get(at: Int): Piece? {
        TODO("Implement this method")
    }

    operator fun get(row: Int, col: Int): Piece? {
        TODO("Implement this method")
    }

    companion object {
        const val SIDE = 3
    }
}

fun createSolvedBoard() = Board()
