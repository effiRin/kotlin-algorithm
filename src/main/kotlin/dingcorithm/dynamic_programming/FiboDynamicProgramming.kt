package dingcorithm.dynamic_programming

import java.math.BigInteger

fun main() {

    val fibo = FiboDynamicProgramming()

    val input = 100
    val memo = mutableMapOf<Int, BigInteger>(
        1 to BigInteger.ONE,
        2 to BigInteger.ONE
    )
    println(fibo.fiboDynamicProgramming(input, memo)) // 354224848179261915075
}

class FiboDynamicProgramming {
    /***
     * 메모에 이미 해당 값이 있으면 반환한다.
     * 만약 없다면 그 값을 피보나치를 통해 구하고 메모에 저장한다.
     *
     * 참고로 100이면 BigInteger는 써야 한다.
     *
     * Long 범위
     * 최솟값: -9,223,372,036,854,775,808
     * 최댓값: 9,223,372,036,854,775,807
     *
     * BigInteger는 고정된 범위가 없음 -> 메모리가 허용하는 한 계속 큰 수 표현 가능
     */
    fun fiboDynamicProgramming(input: Int, fiboMemo: MutableMap<Int, BigInteger>): BigInteger {
        // 이미 있으면 해당 값 반환
        fiboMemo[input]?.let { return it }

        // 없으면 피보나치를 통해 구하고 메모에 저장
        fiboMemo[input] = fiboDynamicProgramming(input - 1, fiboMemo) + fiboDynamicProgramming(input - 2, fiboMemo)

        return fiboMemo[input]!!
    }
}