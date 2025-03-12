package leetcode

fun main() {

    val strs = arrayOf("flower","flow","flight")

    val result = LongestCommonPrefix().longestCommonPrefix(strs)

    println(result)
}

class LongestCommonPrefix {

    fun longestCommonPrefix(strs: Array<String>): String {

        if(strs.size < 2) return ""

        val firstString = strs[0]

        var longestCommonPrefix = ""

        common@ for (lengthIndex in firstString.length downTo 0) {
            val common = firstString.substring(0, lengthIndex)

            var flag = false

            indexOf@ for (i in 1 until strs.size) {
                if (strs[i].indexOf(common) != 0) {
                    flag = false
                    break@indexOf
                }

                if (strs[i].indexOf(common) == 0) {
                    flag = true
                }
            }

            if (flag == true) {
                longestCommonPrefix = common
                break@common
            }
        }

        return longestCommonPrefix
    }
}