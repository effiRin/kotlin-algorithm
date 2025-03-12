package leetcode.sorting

fun main() {

    val nums = intArrayOf(0,1,2)
    val target = 3
    val answer = threeSumClosest(nums, target)

    println(answer)

}

fun threeSumClosest(nums: IntArray, target: Int): Int {
    nums.sort()
    var closestSum = nums[0] + nums[1] + nums[2]

    for (i in nums.indices) {
        var left = i + 1
        var right = nums.size - 1

        while (left < right) {
            val sum = nums[i] + nums[left] + nums[right]

            // 현재 sum이 더 target에 가까우면 업데이트
            if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                closestSum = sum
            }

            // 투 포인터 이동 로직
            if (sum < target) {
                left++
            } else if (sum > target) {
                right--
            } else {
                return sum // target과 정확히 일치하면 바로 반환
            }
        }
    }
    return closestSum
}

