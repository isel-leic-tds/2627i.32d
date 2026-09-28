package palbp.demos.tds.isel.ui

import palbp.demos.tds.isel.domain.Board

interface Command {
    fun execute(params: String? = null, board: Board? = null)
    fun usage(): String
}
