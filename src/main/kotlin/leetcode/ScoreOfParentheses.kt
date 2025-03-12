package leetcode

class ScoreOfParentheses {
    fun scoreOfParentheses(s: String): Int {
        val stack = mutableListOf<Int>()

        for (char in s) {
            if (char == '(') {
                stack.add(0)  // 열린 괄호는 0을 추가
            } else {
                val top = stack.removeAt(stack.size - 1)  // 닫힌 괄호는 스택에서 값을 꺼냄
                if (top == 0) {
                    stack.add(1)  // "()"일 경우 1을 더함
                } else {
                    stack.add(2 * top)  // "(A)"일 경우 2배
                }
            }
        }

        return stack.sum()  // 스택에 남은 값을 모두 더함
    }
}