package com.john;

import com.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: John
 * @date: 2020-02-01 14:08
 * @description:
 **/
public class BinaryTree {
    class ReturnType {
        public TreeNode maxBSTHead;
        public int maxBSTSize;
        public int min;
        public int max;

        public ReturnType(TreeNode maxBSTHead, int maxBSTSize, int min, int max) {
            this.maxBSTHead = maxBSTHead;
            this.maxBSTSize = maxBSTSize;
            this.min = min;
            this.max = max;
        }
    }

    public ReturnType process(TreeNode x) {
        if (x == null) {
            return new ReturnType(null, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        ReturnType lData = process(x.left);
        ReturnType rData = process(x.right);
        int min = Math.min(x.val, Math.min(lData.min, rData.min));
        int max = Math.max(x.val, Math.max(lData.max, rData.max));
        int maxBSTSize = Math.max(lData.maxBSTSize, rData.maxBSTSize);
        TreeNode maxBSTHead = lData.maxBSTSize >= rData.maxBSTSize ? lData.maxBSTHead : rData.maxBSTHead;
        if (lData.maxBSTHead == x.left && rData.maxBSTHead == x.right && x.val > lData.max && x.val < rData.min ) {
            maxBSTSize = lData.maxBSTSize + rData.maxBSTSize + 1;
            maxBSTHead = x;
        }
        return new ReturnType(maxBSTHead, maxBSTSize, min, max);
    }

    /**
     * judge avl tree
     */
//    class ReturnType {
//        public boolean isBalanced;
//        public int height;
//
//        public ReturnType(boolean isBalanced, int height) {
//            this.isBalanced = isBalanced;
//            this.height = height;
//        }
//    }

//    public ReturnType process(TreeNode head) {
//        if (head == null) {
//            return new ReturnType(true, 0);
//        }
//        ReturnType leftData = process(head.left);
//        ReturnType rightData = process(head.right);
//        int height = Math.max(leftData.height, rightData.height) + 1;
//        boolean isBalanced = leftData.isBalanced && rightData.isBalanced && Math.abs(leftData.height - rightData.height) < 2;
//        return new ReturnType(isBalanced, height);
//    }
//
//    public boolean isBalanced(TreeNode head) {
//        return process(head).isBalanced;
//    }

    public static void morris(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            cur = cur.right;
        }
    }

    public static void morrisPre(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    System.out.println(cur.val);
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            } else {
                System.out.println(cur.val);
            }
            cur = cur.right;
        }
    }

    public static void morrisIn(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            System.out.println(cur.val);
            cur = cur.right;
        }
    }
    public static void morrisPos(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                    printEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        printEdge(head);
    }

    public static void printEdge(TreeNode head) {
        TreeNode tail = reverseEdge(head);
        TreeNode cur = tail;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    public static TreeNode reverseEdge(TreeNode from) {
        TreeNode pre = null;
        TreeNode next = null;
        while (from != null) {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }

    public static String serialByPre(TreeNode head) {
        if (head == null) {
            return "#!";
        }
        String res = head.val + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    /**
     * vlidate bst
     * @param root
     * @return
     */
    public static boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean res = true;
        TreeNode pre = null;
        TreeNode cur1 = root;
        TreeNode cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }
            }
            if (pre != null && pre.val > cur1.val) {
                res = false;
            }
            pre = cur1;
            cur1 = cur1.right;
        }
        return res;
    }

    /**
     * validate full binary tree
     * @param head
     * @return
     */
    public static boolean isCBT(TreeNode head) {
        if (head == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean leaf = false;
        TreeNode l = null;
        TreeNode r = null;
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if ((leaf && (l!= null||r!=null)) || (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            } else {
                leaf = true;
            }
        }
        return true;
    }

    public static TreeNode getNextNode(TreeNode node) {
       if (node == null) {
           return node;
       }
       if (node.right != null) {
            return getLeftMost(node.right);
       } else {
           TreeNode parent = node.parent;
           while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
           }
           return parent;
       }
    }

    public static TreeNode getLeftMost(TreeNode node) {
       if (node == null) {
           return node;
       }
       while (node.left != null) {
           node = node.left;
       }
       return node;
    }

    /**
     * find two error nodes
     * @param head
     * @return
     */
    public TreeNode[] getTwoErrNodes(TreeNode head) {
        TreeNode[] errs = new TreeNode[2];
        if (head == null) {
            return errs;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (pre != null && pre.val > head.val) {
                    errs[0] = errs[0] == null ? pre : errs[0];
                    errs[1] = head;
                }
                pre = head;
                head = head.right;
            }
        }
        return errs;
    }

    /**
     * max distance
     */
//    class ReturnType {
//        public int maxDistance;
//        public int height;
//
//        public ReturnType(int maxDistance, int height) {
//            this.maxDistance = maxDistance;
//            this.height = height;
//        }
//    }
//    public ReturnType process(TreeNode head) {
//        if (head == null) {
//            return new ReturnType(0, 0);
//        }
//        ReturnType leftData = process(head.left);
//        ReturnType rightData = process(head.right);
//        int height = Math.max(leftData.height, rightData.height) + 1;
//        int maxDistance = Math.max(leftData.height + rightData.height + 1, Math.max(leftData.maxDistance, rightData.maxDistance));
//        return new ReturnType(maxDistance, height);
//    }
//
//    public int getMaxDistance(TreeNode head) {
//        return process(head).maxDistance;
//    }


    public static void main(String[] args) {
//        TreeNode root = new TreeNode(4);
//        TreeNode two = new TreeNode(2);
//        TreeNode one = new TreeNode(1);
//        TreeNode three = new TreeNode(3);
//        TreeNode six = new TreeNode(6);
//        TreeNode five = new TreeNode(5);
//        TreeNode seven = new TreeNode(7);
//
//        two.left = one;
//        two.right = three;
//        six.left = five;
//        six.right = seven;
//        root.left = two;
//        root.right = six;
        TreeNode root = new TreeNode(5);
        TreeNode one = new TreeNode(1);
        TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
//        TreeNode five = new TreeNode(5);
//        TreeNode seven = new TreeNode(7);

        four.left = three;
        four.right = six;
        root.left = one;
        root.right = four;

        BinaryTree.isBST(root);

    }
}
