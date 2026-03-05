package dingcorithm

fun main() {
    val linkedList = LinkedListKthFromLast(6)
    linkedList.append(7)
    linkedList.append(8)

    println(linkedList.getKthNodeFromLast(2).data)
}

/***
 * 길이 먼저 세기
 * 1번 순회: 리스트 길이 n 구함 → O(n)
 * 2번 순회: (n-k)번째로 이동 → O(n)
 * 합쳐서 O(2n) = O(n) 이지만, 리스트를 두 번 돈다.
 *
 * 반면, fast/slow 방식은 '투 포인터' 기법의 한 종류 '간격(gap) 투 포인터'
 * fast를 k칸 보내는 데 O(k)
 * 그 다음 한 번 쭉 같이 가는 데 O(n-k)
 * 합쳐서 O(k + (n-k)) = O(n)
 *
 * 빅오 표기만 보면 둘 다 O(n)이지만,
 * fast/slow는 2-pass(2n) 를 1-pass(n) 로 줄이고, 공간도 O(1)이라 실전에서 더 효율적
 */

class LinkedListKthFromLast(value: Int) {

    data class Node(
        var data: Int,
        var next: Node? = null
    )

    // 가장 앞에 있는 노드
    private var head: Node? = Node(value)

    fun append(value: Int) {
        // head 가 없으면 새로 넣는다.
        var cur = head ?: run {
            head = Node(value)
            return
        }

        // cur.next가 없는 맨 끝까지 가서
        while (cur.next != null) {
            cur = cur.next!!
        }

        // 새로운 노드를 넣어준다.
        cur.next = Node(value)
    }

    fun getKthNodeFromLast(k: Int): Node {
        require(k >= 0) { "K must be >= 0" }

        // fast : 먼저 앞서 나가서 '기준점'을 만들어주는 포인터
        // slow : fast를 따라가면서, fast가 끝에 도착했을 때 정답 위치에 오게 되는 포인터
        // -> 2개의 노드를 사용함으로써 끝에서부터 K번째만큼 떨어져있는 노드의 값을 구할 수 있다.
        var slow: Node = head ?: throw IllegalArgumentException("List is Empty")
        var fast: Node? = head

        // fast 노드가 k만큼 앞에 가도록 만든다. (K만큼 떨어져있도록)
        for(i in 0 until k) {
            fast = fast?.next ?: throw IllegalArgumentException("k가 list의 길이보다 크거나 같습니다.")
        }

        // fast가 마지막 노드에 도달할 때까지, slow와 fast가 한칸씩 이동한다.
        while(fast != null) {
            slow = slow.next ?: throw IllegalArgumentException("Unexpected null (list shorter than expected)")
            fast = fast.next
        }

        return slow
    }
}