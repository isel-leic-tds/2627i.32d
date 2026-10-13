package palbp.demos.tds.isel.puzzle.ui

import org.junit.jupiter.api.Test
import palbp.demos.tds.isel.puzzle.domain.Board
import palbp.demos.tds.isel.puzzle.ui.commands.CommandResult
import palbp.demos.tds.isel.puzzle.ui.commands.NewCommand
import kotlin.test.assertIs
import kotlin.test.assertNotSame

class NewCommandTests {

    @Test
    fun `New with no arguments succeeds`() {
        // Arrange
        val sut = NewCommand()

        // Act
        val result = sut.execute(null, emptyList())

        // Assert
        assertIs<CommandResult.Success>(result)
    }

    @Test
    fun `New with extra arguments succeeds and ignores them`() {
        // Arrange
        val sut = NewCommand()

        // Act
        val result = sut.execute(null, listOf("arg1", "arg2"))

        // Assert
        assertIs<CommandResult.Success>(result)
    }

    @Test
    fun `New with board succeeds and returns a new board`() {
        // Arrange
        val sut = NewCommand()
        val oldBoard = Board()

        // Act
        val result = sut.execute(oldBoard, emptyList())

        // Assert
        assertIs<CommandResult.Success>(result)
        assertNotSame(oldBoard, result.board)
    }
}