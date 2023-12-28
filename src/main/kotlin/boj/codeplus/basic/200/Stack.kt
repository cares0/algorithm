package boj.codeplus.basic.`200`

interface Stack<E> {

    fun push(element: E)

    fun pop(): E?

    fun size(): Int

    fun isEmpty(): Boolean

    fun peek(): E?

}

@Suppress("UNCHECKED_CAST")
class ArrayStack<E>(
    capacity: Int = DEFAULT_CAPACITY,
): Stack<E> {

    private var elements: Array<Any?> = arrayOfNulls(capacity)
    private var size = 0

    override fun push(element: E) {
        if (size == elements.size) resizeArray()
        elements[size++] = element
    }

    override fun pop(): E? {
        if (isEmpty()) return null
        val element = elements[--size] as E
        elements[size] = null
        return element
    }

    override fun size(): Int = size

    override fun isEmpty(): Boolean = size == 0

    override fun peek(): E? {
        if (isEmpty()) return null
        return elements[size - 1] as E
    }

    private fun resizeArray() {
        val newSize = if (size == 0) 1 else size * 2
        elements = elements.copyOf(newSize)
    }

    companion object {

        private const val DEFAULT_CAPACITY = 10

    }

}

class ListStack<E>(): Stack<E> {

    private val elements: MutableList<E> = mutableListOf()

    override fun push(element: E) {
        elements.add(element)
    }

    override fun pop(): E? {
        if (isEmpty()) return null
        return elements.removeAt(elements.size - 1)
    }

    override fun size(): Int = elements.size

    override fun isEmpty(): Boolean = elements.isEmpty()

    override fun peek(): E? {
        if (isEmpty()) return null
        return elements[elements.size - 1]
    }

}