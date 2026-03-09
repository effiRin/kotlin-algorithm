package dingcorithm.dfs

import java.util.LinkedList

fun main() {
    val graph = mapOf(
        1 to listOf(2, 5, 9),
        2 to listOf(1, 3),
        3 to listOf(2, 4),
        4 to listOf(3),
        5 to listOf(1, 6, 8),
        6 to listOf(5, 7),
        7 to listOf(6),
        8 to listOf(5),
        9 to listOf(1, 10),
        10 to listOf(9)
    )

    val visited = DfsStack().dfsStack(graph, 1) // 1이 시작 노드
    println(visited) // [1, 9, 10, 5, 8, 6, 7, 2, 3, 4]
}

/***
 * 1. 시작 노드를 스택에 넣습니다.
 * 2. 인접 노드들을 스택에 넣습니다.
 * 3. 현재 방문한 노드와 인접한 노드 중 방문하지 않은 노드를 스택에 추가합니다.
 * 4. 2,3의 과정을 스택이 빌 때까지 반복합니다.
 */
class DfsStack {

    fun dfsStack(graph: Map<Int, List<Int>>, curNode: Int): List<Int> {
        val stack = ArrayDeque<Int>()
        val visited = mutableListOf<Int>()

        // 맨 처음 Node
        stack.addLast(curNode)

        while(stack.isNotEmpty()) {
            val newCurNode = stack.removeLast()

            if(!visited.contains(newCurNode)) {
                visited.add(newCurNode)
                stack.addAll(graph[newCurNode] ?: emptyList())
            }
        }

        return visited
    }
}