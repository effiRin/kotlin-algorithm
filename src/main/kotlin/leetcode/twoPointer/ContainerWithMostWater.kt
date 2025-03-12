package leetcode.twoPointer

class ContainerWithMostWater {

    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var maxArea = 0

        while (left < right) {
            val width = right - left
            val minHeight = minOf(height[left], height[right]) // 낮은 높이를 기준으로 계산 - 물을 담을 수 있어야 하므로..
            val area = width * minHeight
            maxArea = maxOf(maxArea, area)

            // 높이가 낮은 쪽을 이동
            if (height[left] < height[right]) {
                left++
            } else {
                right--
            }
        }

        return maxArea
    }
}