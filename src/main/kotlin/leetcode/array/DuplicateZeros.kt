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

    nums.forEachIndexed { index, i ->
        if(i == 0 && index != nums.size - 1) {
            result.add(0)
        }
        if(result.size == nums.size) {
            return@forEachIndexed
        }

        result.add(i)

    }

    println(result.joinToString(","))
}