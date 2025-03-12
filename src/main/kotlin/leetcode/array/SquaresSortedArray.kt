package leetcode.array

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val st = StringTokenizer(br.readLine(), ",")
    val nums = mutableListOf<Int>()
    while (st.hasMoreTokens()) {
        nums.add(st.nextToken().toInt())
    }

    val result = mutableListOf<Int>()

    nums.forEach { num ->
        result.add(num * num)
    }

//    return result.sorted().toIntArray()
}