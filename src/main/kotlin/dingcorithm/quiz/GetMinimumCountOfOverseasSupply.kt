package dingcorithm.quiz

import java.util.PriorityQueue

fun main() {
    val factory = GetMinimumCountOfOverseasSupply()

    println(
        "정답 = 2 / 현재 풀이 값 = " +
                factory.getMinimumCountOfOverseasSupply(
                    stock = 4,
                    dates = intArrayOf(4, 10, 15),
                    supplies = intArrayOf(20, 5, 10),
                    k = 30
                )
    )

    println(
        "정답 = 4 / 현재 풀이 값 = " +
                factory.getMinimumCountOfOverseasSupply(
                    stock = 4,
                    dates = intArrayOf(4, 10, 15, 20),
                    supplies = intArrayOf(20, 5, 10, 5),
                    k = 40
                )
    )

    println(
        "정답 = 1 / 현재 풀이 값 = " +
                factory.getMinimumCountOfOverseasSupply(
                    stock =  2,
                    dates = intArrayOf(1, 10),
                    supplies = intArrayOf(10, 100),
                    k = 11
                )
    )
}

/**
 * [PriorityQueue]
 * 1. 우선순위가 가장 높은 값을 먼저 꺼내는 자료구조
 * 2. 내부적으로 보통 힙(Heap)으로 구현됨
 * 3. 넣은 순서가 아니라, 우선순위(정렬 기준)에 따라 꺼내짐
 *    - 기본적으로는 최소값 우선
 *    - Comparator를 주면 최대값 우선도 가능
 * 4. 주 용도
 *    - 최소값 / 최대값 빠르게 꺼내기
 *    - 스케줄링
 *    - 그리디 알고리즘
 *    - 다익스트라 같은 최단경로 문제
 * 5. 시간 복잡도
 *    - 삽입(offer): O(log n)
 *    - 삭제(poll): O(log n)
 *    - 조회(peek): O(1)
 *
 * [ArrayDeque]
 * 1. 양쪽 끝에서 넣고 빼기가 빠른 자료구조
 * 2. 순서를 유지함
 * 3. 큐(FIFO)나 스택(LIFO)처럼 사용하기 좋음
 * 4. 우선순위에 따라 정렬해주지는 않음
 * 5. 주 용도
 *    - BFS 큐
 *    - 슬라이딩 윈도우
 *    - 스택 / 덱 구현
 * 6. 시간 복잡도
 *    - 앞/뒤 삽입: O(1)
 *    - 앞/뒤 삭제: O(1)
 *
 * [핵심 차이]
 * - PriorityQueue: "우선순위가 높은 값"을 먼저 꺼냄
 * - ArrayDeque: "들어온 순서" 또는 "앞/뒤" 기준으로 꺼냄
 */
class GetMinimumCountOfOverseasSupply {

    fun getMinimumCountOfOverseasSupply(stock: Int, dates: IntArray, supplies: IntArray, k: Int): Int {

        // [참고] compareByDescending 을 못쓰고 maxHeap을 구해야 한다면, minHeap에서 -1을 곱해서 만들어주면 맨 위의 값의 절대값을 max로 보면 됨
        val maxHeap = PriorityQueue<Int>(compareByDescending{it})

        var currentStock = stock
        var index = 0
        var answer = 0 // 공급 횟수

        // 현재 재고가 바닥나는 시점 이전까지 받을 수 있는 밀가루 중 제일 많은 밀가루를 받는 게 목표
        while(currentStock < k) { // k보다 낮으면 계속해라 -> k일 전까지 버텨야하니까
            while(index < dates.size && dates[index] <= currentStock) { // 현재 날짜가 공급 가능한 날짜보다 크거나 같으면 버틸 수 있음 (공급 가능)
                maxHeap.offer(supplies[index]) // maxHeap에 넣으면서 버틸 수 있으면서 가장 큰 날짜로 정렬한다. (공급 횟수를 줄일 수 있는)
                index++
            }

            if(maxHeap.isEmpty()) { throw IllegalStateException("공급을 받을 수 없어 k일까지 버틸 수 없습니다.") }

            answer++
            currentStock += maxHeap.poll()
        }

        return answer
    }
}