package dingcorithm.heap

fun main() {
    val maxHeap = MaxHeap()
    maxHeap.insert(3)
    maxHeap.insert(4)
    maxHeap.insert(2)
    maxHeap.insert(9)
    println(maxHeap.items) // [null, 9, 4, 2, 3]

    val maxHeap2 = MaxHeap()

    maxHeap2.insert(8)
    maxHeap2.insert(6)
    maxHeap2.insert(7)
    maxHeap2.insert(2)
    maxHeap2.insert(5)
    maxHeap2.insert(4)

    println(maxHeap2.items)   // [null, 8, 6, 7, 2, 5, 4]
    println(maxHeap2.delete()) // 8
    println(maxHeap2.items)   // [null, 7, 6, 4, 2, 5]
}

/***
 * 최악의 경우 (가장 큰 값이 insert 된다면 ) 루트 노드까지 가야함
 * 입력값이 N일 때 완전 이진 트리의 최대 높이는 O(logN)인데, 이것이 Max heap 원소 추가에 발생하는 시간 복잡도이다.
 */
class MaxHeap {
    val items = ArrayList<Int?>()

    init {
        items.add(null) // 맨 처음은 null
    }

    fun insert(value: Int) {
        // 1. 원소를 맨 끝에 추가
        items.add(value)

        // 2. 정렬을 합니다.
        var currentIndex = items.size - 1 // 가장 끝에서 시작하여

        while(currentIndex != 1) { // 루트 노드(index = 1)에 도달할 때까지 반복
            val parentIndex = currentIndex / 2 // -> 부모의 인덱스는 '현재 인덱스 / 2'

            if(items[parentIndex]!! < items[currentIndex]!!) { // 부모보다 자식이 크다면 서로 바꾼다
                val temp = items[parentIndex]
                items[parentIndex] = items[currentIndex]
                items[currentIndex] = temp
                currentIndex = parentIndex
            } else { // 부모가 자식보다 크다면 정렬이 완료된 상태로 break
                break
            }
        }
    }

    fun delete(): Int? {
        // 1. 맨 끝 노드를 루트로 올린다 + 루트 노드를 삭제한다.
        val prevMax = items[1]
        items[1] = items[items.size - 1]
        items.removeLast()

        var currentIndex = 1

        // 두 개의 자식 노드 중 큰 값과 비교해서 자식이 크면 바꾼다
        // 부모 노드가 자식 노드 보다 클때까지, 혹은 바닥에 도달할 때까지 반복한다.
        while(currentIndex <= items.size - 1) {
            val leftChildIndex = currentIndex * 2
            val rightChildIndex = currentIndex * 2 + 1
            var maxIndex = currentIndex

            // 자식 노드가 실제 노드 인덱스보다 초과되지 않는지 체크 + 부모보다 큰지 체크
            if(leftChildIndex <= items.size - 1 && items[leftChildIndex]!! > items[maxIndex]!!) {
                maxIndex = leftChildIndex
            }

            if(rightChildIndex <= items.size -1 && items[rightChildIndex]!! > items[maxIndex]!!) {
                maxIndex = rightChildIndex
            }

            // maxIndex와 currentIndex가 같다는 것은 부모 노드가 더 커서, 더 이상 바뀔 게 없다는 뜻으로 break
            if(maxIndex == currentIndex) break

            // break가 아니라면 바꿔준다.
            val temp = items[currentIndex]
            items[currentIndex] = items[maxIndex]
            items[maxIndex] = temp
            currentIndex = maxIndex
        }

        return prevMax
    }
}