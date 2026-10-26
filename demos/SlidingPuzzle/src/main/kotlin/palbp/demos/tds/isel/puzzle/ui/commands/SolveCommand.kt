package palbp.demos.tds.isel.puzzle.ui.commands

import palbp.demos.tds.isel.puzzle.domain.findSolution

/**
 * Implementation of the solve command used to produce the sequence of moves that leads to a solution.
 */
class SolveCommand : Command {

    /**
     * Returns the solution to the puzzle.
     * @param context The command context.
     * @param args The command arguments.
     * @return The solution to the puzzle.
     * @throws IllegalArgumentException if the board is null.
     */
    override fun execute(context: CommandContext, args: List<String>): CommandResult {

        requireNotNull(context.board)

        val movesToSolve = findSolution(context.board)
        return CommandResult.TextResult(movesToSolve?.joinToString(" ") ?: "No solution found")
    }

    override fun usage(): String = "Solve -> Returns the solution to the puzzle"
}