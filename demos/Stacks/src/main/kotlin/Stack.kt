package palbp.demos.tds.isel

interface Stack<T> {
    val top: T
    fun push(elem: T): Stack<T>
    fun pop(): Stack<T>
    fun isEmpty(): Boolean
}
