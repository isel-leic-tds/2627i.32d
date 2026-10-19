package palbp.demos.tds.isel.puzzle.domain

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue


class SolvabilityListExtensionsTests {

    @Test
    fun `countInversions returns the correct number of inversions`() {
        // Arrange
        val list = listOf(1, 2, 4, 3, 5, 7, 8, 6)
        val expectedInversions = 3

        // Act & Assert
        val actualInversions = list.countInversions()
        assertEquals(expectedInversions, actualInversions)
    }

    @Test
    fun `countInversions returns 0 for a sorted list`() {
        // Arrange
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8)
        val expectedInversions = 0

        // Act & Assert
        val actualInversions = list.countInversions()
        assertEquals(expectedInversions, actualInversions)
    }

    @Test
    fun `swap swaps two elements in a list`() {
        // Arrange
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8)
        val expectedList = listOf(1, 2, 3, 4, 5, 7, 6, 8)

        // Act
        val actualList = list.swap(5, 6)

        // Assert
        assertEquals(expectedList, actualList)
    }

    @Test
    fun `swapInversion swaps a pair of inverted elements in a list`() {
        // Arrange
        val list = listOf(1, 2, 3, 4, 5, 7, 6, 8)
        val expectedList = listOf(1, 2, 3, 4, 5, 6, 7, 8)

        // Act
        val swappedList = list.swapInversion()

        // Assert
        assertEquals(expectedList, swappedList)
    }

    @Test
    fun `swapInversion on a sorted list returns the same list`() {
        // Arrange
        val expectedList = listOf(1, 2, 3, 4, 5, 6, 7, 8)

        // Act
        val swappedList = expectedList.swapInversion()

        // Assert
        assertEquals(expectedList, swappedList)
    }

    @Test
    fun `isSolvable returns true for a solvable list`() {
        // Arrange
        val solvable = listOf(1, 2, 3, 4, 5, 7, 8, 6)

        // Act & Assert
        assertTrue { solvable.isSolvable() }
    }

    @Test
    fun `isSolvable returns false for an unsolvable list`() {
        // Arrange
        val unsolvable = listOf(1, 2, 3, 4, 5, 7, 6, 8)

        // Act & Assert
        assertTrue { !unsolvable.isSolvable() }
    }
}