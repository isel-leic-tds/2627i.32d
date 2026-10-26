package palbp.demos.tds.isel.puzzle.ui

import org.junit.jupiter.api.Test
import palbp.demos.tds.isel.puzzle.domain.Board
import palbp.demos.tds.isel.puzzle.ui.commands.CommandContext
import palbp.demos.tds.isel.puzzle.ui.commands.CommandResult
import palbp.demos.tds.isel.puzzle.ui.commands.NewCommand
import kotlin.test.assertFalse
import kotlin.test.assertIs
import kotlin.test.assertNotSame

class NewCommandTests {

    @Test
    fun `New with no arguments returns unsolved board`() {
        // Arrange
        val context = CommandContext(supportedCommands = listOf(NewCommand()))
        val sut = NewCommand()

        // Act
        val result = sut.execute(context, emptyList())

        // Assert
        assertIs<CommandResult.BoardResult>(result)
        assertFalse(result.board.isSolved())
    }

    @Test
    fun `New with extra arguments succeeds and ignores them`() {
        // Arrange
        val context = CommandContext(supportedCommands = listOf(NewCommand()))
        val sut = NewCommand()

        // Act
        val result = sut.execute(context, listOf("arg1", "arg2"))

        // Assert
        assertIs<CommandResult.BoardResult>(result)
    }

    @Test
    fun `New with board succeeds and returns a new board`() {
        // Arrange
        val context = CommandContext(board = Board(), supportedCommands = listOf(NewCommand()))
        val sut = NewCommand()

        // Act
        val result = sut.execute(context, emptyList())

        // Assert
        assertIs<CommandResult.BoardResult>(result)
        assertNotSame(context.board, result.board)
    }
}