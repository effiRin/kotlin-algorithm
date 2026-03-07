package dingcorithm.stack

fun main() {
    val stack = Stack()

    stack.push(4)
    println(stack.peek()?.data)

    stack.push(3)
    println(stack.peek()?.data)

    stack.push(5)
    println(stack.peek()?.data)

    stack.pop()
    println(stack.peek()?.data)

    stack.pop()
    println(stack.peek()?.data)

    stack.pop()
    println(stack.peek()?.data)
}

class Node(val data: Int) {
    var next: Node? = null
}

class Stack {
    private var head: Node? = null

    /***
     * 맨 위에 값을 넣는다.
     */
    fun push(value: Int) {
        val newHead = Node(value)
        newHead.next = head
        head = newHead
    }

    /***
     * 맨 위의 값을 뺀다
     */
    fun pop(): Node? {
        if(isEmpty()) return null

        val popHead = head
        head = head!!.next
        return popHead
    }

    /***
     * 맨 위의 값을 본다.
     */
    fun peek(): Node? {
        return head
    }

    /***
     * 스택이 비어있는지 확인한다.
     */
    fun isEmpty(): Boolean {
        return if(head == null) true else false
    }
}