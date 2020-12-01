//
// Created by John on 2020/3/23.
//
#include "string"
#include "TreeNode.h"
#include "iostream"
#include "sstream"

using namespace std;

class Solution {
public:
    string serialize(TreeNode * root) {
        ostringstream  out;
        serialize(root, out);
        return out.str();
    }

    TreeNode* deserialize(string data) {
        istringstream in(data);
        return deserialize(in);
    }

private:
    void serialize(TreeNode * root, ostringstream& out) {
        if (root) {
            out << root->val << ' ';
            serialize(root->left, out);
            serialize(root->right, out);
        } else {
            out << "# ";
        }
    }

    TreeNode * deserialize(istringstream & in) {
        string val;
        in >> val;
        if (val == "#") {
            return nullptr;
        }
        TreeNode * root = new TreeNode(stoi(val));
        root->left = deserialize(in);
        root->right = deserialize(in);
        return root;
    }

};

//int main() {
//    std::ostringstream foo;                            // out
//    std::ostringstream bar(std::ostringstream::ate);  // out|ate
//
//    foo.str("Test string");
//    bar.str("Test string");
//
//    foo << 101;
//    bar << 101;
//
//    std::cout << foo.str() << '\n';
//    std::cout << bar.str() << '\n';
//    return 0;
//}