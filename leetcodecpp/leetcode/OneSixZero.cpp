//
// Created by John on 2020/2/17.
//

#include "OneSixZero.h"

class Solution{
public:
    ListNode* getInwtersectionNode(ListNode * headA, ListNode *headB) {
        if (headA == NULL || headB == NULL) {
            return NULL;
        }
        ListNode* a = headA;
        ListNode* b = headB;
        while (a != b) {
            a = a == NULL ? headB : a->next;
            b = b == NULL ? headA : b->next;
        }
        return a;
    }
};
//int main() {
//    ListNode * list1 = new ListNode(4);
//    ListNode * list2 = new ListNode(1);
//    ListNode * list3 = new ListNode(8);
//    ListNode * list4 = new ListNode(4);
//    ListNode * list5 = new ListNode(5);
//
//
//    ListNode * list11 = new ListNode(5);
//    ListNode * list12 = new ListNode(0);
//    ListNode * list13 = new ListNode(1);
//    ListNode * list14 = new ListNode(8);
//    ListNode * list15 = new ListNode(4);
//    ListNode * list16 = new ListNode(5);
//
//    list4->next = list5;
//    list3->next = list4;
//    list2->next = list3;
//    list1->next = list2;
//
//
//    list15->next = list16;
//    list14->next = list15;
//    list13->next = list14;
//    list12->next = list13;
//    list11->next = list12;
//
//    Solution * solution = new Solution();
//    solution->getInwtersectionNode(list1, list11);
//
//
//}