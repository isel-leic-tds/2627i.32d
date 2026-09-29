package palbp.demos.tds.isel.puzzle.domain

import palbp.demos.tds.isel.puzzle.domain.Board.Piece
import kotlin.test.*

class BoardTests {

    @Test
    fun `get with lower linear index returns piece`() {
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
    fun `get with linear index of middle piece returns piece`() {
        // Arrange
        val sut = Board()
        val middlePieceValue = Piece.LOWER_LIMIT + 4

        // Act
        val piece = sut[middlePieceValue - 1]

        // Assert
        assertEquals(
            expected = middlePieceValue,
            actual = piece?.value
        )
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
    fun `get with top-left rectangular indexes returns piece`() {
        // Arrange
        val sut = Board()
        val (row, col) = Board.Coordinate(row = 0, col = 0)

        // Act
        val piece = sut[row, col]

        // Assert
        assertEquals(
            expected = Piece.LOWER_LIMIT,
            actual = piece?.value
        )
    }

    @Test
    fun `get with bottom-right rectangular indexes returns null`() {
        // Arrange
        val sut = Board()
        val (row, col) = Board.Coordinate(row = Board.SIDE - 1, col = Board.SIDE - 1)

        // Act
        val piece = sut[row, col]

        // Assert
        assertNull(actual = piece)
    }

    @Test
    fun `get with middle rectangular indexes returns piece`() {
        // Arrange
        val sut = Board()

        val (row, col) = Board.Coordinate(row = Board.SIDE / 2, col = Board.SIDE / 2)

        // Act
        val piece = sut[row, col]

        // Assert
        assertEquals(
            expected = Piece.LOWER_LIMIT + Piece.UPPER_LIMIT / 2,
            actual = piece?.value
        )
    }

    @Test
    fun `get with negative rectangular indexes throws IndexOutOfBoundsException`() {
        // Arrange
        val sut = Board()

        // Act & Assert
        assertFailsWith<IndexOutOfBoundsException> { sut[-1, -1] }
    }

    @Test
    fun `get with out of bounds rectangular indexes throws IndexOutOfBoundsException`() {
        // Arrange
        val sut = Board()

        // Act & Assert
        assertFailsWith<IndexOutOfBoundsException> { sut[Board.SIDE, Board.SIDE] }
    }

    @Test
    fun `getPieceOrNull with valid rectangular indexes returns piece`() {
        // Arrange
        val sut = Board()

        // Act
        val piece = sut.getPieceOrNull(row = 0, col = 0)

        // Assert
        assertEquals(
            expected = Piece.LOWER_LIMIT,
            actual = piece?.value
        )
    }

    @Test
    fun `getPieceOrNull with rectangular coordinates of the empty space returns null`() {
        // Arrange
        val sut = Board()

        // Act
        val piece = sut.getPieceOrNull(row = 2, col = 2)
        
        // Assert
        assertNull(actual = piece)
    }

    @Test
    fun `getPieceOrNull with invalid rectangular indexes returns null`() {
        // Arrange
        val sut = Board()
        
        // Act
        val piece = sut.getPieceOrNull(row = Board.SIDE, col = 0)

        // Assert
        assertNull(actual = piece)
    }

    @Test
    fun `isAdjacentToEmptySpace returns true for adjacent pieces`() {
        // Arrange
        val sut = Board()
        val piece = sut[2, 1] ?: fail("Failed to get piece")

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

    @Test
    fun `getEmptySpaceIndex returns the index of the empty space`() {
        // Arrange
        val sut = Board()
        val expectedSpaceIndex = Board.Coordinate(row = 2, col = 2).toLinear()

        // Act
        val emptySpaceIndex = sut.getEmptySpaceIndex()

        // Assert
        assertEquals(expected = expectedSpaceIndex, actual = emptySpaceIndex)
    }

    @Test
    fun `move piece to empty space succeeds for adjacent piece`() {
        // Arrange
        val sut = Board()
        val piece = sut[2, 1] ?: fail("Failed to get piece")
        val expectedBoard = Board(pieces = listOf(
            Piece(1), Piece(2), Piece(3),
            Piece(4), Piece(5), Piece(6),
            Piece(7), null, Piece(8),
        ))

        // Act
        val actualBoard = sut.move(piece)

        // Assert
        assertContentEquals(expected = expectedBoard, actual = actualBoard)
    }
}