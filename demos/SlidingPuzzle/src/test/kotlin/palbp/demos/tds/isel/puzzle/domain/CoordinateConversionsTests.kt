package palbp.demos.tds.isel.puzzle.domain

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class CoordinateConversionsTests {

    @Test
    fun `rectangularToLinear with valid values works correctly`() {
        // Arrange (the middle position in a 3x3 grid)
        val x = 1
        val y = 1
        // Act
        val linear = rectangularToLinear(x, y)
        // Assert
        assertEquals(expected = 4, actual = linear)
    }

    @Test
    fun `rectangularToLinear with out-of-bounds values throws an IllegalArgumentException`() {
        // Arrange
        val x = -1
        val y = 1
        // Act & Assert
        assertFailsWith<IllegalArgumentException> {
            rectangularToLinear(x, y)
        }
    }

    @Test
    fun `rectangularToLinear with out-of-bounds values in y throws an IllegalArgumentException`() {
        // Arrange
        val x = 1
        val y = -1
        // Act & Assert
        assertFailsWith<IllegalArgumentException> {
            rectangularToLinear(x, y)
        }
    }

    @Test
    fun `linear to rectangular conversion works correctly`() {
        // Arrange (the middle position in a 3x3 grid)
        val linear = 4
        // Act
        val (x, y) = linear.toRectangular()
        // Assert
        assertEquals(expected = 1, actual = x)
        assertEquals(expected = 1, actual = y)
    }

    @Test
    fun `linear to rectangular conversion of a out-of-bounds value throws an exception`() {
        // Arrange
        val linear = -1
        // Act & Assert
        assertFailsWith<IllegalArgumentException> {
            linear.toRectangular()
        }
    }
}