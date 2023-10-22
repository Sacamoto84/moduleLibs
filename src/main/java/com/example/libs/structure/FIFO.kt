package libs.structure

import kotlinx.coroutines.flow.MutableStateFlow

class FIFO<T>(private val capacity: Int) {

    val updateInput = MutableStateFlow(0L) //

    private val queue = ArrayDeque<T>(capacity)

    //Добавить элемент в очередь, если очередь полная то удаляет первый элемент
    fun enqueue(item: T) {
        while (queue.size >= capacity) {
            queue.removeFirst()
        }
        queue.addLast(item)

        updateInput.value++
    }

    fun dequeue(): T? = queue.removeFirst()
    fun peek(): T?    = queue.firstOrNull()
    fun isFull()      = queue.size >= capacity
    fun isEmpty()     = queue.isEmpty()
    fun clear()       = queue.clear()
    fun size()        = queue.size

    fun fill(data : T) = queue.fill(data)


}