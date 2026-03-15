package dingcorithm.quiz

/***
 * https://school.programmers.co.kr/learn/courses/30/lessons/60057
 */
fun main(args: Array<String>) {

    val compression = StringCompression()

    println(compression.stringCompression("abcabcabcabcdededededede"))  // 14

    println("정답 = 3 / 현재 풀이 값 = ${compression.stringCompression("JAAA")}")
    println("정답 = 9 / 현재 풀이 값 = ${compression.stringCompression("AZAAAZDWAAA")}")
    println("정답 = 12 / 현재 풀이 값 = ${compression.stringCompression("BBAABAAADABBBD")}")
}

class StringCompression {

    fun stringCompression(s: String): Int {
        if(s.length == 1) return 1
        val size = s.length

        val result = mutableListOf<String>()

        // size를 전부 돌 필요 없음 -> 압축 단위는 최대 size/2까지만 보면 충분함
        // 예 : 길이 8일 때 chunkSize 5,6,7은 사실상 압축 의미가 없음
        for(chunkSize in 1 .. size / 2) {
            val chunks = s.chunked(chunkSize)

            var prev = chunks[0]
            var count = 1

            // String은 불변 객체라서 매번 새로운 객체를 만들지만, StringBuilder는 내부 가변 버퍼를 사용해서 이어붙임. 이후 toString()을 하면 최종 객체를 만듦
            val compressed = StringBuilder()

            for(i in 1 until chunks.size) {
                val current = chunks[i]

                if(prev == current) {
                    count++
                } else {
                    if(count > 1) {
                        compressed.append(count)
                    }
                    compressed.append(prev)

                    prev = current
                    count = 1
                }
            }

            // 마지막 묶음 처리
            // forEach가 끝난 후에 마지막 prev가 compressingString에 반영되지 않기 때문에 추가 처리
            if(count > 1) {
                compressed.append(count)
            }
            compressed.append(prev)

            result.add(compressed.toString())
        }

        return result.minOf { it.length }
    }
}