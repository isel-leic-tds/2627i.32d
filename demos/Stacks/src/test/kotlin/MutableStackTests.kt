import palbp.demos.tds.isel.MutableStack
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MutableStackTests {

    @Test
    fun `instantiation produces an empty stack`() {
        // Arrange & Act
        val sut = MutableStack<String>()

        // Assert
        assertTrue(sut.isEmpty())
    }

    @Test
    fun `push on empty stack makes it non empty`() {
        // Arrange
        val sut = MutableStack<String>()

        // Act
        sut.push("GLORIOSO")

        // Assert
        assertFalse(sut.isEmpty())
    }


    // ...
}