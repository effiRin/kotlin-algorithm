package dingcorithm.stack

import dingcorithm.util.UtilFunction.printArray

fun main() {
    val topHeights = intArrayOf(6, 9, 5, 7, 4)
    val stack = GetReceiverTopOrdersStack()
    printArray(stack.getReceiverTopOrders(topHeights))  // [0, 0, 2, 2, 4]

    print("정답 = [0, 0, 2, 2, 4] / 현재 풀이 값 = ")
    printArray(stack.getReceiverTopOrders(intArrayOf(6, 9, 5, 7, 4)))

    print("정답 = [0, 0, 2, 3, 3, 3, 6] / 현재 풀이 값 = ")
    printArray(stack.getReceiverTopOrders(intArrayOf(3, 9, 9, 3, 5, 7, 2)))

    print("정답 = [0, 0, 2, 0, 0, 5, 6] / 현재 풀이 값 = ")
    printArray(stack.getReceiverTopOrders(intArrayOf(1, 5, 3, 6, 7, 6, 5)))
}

/***
 * stack을 활용한 풀이
 */
class GetReceiverTopOrdersStack {
    fun getReceiverTopOrders(tops: IntArray): IntArray {
        val answer = IntArray(tops.size)
        val stack = ArrayDeque<Int>()

        for(height in tops) {
            stack.addLast(height) // add와 addLast 둘다 동일한 동작이지만, addLast는 뒤에 넣는다를 명시적으로 표현한 메서드이다.
        }

        while(stack.isNotEmpty()) {
            val height = stack.removeLast()
            var currentIndex = stack.size // pop하고 난 후가 레이저 검사할 top 인덱스 (왼쪽 바로 옆 / 1-based index)

            for(i in (currentIndex - 1) downTo 0) {
                if(height <= tops[i]) {
                    answer[currentIndex] = i + 1 // 1-based index
                    break
                }
            }
        }

        return answer
    }
}