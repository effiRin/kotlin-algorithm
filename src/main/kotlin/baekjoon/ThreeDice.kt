package baekjoon

import java.util.StringTokenizer

class ThreeDice

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    var reward = 0
    val dice = mutableListOf<Int>()

    with(StringTokenizer(br.readLine())) {
        dice.add(nextToken().toInt())
        dice.add(nextToken().toInt())
        dice.add(nextToken().toInt())
    }

    if (dice.distinct().count() == 3) {
        // reward = dice.max() * 1000
        // 리스트에서 가장 큰값 찾아주는 함수 max()를 백준에서 인식을 못함
        // 대체 방법
        var max = 0
        for (i in dice.indices) {
            if (max < dice[i]) { max = dice[i] }
        }
        reward = max * 100
    } else if (dice.distinct().count() == 2) {
        val duplicatedValue = dice.groupingBy { it }.eachCount().filter { it.value == 2 }
        reward = 1000 + (duplicatedValue.keys.first() * 100)
    } else if (dice.distinct().count() == 1) {
        reward = 10000 + (dice.first() * 1000)
    }
    println(reward)

    bw.close()
    br.close()
}
