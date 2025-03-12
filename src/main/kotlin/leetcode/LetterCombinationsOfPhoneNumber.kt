package leetcode

class LetterCombinationsOfPhoneNumber {
    fun letterCombinations(digits: String): List<String> {
        val digitMap = hashMapOf(
            "2" to "abc",
            "3" to "def",
            "4" to "ghi",
            "5" to "jkl",
            "6" to "mno",
            "7" to "pqrs",
            "8" to "tuv",
            "9" to "wxyz"
        )

        val combinationResource = digits.mapNotNull {
            digitMap[it.toString()]
        }

        if(combinationResource.size == 1) return combinationResource[0].map { it.toString() }.toList()
        else {
            var index = 1
            val result = mutableListOf<String>()

            val outer =

            combinationResource.forEach { outer ->
                val outerCharList = outer.map { it }
                val innerCharList = combinationResource[index].map { it.toString() }

                outerCharList.forEach { outerChar ->
                    innerCharList.forEach { innerChar ->
                        result.add((outerChar + innerChar))
                    }
                }
            }

            return result
        }
    }
}