from app.algorithm.Entity import ListNode


class Solution(object):

    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        carry = 0
        dummy = l1
        while l1:
            if not l1.next and l2.next:
                l1.next = ListNode(0)
            if not l2.next and l1.next:
                l2.next = ListNode(0)
            res = l1.val + l2.val + carry
            carry = res // 10
            if carry > 0:
                l1.val = res % 10
            else:
                l1.val = res + carry
            l1, l2 = l1.next, l2.next
        return dummy



# def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
# carry = 0
# dummy = l1
# while l1:
#     res = l1.val + l2.val + carry
#     carry = res // 10
#     if carry > 0:
#         l1.val = res % 10
#         # carry = 0
#         if not l1.next:
#             l1.next = ListNode(1)
#             return dummy
#     else:
#         l1.val = res + carry
#
#     if not l1.next and l2:
#         l1.next = ListNode(0)
#     if not l2.next and l1:
#         l2.next = ListNode(0)
#     l1 = l1.next
#     l2 = l2.next
# return dummy


if __name__ == '__main__':
    l1 = ListNode(2)
    l12 = ListNode(4)
    l13 = ListNode(3)

    l12.next = l13
    l1.next = l12

    l2 = ListNode(5)
    l22 = ListNode(6)
    l23 = ListNode(4)

    l22.next = l23
    l2.next = l22

    solution = Solution()
    solution.addTwoNumbers(l1, l2)
