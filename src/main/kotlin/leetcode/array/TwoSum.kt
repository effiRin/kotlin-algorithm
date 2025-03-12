package leetcode.array

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val st = StringTokenizer(br.readLine(), ",")

    val target = 9

    val nums = mutableListOf<Int>()
    var result: List<Int> = listOf()

    while (st.hasMoreTokens()) {
        nums.add(st.nextToken().toInt())
    }

    nums.forEachIndexed outer@{ index, n ->
        nums.forEachIndexed { index2, m ->
            if(index != index2 && n + m == target) {
                result = mutableListOf(index, index2).sorted()
                return@outer
            }
        }
    }

    println(result)
}