package leetcode

class firstUniqChar {

    fun firstUniqChar(s: String): Int {
        val temp = "leetcode"
        val charArray = temp.toCharArray()

//        val charArray = s.toCharArray()
        val charMap = mutableMapOf<Char, Int>()

        charArray.forEach {
            charMap[it] = (charMap[it] ?: 0 ) + 1
        }

        var result = -1

        run breaker@{
            charArray.forEachIndexed { index, value ->
                if (charMap[value] == 1) {
                    result = index
                    return@forEachIndexed
                }
            }
        }

        return result
    }
}