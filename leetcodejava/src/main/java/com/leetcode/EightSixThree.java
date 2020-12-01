package com.leetcode;

import com.entity.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author: John
 * @date: 2020-10-17 16:36
 * @description: 863
 **/
public class EightSixThree {
//    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
//        List<Integer> list = new ArrayList<>();
//
//        if (root == null || target == null) {
//           return list;
//        }
//        helper(root, target, k, list);
//        return list;
//    }
//
//    private void helper(TreeNode root, TreeNode target, int k, List<Integer> list) {
//        if (root == null) {
//            return;
//        }
//
//
//        helper(root.left, target, k, list);
//        helper(root.right, target, k, list);
//        System.out.println(root.val);
//    }

//    Map<TreeNode, TreeNode> parent;
//
//    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
//        parent = new HashMap<>();
//        dfs(root, null);
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(null);
//        queue.add(target);
//
//        Set<TreeNode> seen = new HashSet<>();
//        seen.add(target);
//        seen.add(null);
//
//        int dist = 0;
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if (node == null) {
//                if (dist == k) {
//                    List<Integer> ans = new ArrayList<>();
//                    for (TreeNode n : queue) {
//                        ans.add(n.val);
//                    }
//                    return ans;
//                }
//                queue.offer(null);
//                dist++;
//            } else {
//                if (!seen.contains(node.left)) {
//                    seen.add(node.left);
//                    queue.offer(node.left);
//                }
//                if (!seen.contains(node.right)) {
//                    seen.add(node.right);
//                    queue.offer(node.right);
//                }
//                TreeNode par = parent.get(node);
//                if (!seen.contains(par)) {
//                    seen.add(par);
//                    queue.offer(par);
//                }
//            }
//        }
//        return new ArrayList<>();
//    }
//
//    private void dfs(TreeNode node, TreeNode par) {
//        if (node != null) {
//            parent.put(node, par);
//            dfs(node.left, node);
//            dfs(node.right, node);
//        }
//    }

//
//    Map<TreeNode, Integer> map = new HashMap<>();
//
//    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
//        List<Integer> res = new LinkedList<>();
//        find(root, target);
//        dfs(root, target, k, map.get(root), res);
//        return res;
//    }
//
//    private int find(TreeNode root, TreeNode target) {
//        if (root == null) {
//            return -1;
//        }
//        if (root == target) {
//            map.put(root, 0);
//            return 0;
//        }
//        int left = find(root.left, target);
//        if (left >= 0) {
//            map.put(root, left + 1);
//            return left + 1;
//        }
//
//        int right = find(root.right, target);
//        if (right >= 0) {
//            map.put(root, right + 1);
//            return right + 1;
//        }
//        return -1;
//    }
//
//    private void dfs(TreeNode root, TreeNode target, int k, int length, List<Integer> res) {
//        if (root == null) {
//            return;
//        }
//        if (map.containsKey(root)) {
//            length = map.get(root);
//        }
//        if (length == k) {
//            res.add(root.val);
//        }
//        dfs(root.left, target, k, length + 1, res);
//        dfs(root.right, target, k, length + 1, res);
//
//    }

//
//
//
//    Map<TreeNode, Integer> map = new HashMap<>();
//
//    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
//        List<Integer> res = new LinkedList<>();
//        find(root, target);
//        dfs(root, target, K, 0, res);
//        return res;
//    }
//
//    // find target node first and store the distance in that path that we could use it later directly
//    private int find(TreeNode root, TreeNode target) {
//        if (root == null) return -1;
//        if (root == target) {
//            map.put(root, 0);
//            return 0;
//        }
//        int left = find(root.left, target);
//        if (left >= 0) {
//            map.put(root, left + 1);
//            return left + 1;
//        }
//        int right = find(root.right, target);
//        if (right >= 0) {
//            map.put(root, right + 1);
//            return right + 1;
//        }
//        return -1;
//    }
//
//    private void dfs(TreeNode root, TreeNode target, int K, int length, List<Integer> res) {
//        if (root == null) return;
//        if (map.containsKey(root)) length = map.get(root);
//        if (length == K) res.add(root.val);
//        dfs(root.left, target, K, length + 1, res);
//        dfs(root.right, target, K, length + 1, res);
//    }





    public static void main(String[] args) {
//        TreeNode root = TreeNode.listToTree("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode root = TreeNode.getTreeNode(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        EightSixThree eightSixThree = new EightSixThree();
        List<Integer> a = eightSixThree.distanceK(root, new TreeNode(5), 2);
        System.out.println("");
    }


    //    Map<TreeNode, Integer> map = new HashMap<>();
//
//    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
//        List<Integer> res = new LinkedList<>();
//        find(root, target);
//        dfs(root, target, K, 0, res);
//        return res;
//    }
//
//    // find target node first and store the distance in that path that we could use it later directly
//    private int find(TreeNode root, TreeNode target) {
//        if (root == null)  {
//            return -1;
//        }
//        if (root.val == target.val) {
//            map.put(root, 0);
//            return 0;
//        }
//        int left = find(root.left, target);
//        if (left >= 0) {
//            map.put(root, left + 1);
//            return left + 1;
//        }
//        int right = find(root.right, target);
//        if (right >= 0) {
//            map.put(root, right + 1);
//            return right + 1;
//        }
//        return -1;
//    }
//
//    private void dfs(TreeNode root, TreeNode target, int K, int length, List<Integer> res) {
//        if (root == null)  {
//            return;
//        }
//        if (map.containsKey(root)) {
//            length = map.get(root);
//        }
//        if (length == K) {
//            res.add(root.val);
//        }
//        dfs(root.left, target, K, length + 1, res);
//        dfs(root.right, target, K, length + 1, res);
//    }


//    Map<TreeNode, Integer> map = new HashMap<>();
//    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
//        List<Integer> res = new ArrayList<>();
//        find(root, target);
//        search(root, 0, K, res);
//        return res;
//    }
//
//    private void find(TreeNode root, TreeNode target) {
//        if (root == null) {
//            return;
//        }
//
//        if (root.val == target.val) {
//            map.put(root, 0);
//            return;
//        }
//
//        find(root.left, target);
//        if (map.containsKey(root.left)) {
//            map.put(root, map.get(root.left) + 1);
//            return;
//        }
//
//        find(root.right, target);
//        if (map.containsKey(root.right)) {
//            map.put(root, map.get(root.right) + 1);
//            return;
//        }
//        return;
//    }
//
//    public void search(TreeNode root, int dis, int K, List<Integer> res) {
//        if (root == null) {
//            return;
//        }
//
//        if (map.containsKey(root)) {
//            dis = map.get(root);
//        }
//
//        if (dis == K) {
//            res.add(root.val);
//        }
//
//        search(root.left, dis + 1, K, res);
//        search(root.right, dis + 1, K, res);
//    }

//    Map<TreeNode, TreeNode> parent;
//
//    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
//         parent = new HashMap<>();
//         dfs(root, null);
//
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(null);
//         queue.add(target);
//
//         Set<TreeNode> seen = new HashSet<>();
//         seen.add(target);
//         seen.add(null);
//
//         int dist = 0;
//         while (!queue.isEmpty()) {
//             TreeNode node = queue.poll();
//             if (node == null) {
//                 if (dist == K) {
//                     List<Integer> ans = new ArrayList<>();
//                     for (TreeNode n : queue) {
//                         ans.add(n.val);
//                     }
//                     return ans;
//                 }
//                queue.offer(null);
//                dist++;
//             } else {
//                 if (!seen.contains(node.left)) {
//                     seen.add(node.left);
//                     queue.offer(node.left);
//                 }
//                 if (!seen.contains(node.right)) {
//                     seen.add(node.right);
//                     queue.offer(node.right);
//                 }
//                 TreeNode par = parent.get(node);
//                 if (!seen.contains(par)) {
//                     seen.add(par);
//                     queue.offer(par);
//                 }
//             }
//         }
//         return new ArrayList<>();
//    }


//    private void dfs(TreeNode root, TreeNode prev) {
//        if (root != null) {
//            parent.put(root, prev);
//            dfs(root.left, root);
//            dfs(root.right, root);
//        }
//    }


//    Map<TreeNode, TreeNode> parent;
//    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
//        parent = new HashMap<>();
//        dfs(root, null);
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(target);
//        Set<TreeNode> seen = new HashSet<>();;
//        seen.add(target);
//        int dist = 0;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            if (dist == K) {
//                List<Integer> ans = new ArrayList<>();
//                for (TreeNode node : queue) {
//                    ans.add(node.val);
//                }
//                return ans;
//            }
//            for (int i = 0; i < size; i++) {
//                TreeNode node = queue.poll();
//                seen.add(node);
//                if (node.left != null && !seen.contains(node.left)) {
//                    seen.add(node.left);
//                    queue.offer(node.left);
//                }
//                if (node.right != null && !seen.contains(node.right)) {
//                    seen.add(node.right);
//                    queue.offer(node.right);
//                }
//                TreeNode par = parent.get(node);
//                if (par != null && !seen.contains(par)) {
//                    seen.add(par);
//                    queue.offer(par);
//                }
//            }
//            dist++;
//        }
//        return new ArrayList<>();
//    }

//    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
//        List<Integer> res = new LinkedList<>();
//        dfs(res, root, target.val, K, 0);
//        return res;
//    }
//
//    private int dfs(List<Integer> res, TreeNode node, int target, int K, int depth) {
//        if (node == null) {
//            return 0;
//        }
//        if (depth == K) {
//            res.add(node.val);
//            return 0;
//        }
//        int left, right;
//        if (node.val == target || depth > 0) {
//            left = dfs(res, node.left, target, K, depth + 1);
//            right = dfs(res, node.right, target, K, depth + 1);
//        } else {
//            left = dfs(res, node.left, target, K, depth);
//            right = dfs(res, node.left, target, K, depth);
//        }
//
//        if (node.val == target) {
//            return 1;
//        }
//        if (left == K || right == K) {
//            res.add(node.val);
//            return 0;
//        }
//        if (left > 0) {
//            dfs(res, node.right, target, K, left + 1);
//            return left + 1;
//        }
//        if (right > 0) {
//            dfs(res, node.left, target, K, right + 1);
//            return right + 1;
//        }
//        return 0;
//
//    }


//    Map<TreeNode, Integer> map = new HashMap<>();
//    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
//        List<Integer> res = new LinkedList<>();
//        find(root, target);
//        dfs(root, K, map.get(root), res);
//        return res;
//    }
//
//    private int find(TreeNode root, TreeNode target) {
//        if (root == null) {
//            return -1;
//        }
//        if (root == target) {
//            map.put(root, 0);
//            return 0;
//        }
//        int left = find(root.left, target);
//        if (left >= 0) {
//            map.put(root, left + 1);
//            return left + 1;
//        }
//        int right = find(root.right, target);
//        if (right >= 0) {
//            map.put(root, right + 1);
//            return right + 1;
//        }
//        return -1;
//    }
//
//
//    private void dfs(TreeNode root, int K, int length, List<Integer> res) {
//        if (root == null) {
//            return;
//        }
//        if (map.containsKey(root)) {
//            length = map.get(root);
//        }
//        if (length == K) {
//            res.add(root.val);
//        }
//        dfs(root.left, K, length + 1, res);
//        dfs(root.right, K, length + 1, res);
//    }

    List<Integer> ans;
    TreeNode target;
    int K;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        ans = new LinkedList<>();
        this.target = target;
        this.K = K;
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return -1;
        }
        if (node == target) {
            subtreeAdd(node, 0);
            return 1;
        }
        int L = dfs(node.left), R = dfs(node.right);
        if (L != -1) {
            if (L == K) {
                ans.add(node.val);
            }
            subtreeAdd(node.right, L + 1);
            return L + 1;
        }
        if (R != -1) {
            if (R == K) {
                ans.add(node.val);
            }
            subtreeAdd(node.left, R + 1);
            return R + 1;
        }
        return -1;
    }


    private void subtreeAdd(TreeNode node, int dist) {
        if (node == null) {
            return;
        }
        if (dist == K) {
            ans.add(node.val);
        } else {
            subtreeAdd(node.left, dist + 1);
            subtreeAdd(node.right, dist + 1);
        }
    }

//    private void dfs(TreeNode node, TreeNode par) {
//        if (node != null) {
//            parent.put(node, par);
//            dfs(node.left, node);
//            dfs(node.right, node);
//        }
//    }

}
