package palbp.demos.tds.isel

class ImmutableStack<T>(private val head: Node<T>? = null) : Stack<T> {

    data class Node<T>(val next: Node<T>?, val elem: T)

    override val top: T
        @Throws(NoSuchElementException::class)
        get() = TODO()

    override fun push(elem: T): Stack<T> =
        TODO()

    override fun pop(): Stack<T> = TODO()

    override fun isEmpty(): Boolean = TODO()

    override fun toString(): String =
        buildString {
            var current = head
            while (current != null) {
                append(" " + current.elem)
                current = current.next
            }
        }
}