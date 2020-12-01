from app.algorithm.Entity import TreeNode


class Solution(object):
    """
    Use BFS to do a level order traversal,
    add childrens to the bfs queue,
    until we met the first empty node.

    For a complete binary tree,
    there should not be any node after we met an empty one.
    """
    def isCompleteTree(self, root):
        bfs = [root]
        i = 0
        while bfs[i]:
            bfs.append(bfs[i].left)
            bfs.append(bfs[i].right)
            i += 1
        print(bfs[i:])
        return not any(bfs[i:])


if __name__ == '__main__':
    root = TreeNode(1)
    two = TreeNode(2)
    three = TreeNode(3)
    four = TreeNode(4)
    five = TreeNode(5)
    six = TreeNode(6)
    seven = TreeNode(7)
    two.left = four
    two.right = five
    # three.left = six
    three.right = seven
    root.left = two
    root.right = three

    solution = Solution()
    solution.isCompleteTree(root)

    # test = [1,3,3,4]
    # a = test[3:]
    # print(a)