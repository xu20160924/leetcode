package com.leetcode;

import com.entity.TreeNode;

import java.util.*;

public class EightNineFour {
//    public List<TreeNode> allPossibleFBT(int N) {
//        List<TreeNode> list = new ArrayList<>();
//        if (N == 1) {
//            list.add(new TreeNode(0));
//        }
//        if (N == 0) {
//            return list;
//        }
//
//        helper(--N, list);
//        return list;
//    }
//
//    TreeNode root = new TreeNode(0);
//    TreeNode node = root;
//    private void helper(int N, List<TreeNode> list) {
//        if (N == 0) {
//            list.add(root);
//            root = new TreeNode(0);
//            node = root;
//            return;
//        }
//
//
//        node.left = new TreeNode(0);
//        node.right = new TreeNode(0);
//
//        helper(N - 2, list);
//        helper( N - 2, list);
//    }

//    Map<Integer, List<TreeNode>> memo = new HashMap<>();
//    public List<TreeNode> allPossibleFBT(int N) {
//        if (!memo.containsKey(N)) {
//            List<TreeNode> ans = new LinkedList<>();
//            if (N == 1) {
//                ans.add(new TreeNode(0));
//            } else if (N % 2 == 1) {
//                for (int x = 0; x < N; ++x) {
//                    int y = N - 1 - x;
//                    for (TreeNode left : allPossibleFBT(x)) {
//                        for (TreeNode right : allPossibleFBT(y)) {
//                            TreeNode bns = new TreeNode(0);
//                            bns.left = left;
//                            bns.right = right;
//                            ans.add(bns);
//                        }
//                    }
//                }
//                memo.put(N, ans);
//            }
//        }
//        return memo.get(N);
//    }

//    Map<Integer, List<TreeNode>> memo = new HashMap();
//
//    public List<TreeNode> allPossibleFBT(int N) {
//        if (!memo.containsKey(N)) {
//            List<TreeNode> ans = new LinkedList();
//            if (N == 1) {
//                ans.add(new TreeNode(0));
//            } else if (N % 2 == 1) {
//                for (int x = 0; x < N; ++x) {
//                    int y = N - 1 - x;
//                    for (TreeNode left : allPossibleFBT(x)) {
//                        for (TreeNode right : allPossibleFBT(y)) {
//                            TreeNode bns = new TreeNode(0);
//                            bns.left = left;
//                            bns.right = right;
//                            ans.add(bns);
//                        }
//                    }
//                }
//            }
//            memo.put(N, ans);
//        }
//
//        return memo.get(N);
//    }


//    public List<TreeNode> allPossibleFBT(int N) {
//        List<TreeNode> ret = new ArrayList<>();
//        if (1 == N) {
//            ret.add(new TreeNode(0));
//        } else if (N % 2 != 0) {
//            for (int i = 2; i <= N; i += 2) {
//                List<TreeNode> leftBranch = allPossibleFBT(i - 1);
//                List<TreeNode> rightBranch = allPossibleFBT(N - i);
//                for (Iterator<TreeNode> leftIter = leftBranch.iterator(); leftIter.hasNext();) {
//                    TreeNode left = leftIter.next();
//                    for (Iterator<TreeNode> rightIter = rightBranch.iterator(); rightIter.hasNext();) {
//                        TreeNode right = rightIter.next();
//                        TreeNode node = new TreeNode(0);
//                        node.left = rightIter.hasNext() ? clone(left) : left;
//                        node.right = leftIter.hasNext() ? clone(right) : right;
//                        ret.add(node);
//                    }
//                }
//            }
//        }
//        return ret;
//    }

//    private List<TreeNode> allPossibleFBT(int N) {
//        List<TreeNode> ret = new ArrayList<>();
//        if (N % 2 == 0) {
//            return ret;
//        } else if (N == 1) {
//            ret.add(new TreeNode(0));
//            return ret;
//        }
//
//        List<List<TreeNode>> cache = new ArrayList<>();
//        cache.add(new ArrayList<>());
//        cache.get(0).add(new TreeNode(0));
//        for (int root = 1; root < N / 2; ++root) {
//            List<TreeNode> newRoot = new ArrayList<>();
//            for (int leftSize = 0; leftSize < root; ++leftSize) {
//                for (TreeNode left : cache.get(leftSize)) {
//                    for (TreeNode right : cache.get(root - leftSize - 1)) {
//                        TreeNode newTree = new TreeNode(0);
//                        newTree.left = left;
//                        newTree.right = right;
//                        newRoot.add(newTree);
//                    }
//                }
//            }
//            cache.add(newRoot);
//        }
//
//        for (int root = 0; root < N / 2; ++root) {
//            for (TreeNode left : cache.get(root)) {
//                for (TreeNode right : cache.get(N / 2 - root - 1)) {
//                    TreeNode newTree = new TreeNode(0);
//                    newTree.left = clone(left);
//                    newTree.right = clone(right);
//                    ret.add(newTree);
//                }
//            }
//        }
//        return ret;
//    }



    private TreeNode clone(TreeNode tree) {
        if (null == tree) {
            return null;
        }
        TreeNode root = new TreeNode(tree.val);
        root.left = clone(tree.left);
        root.right = clone(tree.right);
        return root;
    }

    private List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        // base case
        if (N % 2 == 0) {
            return res;
        } else if (N == 1) {
            res.add(new TreeNode(0));
            return res;
        }

        List<List<TreeNode>> cache = new ArrayList<>();
        cache.add(new ArrayList<>());
        cache.get(0).add(new TreeNode(0));
        for (int root = 1; root < N / 2; ++root) {
            List<TreeNode> newRoot = new ArrayList<>();
            for (int leftSize = 0; leftSize < root; ++leftSize) {
                for (TreeNode left : cache.get(leftSize)) {
                    for (TreeNode right : cache.get(root - leftSize - 1)) {
                        TreeNode newTree = new TreeNode(0);
                        newTree.left = left;
                        newTree.right = right;
                        newRoot.add(newTree);
                    }
                }
            }
            cache.add(newRoot);
        }

        for (int root = 0; root < N / 2; ++root) {
            for (TreeNode left : cache.get(root)) {
                for (TreeNode right : cache.get(N / 2 - root - 1)) {
                    TreeNode newTree = new TreeNode(0);
                    newTree.left = clone(left);
                    newTree.right = clone(right);
                    res.add(newTree);
                }
            }
        }
        return res;
    }



    public static void main(String[] args) {
        EightNineFour eightNineFour = new EightNineFour();
        List<TreeNode> a = eightNineFour.allPossibleFBT(7);
        System.out.println("");
    }




}
