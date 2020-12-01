from app.algorithm.Entity import ListNode


class Solution(object):
    # def reverseBetween(self, head, m, n):
    #
    #     if not head:
    #         return None
    #
    #     left, right = head, head
    #     stop = False
    #
    #     def recurseAndReverse(right, m, n):
    #         nonlocal left, stop
    #
    #         # base case dont proceed any further
    #         if n == 1:
    #             return
    #
    #         # Keep moving the right pointer one step forward until(n == 1)
    #         right = right.next
    #
    #         # Keep moving left pointer to the right until we reach the proper node
    #         # from where the reversal is to start.
    #         if m > 1:
    #             left = left.next
    #
    #         # Recurse with m and n reduced
    #         recurseAndReverse(right, m - 1, n - 1)
    #
    #         # In case both the pointers cross each other or become equal,
    #         # we stop i.e. dont swap data any further.
    #         # We are done reversing at this point.
    #         if left == right or right.next == left:
    #             stop = True
    #
    #         # Until the boolean stop is false， wap data between the two pointers.
    #         if not stop:
    #             left.val, right.val = right.val, left.val
    #             # Move left one step to the right.
    #             # The right pointer moves one step back via backtracking.
    #             left = left.next
    #
    #     recurseAndReverse(right, m, n)
    #     return head

    # def reverseBetween(self, head, m, n):
    #     # Empty list
    #     if not head:
    #         return None
    #
    #     # Move the two pointers until they reach the proper starting point
    #     # in the list.
    #     cur, prev = head, None
    #     while m > 1:
    #         prev = cur
    #         cur = cur.next
    #         m, n = m - 1, n - 1
    #
    #     # The two pointers that will fix the final connections.
    #     tail, con = cur, prev
    #
    #     # Iteratively reverse the nodes until n becomes 0.
    #     while n:
    #         third = cur.next
    #         cur.next = prev
    #         prev = cur
    #         cur = third
    #         n -= 1
    #
    #     # Adjust the final connections as explained in the algorithm
    #     if con:
    #         con.next = prev
    #     else:
    #         head = prev
    #     tail.next = cur
    #     return head

    def reverseBetween(self, head, m, n):
        if not head or m == n:
            return head
        p = dummy = ListNode(None)
        dummy.next = head
        for i in range(m - 1):
            p = p.next
        tail = p.next

        for i in range(n - m):
            tmp = p.next
            p.next = tail.next
            tail.next = tail.next.next
            p.next.next = tmp
        return dummy.next