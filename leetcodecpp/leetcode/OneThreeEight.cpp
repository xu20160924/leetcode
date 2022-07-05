//
// Created by John on 2022/4/30.
//

#include "../algorithm/LeetCodeInterview.h"
#include "map"
#include "unordered_map"

class Solution {
public:
//    Node* copyRandomList(Node* head) {
//        Node cloneHead(0), *p = head, *t = NULL;
//
//        while (p) {
//            Node *cloneNode = new Node(p->val);
//            cloneNode->next = p->next;
//            p->next = cloneNode;
//            p = cloneNode->next;
//        }
//
//        p = head;
//        while (p && p->next) {
//            if (p->random) {
//                p->next->random = p->random->next;
//            }
//            p = p->next->next;
//        }
//
//        p = head;
//        t = &cloneHead;
//        while (p && p->next) {
//            t->next = p->next;
//            p->next = p->next->next;
//
//            t = t->next;
//            p = p->next;
//        }
//        t->next = NULL;
//        return cloneHead.next;
//    }

//    static Node* copyRandomList(Node* head) {
//        map<Node*, Node*> m;
//        Node* ptr = head;
//        while (ptr) {
//            m[ptr] = new Node(ptr->val);
//            ptr = ptr->next;
//        }
//
//        ptr = head;
//        while (ptr) {
//            m[ptr]->next = m[ptr->next];
//            m[ptr]->random = m[ptr->random];
//            ptr = ptr->next;
//        }
//        return m[head];
//    }

    unordered_map<Node*, Node*> cloneMap;
    Node* helper(Node* head) {
        if (!head) {
            return NULL;
        }
        if (cloneMap.count(head)) {
            return cloneMap[head];
        }
        Node *cloned = new Node(head->val);
        cloneMap[head] = cloned;
        cloned->next = helper(head->next);
        cloned->random = helper(head->random);
        return cloned;
    }

    Node* copyRandomList(Node* head) {
        return helper(head);
    }
};