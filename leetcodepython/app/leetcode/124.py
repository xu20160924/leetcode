from app.algorithm.Entity import TreeNode


class Solution(object):
    # def maxPathSum(self, root):
    #     def max_gain(node):
    #         nonlocal max_sum
    #         if not node:
    #             return 0
    #         left_gain = max(max_gain(node.left), 0)
    #         right_gain = max(max_gain(node.right), 0)
    #         price_newpath = node.val + left_gain + right_gain
    #         max_sum = max(max_sum, price_newpath)
    #         return node.val + max(left_gain, right_gain)
    #     max_sum = float('-inf')
    #     max_gain(root)
    #     return max_sum

    def maxPathSum(self, root):
        def maxsums(node):
            if not node:
                return [-2 ** 31] * 2
            left = maxsums(node.left)
            right = maxsums(node.right)
            return [node.val + max(left[0], right[0], 0),
                    max(left + right + [node.val + left[0] + right[0]])]

        return max(maxsums(root))

    # def maxPathSum(self, root):
    #     def maxend(node):
    #         if not node:
    #             return 0
    #         left = maxend(node.left)
    #         right = maxend(node.right)
    #         self.max = max(self.max, left + node.val + right)
    #         return max(node.val + max(left, right), 0)
    #     self.max = None
    #     maxend(root)
    #     return self.max

if __name__ == '__main__':
    root = TreeNode(-10)
    nine = TreeNode(9)
    # three = TreeNode(3)
    twenty = TreeNode(20)
    fifty = TreeNode(15)
    seven = TreeNode(7)

    root.left = nine
    twenty.left = fifty
    twenty.right = seven
    root.right = twenty
    solution = Solution()
    print(solution.maxPathSum(root))

    # print(max([1,2] + [2,3] + [3,4]))
