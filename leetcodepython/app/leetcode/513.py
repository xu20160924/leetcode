from app.algorithm.Entity import TreeNode


class Solution:
    # def findLeftMostNode(self, root):
    #     queue = [root]
    #     for node in queue:
    #         queue += filter(None, (node.right, node.left))
    #     return node.val

    def findLeftMostNode(self, root):
        queue = [root]
        while queue:
            root = queue.pop(0)
            queue += filter(None, (root.right, root.left))
        return root.val

if __name__ == '__main__':
    solution = Solution()
    # root = TreeNode(1)
    # two = TreeNode(2)
    # four = TreeNode(4)
    # five = TreeNode(5)
    # three = TreeNode(3)
    # six = TreeNode(6)
    # seven = TreeNode(7)
    #
    # five.left = seven
    # three.left = five
    # three.right = six
    # two.left = four
    # root.left = two
    # root.right = three

    root = TreeNode(2)
    one = TreeNode(1)
    three = TreeNode(3)
    root.left = one
    root.right = three

    print(solution.findLeftMostNode(root))
