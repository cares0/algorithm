package boj.codeplus.basic

class RingBuffer<T>(
    private val capacity: Int = 10
) {
    private val buffer: MutableList<T?> = MutableList(capacity) { null }
    private var readSequence: Int = 0
    private var writeSequence: Int = -1

    fun offer(element: T): Boolean {
        val size = writeSequence - readSequence + 1
        val isFull = size == capacity
        if (!isFull) {
            val nextWriteSeq = writeSequence + 1
            buffer[nextWriteSeq % capacity] = element
            writeSequence++
            return true
        }
        return false
    }

    fun poll(): T? {
        val isEmpty = writeSequence < readSequence
        if (!isEmpty) {
            val nextValue: T? = buffer[readSequence % capacity]
            readSequence++
            return nextValue
        }
        return null
    }
}
