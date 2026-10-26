package palbp.demos.tds.isel.puzzle.ui.commands

import palbp.demos.tds.isel.puzzle.domain.Board

/**
 * Context for executing commands.
 * It holds the data to be globally accessible by all commands.
 *
 * @property board The current state of the board, or null if no board is available.
 * @property supportedCommands The list of supported commands.
 */
data class CommandContext(val board: Board? = null, val supportedCommands: List<Command>)
