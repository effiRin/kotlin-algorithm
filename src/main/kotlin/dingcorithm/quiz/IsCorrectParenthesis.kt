package dingcorithm.quiz

/***
https://school.programmers.co.kr/learn/courses/30/lessons/12909

Q. 괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻이다. 예를 들어
()() 또는 (())() 는 올바르다.
)()( 또는 (()( 는 올바르지 않다.
이 때, '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 True 를 반환하고 아니라면 False 를 반환하시오.
*/
fun main() {
    val parenthesis = IsCorrectParenthesis()

    println("정답 = true / 현재 풀이 값 = ${parenthesis.isCorrectParenthesis("(())")}")
    println("정답 = false / 현재 풀이 값 = ${parenthesis.isCorrectParenthesis(")")}")
    println("정답 = false / 현재 풀이 값 = ${parenthesis.isCorrectParenthesis("((())))")}")
    println("정답 = false / 현재 풀이 값 = ${parenthesis.isCorrectParenthesis("())()")}")
    println("정답 = false / 현재 풀이 값 = ${parenthesis.isCorrectParenthesis("((())")}")
}

class IsCorrectParenthesis {

    fun isCorrectParenthesis(input: String): Boolean {
        val stack = ArrayDeque<Char>()

        input.forEach { char ->
            if(char == '(') stack.addLast(char)
            else stack.removeLastOrNull() ?: return false
        }

        return stack.isEmpty()
    }

    fun isCorrectParenthesisCounterVer(input: String): Boolean {
        var counter = 0

        input.forEach { char ->
            if(char == '(') counter++
            else {
                counter--
                if(counter < 0) return false
            }
        }

        return counter == 0
    }
}