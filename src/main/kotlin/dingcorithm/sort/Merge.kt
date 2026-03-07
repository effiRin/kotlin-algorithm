package dingcorithm.sort

fun main() {
    val arrayA = intArrayOf(1, 2, 3, 5)
    val arrayB = intArrayOf(4, 6, 7, 8)

    val mergeClass = Merge()

    val result = mergeClass.merge(arrayA, arrayB)
    println(result.joinToString(","))

    val result2 = mergeClass.merge(intArrayOf(-7, -1, 9, 40), intArrayOf(5, 6, 10, 11))
    println(result2.joinToString(","))
}

class Merge {
    fun merge(arrayA: IntArray, arrayB: IntArray): IntArray {
        val result = IntArray(arrayA.size + arrayB.size)
        var resultIndex = 0
        var a = 0
        var b = 0

        while(a < arrayA.size && b < arrayB.size) {
            if(arrayA[a] > arrayB[b]) {
                result[resultIndex++] = arrayB[b++]
            } else {
                result[resultIndex++] = arrayA[a++]
            }
        }

        // 남은 애들 돌리기
        while (a < arrayA.size) { // arrayB보다 큰 애들
            result[resultIndex++] = arrayA[a++]
        }

        while (b < arrayB.size) { // arrayA보다 큰 애들
            result[resultIndex++] = arrayB[b++]
        }

        return result
    }
}