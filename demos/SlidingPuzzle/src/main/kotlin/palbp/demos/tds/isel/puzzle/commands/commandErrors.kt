package palbp.demos.tds.isel.puzzle.commands

/**
 * Base class for all command execution errors
 * @param message the error message
 */
open class CommandException(message: String) : Exception(message)

/**
 * Exception thrown when a piece is not moveable
 * @param message the error message
 */
class PieceNotMoveableException(message: String) : CommandException(message)

/**
 * Exception thrown when the move coordinates are invalid
 * @param message the error message
 */
class InvalidMoveCoordinatesException(message: String) : CommandException(message)
