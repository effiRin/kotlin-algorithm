package leetcode.array

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val st = StringTokenizer(br.readLine(), ",")

    val nums = mutableListOf<Int>()

    while (st.hasMoreTokens()) {
        nums.add(st.nextToken().toInt())
    }

    var result1 = 0
    var result2 = 0
    var result3 = 0

    nums.forEachIndexed { index, value ->
        if (index % 2 == 0) {
            result1 += value
        }

        if (index % 2 == 1) {
            result2 += value
        }
    }

    if(nums.size > 2) {
        result3 = (nums[0] + nums[nums.size-1])
    }

    maxOf(result1, result2, result3)
}