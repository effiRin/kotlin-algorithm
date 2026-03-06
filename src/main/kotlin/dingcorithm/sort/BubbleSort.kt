package dingcorithm.sort

fun main() {
    val input = intArrayOf(4,6,2,9,1)

    val result = BubbleSort().sort(input)
    println(result.joinToString(","))
}

class BubbleSort {
    fun sort(input: IntArray): IntArray {
        val inputSize = input.size

        for(i in 0 until inputSize - 1) { // 비교해야하는 라운드는 size -1 만큼임 ( 예 : 3,2,4,1 -> 3번만 비교하면 됨)
            for(j in 0 until inputSize - i - 1 ) { // 바깥 루프 i가 1번 돌때마다 가장 큰 값 하나가 맨 뒤로 확정되기 때문에, 확정된 구간 제외를 위해 -i
                if(input[j] > input[j + 1]) { // 뒤의 것과 비교했을 때 앞의 것이 크다면, -> 앞뒤를 바꿈
                    val temp = input[j]
                    input[j] = input[j + 1]
                    input[j+1] = temp
                }
            }

        }

        return input
    }
}