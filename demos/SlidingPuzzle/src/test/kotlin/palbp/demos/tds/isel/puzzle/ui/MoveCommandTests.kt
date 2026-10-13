package palbp.demos.tds.isel.puzzle.ui

import palbp.demos.tds.isel.puzzle.domain.Board
import palbp.demos.tds.isel.puzzle.ui.commands.CommandResult
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
        val board = Board()
        val line = 1
        val column = 2
        val sut = MoveCommand()

        // Act
        val result = sut.execute(board, listOf(line.toString(), column.toString()))

        // Assert
        assertIs<CommandResult.Success>(result)
        assertNull(result.board[line, column])
    }

    @Test
    fun `Move with non-numeric arguments fails`() {
        // Arrange
        val board = Board()
        val sut = MoveCommand()

        // Act & Assert
        assertFailsWith<IllegalArgumentException> {
            sut.execute(board, listOf("invalid", "invalid"))
        }
    }

    @Test
    fun `Move with out-of-bounds coordinates fails`() {
        // Arrange
        val board = Board()
        val sut = MoveCommand()

        // Act & Assert
        assertFailsWith<InvalidMoveCoordinatesException> {
            sut.execute(board, listOf("-1", "0"))
        }
    }

    @Test
    fun `Move with too many arguments fails`() {
        // Arrange
        val board = Board()
        val sut = MoveCommand()

        // Act & Assert
        assertFailsWith<IllegalArgumentException> {
            sut.execute(board, listOf("0", "0", "0"))
        }
    }

    @Test
    fun `Move with too few arguments fails`() {
        // Arrange
        val board = Board()
        val sut = MoveCommand()

        // Act & Assert
        assertFailsWith<IllegalArgumentException> {
            sut.execute(board, listOf("0"))
        }
    }

    @Test
    fun `Move with no board fails`() {
        // Arrange
        val sut = MoveCommand()

        // Act & Assert
        assertFailsWith<IllegalArgumentException> {
            sut.execute(null, listOf("0", "0"))
        }
    }

    @Test
    fun `Move with non-moveable piece fails`() {
        // Arrange
        val board = Board()
        val line = 0
        val column = 0
        val sut = MoveCommand()

        // Act & Assert
        assertFailsWith<PieceNotMoveableException> {
            sut.execute(board, listOf(line.toString(), column.toString()))
        }
    }
}