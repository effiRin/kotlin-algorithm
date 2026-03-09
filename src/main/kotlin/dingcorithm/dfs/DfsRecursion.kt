package dingcorithm.dfs


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

    val visited = DfsRecursion().dfsRecursion(graph, 1, mutableListOf<Int>()) // 1이 시작 노드
    println(visited) // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
}

/***
 * 1. 시작 노드인 1부터 탐색한다
 * 2. 현재 방문한 노드를 visited 배열에 추가합니다.
 * 3. 현재 방문한 노드와 인접한 노드 중 방문하지 않은 노드를 방문합니다. -> 재귀로 반복
 * (But, 재귀는 깊은 노드가 있을 경우, 에러가 날 수 있다 )
 */
/*** 출력 결과
 * curNode : 1 / 인접 노드 : [2, 5, 9]
 * curNode : 2 / 인접 노드 : [1, 3]
 * curNode : 3 / 인접 노드 : [2, 4]
 * curNode : 4 / 인접 노드 : [3]
 * curNode : 5 / 인접 노드 : [1, 6, 8]
 * curNode : 6 / 인접 노드 : [5, 7]
 * curNode : 7 / 인접 노드 : [6]
 * curNode : 8 / 인접 노드 : [5]
 * curNode : 9 / 인접 노드 : [1, 10]
 * curNode : 10 / 인접 노드 : [9]
 * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 */
class DfsRecursion() {

    fun dfsRecursion(graph: Map<Int, List<Int>>, curNode: Int, visited: MutableList<Int>): List<Int> {

        visited.add(curNode)

        println("curNode : $curNode / 인접 노드 : ${graph[curNode]}")

        for(node in graph[curNode] ?: emptyList()) {
            if(!visited.contains(node)) { // 방문하지 않았다면
                dfsRecursion(graph, node, visited) // 그 node를 타고타고 가라 ~
            }
        }

        return visited
    }
}