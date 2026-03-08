package dingcorithm.queue

import dingcorithm.util.UtilFunction.printArray

fun main() {
    val prices = intArrayOf(1, 2, 3, 2, 3)
    val queue = GetPriceNotFallPeriods()

    printArray(queue.getPriceNotFallPeriods(prices))

    print("정답 = [4, 3, 1, 1, 0] / 현재 풀이 값 = ")
    printArray(queue.getPriceNotFallPeriods(prices))

    print("정답 = [6, 2, 1, 3, 2, 1, 0] / 현재 풀이 값 = ")
    printArray(queue.getPriceNotFallPeriods(intArrayOf(3, 9, 9, 3, 5, 7, 2)))

    print("정답 = [6, 1, 4, 3, 1, 1, 0] / 현재 풀이 값 = ")
    printArray(queue.getPriceNotFallPeriods(intArrayOf(1, 5, 3, 6, 7, 6, 5)))
}

/***
 * 반복문으로 풀어보겠습니다.O(N^2)
 */
class GetPriceNotFallPeriods {

    fun getPriceNotFallPeriods(prices: IntArray): IntArray {
        val answer = IntArray(prices.size)

        for(i in 0 until prices.size) {
            for(j in i + 1 until prices.size) {
                answer[i]++
                if(prices[i] > prices[j]) break
            }
        }

        return answer
    }
}