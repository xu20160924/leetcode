//
// Created by John on 2020/3/27.
//
#include "vector"
#include "unordered_map"
#include "queue"

using namespace std;

class Solution{

public:
    class Node {
    public:
        vector<Node*> neighbors;
        int val;


        Node() {
            val = 0;
            neighbors = vector<Node*> ();
        }
        Node(int _val) {
            val = _val;
            neighbors = vector<Node*> ();
        }

        Node(int _val, vector<Node*> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };
//    Node * cloneGraph(Node * node) {
//        if (!node) {
//            return NULL;
//        }
//        Node* copy = new Node(node->val, {});
//        copies[node] = copy;
//        queue<Node*> todo;
//        todo.push(node);
//        while (!todo.empty()) {
//            Node * cur = todo.front();
//            todo.pop();
//            for (Node * neighbor : cur->neighbors) {
//                if (copies.find(neighbor) == copies.end()) {
//                    copies[neighbor] = new Node(neighbor->val, {});
//                    todo.push(neighbor);
//                }
//                copies[cur]->neighbors.push_back(copies[neighbor]);
//            }
//        }
//        return copy;
//    }

    Node* cloneGraph(Node* node) {
        if (!node) {
            return NULL;
        }
        if (copies.find(node) == copies.end()) {
            copies[node] = new Node(node->val, {});
            for (Node * neighbor : node->neighbors) {
                copies[node]->neighbors.push_back(cloneGraph(neighbor));
            }
        }
        return copies[node];
    }



private:
    unordered_map<Node*, Node*> copies;

};
