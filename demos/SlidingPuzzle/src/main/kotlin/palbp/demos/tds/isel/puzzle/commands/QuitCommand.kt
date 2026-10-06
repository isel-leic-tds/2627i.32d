package palbp.demos.tds.isel.puzzle.commands

/**
 * The quit command implementation
 */
class QuitCommand : Command {
    override fun execute() = CommandResult.Exit
}