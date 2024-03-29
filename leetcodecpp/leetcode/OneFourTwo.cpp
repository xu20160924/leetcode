//
// Created by John on 2020/4/9.
//

#include "../algorithm/LeetCodeInterview.h"

class Solution{
public:
    static ListNode *detectCycle(ListNode *head) {
        if (!head || !head->next) {
            return NULL;
        }

        ListNode *slow = head, *fast = head, *res = head;
        while (fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;
            // circled
            if (slow == fast) {
                while (res != fast) {
                    res = res->next;
                    fast = fast->next;
                }
                return res;
            }
        }
        return NULL;
    }

//    ListNode * detectCycle(ListNode * head) {
//        if (head == NULL || head->next == NULL) {
//            return NULL;
//        }
//        ListNode * firstp = head;
//        ListNode * secondp = head;
//        bool isCycle = false;
//
//        while (firstp != NULL && secondp != NULL) {
//            firstp = firstp->next;
//            if (secondp->next == NULL) {
//                return NULL;
//            }
//            secondp = secondp->next->next;
//            if (firstp == secondp) {
//                isCycle == true;
//                break;
//            }
//        }
//        if (!isCycle) {
//            return NULL;
//        }
//        firstp = head;
//        while (firstp != secondp) {
//            firstp = firstp->next;
//            secondp = secondp->next;
//        }
//        return firstp;
//    }
};




/**
 *
 *
 * Alogrithm Description:
Step 1: Determine whether there is a cycle

1.1) Using a slow pointer that move forward 1 step each time

1.2) Using a fast pointer that move forward 2 steps each time

1.3) If the slow pointer and fast pointer both point to the same location after several moving steps, there is a cycle;

1.4) Otherwise, if (fast->next == NULL || fast->next->next == NULL), there has no cycle.

Step 2: If there is a cycle, return the entry location of the cycle

2.1) L1 is defined as the distance between the head point and entry point

2.2) L2 is defined as the distance between the entry point and the meeting point

2.3) C is defined as the length of the cycle

2.4) n is defined as the travel times of the fast pointer around the cycle When the first encounter of the slow pointer and the fast pointer

According to the definition of L1, L2 and C, we can obtain:

the total distance of the slow pointer traveled when encounter is L1 + L2

the total distance of the fast pointer traveled when encounter is L1 + L2 + n * C

Because the total distance the fast pointer traveled is twice as the slow pointer, Thus:

2 * (L1+L2) = L1 + L2 + n * C => L1 + L2 = n * C => L1 = (n - 1) C + (C - L2)*

It can be concluded that the distance between the head location and entry location is equal to the distance between the meeting location and the entry location along the direction of forward movement.

So, when the slow pointer and the fast pointer encounter in the cycle, we can define a pointer "entry" that point to the head, this "entry" pointer moves one step each time so as the slow pointer. When this "entry" pointer and the slow pointer both point to the same location, this location is the node where the cycle begins.

================================================================

2 3 0 4
      s
      f
Here is the code:

ListNode *detectCycle(ListNode *head) {
    if (head == NULL || head->next == NULL)
        return NULL;

    ListNode *slow  = head;
    ListNode *fast  = head;
    ListNode *entry = head;

    while (fast->next && fast->next->next) {
        slow = slow->next;
        fast = fast->next->next;
        if (slow == fast) {                      // there is a cycle
            while(slow != entry) {               // found the entry location
                slow  = slow->next;
                entry = entry->next;
            }
            return entry;
        }
    }
    return NULL;                                 // there has no cycle
}
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */


//int main() {
//    ListNode *l1 = new ListNode(3);
//    ListNode *l2 = new ListNode(2);
//    ListNode *l3 = new ListNode(0);
//    ListNode *l4 = new ListNode(4);
//    l4->next = l2;
//    l3->next = l4;
//    l2->next = l3;
//    l1->next = l2;
//    ListNode *result = Solution::detectCycle(l1);
//}
