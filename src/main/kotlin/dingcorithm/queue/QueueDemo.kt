package dingcorithm.queue

fun main() {
    val queue = QueueDemo()
    queue.enqueue(4)
    println(queue.peek())

    queue.enqueue(2)
    println(queue.peek())

    queue.enqueue(3)
    println(queue.peek())

    queue.dequeue()
    println(queue.peek())

    queue.dequeue()
    println(queue.peek())

    queue.dequeue()
    println(queue.peek())
}

class QueueDemo {
    private var head: Node? = null
    private var tail: Node? = null

    fun enqueue(value: Int) {
        val newNode = Node(value)

        if(isEmpty()) {
            head = newNode
            tail = newNode
            return
        } else {
            tail!!.next = newNode // 최초 enqueue 후에 이 과정에서 head의 next도 함께 채워짐! (왜냐하면 최초에 같은 Node를 넣어뒀기 때문)
            tail = newNode
        }
    }

    fun dequeue(): Node? {
        if(isEmpty()) return null

        val dequeueNode = head
        head = head!!.next

        // 마지막 원소를 뽑아 빈 큐가 되면 tail도 null로 맞춰주는 것이 안전
        if(isEmpty()) tail = null

        return dequeueNode
    }

    /***
     * 큐는 맨 앞의 것을 조회한다.
     */
    fun peek(): Int? {
        if(isEmpty()) return null
        return head!!.data
    }

    fun isEmpty(): Boolean {
        return head == null
    }
}

class Node(
    val data: Int,
) {
    var next: Node? = null
}