//package com.john;
//
//import com.entity.ListNode;
//
//import java.util.*;
//import java.util.LinkedList;
//import java.util.Stack;
//
///**
// * @author: John
// * @date: 2019-12-17 17:48
// * @description:
// **/
//public class Test {
//
//    private ListNode p;
//
//    public static int[] getMaxWindw(int[] arr, int w) {
//        if (arr == null || w < 1 | arr.length < w) {
//            return null;
//        }
//        LinkedList<Integer> list = new LinkedList();
//        int[] res = new int[arr.length - w + 1];
//        int index = 0;
//        for (int i = 0; i < arr.length; i++) {
//            while (!list.isEmpty() && arr[list.peekLast()] <= arr[i]) {
//                list.pollLast();
//            }
//            list.addLast(i);
//            if (list.peekFirst() == i - w) {
//                System.out.println(list.getFirst());
//                list.pollFirst();
//            }
//            if (i >= w - 1) {
//                res[index++] = arr[list.peekFirst()];
//            }
//        }
//        return res;
//    }
//
//    public static int[][] getNearLessNoRepeat(int[] arr) {
//        int[][] res = new int[arr.length][2];
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < arr.length; i++) {
//            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
//                int popIndx = stack.pop();
//                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
//                res[popIndx][0] = leftLessIndex;
//                res[popIndx][1] = i;
//            }
//            stack.push(i);
//        }
//        while (!stack.isEmpty()) {
//            int popIndex = stack.pop();
//            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
//            res[popIndex][0] = leftLessIndex;
//            res[popIndex][1] = -1;
//        }
//        return res;
//    }
//
//    public static LinkedList reverseList(List list) {
//        LinkedList result = new LinkedList();
//        while (list.size() > 0) {
//            result.add(list.get(list.size() - 1));
//            list.remove(list.size() - 1);
//            reverseList(list);
//        }
//        return result;
//    }
//
//    public static ListNode reverseList(ListNode head) {
//        ListNode prev = null;
//        ListNode curr = head;
//        while (curr != null) {
//            ListNode nextTemp = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = nextTemp;
//        }
//        return prev;
//    }
//
//    /**
//     * reverse list by iteration
//     *
//     * @param head
//     * @return
//     */
//    public static ListNode reverseListIterate(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ;
//        ListNode p = reverseListIterate(head.next);
//        head.next.next = head;
//        head.next = null;
//        return p;
//    }
//
//    public static int[][] getNearLess(int[] arr) {
//        int[][] res = new int[arr.length][2];
//        Stack<List<Integer>> stack = new Stack<>();
//        for (int i = 0; i < arr.length; i++) {
//            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
//                List<Integer> popIs = stack.pop();
//                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().
//                        get(stack.peek().size() - 1);
//                for (Integer popi : popIs) {
//                    res[popi][0] = leftLessIndex;
//                    res[popi][1] = i;
//                }
//            }
//            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
//                stack.peek().add(Integer.valueOf(i));
//            } else {
//                ArrayList<Integer> list = new ArrayList<>();
//                list.add(i);
//                stack.push(list);
//            }
//        }
//        while (!stack.isEmpty()) {
//            List<Integer> popIs = stack.pop();
//            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
//            for (Integer popi : popIs) {
//                res[popi][0] = leftLessIndex;
//                res[popi][1] = -1;
//            }
//        }
//        return res;
//    }
//
//    public static int[] set_intersection(HashSet<Integer> set1, HashSet<Integer> set2) {
//        int[] output = new int[set1.size()];
//        int idx = 0;
//        for (Integer s : set1) {
//            if (set2.contains(s)) {
//                output[idx++] = s;
//            }
//        }
//        return Arrays.copyOf(output, idx);
//    }
//
//    public static int[] intersection(int[] array1, int[] array2) {
//        HashSet<Integer> set1 = new HashSet<>();
//        for (Integer n : array1) {
//            set1.add(n);
//        }
//
//        HashSet<Integer> set2 = new HashSet<>();
//        for (Integer n : array2) {
//            set2.add(n);
//        }
//
//        if (set1.size() < set2.size()) {
//            return set_intersection(set1, set2);
//        } else {
//            return set_intersection(set2, set1);
//        }
//    }
//
//    public static int longestPalindromeSubseq(String s) {
//        int n = s.length();
//        int[][] f = new int[n][n];
//        for (int i = n - 1; i >= 0; i--) {
//            f[i][i] = 1;
//            for (int j = i + 1; j < n; j++) {
//                if (s.charAt(i) == s.charAt(j)) {
//                    f[i][j] = f[i + 1][j - 1] + 2;
//                } else {
//                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
//                }
//            }
//        }
//        return f[0][n - 1];
//    }
////    public int[][] getNearLess(int[] arr) {
////        int[][] res = new int[arr.length][2];
////
////    }
//
//    /**
//     * 3 find longest sub string no repeat by set
//     *
//     * @param s
//     * @return
//     */
//    public static int lengthOfLongestSubString(String s) {
//        int n = s.length();
//        Set<Character> set = new HashSet<>();
//        int ans = 0, i = 0, j = 0;
//        while (i < n && j < n) {
//            // try to extend the range [i, j]
//            if (!set.contains(s.charAt(j))) {
//                set.add(s.charAt(j++));
//                ans = Math.max(ans, j - i);
//            } else {
//                set.remove(s.charAt(i++));
//            }
//        }
//        return ans;
//    }
//
//    /**
//     * 3 find longest sub string no repeat by map
//     *
//     * @param s
//     * @return
//     */
//    public static int lengthOfLongestSubStringByMap(String s) {
//        int n = s.length(), ans = 0;
//        Map<Character, Integer> map = new HashMap<>(); // current index of character
//        // try to extend the range [i, j]
//        for (int j = 0, i = 0; j < n; j++) {
//            if (map.containsKey(s.charAt(j))) {
//                i = Math.max(map.get(s.charAt(j)), i);
//            }
//            ans = Math.max(ans, j - i + 1);
//            map.put(s.charAt(j), j + 1);
//        }
//        return ans;
////        while (i < n && j < n) {
////            if (!map.containsKey(s.charAt(j++))) {
////                map.put(s.charAt(j), )
////            }
////        }
//    }
//
//    /**
//     * 3 assume s is small relatively we can use int replace the map
//     *
//     * @param s
//     * @return
//     */
//    public int lengthOfLongestSubstring(String s) {
//        int n = s.length(), ans = 0;
//        int[] index = new int[128]; // current index of character
//        // try to extend the range [i, j]
//        for (int j = 0, i = 0; j < n; j++) {
//            i = Math.max(index[s.charAt(j)], i);
//            ans = Math.max(ans, j - i + 1);
//            index[s.charAt(j)] = j + 1;
//        }
//        return ans;
//    }
//
//    /**
//     * 1 two sum
//     *
//     * @param nums
//     * @param target
//     * @return
//     */
//    public static int[] towSum(int[] nums, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            int complement = target - nums[i];
//            if (map.containsKey(complement) && map.get(complement) != i) {
//                return new int[]{i, map.get(complement)};
//            }
//        }
//        throw new IllegalArgumentException("No two sum solution");
//    }
//
//    /**
//     * 1 two sum
//     * violence foreach
//     *
//     * @param nums
//     * @param target
//     * @return
//     */
//    public static int[] twoSumViolence(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] == target - nums[i]) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        throw new IllegalArgumentException("No two sum solution");
//    }
//
//    /**
//     * 1 two sum
//     * one iteration hash
//     *
//     * @param nums
//     * @param target
//     * @return
//     */
//    public static int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int complement = target - nums[i];
//            if (map.containsKey(complement)) {
//                return new int[]{map.get(complement), i};
//            }
//            map.put(nums[i], i);
//        }
//        throw new IllegalArgumentException("No two sum solution");
//    }
//
//    public static int myAoti(String s) {
//        if (s.isEmpty()) {
//            return 0;
//        }
//        char[] strArray = s.toCharArray();
//        long ans = 0;
//        int i = 0, sign = 1, n = s.length();
//        while (i < n && strArray[i] == ' ') {
//            i++;
//        }
//        if (i < n && strArray[i] == '+') {
//            i++;
//        } else if (i < 0 && strArray[i] == '-') {
//            i++;
//            sign = -1;
//        }
//        while (i < n && (strArray[i] >= '0' && strArray[i] <= '9')) {
//            if (ans != (int) ans) { // there judge convert ans to int if it isn't equal before， that mean it's not 32 bit
//                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
//            }
////            ans = strArray[i];
//            ans = ans * 10 + strArray[i++] - '0';
//        }
//        if (ans != (int) ans) {
//            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
//        }
//        return (int) (ans * sign);
//    }
//
//
//    /**
//     * find max sub matrix in a matrix
//     * this question from book
//     *
//     * @param map
//     * @return
//     */
//    public int maxRecSize(int[][] map) {
//        if (map == null || map.length == 0 || map[0].length == 0) {
//            return 0;
//        }
//        int maxArea = 0;
//        int[] height = new int[map[0].length];
//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map[0].length; j++) {
//                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
//            }
//            maxArea = Math.max(maxRecFromBottom(height), maxArea);
//        }
//        return maxArea;
//    }
//
//    /**
//     * find max sub matrix in a matrix
//     * this question from book
//     *
//     * @param height
//     * @return
//     */
//    public static int maxRecFromBottom(int[] height) {
//        if (height == null || height.length == 0) {
//            return 0;
//        }
//        int maxArea = 0;
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < height.length; i++) {
//            while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
//                int j = stack.pop();
//                int k = stack.isEmpty() ? -1 : stack.peek();
//                int curArea = (i - k - 1) * height[j];
//                maxArea = Math.max(maxArea, curArea);
//            }
//            stack.push(i);
//        }
//        while (!stack.isEmpty()) {
//            int j = stack.pop();
//            int k = stack.isEmpty() ? -1 : stack.peek();
//            int curArea = (height.length - k - 1) * height[j];
//            maxArea = Math.max(maxArea, curArea);
//        }
//        return maxArea;
//    }
//
//    /**
//     * monotone stack
//     * O(N^2)
//     * violence solution  not best
//     *
//     * @param arr
//     * @return
//     */
//    public int[][] rightWay(int[] arr) {
//        int[][] res = new int[arr.length][2];
//        for (int i = 0; i < arr.length; i++) {
//            int leftLessIndex = -1;
//            int rightLessIndex = -1;
//            int cur = i - 1;
//            while (cur >= 0) {
//                if (arr[cur] < arr[i]) {
//                    leftLessIndex = cur;
//                    break;
//                }
//                cur--;
//            }
//            cur = i + 1;
//            while (cur < arr.length) {
//                if (arr[cur] < arr[i]) {
//                    rightLessIndex = cur;
//                    break;
//                }
//                cur++;
//            }
//            res[i][0] = leftLessIndex;
//            res[i][1] = rightLessIndex;
//        }
//        return res;
//    }
//
//    public static int getNum(int[] arr, int num) {
//        if (arr == null || arr.length == 0 || num < 0) {
//            return 0;
//        }
//        LinkedList<Integer> qmin = new LinkedList<>();
//        LinkedList<Integer> qmax = new LinkedList<>();
//        int i = 0;
//        int j = 0;
//        int res = 0;
//        while (i < arr.length) {
//            while (j < arr.length) {
//                if (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
//                    qmin.pollLast();
//                }
//                qmin.addLast(j);
//                if (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
//                    qmax.pollLast();
//                }
//                qmax.addLast(j);
//                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
//                    break;
//                }
//                j++;
//            }
//            res += j - i;
//            if (qmin.peekLast() == i) {
//                qmin.pollFirst();
//            }
//            if (qmax.peekFirst() == i) {
//                qmax.pollFirst();
//            }
//            i++;
//        }
//        return res;
//    }
//
//    /**
//     * get visible mountains
//     * from book
//     *
//     * @param arr
//     * @return
//     */
//    public static int getVisibleNum(int[] arr) {
//        if (arr == null || arr.length < 2) {
//            return 0;
//        }
//        int size = arr.length;
//        int maxIndex = 0;
//        for (int i = 0; i < size; i++) {
//            maxIndex = arr[maxIndex] < arr[i] ? i : maxIndex;
//        }
//        Stack<Record> stack = new Stack<>();
//        stack.push(new Record(arr[maxIndex]));
//        int index = nextIndex(maxIndex, size);
//        int res = 0;
//        while (index != maxIndex) {
//            while (stack.peek().value < arr[index]) {
//                int k = stack.pop().times;
//                res += getInternalSum(k) + 2 * k;
//            }
//            if (stack.peek().value == arr[index]) {
//                stack.peek().times++;
//            } else {
//                stack.push(new Record(arr[index]));
//            }
//            index = nextIndex(index, size);
//        }
//        while (stack.size() > 2) {
//            int times = stack.pop().times;
//            res += getInternalSum(times) + 2 * times;
//        }
//        if (stack.size() == 2) {
//            int times = stack.pop().times;
//            res += getInternalSum(times) + (stack.peek().times == 1 ? times : 2 * times);
//        }
//        res += getInternalSum(stack.pop().times);
//        return res;
//    }
//
//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode dummyHead = new ListNode(0);
//        ListNode p = l1, q = l2, curr = dummyHead;
//        int carry = 0;
//        while (p != null || q != null) {
//            int x = (p != null) ? p.val : 0;
//            int y = (q != null) ? q.val : 0;
//            int sum = carry + x + y;
//            carry = sum / 10;
//            curr.next = new ListNode(sum % 10);
//            curr = curr.next;
//            if (p != null) {
//                p = p.next;
//            }
//            if (q != null) {
//                q = q.next;
//            }
//        }
//        if (carry > 0) {
//            curr.next = new ListNode(carry);
//        }
//        return dummyHead.next;
//    }
//
//
//    public static int getInternalSum(int k) {
//        return k == 1 ? 0 : (k * (k - 1) / 2);
//    }
//
//    public static int nextIndex(int i, int size) {
//        return i < (size - 1) ? (i + 1) : 0;
//    }
//
//    public int strStr(String haystack, String needle) {
//        for (int i = 0; ; i++) {
//            for (int j = 0; ; j++) {
//                if (j == needle.length()) {
//                    return i;
//                }
//                if (i + j == haystack.length()) {
//                    return -1;
//                }
//                if (needle.charAt(j) != haystack.charAt(i + j)) {
//                    break;
//                }
//            }
//        }
//    }
//
//
//    /**
//     * 70 LeetCode
//     * Brute Force
//     * @param i
//     * @param n
//     * @return
//     */
////    public static int climbStaires(int i, int n) {
////        if (i > 0) {
////            return 0;
////        }
////        if (i == n) {
////            return 1;
////        }
////        return climbStaires(i + 1, n) + climbStaires(i + 2, n);
////    }
//
//    /**
//     * 70 LeetCode
//     * Recursion with memorization
//     * @param i
//     * @param n
//     * @param memo
//     * @return
//     */
////    public static int climbStairs(int i, int n, int memo[]) {
////        if (i > n) {
////            return 0;
////        }
////        if (i == n) {
////            return 1;
////        }
////        if (memo[i] > 0) {
////            return memo[i];
////        }
////        memo[i] = climbStairs(i + 1, n, memo) + climbStairs(i + 2, n, memo);
////        return memo[i];
////    }
////    public static int climbStairss(int n) {
////        int memo[] = new int[n+1];
////        return climbStairs(0, n, memo);
////    }
//
//    /**
//     * LeetCode 70
//     * dp[i] = dp[i - 1] + dp[i - 2]
//     * @param n
//     * @return
//     */
////    public static int climbStairs(int n) {
////        if (n == 1) {
////            return 1;
////        }
////        int[] dp = new int[n + 1];
////        dp[1] = 1;
////        dp[2] = 2;
////        for (int i = 3; i <= n; i++) {
////           dp[i] = dp[i -1] + dp[i -2];
////        }
////        return dp[n];
////    }
//
//    /**
//     * 70 LeetCode
//     * Fib(n) = Fib(n - 1) + Fib(n - 2)
//     *
//     * @param n
//     * @return
//     */
//    public static int climbStairs(int n) {
//        if (n == 1) {
//            return 1;
//        }
//        int first = 1;
//        int second = 2;
//        for (int i = 0; i <= n; i++) {
//            int third = first + second;
//            first = second;
//            second = third;
//        }
//        return second;
//    }
//
//
//    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        int p = m-- + n-- - 1;
//        while (m >= 0 && n >= 0) {
//            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
//        }
//
//        while (n >= 0) {
//            nums1[p--] = nums2[n--];
//        }
//    }
//
//
////    public static List<Integer> inorderTraversal(TreeNode root) {
////        List<Integer> list = new ArrayList<>();
////        Stack<TreeNode> stack = new Stack<>();
////        TreeNode cur = root;
////        while (cur != null || !stack.isEmpty()) {
////            if (cur != null) {
////                stack.push(cur);
////                cur = cur.left;
////            } else {
////                cur = stack.pop();
////                list.add(cur.val);
////                cur = cur.right;
////            }
////        }
////        return list;
////    }
//
//
//    /**
//     * 94. from LeetCode
//     * recursion inorder traversal
//     *
//     * @param root
//     * @return
//     */
////    public static List<Integer> inorderTraversal(TreeNode root) {
////        List<Integer> res = new ArrayList<>();
////        helper(root, res);
////        return res;
////    }
//    public static void helper(TreeNode root, List<Integer> res) {
//        if (root != null) {
//            if (root.left != null) {
//                helper(root.left, res);
//            }
//            res.add(root.val);
//            if (root.right != null) {
//                helper(root.right, res);
//            }
//        }
//    }
//
//    /**
//     * 347 Top K frequent elements
//     * from leetcod
//     *
//     * @param nums
//     * @param k
//     * @return
//     */
//    public static List<Integer> topKFrequent(int[] nums, int k) {
//        //build hash map: character and how often it appears
//        HashMap<Integer, Integer> count = new HashMap<>();
//        for (int n : nums) {
//            count.put(n, count.getOrDefault(n, 0) + 1);
////            count.put(n, 0);
//        }
//        // init heap 'the less frequent element first'
//        PriorityQueue<Integer> heap = new PriorityQueue<>(((n1, n2) -> count.get(n1) - count.get(n2)));
//
//        // keep k top frequent elements in the heap
//        for (int n : count.keySet()) {
//            System.out.println(n);
//            heap.add(n);
//            if (heap.size() > k) {
//                heap.poll();
//            }
//        }
//
//        // build output list
//        List<Integer> top_k = new LinkedList<>();
//        while (!heap.isEmpty()) {
//            top_k.add(heap.poll());
//        }
//        Collections.reverse(top_k);
//        return top_k;
//    }
//
//    /**
//     * 236 from LeetCode
//     * solution from geek
//     *
//     * @param root
//     * @param p
//     * @param q
//     * @return
//     */
//    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null || root == p || root == q) {
//            return root;
//        }
//        TreeNode left = lowestCommonAncestor(root.left, p, q);
//        TreeNode right = lowestCommonAncestor(root.right, p, q);
//        return left == null ? right : right == null ? left : root;
//
//    }
//
//    /**
//     * 169 from LeetCode
//     *
//     * @param nums
//     * @return
//     */
//    public static Map<Integer, Integer> countNums(int[] nums) {
//        Map<Integer, Integer> counts = new HashMap<>();
//        for (int num : nums) {
//            if (!counts.containsKey(num)) {
//                counts.put(num, 1);
//            } else {
//                counts.put(num, counts.get(num) + 1);
//            }
//        }
//        return counts;
//    }
//
//    /**
//     * 169 from LeetCode
//     *
//     * @param nums
//     * @return
//     */
//    public static int majorityElement(int[] nums) {
//        Map<Integer, Integer> coutns = countNums(nums);
//        Map.Entry<Integer, Integer> majorityEntry = null;
//        for (Map.Entry<Integer, Integer> entry : coutns.entrySet()) {
//            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
//                majorityEntry = entry;
//            }
//        }
//        return majorityEntry.getKey();
//    }
//
//    /**
//     * 122. Best Time to Buy and Sell Stock II
//     * @param prices
//     * @return
//     */
////    public static int maxProfit(int[] prices) {
////        int i = 0;
////        int valley = prices[0];
////        int peak = prices[0];
////        int maxprofit = 0;
////        while (i < prices.length - 1) {
////            while (i < prices.length -1 && prices[i] >= prices[i + 1]) {
////                i++;
////            }
////            valley = prices[i];
////            while (i < prices.length -1 && prices[i] <= prices[i + 1]) {
////                i++;
////            }
////            peak = prices[i];
////            maxprofit += peak - valley;
////        }
////        return maxprofit;
////    }
//
//    /**
//     * 122. Best Time to Buy and Sell Stock II
//     *
//     * @param prices
//     * @return
//     */
//    public static int maxProfit(int[] prices) {
//        int maxprofie = 0;
//        for (int i = 1; i < prices.length; i++) {
//            if (prices[i] > prices[i - 1]) {
//                maxprofie += prices[i] - prices[i - 1];
//            }
//        }
//        return maxprofie;
//    }
//
////    public static List<List<Integer>> levelOrder(TreeNode root) {
////        Queue<TreeNode> queue = new LinkedList<>();
////        List<List<Integer>> wrapList = new LinkedList<>();
////        if (root == null) {
////            return wrapList;
////        }
////
////        queue.offer(root);
////        while (!queue.isEmpty()) {
////            int levelNum = queue.size();
////            List<Integer> subList = new LinkedList<>();
////            for (int i = 0; i < levelNum; i++) {
////                if (queue.peek().left != null) {
////                    queue.offer(queue.peek().left);
////                }
////                if (queue.peek().right != null) {
////                    queue.offer(queue.peek().right);
////                }
////                subList.add(queue.poll().val);
////                wrapList.add(subList);
////            }
////            return wrapList;
////        }
////    }
//
//    /**
//     *  36 from LeetCode
//     * @param board
//     * @return
//     */
////    public static boolean isValidSudoku(char[][] board) {
////        Set seen = new HashSet();
////        for (int i = 0; i < 9; i++) {
////            for (int j = 0; j < 9; j++) {
////                char number = board[i][j];
////                if (number != '.') {
////                    if (!seen.add(number + " in row " + i) ||
////                            !seen.add(number + " in column " + j) ||
////                            !seen.add(number + " in block " + i / 3 + "-" + j / 3)) {
////                        return false;
////                    }
////                }
////            }
////        }
////        return true;
////    }
//
//    /**
//     * 36 from LeetCode
//     *
//     * @param board
//     * @return
//     */
//    public static boolean isValidSudoku(char[][] board) {
//        for (int i = 0; i < 9; i++) {
//            int hori = 0, veti = 0, sqre = 0;
//            for (int j = 0; i < 9; i++) {
//                int h = board[j][j] - 48;
//                int v = board[j][i] = 48;
//                int s = board[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3] - 48;
//                if (h > 0) {
//                    hori = sodokuer(h, hori);
//                }
//                if (v > 0) {
//                    veti = sodokuer(v, veti);
//                }
//                if (s > 0) {
//                    sqre = sodokuer(s, sqre);
//                }
//                if (hori == -1 || veti == -1 || sqre == -1) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    public static void solveSudoku(char[][] board) {
//        // record row, some number is filled?
//        boolean[][] row = new boolean[9][9];
//        // record column, some number is filled？
//        boolean[][] col = new boolean[9][9];
//        // record block some number is filled?
//        boolean[][] block = new boolean[9][9];
//
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                if (board[i][j] != '.') {
//                    int num = board[i][j] - '1';
//                    row[j][num] = true;
//                    col[j][num] = true;
//                    block[i / 3 * 3 + j / 3][num] = true;
//                }
//            }
//        }
//        dfs(board, row, col, block, 0, 0);
//    }
//    public static boolean dfs(char[][] board, boolean[][] row, boolean[][] col, boolean[][] block, int i, int j) {
//        // find empty position
//        while (board[i][j] != '.') {
//            if (++j >= 9) {
//                i++;
//                j = 0;
//            }
//            if (i >= 9) {
//                return true;
//            }
//        }
//        for(int num = 0; num < 9; num++) {
//            int blockIndex = i / 3 * 3 + j / 3;
//            if (!row[i][num] && !col[j][num] && !block[blockIndex][num]) {
//                //recursion
//                board[i][j] = (char) ('1' + num);
//                row[i][num] = true;
//                col[j][num] = true;
//                block[blockIndex][num] = true;
//                if (dfs(board, row, col, block, i, j)) {
//                    return true;
//                } else {
//                    row[i][num] = false;
//                    col[j][num] = false;
//                    block[blockIndex][num] = false;
//                    board[i][j] = '.';
//                }
//            }
//        }
//        return false;
//    }
//
//    /**
//     * 69 from LeetCode
//     * solution from geek
//     * @param x
//     * @return
//     */
//    public static int sqrt(int x) {
//        if (x == 0 || x == 1) {
//            return x;
//        }
//        int l = 1, r = x, res = 0;
//        while (l <= r) {
//            int m = (l + r) / 2;
//            if (m == x / m) {
//                return m;
//            } else if (m > x / m) {
//                r = m - 1;
//            } else {
//                l = m + 1;
//                res = m;
//            }
//        }
//        return res;
//    }
//
//    public static void printBoard(char[][] board) {
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                System.out.println(board[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    public static int sodokuer(int n, int val) {
//        return ((val >> n) & 1) == 1 ? -1 : val ^ (1 << n);
//    }
//
//
//    public static List<String> result = new ArrayList<>();
//    /**
//     * 212 LeetCode
//     * solution from geek
//     * @param board
//     * @param words
//     * @return
//     */
//    public static List<String> findWords(char[][] board, String[] words) {
//        if (board == null || words == null) {
//            return new ArrayList<>();
//        }
//        TrieNode trieNode = new TrieNode();
//        for (int i = 0; i < words.length; i++) {
//            for (int j = 0; j < words[i].length(); j++) {
//                char s = words[i].charAt(j);
//                trieNode.put(s, new TrieNode());
//            }
//        }
//        trieNode.setEnd();
//
//        int r = board.length;
//        int c = board[0].length;
//        boolean[][] visited = new boolean[r][c];
//        for (int i = 0; i < r; i++) {
//            for (int j = 0; j < c; j++) {
//
//            }
//        }
//
//        return null;
//
//    }
//
//    private static void dfsFindWrods(char[][] board,  boolean[][] visited, Trie trie, String s, int x, int y) {
//        if (x < 0 || x > board.length || y < 0 || y > board[0].length) {
//            return;
//        }
//        if (visited[x][y]) {
//            return;
//        }
//
//        s += board[x][y];
//
//        if (!trie.startsWith(s)) {
//            return;
//        }
//
//        if (trie.search(s)) {
//            result.add(s);
//        }
//
//        visited[x][y] = true;
//        dfsFindWrods(board, visited, trie, s, x - 1, y);
//        dfsFindWrods(board, visited, trie, s, x + 1, y);
//        dfsFindWrods(board, visited, trie, s, x, y - 1);
//        dfsFindWrods(board, visited, trie, s, x, y + 1);
//        visited[x][y]= false;
//
//    }
//
//
//
//
//    public static int fib(int n) {
//        return n <= 1 ? n : fib(n - 1) + fib(n - 2);
//    }
//
//
//    public static void main(String[] args) {
//        //        System.out.println((char) ('1' + 2));
////        char[][] input = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
////                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
////                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
////                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
////                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
////                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
////                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
////                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
////                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
////        System.out.println(isValidSudoku(input));
//
////        int[] nums = {7,1,5,3,6,4};
////        maxProfit(nums);
////        int nums[] = {1,1,1,2,2,3,3,4,};
////        int nums[] = {3,2,2,1,1,1};
////        int k = 2;
////        List<Integer> result = topKFrequent(nums, k);
////        System.out.println(result);
////        int[] nums1 = {1,2,3,0,0,0};
////        int[] nums2 = {2,5,6};
////        merge(nums1, 3, nums2, 3);
////        TreeNode root = new TreeNode(1);
////        TreeNode root2 = new TreeNode(2);
////        TreeNode root3 = new TreeNode(3);
////        TreeNode root4 = new TreeNode(4);
////        TreeNode root5 = new TreeNode(5);
////        TreeNode root6 = new TreeNode(6);
////        TreeNode root7 = new TreeNode(7);
////
////        root.left = root2;
////        root.right = root3;
////        root2.left = root4;
////        root2.right = root5;
////        root3.left = root6;
////        root3.right = root7;
//
////        root.right = root1;
////        root.left = root1;
////        root.right = root2;
////        root2.left = root3;
////        List<Integer> res = inorderTraversal(root);
////        System.out.println(res);
//
//        //        int[] arry = {2,4,2};
////                int[] arry = {2,3,1,6,4};
//
////        System.out.println(climbStairss(10));
//
////        ListNode l1 = new ListNode(2);
////        ListNode l11 = new ListNode(4);
////        l1.next = l11;
////        ListNode l111 = new ListNode(3);
////        l11.next = l111;
////        ListNode l2 = new ListNode(5);
////        ListNode l22 = new ListNode(6);
////        l2.next = l22;
////        ListNode l222 = new ListNode(4);
////        l22.next = l222;
////
////        ListNode res = addTwoNumbers(l1, l2);
////        System.out.println(res);
//
//
////        int[] array = {1, 5, 5, 2};
////        System.out.println(getVisibleNum(array));
//
//
////         LinkedList<Integer> qmin = new LinkedList<>();
////         qmin.pollLast()
////        int[] arr = {3, 1, 3, 4, 3, 5, 3, 2, 2};
////        int[][] result = getNearLess(arr);
////        String a = "4193 with words";
////        System.out.println(myAoti(a));
////        for (int i = 0; i < ; i++) {
////
////        }
//    }
//
//
//    /**
//     * 94 from LeetCode using stack to inorder traversal
//     *
//     * @param root
//     * @return
//     */
//    public static List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode curr = root;
//        while (curr != null || !stack.isEmpty()) {
//            while (curr != null) {
//                stack.push(curr);
//                curr = curr.left;
//            }
//            curr = stack.pop();
//            res.add(curr.val);
//            curr = curr.right;
//        }
//        return res;
//    }
//
//
////    public static void main(String[] args) {
//////        List<Integer> list = new LinkedList<>();
//////        list.add(1);
//////        list.add(2);
//////        list.add(3);
//////        list.add(4);
//////        list.add(5);
////        ListNode listNode1 = new ListNode(1);
////        ListNode listNode2 = new ListNode(2);
////        ListNode listNode3 = new ListNode(3);
////        ListNode listNode4 = new ListNode(4);
////        ListNode listNode5 = new ListNode(5);
////
////        listNode1.next = listNode2;
////        listNode2.next = listNode3;
////        listNode3.next = listNode4;
////        listNode4.next = listNode5;
////
////
////
////        ListNode result = reverseListIterate(listNode1);
//////        for (int i = 0; i < result; i++) {
//////            System.out.println(result.get(i));
//////        }
////        ListNode current = result;
////        while (current!= null) {
////            System.out.println(current.getVal());
////            current = current.next;
////        }
////
//////        int[] a = {3,4,1,5,6,2,7};
//////        int[][] b = getNearLessNoRepeat(a);
//////        System.out.println(b.toString());
//////        int[] a = {4,3,5,4,3,3,6,7};
//////        int[] b = getMaxWindw(a, 3);
//////        for (int i = 0; i < b.length; i++) {
//////            System.out.println(b[i]);
//////        }
////    }
//}
