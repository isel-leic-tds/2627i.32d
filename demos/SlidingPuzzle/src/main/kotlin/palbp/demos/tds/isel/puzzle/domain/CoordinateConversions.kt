package palbp.demos.tds.isel.puzzle.domain



/**
 * Converts a rectangular coordinate to a linear coordinate.
 * @param row The row.
 * @param col The column.
 * @return The linear coordinate.
 * @throws IllegalArgumentException if the rectangular coordinate is out of bounds.
 */
fun rectangularToLinear(row: Int, col: Int): Int =
    require(row in 0 until Board.SIDE && col in 0 until Board.SIDE) { "Invalid coordinates" }
        .let { row * Board.SIDE + col }

/**
 * Converts a rectangular coordinate to a linear coordinate.
 * @return The linear coordinate.
 */
fun Board.Coordinate.toLinear(): Int = rectangularToLinear(row, col)

/**
 * Converts a linear coordinate to a rectangular coordinate.
 * @param linear The linear coordinate.
 * @return The rectangular coordinate.
 * @throws IllegalArgumentException if the linear coordinate is out of bounds.
 */
@Throws(IllegalArgumentException::class)
fun linearToRectangular(linear: Int): Board.Coordinate {
    return Board.Coordinate(row = linear / Board.SIDE, col = linear % Board.SIDE)
}

/**
 * Extension of Integer that converts a linear coordinate to a rectangular coordinate.
 * @return The rectangular coordinate.
 * @throws IllegalArgumentException if the linear coordinate is out of bounds.
 */
@Throws(IllegalArgumentException::class)
fun Int.toRectangular(): Board.Coordinate =
    linearToRectangular(this)

