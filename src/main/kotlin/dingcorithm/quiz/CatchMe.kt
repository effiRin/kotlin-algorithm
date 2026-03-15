package dingcorithm.quiz

import kotlin.math.sign

fun main(args: Array<String>) {
    val ifYouCan = CatchMe()

    println("정답 = 5 / 현재 풀이 값 = ${ifYouCan.catchMe(11, 2)}")
    println("정답 = 3 / 현재 풀이 값 = ${ifYouCan.catchMe(10, 3)}")
    println("정답 = 8 / 현재 풀이 값 = ${ifYouCan.catchMe(51, 50)}")
}

// C -> 1 이동
// C+1 -> 1+1이동
// C+3 -> 1+1+1 이동
// C+6 -> 1+1+1+1 이동
// C+10 -> ...

/***
 * 브라운은 BFS
 * 코니는 매초마다 + time만큼 이동
 * 방문 체크는 위치 + 시간의 홀짝
 */
class CatchMe {
    fun catchMe(cony: Int, brown: Int): Int? {
        val MAX = 200_000
        var conyPlayTime = 0
        var conyLoc = cony

        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.addLast(brown to 0) // brown - 루트 노드를 넣는다.

        // 방문한 위치, 그 위치에 걸렸던 시간들
        // 참고로 MutableList<Int>를 쓸 수 있지만 선형 탐색을 하기 때문에 비효율적임. 따라서 Map
        val visited = MutableList(MAX + 1) { mutableSetOf<Int>() } // 인덱스를 써야하므로 이렇게...
        visited[brown].add(0)

        while(conyLoc <= MAX) {
            conyLoc += conyPlayTime // 코니의 위치

            // 위치에 현재 소요된 시간(playTime)이 있는지 확인 -> 이미 방문했는지 (있으면 반환)
            if(visited[conyLoc].contains(conyPlayTime)) {
                return conyPlayTime
            }

            // 방문하지 않았다면 BFS 탐색 시작
            for(i in 0 until queue.size) {
                val (brownLoc, brownTime) = queue.removeFirst() // brown의 위치와 시간
                val newTime = brownTime + 1

                var newLoc = brownLoc - 1 // 새 위치 -> 3가지 경우
                if(newLoc in 0 .. MAX && !visited[newLoc].contains(newTime)) { // 이미 방문 안했을 경우만
                    queue.addLast(Pair(newLoc, newTime))
                    visited[newLoc].add(newTime)
                }

                newLoc = brownLoc + 1
                if(newLoc in 0 .. MAX && !visited[newLoc].contains(newTime)) {
                    queue.addLast(Pair(newLoc, newTime))
                    visited[newLoc].add(newTime)
                }

                newLoc = brownLoc * 2
                if(newLoc in 0 .. MAX && !visited[newLoc].contains(newTime)) {
                    queue.addLast(Pair(newLoc, newTime))
                    visited[newLoc].add(newTime)
                }
            }

            conyPlayTime++
        }

        return null
    }
}