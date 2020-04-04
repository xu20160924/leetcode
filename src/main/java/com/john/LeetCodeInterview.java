package com.john;

import com.entity.ListNode;
import com.entity.TreeNode;
import com.sun.org.apache.xerces.internal.util.XMLInputSourceAdaptor;

import java.util.*;
import java.util.LinkedList;

/**
 * @author: John
 * @date: 2020-02-14 15:37
 * @description:
 **/
public class LeetCodeInterview {

    public String replaceSpaces(String S, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }

//    public boolean oneEditAway(String first, String second) {
//
//    }

    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len/2; j++) {
                if (matrix[i][len-j-1] == matrix[i][j]) {
                    continue;
                }
                matrix[i][len-j-1] = matrix[i][j] ^ matrix[i][len-j-1];
                matrix[i][j] = matrix[i][len-j-1] ^ matrix[i][j];
                matrix[i][len-j-1] = matrix[i][j] ^ matrix[i][len-j-1];

//                matrix[i][j] = matrix[i][j] ^ matrix[len - j - 1][len - i - 1];
//                matrix[len - j - 1][len - i - 1] = matrix[len - j - 1][len - i - 1] ^ matrix[i][j];
//                matrix[i][j] = matrix[i][j] ^ matrix[len - j - 1][len - i - 1];
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                if (matrix[i][j] == matrix[len-1-j][len-1-i]) {
                    continue;
                }
                matrix[i][j] = matrix[i][j] ^ matrix[len-1-j][len-1-i];
                matrix[len-1-j][len-1-i] = matrix[len-1-j][len-1-i] ^ matrix[i][j];
                matrix[i][j] = matrix[i][j] ^ matrix[len-1-j][len-1-i];
            }
        }



        System.out.println("over");
    }

//    public int kthToLast(ListNode head, int k) {
//       if (head == null) {
//          return;
//       }
//
//    }


    public static class StackOfPlates {
        private int cap;
        private List<Deque<Integer>> stackList;
        public StackOfPlates(int cap) {
            this.cap = cap;
            stackList = new ArrayList<>();
        }
        public void push(int val) {
            if (stackList.size() == 0 || stackList.get(stackList.size() - 1).size() == cap) {
                addNewStack(val);
            } else {
                Deque<Integer> lastStack = stackList.get(stackList.size() - 1);
                lastStack.push(val);
            }
        }

        public int pop() {
            if (stackList.size() == 0) {
                return -1;
            } else {
                int res = stackList.get(stackList.size() - 1).pop();
                if (stackList.get(stackList.size() - 1).size() == 0) {
                    stackList.remove(stackList.size() - 1);
                }
                return res;
            }
        }

        public int popAt(int index) {
            if (index >= stackList.size()) {
                return -1;
            }
            int res = stackList.get(index).pop();
            if (stackList.get(index).size() == 0) {
                stackList.remove(index);
            }
            return res;
        }

        private void addNewStack(int val) {
            if (cap > 0) {
                Deque<Integer> stack = new ArrayDeque<>();
                stack.push(val);
                stackList.add(stack);
            }
        }
    }
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return new ListNode[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        List<ListNode> list = new ArrayList<>();
        int size = 1;
        ListNode start = new ListNode(0), find = start;
        while (queue.size() > 0) {
            if (size > 0) {
                size--;
                TreeNode head = queue.poll();
                find.next = new ListNode(head.val);
                find = find.next;
                if (head.left != null) {
                    queue.add(head.left);
                }
                if (head.right != null) {
                    queue.add(head.right);
                }
            } else {
                list.add(start.next);
                size = queue.size();
                start = new ListNode(0);
                find = start;
            }
        }
        list.add(start.next);
        ListNode[] res = new ListNode[list.size()];
        int j = 0;
        for (ListNode i : list) {
            res[j++] = i;
        }
        return res;
    }

//    public ListNode[]

    private void merge(List<Integer> left,
                                List<Integer> right,
                                LinkedList<Integer> tmp,
                                List<List<Integer>> result,
                                Integer prefix) {
        if (left.size() == 0 && right.size() == 0) {
            LinkedList<Integer> copy = new LinkedList<>(tmp);
            copy.add(0, prefix);
            result.add(copy);
        }
        if (left.size() > 0) {
            tmp.add(left.get(0));
            merge(left.subList(1, left.size()), right, tmp, result, prefix);
            tmp.pollLast();
        }
        if (right.size() > 0) {
            tmp.add(right.get(0));
            merge(left, right.subList(1, right.size()), tmp, result, prefix);
            tmp.pollLast();
        }
    }


    private List<List<Integer>> dfs(TreeNode root) {
        if (root.left != null && root.right != null) {
            List<List<Integer>> left = dfs(root.left);
            List<List<Integer>> right = dfs(root.right);
            List<List<Integer>> cur_seq = new ArrayList<>();
            for (List<Integer> l : left) {
                for (List<Integer> r : right) {
//                    List<Integer> merge_result = new ArrayList<>();
                    List<List<Integer>> merge_result = new ArrayList<>();
                    merge(l, r, new LinkedList<>(), merge_result, root.val);
                    cur_seq.addAll(merge_result);
                }
            }
            return cur_seq;
        } else if (root.left != null) {
            List<List<Integer>> left = dfs(root.left);
            for (List<Integer> list : left) {
                list.add(0, root.val);
            }
            return left;
        } else if (root.right != null) {
            List<List<Integer>> right = dfs(root.right);
            for (List<Integer> list : right) {
                list.add(0, root.val);
            }
            return right;
        }
        List<List<Integer>> rootList = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        rootList.add(temp);
        return rootList;
    }

    public List<List<Integer>> BSTSequences(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> r = new ArrayList<>();
        result.add(r);
        if (root == null) {
            return result;
        }
        return dfs(root);
    }

//    public List<List<Integer>> pathSum(TreeNode root, int sum) {
//        List<List<Integer>> ret = new ArrayList<>();
//        List<Integer> cur = new ArrayList<>();
//        pathSum(root, sum, sum, cur, ret);
//        return ret;
//    }
//
//    public void pathSum(TreeNode root, int orSum, int sum, List<Integer> cur, List<List<Integer>> ret) {
//        if (root == null) {
//            return;
//        }
//
//        cur.add(root.val);
//        if (root.val == orSum) {
//            List<Integer> list = new ArrayList<>();
//            list.add(root.val);
//            ret.add(list);
//            return;
//        }
//        if (cur.size() > 2 && root.val-cur.get(0) == Math.abs(sum)) {
//            List<Integer> list = new ArrayList<>(cur);
//            list.remove(0);
//            ret.add(list);
//        }
//        if (root.val == sum) {
//            ret.add(new ArrayList<>(cur));
//        } else {
//            pathSum(root.left, sum, sum - root.val, cur, ret);
//            pathSum(root.right, sum, sum - root.val, cur, ret);
//        }
//        cur.remove(cur.size() - 1);
//    }

    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);
        return recursionPathSum(root, prefixSumCount, sum, 0);
    }

    private int recursionPathSum(TreeNode node, Map<Integer, Integer> prefixSumCount, int target, int currSum) {
        if (node == null) {
            return 0;
        }
        int res = 0;
        currSum += node.val;
        res += prefixSumCount.getOrDefault(currSum - target, 0);
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);
        res += recursionPathSum(node.left, prefixSumCount, target, currSum);
        res += recursionPathSum(node.right, prefixSumCount, target, currSum);
        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);
        return res;
    }

    public String printBin(double num) {
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        double cur = 0;
        double tried = 0.5;
        while (tried >= 0.5 / (Math.pow(2, 31))) {
            if (num - cur == tried) {
                sb.append('1');
                return sb.toString();
            } else if (num - cur < tried) {
                sb.append('0');
                tried *= 0.5;
            } else {
                sb.append('1');
                cur += tried;
                tried *= 0.5;
            }
        }
        return "ERROR";
    }

//    public int reverseBits(int num) {
//        int n = 1;
//        int dpNotchange = 0;
//        int dpChange = 0;
//        int res = 0;
//        while (n > 0) {
//            if (n & num > 0) {
//
//            }
//        }
//    }

    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        LeetCodeInterview leetCodeInterview = new LeetCodeInterview();
//        leetCodeInterview.rotate(matrix);

//        StackOfPlates stackOfPlates = new StackOfPlates(0);
//        stackOfPlates.push(1);
//        stackOfPlates.push(2);
//        stackOfPlates.push(3);
//        stackOfPlates.push(4);
//        stackOfPlates.push(5);
//        stackOfPlates.push(6);
//        stackOfPlates.push(7);


//        stackOfPlates.pop();
//        stackOfPlates.pop();
//        stackOfPlates.pop();
//        stackOfPlates.pop();

//        stackOfPlates.popAt(2);

//        TreeNode five = new TreeNode(5);
//        TreeNode two = new TreeNode(2);
//        TreeNode one = new TreeNode(1);
//        TreeNode four = new TreeNode(4);
//        TreeNode three = new TreeNode(3);
//        four.left = three;
//        two.left = one;
//        two.right = four;
//        five.left = two;

//        TreeNode two = new TreeNode(2);
//        TreeNode three = new TreeNode(3);
//        two.left = one;
//        two.right = three;

//        TreeNode five = new TreeNode￿(5);
//        TreeNode two = new TreeNode(2);
//        TreeNode one = new TreeNode(1);
//        TreeNode four = new TreeNode(4);
//        TreeNode three = new TreeNode(3);
//        four.left = three;
//        two.left = one;
//        two.right = four;
//        five.left = two;

//        TreeNode three = new TreeNode(3);
//        TreeNode four = new TreeNode(4);
//        TreeNode five = new TreeNode(5);
//        TreeNode seven = new TreeNode(7);
//        TreeNode eight = new TreeNode(8);
//
//        four.left = eight;
//        three.right = seven;
//        two.left = four;
//        two.right = five;
//        one.left = two;
//        one.right = three;

//        TreeNode five = new TreeNode(5);
//
//        TreeNode four = new TreeNode(4);
//        TreeNode eight = new TreeNode(8);
//        TreeNode eleven = new TreeNode(11);
//        TreeNode thirteen = new TreeNode(13);
//        TreeNode fourfour = new TreeNode(4);
//        TreeNode fivefive = new TreeNode(5);
//        TreeNode one = new TreeNode(1);
//        TreeNode seven = new TreeNode(7);
//        TreeNode two = new TreeNode(2);
//        fourfour.left = fivefive;
//        fourfour.right = one;
//        eleven.left = seven;
//        eleven.right = two;
//        eight.left = thirteen;
//        eight.right = fourfour;
//        four.left = eleven;
//        five.left = four;
//        five.right = eight;
//
//        LeetCodeInterview leetCodeInterview = new LeetCodeInterview();
//        int res = leetCodeInterview.pathSum(five, 22);
//        System.out.println("over");

        int n = 1 << 3;
        System.out.printf("f:" + n);
    }
}
