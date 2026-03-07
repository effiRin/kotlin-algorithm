package dingcorithm.sort

fun main() {
    val array = intArrayOf(5, 3, 2, 1, 6, 8, 7, 4)

    println(MergeSort().mergeSort(array).joinToString(","))
}

/***
 * mergeSort 함수의 시간 복잡도
 * mid를 찾는 것은 log2의 N -> logN
 * merge 함수는 O(N)
 * 이를 재귀로 반복하기 때문에 N * logN = O(NlogN)이 된다
 */
class MergeSort {
    val mergeClass = Merge()

    fun mergeSort(array: IntArray): IntArray {
        if(array.size <= 1) return array

        val mid = array.size / 2
        val left = mergeSort(array.copyOfRange(0, mid))
        val right = mergeSort(array.copyOfRange(mid, array.size))

        return mergeClass.merge(left, right)
    }
}
