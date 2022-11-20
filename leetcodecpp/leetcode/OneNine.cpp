//
// Created by caidaoliuhai on 2022/8/19.
//
#include "../algorithm/LeetCodeInterview.h"
#include "iostream"

using namespace std;

class Solution {
public:
//    ListNode* removeNthFromEnd(ListNode* head, int n) {
//        ListNode *start = new ListNode(0);
//        ListNode *slow = start, *fast = start;
//        slow->next = head;
//
//        for (int i = 0; i <= n; i++) {
//            fast = fast->next;
//        }
//
//        while (fast) {
//            slow = slow->next;
//            fast = fast->next;
//        }
//
//        slow->next = slow->next->next;
//        return start->next;
//    }


//    ListNode* removeNthFromEnd(ListNode* head, int n) {
//        ListNode *fast = head, *slow = head;
//        for (int i = 0; i < n; i++) {
//            fast = fast->next;
//        }
////        if (!fast) {
////            return head->next;
////        }
//        while (fast->next) {
//            fast = fast->next;
//            slow = slow->next;
//        }
//        slow->next = slow->next->next;
//        return head;
//    }

//    ListNode* removeNthFromEnd(ListNode* head, int n) {
//        ListNode *res = head;
//        shift(head, n);
//        return res->next;
//    }
//
//    int shift(ListNode *head, int n) {
//        if (!head) {
//            return 0;
//        }
//        int i = shift(head->next, n) + 1;
//        if (i > n) {
//            head->next->val = head->val;
//        }
//        return i;
//    }

    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* res = head;
        remove(head, n);
        return res;
    }

    ListNode* remove(ListNode* head, int n) {
        if (!head) {
            return head;
        }
        head->next = remove(head->next,  n);
        n--;
        if (!n) {
            return head->next;
        } else {
            return head;
        }
    }
};

//int main() {
////    ListNode* listnode1 = new ListNode(1);
////    ListNode* listnode2 = new ListNode(2);
////    ListNode* listnode3 = new ListNode(3);
////    ListNode* listnode4 = new ListNode(4);
////    ListNode* listnode5 = new ListNode(5);
////    listnode4->next = listnode5;
////    listnode3->next = listnode4;
////    listnode2->next = listnode3;
////    listnode1->next = listnode2;
////
////    Solution* solution = new Solution();
////    ListNode* res = solution->removeNthFromEnd(listnode1, 2);
////    cout << res << endl;
////    int array[] = {1,2,3,4,5};
//    int array[] = {1,2,3,4,5};
//    int size = sizeof(array) / sizeof(array[0]);
//    ListNode *listNode = createListNode(array, size);
//    Solution *solution = new Solution();
//    ListNode *res = solution->removeNthFromEnd(listNode, 2);
//    cout << res << endl;
//}

