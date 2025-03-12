package leetcode.binaryTree

fun main(){
    var ti = TreeNode(5)
    ti.left = TreeNode(3)
    ti.right = TreeNode(1)
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class SameTree {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        // 기저조건
        // 두 노드가 모두 null이면 같은 트리
        if(p == null && q == null) return true
        // 한쪽만 null이거나 값이 다르면 다른 트리
        if(p == null || q == null || p.`val` != q.`val`) return false

        // 왼쪽과 오른쪽 서브트리도 동일한지 재귀 호출
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }
}