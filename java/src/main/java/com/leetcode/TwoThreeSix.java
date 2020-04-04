package com.leetcode;

import com.entity.TreeNode;
import javafx.util.Pair;

import java.util.*;

/**
 * @author: John
 * @date: 2020-02-21 12:55
 * @description: 236
 **/
public class TwoThreeSix {
    private TreeNode ans;

//    public TwoThreeSix() {
//        this.ans = null;
//    }
//    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
//        if (currentNode == null) {
//            return false;
//        }
//        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;
//        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;
//        int mid = (currentNode == p || currentNode == q) ? 1 : 0;
//        if (mid + left + right >= 2) {
//            this.ans = currentNode;
//        }
//        return (mid + left + right > 0);
//    }
//
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        this.recurseTree(root, p, q);
//        return this.ans;
//    }


//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        Deque<TreeNode> stack = new ArrayDeque<>();
//
//        Map<TreeNode, TreeNode> parent = new HashMap<>();
//        parent.put(root, null);
//        stack.push(root);
//
//        while (!parent.containsKey(p) || !parent.containsKey(q)) {
//            TreeNode node = stack.pop();
//            if (node.left != null) {
//                parent.put(node.left, node);
//                stack.push(node.left);
//            }
//            if (node.right != null) {
//                parent.put(node.right, node);
//                stack.push(node.right);
//            }
//        }
//        Set<TreeNode> ancestors = new HashSet<>();
//        while (p != null) {
//            ancestors.add(p);
//            p = parent.get(p);
//        }
//        while (!ancestors.contains(q)) {
//            q = parent.get(q);
//        }
//        return q;
//    }


//    private static int BOTH_PENDING = 2;
//    private static int LEFT_DONE = 1;
//    private static int BOTH_DONE = 0;
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
//        stack.push(new Pair<>(root, TwoThreeSix.BOTH_PENDING));
//        boolean one_node_found = false;
//        TreeNode LCA = null;
//        TreeNode child_node = null;
//        while (!stack.isEmpty()) {
//            Pair<TreeNode, Integer> top = stack.peek();
//            TreeNode parent_node = top.getKey();
//            int parent_state = top.getValue();
//            if (parent_state != TwoThreeSix.BOTH_DONE) {
//                if (parent_state == TwoThreeSix.BOTH_PENDING) {
//                    if (parent_node == p || parent_node == q) {
//                        if (one_node_found) {
//                           return LCA;
//                        } else {
//                            one_node_found = true;
//                            LCA = stack.peek().getKey();
//                        }
//                    }
//                    child_node = parent_node.left;
//                } else {
//                    child_node = parent_node.right;
//                }
//                stack.pop();
//                stack.push(new Pair<TreeNode, Integer>(parent_node, parent_state-1));
//                if (child_node != null) {
//                    stack.push(new Pair<>(child_node, TwoThreeSix.BOTH_PENDING));
//                }
//            } else {
//                if (LCA == stack.pop().getKey() && one_node_found) {
//                    LCA = stack.peek().getKey();
//                }
//            }
//        }
//        return null;
//    }

    // Three static flags to keep track of post-order traversal.

    // Both left and right traversal pending for a node.
    // Indicates the nodes children are yet to be traversed.
//    private static int BOTH_PENDING = 2;

    // Left traversal done.
//    private static int LEFT_DONE = 1;

    // Both left and right traversal done for a node.
    // Indicates the node can be popped off the stack.
//    private static int BOTH_DONE = 0;

//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//
//        Stack<Pair<TreeNode, Integer>> stack = new Stack<Pair<TreeNode, Integer>>();
//
//        // Initialize the stack with the root node.
//        stack.push(new Pair<TreeNode, Integer>(root, TwoThreeSix.BOTH_PENDING));
//
//        // This flag is set when either one of p or q is found.
//        boolean one_node_found = false;
//
//        // This is used to keep track of the LCA.
//        TreeNode LCA = null;
//
//        // Child node
//        TreeNode child_node = null;
//
//        // We do a post order traversal of the binary tree using stack
//        while (!stack.isEmpty()) {
//
//            Pair<TreeNode, Integer> top = stack.peek();
//            TreeNode parent_node = top.getKey();
//            int parent_state = top.getValue();
//
//            // If the parent_state is not equal to BOTH_DONE,
//            // this means the parent_node can't be popped off yet.
//            if (parent_state != TwoThreeSix.BOTH_DONE) {
//
//                // If both child traversals are pending
//                if (parent_state == TwoThreeSix.BOTH_PENDING) {
//
//                    // Check if the current parent_node is either p or q.
//                    if (parent_node == p || parent_node == q) {
//
//                        // If one_node_found was set already, this means we have found
//                        // both the nodes.
//                        if (one_node_found) {
//                            return LCA;
//                        } else {
//                            // Otherwise, set one_node_found to True,
//                            // to mark one of p and q is found.
//                            one_node_found = true;
//
//                            // Save the current top element of stack as the LCA.
//                            LCA = stack.peek().getKey();
//                        }
//                    }
//
//                    // If both pending, traverse the left child first
//                    child_node = parent_node.left;
//                } else {
//                    // traverse right child
//                    child_node = parent_node.right;
//                }
//
//                // Update the node state at the top of the stack
//                // Since we have visited one more child.
//                stack.pop();
//                stack.push(new Pair<TreeNode, Integer>(parent_node, parent_state - 1));
//
//                // Add the child node to the stack for traversal.
//                if (child_node != null) {
//                    stack.push(new Pair<TreeNode, Integer>(child_node, TwoThreeSix.BOTH_PENDING));
//                }
//            } else {
//
//                // If the parent_state of the node is both done,
//                // the top node could be popped off the stack.
//                // Update the LCA node to be the next top node.
//                if (LCA == stack.pop().getKey() && one_node_found) {
//                    LCA = stack.peek().getKey();
//                }
//
//            }
//        }
//
//        return null;
//    }

    private static int BOTH_PENDING = 2;
    private static int LEFT_DONE = 1;
    private static int BOTH_DONE = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<Pair<TreeNode, Integer>> stack = new Stack<Pair<TreeNode, Integer>>();
        stack.push(new Pair<TreeNode, Integer>(root, TwoThreeSix.BOTH_PENDING));
        boolean one_node_found = false;
        TreeNode LCA = null;
        TreeNode child_node = null;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> top = stack.peek();
            TreeNode parent_node = top.getKey();
            int parent_state = top.getValue();
            if (parent_state != TwoThreeSix.BOTH_DONE) {
                if (parent_state == TwoThreeSix.BOTH_PENDING) {
                    if (parent_node == p || parent_node == q) {
                        if (one_node_found) {
                            return LCA;
                        } else {
                            one_node_found = true;
                            LCA = stack.peek().getKey();
                        }
                    }
                    child_node = parent_node.left;
                } else {
                    child_node = parent_node.right;
                }
                stack.pop();
                stack.push(new Pair<TreeNode, Integer>(child_node, parent_state - 1));
                if (child_node != null) {
                    stack.push(new Pair<TreeNode, Integer>(child_node, TwoThreeSix.BOTH_PENDING));
                }
            } else {
                if (LCA == stack.pop().getKey() && one_node_found) {
                    LCA = stack.peek().getKey();
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(1);
        TreeNode six = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode zero = new TreeNode(0);
        TreeNode eight = new TreeNode(8);
        TreeNode seven = new TreeNode(7);
        TreeNode four = new TreeNode(4);


        two.left = seven;
        two.right = four;
        five.left = six;
        five.right = two;
        one.left = zero;
        one.right = eight;
        root.left = five;
        root.right = one;

        TwoThreeSix twoThreeSix = new TwoThreeSix();
        twoThreeSix.lowestCommonAncestor(root, five, four);
    }
}
