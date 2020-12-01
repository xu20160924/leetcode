class Solution(object):
    def isSubtree(self, s, t):
        return self.traverse(s, t)

    def traverse(self, s, t):
        return s and (self.traverse(s,t) or self.traverse(s.left, t) or self.traverse(s.right, t))

    def equals(self, s, t):
        if not s and not t:
            return True
        if not s or not t:
            return False
        return s.val == t.val and self.equals(s.left, t.left) and self.equals(s.right, t.right)
