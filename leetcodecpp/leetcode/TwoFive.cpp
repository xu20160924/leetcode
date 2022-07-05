//
// Created by John on 2022/5/1.
//

#include "../algorithm/LeetCodeInterview.h"

class Solution {
public:
//    static ListNode* reverseKGroup(ListNode* head, int k) {
//
//        ListNode *tail, *dummy = new ListNode(0);
//        dummy->next = head;
//        tail = dummy;
//        while (head) {
//            int n = k;
//            ListNode *cur = head, *prev = NULL, *next = NULL, *nextTail = cur;
//            while (n-- && cur && cur->next) {
//                next = cur->next;
//                cur->next = prev;
//                prev = cur;
//                cur = next;
//            }
//
//            if (n) {
//                tail->next = prev;
//                tail = nextTail;
//            } else {
//                tail = cur;
//            }
//            head = next;
//        }
//        return dummy->next;
//    }
//    static ListNode* reverseKGroup(ListNode* head, int k) {
//        if (head == NULL || k == 1) {
//            return head;
//        }
//        int num = 0;
//        ListNode *preheader = new ListNode(-1);
//        preheader->next = head;
//        ListNode *cur = preheader, *next, *tmp, *pre = preheader;
//
//        while (cur = cur->next) {
//            num++;
//        }
//        while (num >= k) {
//            cur = pre->next;
//            next = cur->next;
//            for (int i = 1; i < k; i++) {
//                tmp = next->next;
//                next->next = pre->next;
//                pre->next = next;
//                cur->next = tmp;
//                next = tmp;
//            }
//            pre = cur;
//            num -= k;
//        }
//        return preheader->next;
//    }
//    static ListNode* reverseKGroup(ListNode *head, int k) {
//        if (head == NULL || k == 1) {
//            return head;
//        }
//        int num = 0;
//        ListNode *preheader = new ListNode(-1);
//        preheader->next = head;
//        ListNode *cur = preheader, *next, *pre = preheader;
//        while (cur = cur->next) {
//            num++;
//        }
//        while (num >= k) {
//            cur = pre->next;
//            next = cur->next;
//            for (int i = 1; i < k; i++) {
//                cur->next = next->next;
//                next->next = pre->next;
//                pre->next = next;
//                next = cur->next;
//            }
//            pre = cur;
//            num -= k;
//        }
//        return preheader->next;
//    }

    ListNode* reverse(ListNode* first, ListNode* last) {
        ListNode* prev = last;

        while (first != last) {
            auto tmp = first->next;
            first->next = prev;
            prev = first;
            first = tmp;
        }
        return prev;
    }

    ListNode* reverseKGroup(ListNode* head, int k) {
        auto node = head;
        for (int i = 0; i < k; ++i) {
            if (!node) {
                return head;
            }
            node = node->next;
        }
        auto new_head = reverse(head, node);
        head->next = reverseKGroup(node, k);
        return new_head;
    }
};

//int main() {
//    ListNode *l1 = new ListNode(1);
//    ListNode *l2 = new ListNode(2);
//    ListNode *l3 = new ListNode(3);
//    ListNode *l4 = new ListNode(4);
//    ListNode *l5 = new ListNode(5);
//
//    l4->next = l5;
//    l3->next = l4;
//    l2->next = l3;
//    l1->next = l2;
//    ListNode *result = Solution::reverseKGroup(l1, 3);
//}

