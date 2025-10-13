package leetcode

import leetcode.binaryTree.TreeNode
import java.util.*

class SumOfLeftLeaves {

    fun main(){

    }

    fun sumOfLeftLeaves(root: TreeNode?): Int {
        if (root == null) return 0

        var sum = 0
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)

        while(queue.isNotEmpty()) {
            val node = queue.poll()

            node.left?.let {
                if(it.left == null && it.right == null) {
                    sum += node.`val`
                }

                queue.add(it)
            }

            node.right?.let {
                queue.add(it)
            }
        }

        return sum
    }
}