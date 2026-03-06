package dingcorithm.sort

fun main() {
    val input = intArrayOf(4, 6, 2, 9, 1)

    val result = SelectionSort().sort(input)

    println(result.joinToString(","))
}

class SelectionSort {

    fun sort(array: IntArray): IntArray {
        val arraySize = array.size

        for(i in 0 until arraySize - 1) {
            var minIndex = i                   // 최소값을 앞으로 보냄

            for(j in i until arraySize) { // 따라서 루프를 돌며 앞으로 간 최소값 제외한 나머지 구간을 탐색
                if(array[j] < array[minIndex]) {
                    minIndex = j
                }
            }

            val temp = array[minIndex]
            array[minIndex] = array[i]
            array[i] = temp
        }

        return array
    }
}