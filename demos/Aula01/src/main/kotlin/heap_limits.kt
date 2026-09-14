package palbp.demos.tds.isel


val retention = mutableListOf<Long>()

fun addIt(count: Long) {
    println("Adding $count")
    retention.add(count)
}


fun __main() {
    var count = 0L
    while (true) {
        addIt(count++)
    }
}
