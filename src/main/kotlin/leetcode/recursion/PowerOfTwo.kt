package leetcode.recursion

import kotlin.math.log2

fun main() {
    val dap = PowerOfTwo().isPowerOfTwo(536870912)
    println("dap : $dap")
}

class PowerOfTwo {
    fun isPowerOfTwo(n: Int): Boolean {
        /*
        부동 소수점 오류로 아래처럼 풀면 안됨
        if(n <= 0) return false
        val dap = log2(n.toDouble())
        return dap % 1.0 == 0.0
        */

        // 2의 거듭제곱 수는 단 하나의 1비트만 존재함.
        // 8 (1000), 16 (10000), 32 (100000), 64 (1000000)...
        // (n - 1)을 하면 모든 비트가 뒤집힘.
        // n & (n - 1) == 0 이면 2의 거듭제곱!
        return n > 0 && Integer.bitCount(n) == 1
    }
}