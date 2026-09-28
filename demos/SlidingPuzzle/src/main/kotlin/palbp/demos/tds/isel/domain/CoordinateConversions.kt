package palbp.demos.tds.isel.domain


fun rectangularToLinear(x: Int, y: Int): Int {
    return y + x * Board.SIDE
}

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
