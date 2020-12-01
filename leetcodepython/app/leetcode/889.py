from app.algorithm.Entity import TreeNode


class Solution:
    # def constructFromPrePost(self, pre, post):
    #     if not pre: return None
    #     root = TreeNode(pre[0])
    #     if len(pre) == 1: return root
    #
    #     L = post.index(pre[1]) + 1
    #     root.left = self.constructFromPrePost(pre[1:L+1], post[:L])
    #     root.right = self.constructFromPrePost(pre[L+1:], post[L:-1])
    #     return root

    def constructFromPrePost(self, pre, post):
        stack = [TreeNode(pre[0])]
        j = 0
        for v in pre[1:]:
            node = TreeNode(v)
            while stack[-1].val == post[j]:
                stack.pop()
                j += 1
            if not node[-1].left:
                node[-1].left = node
            else:
                node[-1].right = node

            stack.append(node)
        return stack[0]