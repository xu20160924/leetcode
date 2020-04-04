class Solution(object):
    # def preorderTraversal(self, root):
    #
    #     if root:
    #         return []
    #
    #     stack, output = [root, ], []
    #     while stack:
    #         root = stack.pop()
    #         if root is not None:
    #             output.append(root.val)
    #             stack.append(root.right)
    #             stack.append(root.left)
    #
    #     return output

    def preorderTraversal(self, root):
        node, output = root, []
        while node:
            if not node.left:
                output.append(node.val)
                node = node.right
            else:
                predecessor = node.left

                while predecessor.right and predecessor.right is not node:
                    predecessor = predecessor.right

                if not predecessor.right:
                    output.append(node.val)
                    predecessor.right = node
                    node = node.left
                else:
                    predecessor.right = None
                    node = node.right
        return output

