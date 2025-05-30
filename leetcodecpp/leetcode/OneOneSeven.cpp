//
// Created by on 2025/4/7.
//

#include <queue>

#include "Node.h"

using namespace std;


class Solution {
public:
    // Node* connect(Node* root) {
    //     queue<Node*> que;
    //     que.push(root);
    //     while (!que.empty()) {
    //         int size = que.size();
    //         Node* prev = NULL;
    //         for (int i = 0; i < size; i++) {
    //             Node *node = que.front();
    //             que.pop();
    //             if (prev) {
    //                 prev->next = node;
    //                 prev = node;
    //             }
    //             if (node->left) {
    //                 que.push(node->left);
    //             }
    //             if (node->right) {
    //                 que.push(node->right);
    //             }
    //         }
    //     }
    //     return root;
    // }
    // Node* connect(Node* root) {
    //     while (root) {
    //         Node *temp = new Node(0);
    //         Node *cur = temp;
    //         while (root) {
    //             if (root->left) {
    //                 cur->next = root->left;
    //                 cur = cur->next;
    //             }
    //             if (root->right) {
    //                 cur->next = root->right;
    //                 cur = cur->next;
    //             }
    //             root = root->next;
    //         }
    //         root = temp->next;
    //     }
    //     return root;
    // }
    Node* connect(Node* root) {
        if (!root) {
            return root;
        }
        Node *head = root;

        while(head) {
            Node *dummy = new Node(0);
            Node *temp = dummy;
            for (Node *cur = head; cur != NULL; cur = cur->next) {
                if (cur->left) {
                    temp->next = cur->left;
                    temp = temp->next;
                }
                if (cur->right) {
                    temp->next = cur->right;
                    temp = temp->next;
                }
            }
            head = dummy->next;
        }
        return root;
    }
};
