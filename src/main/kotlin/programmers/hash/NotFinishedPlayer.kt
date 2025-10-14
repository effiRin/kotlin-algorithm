package programmers.hash

fun main() {
    val notFinishedPlayer = NotFinishedPlayer()

    val testCases: MutableList<Triple<List<String>, List<String>, String>> = mutableListOf()
    testCases.add(Triple(listOf("leo", "kiki", "eden"), listOf("eden", "kiki"), "leo"))
    testCases.add(Triple(listOf("marina", "josipa", "nikola", "vinko", "filipa"), listOf("josipa", "filipa", "marina", "nikola"), "vinko"))

    // 참가자 중에는 동명이인이 있을 수 있습니다. -> mislav (hashset 이용할 수 없음 -> 중복 제거)
    testCases.add(Triple(listOf("mislav", "stanko", "mislav", "ana"), listOf("stanko", "ana", "mislav"), "mislav"))

    testCases.forEachIndexed { index, value ->
        println("testCase : $index")

        val answer = notFinishedPlayer.solution(value.first, value.second)
        println("answer : $answer / result : ${answer == value.third}")
    }
}

class NotFinishedPlayer {

    fun solution(participant: List<String>, completion: List<String>): String {

        // 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
        if(participant.size < 1 || participant.size > 100000) return ""

        // completion의 길이는 participant의 길이보다 1 작습니다.
        if(completion.size != participant.size - 1) return ""

        // 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다. -> 고민
        val participantMap =  hashMapOf<String, Int>()
        val completionMap = hashMapOf<String, Int>()
        var answer = ""

        completion.forEach { name ->
            completionMap[name] = 1
        }

        participant.forEach { name ->
            participantMap[name] = participantMap[name]?.let {
                it + 1
            } ?: 1
        }

        completion.forEach { name ->
            participantMap[name] = participantMap[name]!! - 1
        }

        participantMap.forEach { (name, value) ->
            if(value >= 1) answer = name
        }

        return answer
    }
}