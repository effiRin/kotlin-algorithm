package dingcorithm.hash

import kotlin.math.abs


fun main() {
    val myDict = Dict()
    myDict.put("test", 3)
    myDict.put("333", 7)
    myDict.put("77", 6)

    println(myDict.get("test"))
    println(myDict.get("333"))
    println(myDict.get("77"))
}

class Dict {

//    private val items: Array<Any?> = arrayOfNulls(8)
    private var items: Array<LinkedTuples> = Array(8) { LinkedTuples() } // size와 init하고 싶은 element

    /***
     * dictionary에 key 해당하는 곳에 value를 저장해두겠다.
     */
    fun put(key: String, value: Any) {
        val index = abs(key.hashCode() % items.size) // hashCode가 음수가 나올 수도 있으므로 절대값
        items[index].add(key, value) // 충돌을 해결하기 위해 LinkedTuples을 이용하여 add
    }

    /***
     * dictionary에 key 해당하는 value를 반환해라
     */
    fun get(key: String): Any? {
        val index = abs(key.hashCode() % items.size)

        return items[index].get(key)
    }
}

