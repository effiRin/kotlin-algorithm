package baekjoon

import java.util.*


class Job_2056

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main2() {
    val lines = br.readLines()

    val lineNum = lines[0].toInt()     // 첫번째줄 = 전체 줄 수
    val jobNum = hashMapOf<Int, Int>() // n번째 작업(ln-1) - time
    var totalTime = 0 // 전체 총 시간

    // 줄마다 돈다
    for (ln in 1 until lineNum + 1) {
        val st = StringTokenizer(lines[ln], " ")

        // 그 줄의 숫자를 쪼갠다
        var nums = mutableListOf<Int>()
        while (st.hasMoreTokens()) {
            nums.add(st.nextToken().toInt())
        }

        println(nums.toString())

        // 2번째줄이 1번작업
        jobNum[ln] = nums[0]  // 첫째값은 시간

        val preJobCount = nums[1] // 둘째는 선행 작업 개수

        var jobTime = nums[0] // 이 작업의 걸리는 시간

        if (preJobCount > 0) { // 선행 작업 있을 경우
            val completeNum = mutableListOf<Int>() // 처리 완료된 선행 작업

            for (jc in 2 until 2 + preJobCount) {
                if(nums[jc] !in completeNum) {
                    jobTime += jobNum[nums[jc]]!! // nums[jc] = 선행 작업 번호
                    completeNum.add(nums[jc])
                }
            }
        }

            totalTime += jobTime
    }

    println(totalTime)

    bw.close()
    br.close()
}

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt() // 작업의 수 N
    val time = IntArray(n + 1) // 각 작업에 걸리는 시간을 저장하는 배열
    val inDegree = IntArray(n + 1) // 각 작업의 진입 차수
    val adjList = Array(n + 1) { mutableListOf<Int>() } // 각 작업의 선행 관계를 저장하는 리스트
    val dp = IntArray(n + 1) // 각 작업의 완료 시간을 저장하는 DP 배열

    // 입력 처리
    for (i in 1..n) {
        val st = StringTokenizer(br.readLine())
        time[i] = st.nextToken().toInt() // i번 작업의 소요 시간
        dp[i] = time[i] // dp 배열 초기화 (해당 작업의 최소 시간은 그 작업의 소요 시간)
        val preCount = st.nextToken().toInt() // i번 작업을 하기 전에 필요한 작업의 수
        for (j in 0 until preCount) {
            val preWork = st.nextToken().toInt() // 선행 작업 번호
            adjList[preWork].add(i) // 선행 작업의 후속 작업 추가
            inDegree[i]++ // 진입 차수 증가
        }
    }

    // 위상 정렬을 위한 큐
    val queue: Queue<Int> = LinkedList()

    // 진입 차수가 0인 작업(즉, 바로 수행할 수 있는 작업)을 큐에 추가
    for (i in 1..n) {
        if (inDegree[i] == 0) {
            queue.add(i)
        }
    }

    // 위상 정렬
    while (queue.isNotEmpty()) {
        val current = queue.poll()

        for (next in adjList[current]) {
            inDegree[next]-- // 진입 차수 감소
            // 선행 작업이 완료된 후 수행할 수 있으므로, 선행 작업들의 완료 시간을 고려하여 최댓값을 선택
            dp[next] = maxOf(dp[next], dp[current] + time[next])

            if (inDegree[next] == 0) {
                queue.add(next)
            }
        }
    }

    // 모든 작업이 완료되는 데 걸리는 최소 시간 출력 (dp 배열에서 최댓값 찾기)
    println(dp.maxOrNull())
}

