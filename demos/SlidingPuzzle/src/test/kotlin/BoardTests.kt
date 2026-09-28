import palbp.demos.tds.isel.domain.Board
import palbp.demos.tds.isel.domain.Board.Piece
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNull
import kotlin.test.fail

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
            actual = piece?.value
        )
    }

    @Test
    fun `get with linear index on the empty space returns null`() {
        // Arrange
        val sut = Board()
        // Act
        val piece = sut[Piece.UPPER_LIMIT - 1]
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
            sut[Piece.UPPER_LIMIT]
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

    @Test
    fun `isAdjacentToEmptySpace returns true for adjacent pieces`() {
        // Arrange
        val sut = Board()
        val piece = sut[1, 2] ?: fail("Failed to get piece")

        // Act
        val isAdjacent = sut.isAdjacentToEmptySpace(piece)

        // Assert
        assertEquals(expected = true, actual = isAdjacent)
    }

    @Test
    fun `isAdjacentToEmptySpace returns false for non-adjacent pieces`() {
        // Arrange
        val sut = Board()
        val piece = sut[0, 0] ?: fail("Failed to get piece")

        // Act
        val isAdjacent = sut.isAdjacentToEmptySpace(piece)

        // Assert
        assertEquals(expected = false, actual = isAdjacent)
    }
}