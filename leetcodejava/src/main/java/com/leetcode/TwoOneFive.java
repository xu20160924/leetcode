package com.leetcode;

import java.util.Random;

/**
 * @author: John
 * @date: 2020-03-03 16:52
 * @description: 215
 **/
public class TwoOneFive {
//    public int findKthLarget(int[] nums, int k) {
//        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> n1 - n2);
//        for (int n : nums) {
//            heap.add(n);
//            if (heap.size() > k) {
//               heap.poll();
//            }
//        }
//        return heap.poll();
//    }
//    int [] nums;
//
//    public void swap(int a, int b) {
//        int tmep = nums[a];
//        nums[a] = nums[b];
//        nums[b] = tmep;
//    }
//
//    public int partition(int left, int right, int pivot_index) {
//        int pivot = nums[pivot_index];
//        // move pivot to end
//        swap(pivot_index, right);
//        int store_index = left;
//
//        // move all smaller elements to the left
//        for (int i = left; i <= right; i++) {
//            if (nums[i] < pivot) {
//                swap(store_index, i);
//                store_index++;
//            }
//        }
//
//        // move pivot to its final place
//        swap(store_index, right);
//        return store_index;
//    }
//
//    public int quickselect(int left, int right, int k_smallest) {
//        // Returns the k-th smallest element of list within left.. right.
//        if (left == right) {  // If the list contains only one element.
//            return nums[left];  //return that element
//        }
//        // select a random pivot_index
//        Random random = new Random();
//        int pivot_index = left + random.nextInt(right - left);
//        pivot_index = partition(left, right, pivot_index);
//        // the pivot is on(N -k) th smallest position
//        if (k_smallest == pivot_index) {
//            return nums[k_smallest];
//            // go left side
//        } else if (k_smallest < pivot_index) {
//            return quickselect(left, pivot_index - 1, k_smallest);
//        }
//        // go right side
//        return quickselect(pivot_index + 1, right, k_smallest);
//    }
//
//    public int findKthLargest(int[] nums, int k) {
//        this.nums = nums;
//        int size = nums.length;
//        return quickselect(0, size -1, size - k);
//    }

//    public int findKthLargest(int[] nums, int k) {
//        int N = nums.length;
//        Arrays.sort(nums);
//        return nums[N - k];
//    }

//    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for (int val : nums) {
//           pq.offer(val);
//           if (pq.size() > k) {
//               pq.poll();
//           }
//        }
//        return pq.peek();
//    }

//    public int findKthLargest(int[] nums, int k) {
//        k = nums.length - k;
//        int lo = 0;
//        int hi = nums.length - 1;
//        while (lo < hi) {
//            int j = partition(nums, lo, hi);
//            if (j < k) {
//               lo = j + 1;
//            } else if (j > k) {
//                hi = j - 1;
//            } else {
//                break;
//            }
//        }
//        return nums[k];
//    }
//
//    private int partition(int[] a, int lo, int hi) {
//        int i = lo;
//        int j = hi + 1;
//        while (true) {
//            while (i < hi && less(a[++i], a[lo])) {};
//            while (i > lo && less(a[lo], a[--j])) {};
//            if (i >= j) {
//               break;
//            }
//            exch(a, i, j);
//        }
//        exch(a, lo, j);
//        return j;
//    }
//
//    private void exch(int[] a, int i, int j) {
//        int tmp = a[i];
//        a[i] = a[j];
//        a[j] = tmp;
//    }
//
//    private boolean less(int v, int w) {
//        return v < w;
//    }
//
//
//    public static void main(String[] args) {
//        int[] nums = {3, 2, 1, 5, 6, 4};
//        TwoOneFive twoOneFive = new TwoOneFive();
//        twoOneFive.findKthLargest(nums, 2);
//    }


//    public int findKthLargest(int[] nums, int k) {
//        final PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for (int val : nums) {
//            pq.offer(val);
//            if (pq.size() > k) {
//                pq.poll();
//            }
//        }
//        return pq.peek();
//    }

//    public int findKthLargest(int[] nums, int k) {
//        k = nums.length - k;
//        int lo = 0;
//        int hi = nums.length - 1;
//        while (lo < hi) {
//            final int j = partition(nums, lo, hi);
//            if (j < k) {
//               lo = j + 1;
//            } else if (j > k) {
//               hi = j - 1;
//            } else {
//                break;
//            }
//        }
//        return nums[k];
//    }
//
//    private int partition(int[] a, int lo, int hi) {
//       int i = lo;
//       int j = hi + 1;
//       while (true) {
//          while (i < hi && a[++i] < a[lo]) {
//          }
//          while (j > lo && a[lo] < a[--j]) {
//
//          }
//          if (i >= j) {
//             break;
//          }
//          exch(a, i, j);
//       }
//       exch(a, lo, j);
//       return j;
//    }
//
//    private void exch(int[] a, int i, int j) {
//        final int temp = a[i];
//        a[i] = a[j];
//        a[j] = temp;
//    }

//    int[] nums;
//
//    public void swap(int a, int b) {
//        int tmp = this.nums[a];
//        this.nums[a] = this.nums[b];
//        this.nums[b] = tmp;
//    }
//
//    public int partition(int left, int right, int pivot_index) {
//        int pivot = this.nums[pivot_index];
//        // 1. move pivot to end
//        // 这里之所以要将pivot的交换到最后是要将除pivot之外的所有元素都进行比较
//        swap(pivot_index, right);
//        int store_index = left;
//
//        // 2. move all smaller elements to the left
//        for (int i = left; i <= right; i++) {
//           if (this.nums[i] < pivot) {
//               swap(store_index, i);
//               store_index++;
//           }
//        }
//
//        // 3. move pivot to its final place
//        // 比较完成后需要将pivot交换到storeIndex 位置
//        swap(store_index, right);
//        return store_index;
//    }
//
//    public int quickselect(int left, int right, int k_smallest) {
//        /**
//         * Returns the kth smallest element of list within left..right.
//         */
//        if (left == right) { // If the list contains only one element.
//            return this.nums[left];  // return that element
//        }
//
//        // Select a random pivot_index
//        Random random_num = new Random();
//        int pivot_index = left + random_num.nextInt(right - left);
//
//        pivot_index = partition(left, right, pivot_index);
//
//        // the pivot is on (N - k)th smalleset position
//        if (k_smallest == pivot_index) {
//            return this.nums[k_smallest];
//        }
//        // go left side
//        else if (k_smallest < pivot_index) {
//            return quickselect(left, pivot_index - 1, k_smallest);
//        }
//        // go right side
//        return quickselect(pivot_index + 1, right, k_smallest);
//    }
//
//    public int findKthLargest(int[] nums, int k) {
//       this.nums = nums;
//       int size = nums.length;
//       // Kth largest is (N - k)th smallest
//       return quickselect(0, size - 1, size - k);
//    }


    //    /**
//     * 没有随机取pivot 这题通过速度很慢
//     * @param nums
//     * @param k
//     * @return
//     */
//    public int findKthLargest(int[] nums, int k) {
//        int len = nums.length;
//        int left = 0;
//        int right = len - 1;
//
//        // 转换一下，第k大元素的索引是len - k
//        int target = len - k;
//        while (true) {
//            int index = partition(nums, left, right);
//            if (index == target) {
//                return nums[index];
//            } else if (index < target) {
//                left = index + 1;
//            } else {
//                right = index - 1;
//            }
//        }
//    }
//
//    /**
//     * 在数组nums的子区间[left, right] 执行partition操作，返回nums[left] 排序以后应该在的位置
//     * 在遍历过程中保持循环不变量的语义
//     * 1. [left + 1, j] < nums[left]
//     * 2. (j, i] >= nums[left]
//     * @param nums
//     * @param left
//     * @param right
//     * @return
//     */
//    private int partition(int[] nums, int left, int right) {
//        // 这里直接使用left作为初始pivot 进行单边循环法
//        int pivot = nums[left];
//        int j = left;
//        for (int i = left + 1; i <= right; i++) {
//            if (nums[i] < pivot) {
//                // 小于pivot 的元素都被交换到前面
//                j++;
//                swap(nums, j, i);
//            }
//        }
//        // 在之前遍历的过程中，满足[left + 1, j] < pivot, 并且(j, i) >= pivot
//        swap(nums, j, left);
//        // 交换以后 [left, j - 1] < pivot, nums[j] = pivot, [j + 1, right] >= pivot
//        return j;
//    }
//
    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = index2;
        nums[index2] = tmp;
    }

//    private static Random random = new Random(System.currentTimeMillis());
//
//    public int findKthLargest(int[] nums, int k) {
//        int len = nums.length;
//        int target = len - k;
//        int left = 0;
//        int right = len - 1;
//        while (true) {
//
//        }
//    }
//
//    private int partition(int[] nums, int left, int right) {
//        // 再区间随机选择一个元素作为标定点
//        if (right > left) {
//            int randomIndex = left + random.nextInt(right - left + 1);
//            swap(nums, left, randomIndex);
//        }
//
//        int pivot = nums[left];
//        int j = left;
//        for (int i = left + 1; i <= right; i++) {
//            if (nums[i] < pivot) {
//                j++;
//                swap(nums, j, i);
//            }
//        }
//        swap(nums, left, j);
//        return j;
//    }

    private static Random random = new Random(System.currentTimeMillis());

//    public int findKthLargest(int[] nums, int k) {
//        int len = nums.length;
//        int left = 0;
//        int right = len - 1;
//
//        // 转换一下， 第k大元素的索引是len - k
//        int target = len - k;
//        while (true) {
//            int index = partition(nums, left, right);
//            if (index == target) {
//                return nums[index];
//            } else if (index < target) {
//                left = index + 1;
//            } else {
//                right = index - 1;
//            }
//        }
//    }
//
//    private int partition(int[] nums, int left, int right) {
//        // 在区间随机选择一个元素作为标定点
//        if (right > left) {
//            int randomIndex = left + random.nextInt(right - left + 1);
//            swap(nums, left, randomIndex);
//        }
//        int pivot = nums[left];
//
//        // 将等于pivot 的元素分散到两边
//        // [left, lt] <= pivot
//        // (rt, right) >= pivot
//
//        int lt = left + 1;
//        int rt = right;
//
//        while (true) {
//            while (lt <= rt && nums[lt] < pivot) {
//                lt++;
//            }
//            while (lt <= rt && nums[rt] > pivot) {
//                rt--;
//            }
//            if (lt > rt) {
//                break;
//            }
//            swap(nums, lt, rt);
//            lt++;
//            rt--;
//        }
//
//        swap(nums, left, right);
//        return rt;
//    }


    // 根据k的不同，选最大堆和最小堆， 目的是让堆中的元素更小
    // 思路1: k 要是更靠近0的话，此时k是一个较大的数，用最大堆
    // 例如在一个有6个元素数组里找第5大的元素
    // 思路2 : k 要是更靠近的话 用最小堆
    // 所以分界点就是k = len - k
//    public int findKthLargest(int []nums, int k) {
//        int len = nums.length;
//        if (k <= len - k) {
//           // System.out.println("使用最小堆")
//           // 特例: k = 1, 用容量为k的最小堆
//           // 使用一个含有k个元素的最小堆
//           PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a, b) -> a - b);
//           for (int i = 0; i < k; i++) {
//              minHeap.add(nums[i]);
//           }
//           for (int i = k; i < len; i++) {
//               // 看一眼，不拿出，因为有可能没有必要替换
//               Integer topEle = minHeap.peek();
//               // 只要当前遍历的元素比堆顶元素大，堆顶弹出，遍历的元素进去
//               if (nums[i] > topEle) {
//                   minHeap.poll();
//                   minHeap.add(nums[i]);
//               }
//           }
//           return minHeap.peek();
//        } else {
//            // System.out.println("使用最大堆");
//            assert k > len - k;
//            // 特例: k = 100, 用容量为 len - k + 1 的最大值
//            int capacity = len - k + 1;
//            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(capacity, (a, b) -> b - a);
//            for (int i = 0; i < capacity; i++) {
//                maxHeap.add(nums[i]);
//            }
//
//            for (int i = capacity; i < len; i++) {
//                // 看一眼，不拿出， 因为有可能没有必要替换
//                Integer topEle = maxHeap.peek();
//                // 只要当前遍历的元素比堆顶元素小，堆顶弹出, 遍历的元素进去
//                if (nums[i] < topEle) {
//                    maxHeap.poll();
//                    maxHeap.add(nums[i]);
//                }
//            }
//            return maxHeap.peek();
//        }
//    }

//    public int findKthLargest(int[] nums, int k) {
//        if (nums == null) {
//            return -1;
//        }
//        return quickSelect(nums, 0, nums.length - 1, k);
//    }
//
//    private int quickSelect(int[] nums, int start, int end, int k) {
//        if (start == end) {
//            return nums[start];
//        }
//
//        int i = start, j = end;
//        int pivot = nums[(start + end) / 2];
//        while (i <= j) {
//            while (i <= j && nums[i] > pivot) {
//                i++;
//            }
//            while (i <= j && nums[j] < pivot) {
//                j--;
//            }
//            if (i <= j) {
//                int temp = nums[i];
//                nums[i] = nums[j];
//                nums[j] = temp;
//                i++;
//                j--;
//            }
//        }
//
//
//        if (start + k <= j) {
//            return quickSelect(nums, start, j, k);
//        }
//
//        if (start + k >= i) {
//            return quickSelect(nums, i, end, k - (i - start));
//        }
//        return nums[j + 1];
//    }

//    public int findKthLargest(int k, int[] nums) {
//        if (nums == null) {
//            return -1;
//        }
//        return partition(nums, 0, nums.length - 1, k);
//    }
//
//    private int partition(int[] nums, int start, int end, int k) {
//        if (start >= end) {
//            return nums[start];
//        }
//        int left = start, right = end;
//        int pivot = nums[(start + end) / 2];
//
//        while (left <= right) {
//            while (left <= right && nums[left] < pivot) {
//                left++;
//            }
//            while (left <= right && nums[right] < pivot) {
//                right--;
//            }
//            if (left <= right) {
//                swap(nums, left, right);
//                left++;
//                right--;
//            }
//        }
//        if (k <= right) {
//            return partition(nums, start, right, k);
//        }
//
//        if (k >= left) {
//           return partition(nums, left, end, k);
//        }
//
//        return nums[k];
//    }

    public int kthLargestElement(int n, int[] nums) {
        if (nums == null) {
            return -1;
        }
        return quickSelect(nums, 0, nums.length - 1, n);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }

        int i = start, j = end;
        int pivot = nums[(i + j) / 2];

        while (i <= j) {
            while (i <= j && nums[i] > pivot) {
                i++;
            }
            while (i <= j && nums[j] < pivot) {
                j--;
            }
            if (i <= j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j--;
                i++;
            }
        }
        if (start + k - 1 <= j) {
           return quickSelect(nums, start, j, k);
        }

        if (start + k - 1 >= i) {
           return quickSelect(nums, i, end, k - (i - start));
        }
        return nums[j + 1];
    }


    public static void main(String[] args) {
        TwoOneFive twoOneFive = new TwoOneFive();
        System.out.println(twoOneFive.kthLargestElement(4, new int[]{3, 2, 1, 5, 6, 4}));
//        System.out.println(twoOneFive.findKthLargest(new int[]{3, 1, 2, 4}, 2));
    }
}
