package dingcorithm.recursive

/***
 * DFS + 재귀 함수
 * 시간 복잡도 : O(2^N)
 * 공간 복잡도 : O(N) -> 재귀 깊이 만큼 콜스택이 쌓이니까
 */
fun main() {
    val numbers = intArrayOf(1, 1, 1, 1, 1)
    val targetNumber = 3

    println(GetCountOfWaysToTargetByDoingPlusOrMinus().getCountOfWaysToTargetByDoingPlusOrMinus(numbers, targetNumber)) // 5
}

class GetCountOfWaysToTargetByDoingPlusOrMinus {

    val allWays = ArrayList<Int>()

    fun getCountOfWaysToTargetByDoingPlusOrMinus(numbers: IntArray, targetNumber: Int): Int {

        // 맨 처음에 시작할 재귀함수의 시작점은 여기서 준다.
        getAllWaysByDoingPlusOrMinus(
            currentIndex = 0,
            currentSum = 0,
            array = numbers
        )

        var targetCount = 0

        for (way in allWays) {
            if(way == targetNumber) targetCount++
        }

        return targetCount
    }

    private fun getAllWaysByDoingPlusOrMinus(currentIndex: Int, currentSum: Int, array: IntArray) {
        if(currentIndex == array.size) {
            allWays.add(currentSum)
            return
        }

        getAllWaysByDoingPlusOrMinus(
            currentIndex = currentIndex + 1,
            currentSum = currentSum + array[currentIndex],
            array = array
        )

        getAllWaysByDoingPlusOrMinus(
            currentIndex = currentIndex + 1,
            currentSum = currentSum - array[currentIndex],
            array = array
        )
    }
}