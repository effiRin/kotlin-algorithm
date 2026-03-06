package dingcorithm.sort

fun main() {
    val input = intArrayOf(4, 6, 2, 9, 1)

    val result = InsertionSort().sort(input)
    println(result.joinToString(","))
}

/***
 * 빅 노테이션 - N^2 (이중 포문),
 * 오메가 노테이션 - n (이미 다 정렬된 상태라서)
 *
 * 선택 정렬과 버블 정렬은 입력받은 배열이 정렬되었는지 여부와 상관없이 무조건 N^2이 걸리지만,
 * 이미 정렬된 배열의 경우 삽입 정렬이 더 효율적인 것.
 */
class InsertionSort {

    fun sort(array: IntArray): IntArray {
        val arraySize = array.size

        if(arraySize <= 1) return array

        for(i in 1 until arraySize) { // 맨앞 제외 1번째 인덱스부터 시작

            for(j in 0 until i) { // 삽입하는 만큼 (i만큼) 탐색을 돈다
                val cur = i - j // 거꾸로 향하는 포인터가 된다 (

                if(array[cur - 1] > array[cur]) { // 앞의 거가 뒤의 것보다 크면 바꾼다(swap).
                    val temp = array[cur]
                    array[cur] = array[cur - 1]
                    array[cur - 1] = temp
                } else { // 만약 앞의 것과 뒤의 것이 맞게 정렬되어 있다면 break -> 앞이 이미 다 정렬된 상황이기 때문
                    break
                }
            }
        }

        return array
    }
}