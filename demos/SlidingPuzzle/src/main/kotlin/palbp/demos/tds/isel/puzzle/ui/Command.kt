package palbp.demos.tds.isel.puzzle.ui

import palbp.demos.tds.isel.puzzle.domain.Board

interface Command {
    fun execute(params: String? = null, board: Board? = null)
    fun usage(): String
}
