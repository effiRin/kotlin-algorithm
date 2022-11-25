package baekjoon

class ThreeDice

fun main() = with(System.`in`.bufferedReader()) {
    var reward = 0
    val result = readLine().split(" ").map { it.toInt() }

    if (result.distinct().count() == 3) {
        // reward = result.max() * 1000
        // 리스트에서 가장 큰값 찾아주는 함수 max()를 백준에서 인식을 못함
        // 대체 방법
        var max = 0
        for (i in result.indices) {
            if (max < result[i]) { max = result[i] }
        }
        reward = max * 100
    } else if (result.distinct().count() == 2) {
        val duplicatedValue = result.groupingBy { it }.eachCount().filter { it.value == 2 }
        reward = 1000 + (duplicatedValue.keys.first() * 100)
    } else if (result.distinct().count() == 1) {
        reward = 10000 + (result.first() * 1000)
    }
    println(reward)
}
