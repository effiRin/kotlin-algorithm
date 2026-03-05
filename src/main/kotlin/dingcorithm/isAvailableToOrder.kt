package dingcorithm

fun main() {
    val shopMenus = arrayOf("만두", "떡볶이", "오뎅", "사이다", "콜라") // 현재 가능한 메뉴
    val shopOrders = arrayOf("오뎅", "콜라", "만두") // 유저가 주문한 메뉴

    val result = isAvailableToOrder(shopMenus, shopOrders) // 주문이 가능한지?
    println(result)
}

fun isAvailableToOrder(menus: Array<String>, orders: Array<String>): Boolean {
    val menuSet = HashSet<String>()

    // O(N)
    for(menu in menus) {
        menuSet.add(menu)
    }

   // O(M)
    for(order in orders) {
        if(!menuSet.contains(order)) return false // 평균 O(1)
    }

    return true
}

fun isAvailableToOrderSimple(menus: Array<String>, orders: Array<String>): Boolean {
    val menuSet = menus.toHashSet()

    return orders.all { it in menuSet } // 모든 원소가 menuSet에 포함되면 all을 통해 true 반환
}