package dingcorithm.hash

import kotlin.math.abs

/***
 * Q. 오늘 수업에 많은 학생들이 참여했습니다. 단 한 명의 학생을 제외하고는 모든 학생이 출석했습니다.
 * 모든 학생의 이름이 담긴 배열과 출석한 학생들의 배열이 주어질 때, 출석하지 않은 학생의 이름을 반환하시오.
 */
fun main() {
    val allStudents = arrayOf("나연", "정연", "모모", "사나", "지효", "미나", "다현", "채영", "쯔위")
    val presentStudents = arrayOf("정연", "모모", "채영", "쯔위", "사나", "나연", "미나", "다현")

    val rollBook = GetAbsentStudent()

    println(rollBook.getAbsentStudent(allStudents, presentStudents))

    println(
        "정답 = 예지 / 현재 풀이 값 = " +
                rollBook.getAbsentStudent(
                    arrayOf("류진", "예지", "채령", "리아", "유나"),
                    arrayOf("리아", "류진", "채령", "유나")
                )
    )

    println(
        "정답 = RM / 현재 풀이 값 = " +
                rollBook.getAbsentStudent(
                    arrayOf("정국", "진", "뷔", "슈가", "지민", "RM"),
                    arrayOf("뷔", "정국", "지민", "진", "슈가")
                )
    )
}

/***
 * 여러 가지 푸는 방법이 있다.
 * 1. 이중 반복문
 *   : O(N^2)
 * 2. 정렬
 *   : 정렬 후 원소 하나씩 보면서 존재하지 않는(결석) 학생 찾기
 *   가장 최고의 정렬 속도는 O(NlogN) + 하나의 원소들을 봐야 하므로 O(N)
 *   O(NlogN + N) -> O(NlogN)
 * 3. Hash Table
 *   : 전체 학생을 Hash Table로 만들고, 출석 학생을 돌면서 Hash Table의 키값을 제거하여 결석 학생 1명을 찾는다.
 *   해시 테이블 만들기 O(N)
 *   출석 학생 지우기 O(N)
 *   O(N + N) -> O(N) (가장 효율적)
 */
class GetAbsentStudent {
    fun getAbsentStudent(allStudent: Array<String>, absentStudent: Array<String>): String {
        val rollBook = HashMap<String, Int>()

        for(student in allStudent) {
            rollBook[student] = 0
        }

        for(student in absentStudent) {
            rollBook.remove(student)
        }

        return rollBook.keys.first()
    }

    fun getAbsentStudentKotlinVer(allStudent: Array<String>, absentStudent: Array<String>): String =
        allStudent.toHashSet().apply { // 존재 체크만 필요하다면, 'key만 관리'하는 HashSet이 용이하다.
            removeAll(absentStudent.toHashSet())
        }.first()
}