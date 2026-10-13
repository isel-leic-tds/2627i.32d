package palbp.demos.tds.isel.puzzle.ui

import org.junit.jupiter.api.Test
import palbp.demos.tds.isel.puzzle.ui.commands.CommandResult
import palbp.demos.tds.isel.puzzle.ui.commands.QuitCommand
import kotlin.test.assertIs

class QuitCommandTests {

    @Test
    fun `Quit with no arguments succeeds`() {
        // Arrange
        val sut = QuitCommand()

        // Act
        val result = sut.execute(null, emptyList())

        // Assert
        assertIs<CommandResult.Exit>(result)
    }

    @Test
    fun `Quit extra arguments succeeds and ignores them`() {
        // Arrange
        val sut = QuitCommand()

        // Act
        val result = sut.execute(null, listOf("ignored1", "ignored2"))

        // Assert
        assertIs<CommandResult.Exit>(result)
    }
}