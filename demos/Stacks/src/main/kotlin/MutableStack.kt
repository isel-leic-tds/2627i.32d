package palbp.demos.tds.isel

class MutableStack<T> : Stack<T> {

    data class Node<T>(val next: Node<T>?, val elem: T)

    private var head: Node<T>? = null

    override val top: T
        @Throws(NoSuchElementException::class)
        get() = head?.elem ?: throw NoSuchElementException()

    override fun push(elem: T): Stack<T> {
        head = Node(next = head, elem = elem)
        return this
    }

    override fun pop(): Stack<T> {
        val observedHead = head ?: throw NoSuchElementException()
        head = observedHead.next
        return this
    }

    override fun isEmpty(): Boolean = head == null

    override fun toString(): String =
        buildString {
            var current = head
            while (current != null) {
                append(" " + current.elem)
                current = current.next
            }
        }
}