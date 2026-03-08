package dingcorithm.util

object UtilFunction {

    fun printArray(array: IntArray) {
        println(array.joinToString(","))
    }

    fun printList(list: List<Int>) {
        print("[")
        for (i in list.indices) {
            print(list[i])
            if (i < list.size - 1) {
                print(", ")
            }
        }
        println("]")
    }
}