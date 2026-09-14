package palbp.demos.tds.isel

tailrec fun recursion(count: Long) {
    print("$count ")
    recursion(count + 1)
}

fun _main() {
    recursion(0)
}
