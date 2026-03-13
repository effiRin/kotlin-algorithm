package dingcorithm.quiz

import java.math.BigInteger

fun main(args: Array<String>) {

    val seatCount = 9
    val vipSeatArray = intArrayOf(4, 7)

    // 12 출력
    val theaterSeat = GetAllWaysOfTheaterSeat()
    println(theaterSeat.getAllWaysOfTheaterSeat(seatCount, vipSeatArray))
}

class GetAllWaysOfTheaterSeat {
    private val memo = hashMapOf<Int, BigInteger>(
        0 to BigInteger.ONE, // VIP가 연속되거나 구간 길이가 0일 수도 있기 때문에 0도 1로 넣어두는 편이 안전하다
        1 to BigInteger.ONE,
        2 to BigInteger.TWO
    )

    // 피보나치 수열을 구하는 함수
    fun fibo(n: Int): BigInteger {
        return memo[n] ?: run {
            memo[n] = fibo(n-1) + fibo(n-2)
            memo[n]!!
        }
    }

    fun getAllWaysOfTheaterSeat(seatCount: Int, vipSeatArray: IntArray): BigInteger {

        var result = BigInteger.ONE
        var prevVip = 0

        for(vip in vipSeatArray) {
            val vipIndex = vip - 1 // vip가 4,7면 배열로는 0~3, 그 다음 5~6을 구해야함
            result *= fibo(vipIndex - prevVip)
            prevVip = vipIndex + 1 // 1을 안 더해주면 vip 자리가 포함되는 것
        }

        // 맨 끝 구간까지 처리
        result *= fibo(seatCount - prevVip)
        return result
    }
}