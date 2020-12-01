package com.leetcode;

import com.entity.TreeNode;

import java.util.*;

/**
 * @author: John
 * @date: 2020-10-28 13:44
 * @description: 919
 **/
public class NineOneNine {
//    TreeNode root = null;
//    List<List<TreeNode>> list = new ArrayList<>();
//    int level = 0;
//
//    public NineOneNine(TreeNode root) {
//        this.root = root;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            List<TreeNode> tempList = new ArrayList<>();
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode node = queue.poll();
//                if (node.left != null) {
//                    queue.add(node.left);
//                }
//                if (node.right != null) {
//                    queue.add(node.right);
//                }
//                tempList.add(node);
//            }
//            list.add(tempList);
//        }
//        this.level = list.size() - 1;
//    }
//
//    public int insert(int v) {
//        TreeNode par = null, newNode = new TreeNode(v);
//        if (level > 0 &&  list.get(level).size() < list.get(level - 1).size() *  2) {
//            par = list.get(level - 1).get(list.get(level - 1).size() - 1);
//            list.get(level).add(newNode);
//        } else {
//            par = list.get(level).get(0);
//            List<TreeNode> newList = new ArrayList<>();
//            newList.add(newNode);
//            list.add(newList);
//        }
//        if (par.left == null) {
//            par.left = newNode;
//        } else {
//            par.right = newNode;
//        }
//        return par.val;
//    }
//
//    public TreeNode get_root() {
//        return root;
//    }



//    TreeNode root;
//    Deque<TreeNode> deque;
//    public NineOneNine(TreeNode root) {
//        this.root = root;
//        deque = new LinkedList();
//        Queue<TreeNode> queue = new LinkedList();
//        queue.offer(root);
//
//        // BFS to populate deque
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if (node.left == null || node.right == null)
//                deque.offerLast(node);
//            if (node.left != null)
//                queue.offer(node.left);
//            if (node.right != null)
//                queue.offer(node.right);
//        }
//    }
//
//    public int insert(int v) {
//        TreeNode node = deque.peekFirst();
//        deque.offerLast(new TreeNode(v));
//        if (node.left == null)
//            node.left = deque.peekLast();
//        else {
//            node.right = deque.peekLast();
//            deque.pollFirst();
//        }
//
//        return node.val;
//    }
//
//    public TreeNode get_root() {
//        return root;
//    }


//    TreeNode root;
//    Deque<TreeNode> deque;
//    public NineOneNine(TreeNode root) {
//        this.root = root;
//        deque = new LinkedList<>();
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if (node.left == null || node.right == null) {
//                deque.offerLast(node);
//            }
//            if (node.left != null) {
//                queue.offer(node.left);
//            }
//            if (node.right != null) {
//                queue.offer(node.right);
//            }
//        }
//    }
//
//    public int insert(int v) {
//        TreeNode node = deque.peekFirst();
//        deque.offerLast(new TreeNode(v));
//        if (node.left == null) {
//            node.left = deque.peekLast();
//        } else {
//            node.right = deque.peekLast();
//            deque.pollFirst();
//        }
//        return node.val;
//    }
//
//    public TreeNode get_root() {
//        return root;
//    }

//    List<TreeNode> tree;
//
//    public NineOneNine(TreeNode root) {
//        tree = new ArrayList<>();
//        tree.add(root);
//        for (int i = 0; i < tree.size(); i++) {
//            if (tree.get(i).left != null) {
//                tree.add(tree.get(i).left);
//            }
//            if (tree.get(i).right != null) {
//                tree.add(tree.get(i).right);
//            }
//        }
//    }
//
//    public int insert(int v) {
//        int N = tree.size();
//        TreeNode node = new TreeNode(v);
//        tree.add(node);
//        if (N % 2 == 1) {
//            tree.get((N - 1) / 2).left = node;
//        } else {
//            tree.get((N - 1) / 2).right = node;
//        }
//        return tree.get((N - 1) / 2).val;
//    }
//
//    public TreeNode get_root() {
//        return tree.get(0);
//    }


//    private TreeNode root;
//
//    public NineOneNine(TreeNode root) {
//        this.root = root;
//    }
//
//    public int insert(int v) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while (true) {
//            TreeNode n = queue.poll();
//            if (n.right != null) {
//                queue.offer(n.left);
//                queue.offer(n.right);
//            } else  {
//                if (n.left == null) {
//                    n.left = new TreeNode(v);
//                } else {
//                    n.right = new TreeNode(v);
//                }
//                return n.val;
//            }
//        }
//    }

//    public TreeNode get_root() {
//        return root;
//    }

    private final TreeNode root;
    private final Queue<TreeNode> queue;

    public NineOneNine(TreeNode root) {
        this.root = root;
        this.queue = new LinkedList<>();
        queue.offer(root);
    }

    public int insert(int v) {
        while (queue.peek().right != null) {
            queue.offer(queue.peek().left);
            queue.offer(queue.poll().right);
        }
        TreeNode parent = queue.peek(), n = new TreeNode(v);
        if (parent.left == null) {
            parent.left = n;
        } else {
            parent.right = n;
        }
        return parent.val;
    }

    public TreeNode get_root() {
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode(new Integer[]{1, 2, 3, 4, 5, 6});
        NineOneNine nineOneNine = new NineOneNine(root);
        System.out.println(nineOneNine.insert(7));
        System.out.println(nineOneNine.insert(8));
        System.out.println(nineOneNine.get_root().val);

//        TreeNode root = TreeNode.getTreeNode(new Integer[]{1});
//        NineOneNine nineOneNine = new NineOneNine(root);
//        System.out.println(nineOneNine.insert(2));
//        System.out.println(nineOneNine.get_root().val);


//        TreeNode root = TreeNode.getTreeNode(new Integer[]{1});
//        NineOneNine nineOneNine = new NineOneNine(root);
//        System.out.println(nineOneNine.insert(2));
//        System.out.println(nineOneNine.insert(3));
//        System.out.println(nineOneNine.insert(4));
//        System.out.println(nineOneNine.get_root().val);

    }

    /**
     * ["CBTInserter","insert","insert","insert","get_root"]
     * [[[1]],[2],[3],[4],[]]
     */

    /**
     * ["CBTInserter","insert","get_root"]
     * [[[1]],[2],[]]
     */

    //        queue.add(root);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            int num = size;
//            for (int i = 0; i < size; i++) {
//                TreeNode node = queue.peek();
//                if (node.left != null) {
//                    queue.add(node.left);
//                }
//                if (node.right != null) {
//                    queue.add(node.right);
//                }
//                if (--num >= 0) {
//                    queue.pollFirst();
//                }
//            }
//            if (num == 0) {
//                System.out.println("");
//            }
//        }
}
