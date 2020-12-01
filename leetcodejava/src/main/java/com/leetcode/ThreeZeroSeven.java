package com.leetcode;

/**
 * @author: John
 * @date: 2020-03-23 20:00
 * @description: 307
 **/
public class ThreeZeroSeven {
    private int[] b;
    private int len;
    private int[] nums;

//    public ThreeZeroSeven(int[] nums) {
//       this.nums = nums;
////       double l = Math.sqrt(nums.length);
//       len = (int) Math.ceil(nums.length / 1);
//       b = new int[len];
//       for (int i = 0; i < nums.length; i++) {
//           b[i / len] += nums[i];
//       }
//    }
//
//    public int sumRange(int i, int j) {
//        int sum = 0;
//        int startBlock = i / len;
//        int endBlock = j / len;
//        if (startBlock == endBlock) {
//            for (int k = i; k <= j; k++) {
//                sum += nums[k];
//            }
//        } else {
//            for (int k = i; k <= (startBlock + 1) * len - 1; k++) {
//                sum += nums[k];
//            }
//            for (int k = startBlock + 1; k <= endBlock - 1; k++) {
//                sum += b[k];
//            }
//            for (int k = endBlock * len; k <=  j; k++) {
//                sum += nums[k];
//            }
//        }
//        return sum;
//    }
//    public void update(int i, int val) {
//       int b_1 = i / len;
//       b[b_1] = b[b_1] - nums[i] + val;
//       nums[i] = val;
//    }


//    int[] tree;
//    int n;
//
//    public ThreeZeroSeven(int[] nums) {
//        if (nums.length > 0) {
//            n = nums.length;
//            tree = new int[n * 2];
//            buildTree(nums);
//        }
//    }
//
//    private void buildTree(int[] nums) {
//        for (int i = n, j = 0; i < 2 * n; i++, j++) {
//            tree[i] = nums[j];
//        }
//        for (int i = n - 1; i > 0; --i) {
//            tree[i] = tree[i * 2] + tree[i * 2 + 1];
//        }
//    }
//
//    public void update(int pos, int val) {
//        pos += n;
//        tree[pos] = val;
//        while (pos > 0) {
//            int left = pos;
//            int right = pos;
//            if (pos % 2 == 0) {
//                right = pos + 1;
//            } else {
//                left = pos - 1;
//            }
//            // parent is updated after child is updated
//            tree[pos / 2] = tree[left] + tree[right];
//            pos /= 2;
//        }
//    }
//
//    public int sumRange(int l, int r) {
//        //get leaf with value 'l'
//        l += n;
//        // get leaf with value 'r'
//        r += n;
//        int sum = 0;
//        while (l <= r) {
//            if ((l % 2) == 1) {
//                sum += tree[l];
//                l++;
//            }
//            if ((r % 2) == 0) {
//                sum += tree[r];
//                r--;
//            }
//            l /= 2;
//            r /= 2;
//        }
//        return sum;
//    }

//    class SegmentTreeNode {
//        int start, end;
//        SegmentTreeNode left, right;
//        int sum;
//
//        public SegmentTreeNode(int start, int end) {
//            this.start = start;
//            this.end = end;
//            this.left = null;
//            this.right = null;
//            this.sum = 0;
//        }
//    }
//    SegmentTreeNode root = null;
//
//    public ThreeZeroSeven(int[] nums) {
//        root = buildTree(nums, 0, nums.length - 1);
//    }
//
//    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
//        if (start > end) {
//            return null;
//        } else {
//            SegmentTreeNode ret = new SegmentTreeNode(start, end);
//            if (start == end) {
//                ret.sum = nums[start];
//            } else {
//                int mid = start + (end - start) / 2;
//                ret.left = buildTree(nums, start, mid);
//                ret.right = buildTree(nums, mid + 1, end);
//                ret.sum = ret.left.sum + ret.right.sum;
//            }
//            return ret;
//        }
//    }
//
//    void update(int i, int val) {
//
//    }
//    private void update(SegmentTreeNode root, int pos, int val) {
//        if (root.start == root.end) {
//            root.sum = val;
//        } else {
//            int mid = root.start + (root.end - root.start) / 2;
//            if (pos <= mid) {
//                update(root.left, pos, val);
//            } else {
//                update(root.right, pos, val);
//            }
//            root.sum = root.left.sum + root.right.sum;
//        }
//    }
//
//    public int sumRange(int i, int j) {
//        return sumRange(root, i, j);
//    }
//
//    private int sumRange(SegmentTreeNode root, int start, int end) {
//        if (root.end == end && root.start == start) {
//            return root.sum;
//        } else {
//            int mid = root.start + (root.end - root.start) / 2;
//            if (end <= mid) {
//                return sumRange(root.left, start, end);
//            } else if (start >= mid + 1) {
//                return sumRange(root.right, start, end);
//            } else {
//                return sumRange(root.right, mid + 1, end) + sumRange(root.left, start, mid);
//            }
//        }
//    }

    int[] BIT;
    int n;
    ThreeZeroSeven(int[] nums) {
        this.nums = nums;
        n = nums.length;
        BIT = new int[n + 1];
        for (int i = 0; i < n; i++) {
            init(i, nums[i]);
        }
    }

    public void init(int i, int val) {
        i++;
        while (i <= n) {
           BIT[i] = val;
           i += (i & -i);
        }
    }

    void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        init(i, diff);
    }

    public int getSum(int i) {
        int sum = 0;
        i++;
        while (i > 0) {
            sum += BIT[i];
            i -= (i & -i);
        }
        return sum;
    }
    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }

    public static void main(String[] args) {
        ThreeZeroSeven threeZeroSeven = new ThreeZeroSeven(new int[]{1, 3, 5});
        System.out.println(threeZeroSeven.sumRange(0, 2));
    }
}
