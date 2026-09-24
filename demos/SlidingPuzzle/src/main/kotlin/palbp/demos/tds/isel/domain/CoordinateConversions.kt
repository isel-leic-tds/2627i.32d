package palbp.demos.tds.isel.domain


fun rectangularToLinear(x: Int, y: Int): Int {
    return x + y * Board.SIDE
}

fun linearToRectangular(linear: Int): Pair<Int, Int> {
    return Pair(linear % Board.SIDE, linear / Board.SIDE)
}

fun Int.toRectangular(): Pair<Int, Int> =
    linearToRectangular(this)