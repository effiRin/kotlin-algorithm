//package baekjoon
//
//import java.util.StringTokenizer
//class Job_1043
//
//private val br = System.`in`.bufferedReader()
//private val bw = System.out.bufferedWriter()
//
//fun main2222() {
//    val lines = br.readLines()
//
//    // 2번째줄 진실을 아는 사람들
//    val st2 = StringTokenizer(lines[1], " ")
//    val trueList = mutableListOf<Int>()
//
//    while (st2.hasMoreTokens()) {
//        trueList.add(st2.nextToken().toInt())
//    }
//
//    trueList.sort()
//
//    for(i in trueList[0] .. trueList[1]){
//        if(i % 2 == 0)
//    }
//
//    trueList.
//
//
//    val truePeopleList = (trueList - trueList[0]).toHashSet()
//
//    val partyList = mutableListOf<List<Int>>()
//
//    // party와 partyPeople
//    for (i in 2 until lines.size) {
//        val st3 = StringTokenizer(lines[i], " ")
//        val partyPeople = mutableListOf<Int>()
//
//        while (st3.hasMoreTokens()) {
//            partyPeople.add(st3.nextToken().toInt())
//        }
//
//        partyList.add((partyPeople - partyPeople[0]))
//    }
//
//    // truePeople List
//    partyList.forEach {
//        var isExistTruePeople = false
//        it.forEach {
//            if (it in truePeopleList) {
//                isExistTruePeople = true
//            }
//        }
//
//        if (isExistTruePeople) {
//            truePeopleList.addAll(it)
//        }
//    }
//
//    partyList.reversed().forEach {
//        var isExistTruePeople = false
//        it.forEach {
//            if (it in truePeopleList) {
//                isExistTruePeople = true
//            }
//        }
//
//        if (isExistTruePeople) {
//            truePeopleList.addAll(it)
//        }
//    }
//
//    // 지민이의 거짓말 파티 횟수
//    var jiminsParty = 0
//
//    partyList.forEach {
//        var isExistTruePeople = false
//        it.forEach {
//            if (it in truePeopleList) {
//                isExistTruePeople = true
//            }
//        }
//
//        if (isExistTruePeople) {
//            jiminsParty++
//        }
//    }
//
//    println(jiminsParty)
//
//    bw.close()
//    br.close()
//}
//
//fun main() {
//
//    val br = System.`in`.bufferedReader()
//    val bw = System.out.bufferedWriter()
//
//    val (n, m) = br.readLine().split(" ").map { it.toInt() }
//
//    val truePeopleList = mutableSetOf<Int>()
//
//    // 진실을 아는 사람 수
//    val trueInfo = br.readLine().split(" ").map { it.toInt() }
//    val trueCount = trueInfo[0]
//
//    // 진실을 아는 사람들 추가
//    for (i in 1..trueCount) {
//        truePeopleList.add(trueInfo[i])
//    }
//
//    // 파티 목록
//    val partyList = mutableListOf<MutableList<Int>>()
//
//    for (i in 0 until m) {
//        val partyPeople = br.readLine().split(" ").map { it.toInt() }
//        partyList.add(partyPeople.drop(1).toMutableList()) // 첫 번째 수는 사람 수이므로 제외
//    }
//
//    // 진실을 아는 사람 목록 업데이트
//    var found = true
//    while (found) {
//        found = false
//        for (party in partyList) {
//            // 해당 파티에 진실을 아는 사람이 있다면
//            if (party.any { it in truePeopleList }) {
//                truePeopleList.addAll(party)
//                found = true // 업데이트가 있었으므로 다시 탐색
//            }
//        }
//    }
//
//    // 지민이의 거짓말이 가능한 파티 횟수 계산
//    val jiminsParty = partyList.count { party -> party.none { it in truePeopleList } }
//
//    println(jiminsParty)
//    bw.flush()
//    bw.close()
//    br.close()
//}
