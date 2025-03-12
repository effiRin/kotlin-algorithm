import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val st = StringTokenizer(br.readLine(), " ")

    val nums = mutableListOf<Int>()

    while (st.hasMoreTokens()) {
        nums.add(st.nextToken().toInt())
    }

    println(nums[0] - nums[1])
}