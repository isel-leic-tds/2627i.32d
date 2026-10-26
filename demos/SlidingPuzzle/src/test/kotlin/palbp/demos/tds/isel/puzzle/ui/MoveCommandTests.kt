package palbp.demos.tds.isel.puzzle.ui

import palbp.demos.tds.isel.puzzle.domain.Board
import palbp.demos.tds.isel.puzzle.ui.commands.CommandContext
import palbp.demos.tds.isel.puzzle.ui.commands.CommandResult
import palbp.demos.tds.isel.puzzle.ui.commands.InvalidCommandArgumentsException
import palbp.demos.tds.isel.puzzle.ui.commands.InvalidMoveCoordinatesException
import palbp.demos.tds.isel.puzzle.ui.commands.MoveCommand
import palbp.demos.tds.isel.puzzle.ui.commands.PieceNotMoveableException
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertIs
import kotlin.test.assertNull

class MoveCommandTests {

    @Test
    fun `Move with valid board and coordinates for a moveable piece succeeds`() {
        // Arrange
        val context = CommandContext(board = Board(), supportedCommands = listOf(MoveCommand()))
        val line = 1
        val column = 2
        val sut = MoveCommand()

        // Act
        val result = sut.execute(context, listOf(line.toString(), column.toString()))

        // Assert
        assertIs<CommandResult.BoardResult>(result)
        assertNull(result.board[line, column])
    }

    @Test
    fun `Move with non-numeric arguments fails`() {
        // Arrange
        val context = CommandContext(board = Board(), supportedCommands = listOf(MoveCommand()))
        val sut = MoveCommand()

        // Act & Assert
        assertFailsWith<InvalidCommandArgumentsException> {
            sut.execute(context, listOf("invalid", "invalid"))
        }
    }

    @Test
    fun `Move with out-of-bounds coordinates fails`() {
        // Arrange
        val context = CommandContext(board = Board(), supportedCommands = listOf(MoveCommand()))
        val sut = MoveCommand()

        // Act & Assert
        assertFailsWith<InvalidMoveCoordinatesException> {
            sut.execute(context, listOf("-1", "0"))
        }
    }

    @Test
    fun `Move with too many arguments fails`() {
        // Arrange
        val context = CommandContext(board = Board(), supportedCommands = listOf(MoveCommand()))
        val sut = MoveCommand()

        // Act & Assert
        assertFailsWith<InvalidCommandArgumentsException> {
            sut.execute(context, listOf("0", "0", "0"))
        }
    }

    @Test
    fun `Move with too few arguments fails`() {
        // Arrange
        val context = CommandContext(board = Board(), supportedCommands = listOf(MoveCommand()))
        val sut = MoveCommand()

        // Act & Assert
        assertFailsWith<InvalidCommandArgumentsException> {
            sut.execute(context, listOf("0"))
        }
    }

    @Test
    fun `Move with no board fails`() {
        // Arrange
        val context = CommandContext(supportedCommands = listOf(MoveCommand()))
        val sut = MoveCommand()

        // Act & Assert
        assertFailsWith<IllegalArgumentException> {
            sut.execute(context, listOf("0", "0"))
        }
    }

    @Test
    fun `Move with non-moveable piece fails`() {
        // Arrange
        val context = CommandContext(board = Board(), supportedCommands = listOf(MoveCommand()))
        val line = 0
        val column = 0
        val sut = MoveCommand()

        // Act & Assert
        assertFailsWith<PieceNotMoveableException> {
            sut.execute(context, listOf(line.toString(), column.toString()))
        }
    }
}