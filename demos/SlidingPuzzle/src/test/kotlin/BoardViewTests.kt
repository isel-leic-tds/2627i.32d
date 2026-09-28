import org.junit.jupiter.api.Test
import palbp.demos.tds.isel.domain.Board
import palbp.demos.tds.isel.ui.Display
import palbp.demos.tds.isel.ui.boardView
import kotlin.test.assertEquals

class MockDisplay : Display {
    private val output = mutableListOf<String>()

    override fun show(message: String) {
        output.add(message)
    }

    override fun newLine() {
        output.add("\n")
    }

    fun getOutput(): List<String> = output
}

class BoardViewTests {

    @Test
    fun `boardView correctly displays board`() {
        // Arrange
        val board = Board()
        val mockDisplay = MockDisplay()

        // Act
        boardView(
            board = board,
            display = mockDisplay
        )


        // Assert
        val output = mockDisplay.getOutput()
        for (value in Board.Piece.LOWER_LIMIT until Board.Piece.UPPER_LIMIT) {
            assertEquals(
                expected = 1,
                actual = output.count { it.contains(other = value.toString()) }
            )
        }
    }
}