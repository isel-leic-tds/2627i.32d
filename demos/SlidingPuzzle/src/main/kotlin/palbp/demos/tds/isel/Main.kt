package palbp.demos.tds.isel

import palbp.demos.tds.isel.domain.Piece


fun myRepeat(count: Int, action: () -> Unit): Unit {
    for (i in 0 until count)
        action()
}



fun main() {

    myRepeat(count = 38) {
        println("Benfica campeão!!!")
    }
}