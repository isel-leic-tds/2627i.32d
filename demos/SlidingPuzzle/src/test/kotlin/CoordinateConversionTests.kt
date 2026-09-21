import palbp.demos.tds.isel.domain.rectangularToLinear
import palbp.demos.tds.isel.domain.toRectangular
import kotlin.test.Test
import kotlin.test.assertEquals

class CoordinateConversionTests {

    @Test
    fun `rectangular to linear conversion works correctly`() {
        // Arrange (the middle position in a 3x3 grid)
        val x = 1
        val y = 1
        // Act
        val linear = rectangularToLinear(x, y)
        // Assert
        assertEquals(expected = 4, actual = linear)
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
}