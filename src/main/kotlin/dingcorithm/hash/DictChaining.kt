package dingcorithm.hash

fun main() {
    val linkedTuple = LinkedTuples()

    linkedTuple.add("333", 7)
    linkedTuple.add("77", 6)

    println(linkedTuple.get("333")) // 7
}

/***
 * 그런데 만약 랜덤한 키값을 넣다가 인덱스가 겹치면?
 * (해쉬의 값이 같거나, 해쉬 값을 배열의 길이로 나눴더니 똑같은 숫자가 되면?)
 * 같은 배열의 인덱스로 맵핑이 되어서 데이터를 덮어 씌우는 결과가 발생하는 것을 '충돌'이라고 한다.
 * 해시 테이블의 구조상 어쩔 수 없이 발생할 수밖에 없다.
 *
 * 충돌을 해결하는 첫 번째 방법은 바로 링크드 리스트를 사용하는 방식입니다.
 * 이 방식은 충돌이 발생했을 때 그 값들을 링크드 리스트로 연결 지어서 해결한다고 해서 체이닝(Chaining) 이라고 합니다.
 */
class LinkedTuples {

    private val linkedTuples = ArrayList<KeyValuePair>()

    fun add(key: String, value: Any) {
        linkedTuples.add(KeyValuePair(key, value))
    }

    fun get(key: String): Any? {
        for(tuple in linkedTuples) {
            if(key == tuple.key) return tuple.value
        }

        return null
    }
}

data class KeyValuePair(
    val key: String,
    val value: Any?
)