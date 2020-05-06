package subtask6

class FullBinaryTrees {

    data class Node(var left: Node? = null, var right: Node? = null, var depth: Int = 0)

    fun stringForNodeCount(count: Int): String {
        if (count % 2 == 0) return "[]"

        val i = createNodeList(count)
        val outcome = mutableListOf<MutableList<Int?>>()

        for (node in i) {
            val treeList = conventTreeToList(node)

            while (treeList.last() == null) {
                treeList.removeAt(treeList.lastIndex)
            }
            outcome.add(treeList)
        }
        return outcome.toString()
    }

    private fun createNodeList(n: Int): MutableList<Node> {
        if (n == 1) return mutableListOf(Node())

        val outcome = mutableListOf<Node>()

        for (i in 1 until n step 2) {
            val leftNodeList = createNodeList(i)
            val rightNodeList = createNodeList(n.minus(1).minus(i))

            for (leftNode in leftNodeList) {
                for (rightNode in rightNodeList) {
                    outcome.add(
                        Node(
                            leftNode,
                            rightNode,
                            maxOf(leftNode.depth, rightNode.depth).plus(1)
                        )
                    )
                }
            }
        }
        return outcome
    }

    private fun conventTreeToList(node: Node): MutableList<Int?> {
        val out = mutableListOf<Int?>(0)
        val max = node.depth
        var currentLevel = 0
        val children = mutableListOf(node.left, node.right)

        while (children.isNotEmpty()) {
            val nextChildren = mutableListOf<Node?>()
            for (child in children) {
                if (child != null) {
                    out.add(0)
                    nextChildren.add(child.left)
                    nextChildren.add(child.right)
                } else
                    if (currentLevel != max) out.add(null)
            }
            children.clear()
            children.addAll(nextChildren)
            currentLevel++
        }
        return out
    }
}