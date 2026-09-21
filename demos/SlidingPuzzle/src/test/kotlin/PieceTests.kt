import palbp.demos.tds.isel.domain.Board.Piece
import kotlin.test.Test
import kotlin.test.assertFailsWith


class PieceTests {

    @Test
    fun createPiece_with_valid_value_succeeds() {
        Piece(value = Piece.LOWER_LIMIT + 1)
    }

    @Test
    fun createPiece_with_value_below_low_limit_fails() {
        assertFailsWith<IllegalArgumentException> {
            Piece(value = Piece.LOWER_LIMIT - 1)
        }
    }

    @Test
    fun createPiece_with_value_above_high_limit_fails() {
        assertFailsWith<IllegalArgumentException> {
            Piece(value = Piece.UPPER_LIMIT + 1)
        }
    }
}