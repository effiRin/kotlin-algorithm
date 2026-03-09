package dingcorithm.dfs_bfs

fun main() {
    val graph = mapOf(
        1 to listOf(2, 3, 4),
        2 to listOf(1, 5),
        3 to listOf(1, 6, 7),
        4 to listOf(1, 8),
        5 to listOf(2, 9),
        6 to listOf(3, 10),
        7 to listOf(3),
        8 to listOf(4),
        9 to listOf(5),
        10 to listOf(6)
    )

    val visited = BfsQueue().bfsQueue(graph, 1) // 1이 시작 노드
    println(visited) // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
}

/***
 * 1. 루트 노드를 큐에 넣습니다.
 * 2. 현재 큐의 노드를 빼서 visited 에 추가한다.
 * 3. 현재 방문한 노드와 인접한 노드 중 방문하지 않은 노드를 큐에 추가한다.
 * 4. 2부터 반복한다.
 * 5. 큐가 비면 탐색을 종료한다.
 */
class BfsQueue {

    fun bfsQueue(graph: Map<Int, List<Int>>, startNode: Int): MutableList<Int> {
        val queue = ArrayDeque<Int>()
        queue.addLast(startNode)

        val visited = mutableListOf<Int>()

        while(queue.isNotEmpty()) {
            val newNode = queue.removeFirst()
            visited.add(newNode)

            for(node in graph[newNode] ?: emptyList()) { // 인접한 노드들
                if(!visited.contains(node)) {
                    queue.addLast(node)
                }
            }
        }

        return visited
    }
}