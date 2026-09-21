import palbp.demos.tds.isel.domain.Board
import palbp.demos.tds.isel.domain.Board.Piece
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNull

class BoardTests {

    @Test
    fun `get with linear index returns piece`() {
        // Arrange
        val sut = Board()
        // Act
        val piece = sut[Piece.LOWER_LIMIT - 1]
        // Assert
        assertEquals(
            expected = Piece.LOWER_LIMIT,
            actual = if (piece != null) piece.value else null
            //actual = piece?.value
        )
    }

    @Test
    fun `get with linear index on the empty space returns null`() {
        // Arrange
        val sut = Board()
        // Act
        val piece = sut[Piece.UPPER_LIMIT]
        // Assert
        assertNull(actual = piece)
    }

    @Test
    fun `get with negative linear index throws IndexOutOfBoundsException`() {
        // Arrange
        val sut = Board()
        // Act & Assert
        assertFailsWith<IndexOutOfBoundsException> {
            sut[-1]
        }
    }

    @Test
    fun `get with out of bounds linear index throws IndexOutOfBoundsException`() {
        // Arrange
        val sut = Board()
        // Act & Assert
        assertFailsWith<IndexOutOfBoundsException> {
            sut[Piece.UPPER_LIMIT + 1]
        }
    }

    @Test
    fun `get with rectangular indexes returns piece`() {
        // Arrange
        val sut = Board()
        // Act
        val piece = sut[1, 1]
        val linearIndex = 4
        // Assert
        assertEquals(
            expected = Piece.LOWER_LIMIT + linearIndex,
            actual = piece?.value
        )
    }
}