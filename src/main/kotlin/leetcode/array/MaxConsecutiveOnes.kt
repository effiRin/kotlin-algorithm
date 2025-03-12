package leetcode.array

import java.util.*

fun main() {

    val br = System.`in`.bufferedReader()
//    val bw = System.out.bufferedWriter()

    val st = StringTokenizer(br.readLine(), ",")
    val nums = mutableListOf<Int>()
    while (st.hasMoreTokens()) {
        nums.add(st.nextToken().toInt())
    }

    val result = hashMapOf<Int, Int>()
    result[0] = 0
    var key = 0

    nums.forEach { num ->
                if(num == 1) {
                    result[key] = result[key]?.let { it + 1 } ?: 1
                } else {
                    key++
                }
            }

    println(result.values.max())
//            return result.values.max()
}