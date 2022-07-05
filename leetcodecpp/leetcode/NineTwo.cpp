//
// Created by John on 2020/4/8.
//

#include "../algorithm/LeetCodeInterview.h"

class Solution{
public:
//    static ListNode* reverseBetween(ListNode * head, int m, int n) {
//        ListNode *dummy = new ListNode(0), *pre = dummy, *cur;
//        dummy->next = head;
//        for (int i = 0; i < m - 1; i++) {
//            pre = pre->next;
//        }
//        cur = pre->next;
//        for (int i = 0; i < n - m; ++i) {
//            ListNode* temp = pre->next;
//            pre->next = cur->next;
//            cur->next = cur->next->next;
//            pre->next->next = temp;
//        }
//        return dummy->next;
//    }


/**
 *  1,2,3,4,5,6
 *  2 5
 */
//    static ListNode* reverseBetween(ListNode * head, int m, int n) {
//        ListNode *dummy = new ListNode(0), *pre = dummy, *cur = head;
//        dummy->next = head;
//        n -= m;
//
//        while (--m) {
//            pre = pre->next;
//        }
//        cur = pre->next;
//
//        while (n--) {
//            ListNode *temp = pre->next;
//            pre->next = cur->next;
//            cur->next = cur->next->next;
//            pre->next->next = temp;
//        }
//        return dummy->next;
//    }




    static ListNode* reverseBetween(ListNode * head, int m, int n) {
        if (!n) {
            return head;
        }
        if (m > 1) {
            head->next = reverseBetween(head->next, --m, --n);
        }
        else {
            ListNode *pre = NULL;
            ListNode *tail = head;
            while (n--) {
                ListNode *next = head->next;
                head->next = pre;
                pre = head;
                head = next;
            }
            tail->next = head;
            return pre;
        }
        return head;
    }
    // 1 2 3 4 5


//    static ListNode* reverseBetween(ListNode* head, int m, int n) {
//        if(m>1)
//            head->next=reverseBetween(head->next,m-1,n-1);
//        else{
//            ListNode* prev=NULL;
//            ListNode* tail=head;
//            int nodesToReverse=n-m+1;
//            while(nodesToReverse--){
//                ListNode* next=head->next;
//                head->next=prev;
//                prev=head;
//                head=next;
//            }
//            tail->next=head;
//            return prev;
//        }
//        return head;
//    }
};

/**
 *
 * class Solution {
public:
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        if(m>1)
            head->next=reverseBetween(head->next,m-1,n-1);
        else{
            ListNode* prev=NULL;
            ListNode* tail=head;
            int nodesToReverse=n-m+1;
            while(nodesToReverse--){
                ListNode* next=head->next;
                head->next=prev;
                prev=head;
                head=next;
            }
            tail->next=head;
            return prev;
        }
        return head;
    }
};
 */



/**
*
 * class Solution {

    // Object level variables since we need the changes
    // to persist across recursive calls and Java is pass by value.
    private boolean stop;
    private ListNode left;

    public void recurseAndReverse(ListNode right, int m, int n) {

        // base case. Don't proceed any further
        if (n == 1) {
            return;
        }

        // Keep moving the right pointer one step forward until (n == 1)
        right = right.next;

        // Keep moving left pointer to the right until we reach the proper node
        // from where the reversal is to start.
        if (m > 1) {
            this.left = this.left.next;
        }

        // Recurse with m and n reduced.
        this.recurseAndReverse(right, m - 1, n - 1);

        // In case both the pointers cross each other or become equal, we
        // stop i.e. don't swap data any further. We are done reversing at this
        // point.
        if (this.left == right || right.next == this.left) {
            this.stop = true;
        }

        // Until the boolean stop is false, swap data between the two pointers
        if (!this.stop) {
            int t = this.left.val;
            this.left.val = right.val;
            right.val = t;

            // Move left one step to the right.
            // The right pointer moves one step back via backtracking.
            this.left = this.left.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        this.left = head;
        this.stop = false;
        this.recurseAndReverse(head, m, n);
        return head;
    }
}
 *
*/

/**
 *  1,2,3,4,5,6
 *  2 5
 */
//int main() {
////    cout << (2 % 5) << endl;
//
//    ListNode * node1 = new ListNode(1);
//    ListNode * node2 = new ListNode(2);
//    ListNode * node3 = new ListNode(3);
//    ListNode * node4 = new ListNode(4);
//    ListNode * node5 = new ListNode(5);
////    ListNode * node6 = new ListNode(6);
////
////    node5->next = node6;
//    node4->next = node5;
//    node3->next = node4;
//    node2->next = node3;
//    node1->next = node2;
//
////    ListNode *node1 = new ListNode(3);
////    ListNode *node2 = new ListNode(5);
////    node1->next = node2;
//
//    ListNode *result = Solution::reverseBetween(node1, 2, 4);
//    cout << 1 << endl;
//}


