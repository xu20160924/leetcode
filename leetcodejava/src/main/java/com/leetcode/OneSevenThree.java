package com.leetcode;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: John
 * @date: 2020-04-06 17:12
 * @description: 173
 * Binary Search Tree Iterator
 **/
public class OneSevenThree {
//    private List<Integer> nodes;
//    public OneSevenThree(TreeNode root) {
//        nodes = new ArrayList<>();
//        inorder(root, nodes);
//    }
//
//    // return the next smallest number
//    public int next() {
//        if (hasNext()) {
//            return nodes.remove(0);
//        }
//        return -1;
//    }
//
//    // return whether we have a next smallest number
//    public boolean hasNext() {
//        return !nodes.isEmpty();
//    }
//
//    private void inorder(TreeNode root, List<Integer> res) {
//        if (root != null) {
//           if (root.left != null) {
//               inorder(root.left, res);
//           }
//           res.add(root.val);
//           if (root.right != null) {
//               inorder(root.right, res);
//           }
//        }
//      }
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode curr = root;
//
//        while (curr != null || !stack.isEmpty()) {
//            while (curr != null) {
//               stack.push(curr);
//               curr = curr.left;
//            }
//            curr = stack.pop();
//            res.add(curr.val);
//            curr = curr.right;
//        }
//        return res;

//   ArrayList<Integer> nodesSorted;
//   int index;
//
//   public OneSevenThree(TreeNode root) {
//      // Array containing all the nodes in the sorted order
//      this.nodesSorted = new ArrayList<>();
//
//      // pointer to the next smallest element in the BST
//      this.index = -1;
//
//      // call to flatten the input binary search tree
//      this.inorder(root);
//   }
//
//   private void inorder(TreeNode root) {
//     if (root == null) {
//        return;
//     }
//     this.inorder(root.left);
//     this.nodesSorted.add(root.val);
//     this.inorder(root.right);
//   }
//
//   public int next() {
//      return this.nodesSorted.get(++this.index);
//   }
//
//   public boolean hasNext() {
//      return this.index + 1 < this.nodesSorted.size();
//   }

    Stack<TreeNode> stack;
    public OneSevenThree(TreeNode root) {
       // Stack for the recursion simulation
       this.stack = new Stack<>();

       // Remember that the algorithm starts with a call to the helper function
        // with the root node as the input
        this.leftmostInorder(root);
    }

    private void leftmostInorder(TreeNode root) {
       // For a given node, add all the elements in the leftmost branch of the tree
       // under it to the stack.
       while (root != null) {
          this.stack.push(root);
          root = root.left;
       }
    }

    //
    public int next() {
        // Node at the top of the stack is the next smallest element.
        TreeNode topmostNode = this.stack.pop();
        // Need to maintain the invariant. If the node has a right child,
        // call the helper function for the right child

        if (topmostNode.right != null) {
           this.leftmostInorder(topmostNode.right);
        }

        return topmostNode.val;
    }

    public boolean hasNext() {
        return this.stack.size() > 0;
    }
}
