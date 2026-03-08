package dingcorithm.queue

import dingcorithm.util.UtilFunction.printArray

/***
 * 초 단위로 기록된 주식 가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 함수를 완성하세요.
 * prices = [1, 2, 3, 2, 3]
 * answer = [4, 3, 1, 1, 0]
 */
fun main() {
    val prices = intArrayOf(1, 2, 3, 2, 3)
    val queue = GetPriceNotFallPeriodsQueue()

    printArray(queue.getPriceNotFallPeriods(prices))

    print("정답 = [4, 3, 1, 1, 0] / 현재 풀이 값 = ")
    printArray(queue.getPriceNotFallPeriods(prices))

    print("정답 = [6, 2, 1, 3, 2, 1, 0] / 현재 풀이 값 = ")
    printArray(queue.getPriceNotFallPeriods(intArrayOf(3, 9, 9, 3, 5, 7, 2)))

    print("정답 = [6, 1, 4, 3, 1, 1, 0] / 현재 풀이 값 = ")
    printArray(queue.getPriceNotFallPeriods(intArrayOf(1, 5, 3, 6, 7, 6, 5)))
}

/***
 * 큐로 풀어보겠습니다. (O(N^2))
 */
class GetPriceNotFallPeriodsQueue {

    fun getPriceNotFallPeriods(prices: IntArray): IntArray {
        val queue = ArrayDeque<Int>()
        val answer = IntArray(prices.size)

        for(price in prices) {
            queue.addLast(price)
        }

        var currentIndex = 0

        while(queue.isNotEmpty()) {
            val currentPrice = queue.removeFirst()

            for(i in currentIndex + 1 until prices.size) { // 마지막은 어차피 이 for문이 돌지 않기 때문에 고려하지 않고 아래와 같이
                answer[currentIndex]++
                if(currentPrice > prices[i]) break
            }

            currentIndex++
        }

        return answer
    }
}