package palbp.demos.tds.isel.domain

/**
 * Represents a piece of a sliding puzzle.
 * A piece must have a value between 1 and MAX_PIECES.
 */
data class Piece(val value: Int) {
    init {
        require(value in LOWER_LIMIT..UPPER_LIMIT)
    }

    companion object {
        const val LOWER_LIMIT = 1
        const val UPPER_LIMIT = 8
    }
}