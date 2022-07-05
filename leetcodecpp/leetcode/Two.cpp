//
// Created by John on 2022/4/9.
//
#include "../algorithm/LeetCodeInterview.h"

using namespace std;

class Solution {
public:
    static
//    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
//        int carry = 0;
//        ListNode dummyNode = ListNode();
//        ListNode *curr = &dummyNode;
//
//        while (l1 != nullptr || l2 != nullptr) {
//            int total = (l1 == nullptr ? 0 : l1->val) + (l2 == nullptr ? 0 : l2->val) + carry;
//            curr->next = new ListNode(total % 10);
//            curr = curr->next;
//            carry = total / 10;
//            if (l1 != nullptr) {
//                l1 = l1->next;
//            }
//            if (l2 != nullptr) {
//                l2 = l2->next;
//            }
//        }
//        if (carry > 0) {
//            curr->next = new ListNode(carry);
//        }
//        return dummyNode.next;
//    }

//    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
//        int c = 0;
//        ListNode newHead(0);
//        ListNode *t = &newHead;
//        while (c || l1 || l2) {
//            c += (l1 ? l1->val : 0) + (l2 ? l2->val : 0);
//            t->next = new ListNode(c % 10);
//            t = t->next;
//            c /= 10;
//            if (l1) {
//                l1 = l1->next;
//            }
//            if (l2) {
//                l2 = l2->next;
//            }
//        }
//        return t->next;
//    }

//    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
//        if(!l1 && !l2) return NULL;
//        int c = (l1? l1->val:0) + (l2? l2->val:0);
//        ListNode *newHead = new ListNode(c%10), *next = l1? l1->next:NULL;
//        c /= 10;
//        if(next) next->val += c;
//        else if(c) next = new ListNode(c);
//        newHead->next = addTwoNumbers(l2? l2->next:NULL, next);
//        return newHead;
//    }
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
        // if both all nullptr return NULL
        if (!l1 && !l2) {
            return NULL;
        }
        int c = (l1 ? l1->val : 0) + (l2 ? l2->val : 0);
        ListNode *newHead = new ListNode(c%10), *next = l1 ? l1->next : NULL;
        c /= 10;
        if (next) {
            next->val += c;
        } else if (c) {
            next = new ListNode(c);
        }
        newHead->next = addTwoNumbers(l2 ? l2->next : NULL, next);
        return newHead;
    }


//public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode dummyHead = new ListNode(0);
//        ListNode p = l1, q = l2, curr = dummyHead;
//        int carry = 0;
//        while (p != null || q != null) {
//            int x = (p != null) ? p.val : 0;
//            int y = (q != null) ? q.val : 0;
//            int sum = carry + x + y;
//            carry = sum / 10;
//            curr.next = new ListNode(sum % 10);
//            curr = curr.next;
//            if (p != null) p = p.next;
//            if (q != null) q = q.next;
//        }
//        if (carry > 0) {
//            curr.next = new ListNode(carry);
//        }
//        return dummyHead.next;
//    }

};


