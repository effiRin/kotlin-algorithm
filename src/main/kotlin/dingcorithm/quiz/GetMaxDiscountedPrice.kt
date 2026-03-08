package dingcorithm.quiz

/***
 * Q.
 * 다음과 같이 숫자로 이루어진 배열이 두 개가 있다.
 * 하나는 상품의 가격을 담은 배열이고, 하나는 쿠폰을 담은 배열이다.
 * 쿠폰의 할인율에 따라 상품의 가격을 할인 받을 수 있다.
 * 이 때, 최대한 할인을 많이 받는다면 얼마를 내야 하는가?
 * 단, 할인 쿠폰은 한 제품에 한 번씩만 적용 가능하다.
 * (+ 가격 배열 안의 것은 할인 못 받아도 다 사야함)
 */
fun main() {
    val shopPrices = intArrayOf(30000, 2000, 1500000)
    val userCoupons = intArrayOf(20, 40)

    val discount = GetMaxDiscountedPrice()

    println(
        "정답 = 926000 / 현재 풀이 값 = ${
            discount.getMaxDiscountedPrice(intArrayOf(30000, 2000, 1500000), intArrayOf(20, 40))
        }"
    )

    println(
        "정답 = 485000 / 현재 풀이 값 = ${
            discount.getMaxDiscountedPrice(intArrayOf(50000, 1500000), intArrayOf(10, 70, 30, 20))
        }"
    )

    println(
        "정답 = 1550000 / 현재 풀이 값 = ${
            discount.getMaxDiscountedPrice(intArrayOf(50000, 1500000), intArrayOf())
        }"
    )

    println(
        "정답 = 1458000 / 현재 풀이 값 = ${
            discount.getMaxDiscountedPrice(intArrayOf(20000, 100000, 1500000), intArrayOf(10, 10, 10))
        }"
    )
}

class GetMaxDiscountedPrice
{
    fun getMaxDiscountedPrice(shopPrices: IntArray, userCoupons: IntArray): Int {
        val sortedPrices = shopPrices.sortedArrayDescending()
        val sortedCoupons = userCoupons.sortedArrayDescending()

        var answer = 0

        for(i in 0 until sortedPrices.size) {
            answer += if(sortedCoupons.size > i) sortedPrices[i] * (100 - sortedCoupons[i]) / 100 else sortedPrices[i]
        }

        return answer
    }
}