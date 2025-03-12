package leetcode.array

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val st = StringTokenizer(br.readLine(), ",")
    val nums = mutableListOf<Int>()
    while (st.hasMoreTokens()) {
        nums.add(st.nextToken().toInt())
    }

    // content
    var count = 0

    nums.forEach { num ->
        if(num.toString().length % 2 == 0) {
            count++
        }
    }

//    return count
    println(count)
}