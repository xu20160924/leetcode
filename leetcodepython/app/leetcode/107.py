from app.algorithm.Entity import TreeNode


class Solution(object):
    def levelOrderBottom(self, root):
        queue = []
        cur = [root]
        while cur:
            cur_layer_val = []
            next_layer_node = []
            for node in cur:
                if node:
                    cur_layer_val.append(node.val)
                    next_layer_node.extend([node.left, node.right])
            if cur_layer_val:
                queue.insert(0, cur_layer_val)
            cur = next_layer_node
        return queue

if __name__ == '__main__':
    root = TreeNode(3)
    nine = TreeNode(9)
    twenty = TreeNode(20)
    fifty = TreeNode(15)
    seven = TreeNode(7)

    twenty.left = fifty
    twenty.right = seven
    root.left = nine
    root.right = twenty

    solution = Solution()
    solution.levelOrderBottom(root)
