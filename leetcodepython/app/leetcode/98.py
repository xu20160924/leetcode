from app.algorithm.Entity import TreeNode


class Solution(object):
    # def isValidBST(self, root):
    #     def helper(node, lower = float('-inf'), upper = float('inf')):
    #         if not node:
    #             return True
    #         val = node.val
    #         if val <= lower or val >= upper:
    #             return False
    #         if not helper(node.right, val, upper):
    #             return False
    #         if not helper(node.left, lower, val):
    #             return False
    #         return True
    #     return helper(root)
    # def isValidBST(self, root: TreeNode) -> bool:
    #     if not root:
    #         return True
    #     stack = [(root, float('-inf'), float('inf')), ]
    #     while stack:
    #         root, lower, upper = stack.pop()
    #         if not root:
    #             continue
    #         if root.val <= lower or root.val >= upper:
    #             return False
    #         stack.append(root.left, lower, root.val)
    #         stack.append(root.right, root.val, upper)
    #
    #     return True

    def isValidBST(self, root):
        stack, inorder = [], float('-inf')
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()

            if root.val <= inorder:
                return False
            inorder = root.val
            root = root.right
        return True




if __name__ == '__main__':
    root = TreeNode(5)
    one = TreeNode(1)
    four = TreeNode(4)
    # three = TreeNode(3)
    seven = TreeNode(7)
    six = TreeNode(6)

    six.left = four
    six.right = seven
    root.left = one
    root.right = six
    # four.left = three
    # four.right = six
    # root.left = one
    # root.right = four
    solution = Solution()
    solution.isValidBST(root)