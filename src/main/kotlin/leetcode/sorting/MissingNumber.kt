package leetcode.sorting

import java.util.*

fun main() {

    val nums = intArrayOf(1,2)
    val answer = missingNumber(nums)

    println(answer)

}

fun missingNumber(nums: IntArray): Int {
    // 순차대로 정렬을 하고 인덱스와 비교

    var answer = -1

    nums.sortedArray().also {
        run breaker@{
            it.forEachIndexed { index, value ->
                println("index : $index")
                println("value : $value")
                if (index != value) {
                    answer = index
                    return@breaker
                }
            }
        }

        if(answer < 0) {
            answer = nums.size
        }
    }

    return answer
}