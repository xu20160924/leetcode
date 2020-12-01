package com.leetcode;

/**
 * @author: John
 * @date: 2020-03-13 14:32
 * @description: 4
 **/
public class Four {
//    public double findMedianSortedArrays(int[] A, int[] B) {
//       int m = A.length;
//       int n = B.length;
//       if (m > n) {
//           int[] temp = A; A = B; B = temp;
//           int tmp = m; m = n; n = tmp;
//       }
//       int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
//       while (iMin <= iMax) {
//           int i = (iMin + iMax) / 2;
//           int j = halfLen - i;
//           if (i < iMax && B[j - 1] > A[i]) {
//              iMin = i + 1;
//           } else if (i > iMin && A[i - 1] > B[j]) {
//              iMax = i - 1;
//           } else {
//               int maxLeft = 0;
//               if (i == 0) {
//                   maxLeft = B[j - 1];
//               } else if (j == 0) {
//                   maxLeft = A[i - 1];
//               } else {
//                   maxLeft = Math.max(A[i-1], B[j-1]);
//               }
//               if ((m+n) % 2 == 1) {
//                   return maxLeft;
//               }
//               int minRight = 0;
//               if (i == m) {
//                   minRight = A[i];
//               } else if (j == n) {
//                  minRight = A[i];
//               } else {
//                   minRight = Math.min(B[j], A[i]);
//               }
//               return (maxLeft + minRight) / 2.0;
//           }
//       }
//       return 0.0;
//    }

//    public double findMedianSortedArrays(int[] A, int[] B) {
//        int m = A.length;
//        int n = B.length;
//        if (m > n) {
//            int[] temp = A;
//            A = B;
//            B = temp;
//            int tmp = m;
//            m = n;
//            n = tmp;
//        }
//        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
//        while (iMin <= iMax) {
//            int i = (iMin + iMax) / 2;
//            int j = halfLen - i;
//            if (i < iMax && B[j - 1] > A[i]) {
//                iMin = i + 1; // i is too small
//            } else if (i > iMin && A[i - 1] > B[j]) {
//                iMax = i - 1; // i is too big
//            } else { // i is perfect
//                int maxLeft;
//                if (i == 0) {
//                    maxLeft = B[j - 1];
//                } else if (j == 0) {
//                    maxLeft = A[i - 1];
//                } else {
//                    maxLeft = Math.max(A[i - 1], B[j - 1]);
//                }
//                if ((m + n) % 2 == 1) {
//                    return maxLeft;
//                }
//                int minRight;
//                if (i == m) {
//                    minRight = B[j];
//                } else if (j == n) {
//                    minRight = A[i];
//                } else {
//                    minRight = Math.min(B[j], A[i]);
//                }
//                return (maxLeft + minRight) / 2.0;
//            }
//        }
//        return 0.0;
//    }
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int[] nums;
//        int m = nums1.length;
//        int n = nums2.length;
//        nums = new int[m + n];
//        if (m == 0) {
//            if (n % 2 == 0) {
//                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
//            } else {
//                return nums2[n / 2];
//            }
//        }
//        if (n == 0) {
//            if (m % 2 == 0) {
//                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
//            } else {
//                return nums1[m / 2];
//            }
//        }
//        int count = 0;
//        int i = 0, j = 0;
//        while (count != (m + n)) {
//           if (i == m) {
//               while (j != n) {
//                  nums[count++] = nums2[j++];
//               }
//               break;
//           }
//           if (j == n) {
//              while (i != m) {
//                  nums[count++] = nums1[i++];
//              }
//              break;
//           }
//           if (nums1[i] < nums2[j]) {
//               nums[count++] = nums1[i++];
//           } else {
//               nums[count++] = nums2[j++];
//           }
//        }
//        if (count % 2 == 0) {
//            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
//        } else {
//            return nums[count / 2];
//        }
//    }

//    public double findMedianSortedArrays(int[] A, int[] B) {
//        int m = A.length;
//        int n = B.length;
//        int len = m + n;
//        int left = -1, right = -1;
//        int aStart = 0, bStart = 0;
//        for (int i = 0; i <= len / 2; i++) {
//            left = right;
//            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
//                right = A[aStart++];
//            } else {
//                right = B[bStart++];
//            }
//        }
//        if ((len & 1) == 0) {
//            return (left + right) / 2.0;
//        } else {
//            return right;
//        }
//    }

//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int n = nums1.length;
//        int m = nums2.length;
//        int left = (n + m + 1) / 2;
//        int right = (n + m + 2) / 2;
//        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
//    }
//
//    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
//        int len1 = end1 - start1 + 1;
//        int len2 = end2 - start2 + 1;
//        if (len1 > len2) {
//            return getKth(nums2, start2, end2, nums1, start1, end1, k);
//        }
//        if (len1 == 0) {
//            return nums2[start2 + k - 1];
//        }
//
//        if (k == 1) {
//            return Math.min(nums1[start1], nums2[start2]);
//        }
//        int i = start1 + Math.min(len1, k / 2) - 1;
//        int j = start2 + Math.min(len2, k /2 ) - 1;
//
//        if (nums1[i] > nums2[j]) {
//           return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
//        } else {
//            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
//        }
//    }

//    public double findMedianSortedArrays(int[] A, int[] B) {
//        int m = A.length;
//        int n = B.length;
//        if (m > n) {
//           return findMedianSortedArrays(B, A);
//        }
//        int iMin = 0, iMax = m;
//        while (iMax <= iMax) {
//            int i = (iMin + iMax) / 2;
//            int j = (m + n + 1) / 2 - i;
//            if (j != 0 && i != m && B[j-1] > A[i]) {
//                iMin = i + 1;
//            } else if (i != 0 && j != n && A[i - 1] > B[j]) {
//                iMax = i - 1;
//            } else {
//                int maxLeft = 0;
//                if (i == 0) {
//                    maxLeft = B[j - 1];
//                } else if (j == 0) {
//                    maxLeft = A[i - 1];
//                } else {
//                    maxLeft = Math.max(A[i - 1], B[j - 1]);
//                }
//                if ((m + n ) % 2 == 1) {
//                    return maxLeft;
//                }
//                int minRight = 0;
//                if (i == m) {
//                   minRight = B[j];
//                } else if (j == n) {
//                   minRight = A[i];
//                } else {
//                    minRight = Math.min(B[j], A[i]);
//                }
//                return (maxLeft + minRight) / 2.0;
//            }
//        }
//        return 0.0;
//    }


//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        if (nums1.length > nums2.length) {
//            return findMedianSortedArrays(nums2, nums1);
//        }
//
//        int x = nums1.length;
//        int y = nums2.length;
//
//        int low = 0;
//        int high = x;
//        while (low <= high) {
//            int partitionx = (low + high) / 2;
//            int partitiony = (y + x + 1) / 2 - partitionx;
//
//            int maxLeftX = (partitionx == 0) ? Integer.MIN_VALUE : nums1[partitionx - 1];
//            int minRightX = (partitionx == x) ? Integer.MAX_VALUE : nums1[partitionx];
//
//            int maxLeftY = (partitiony == 0) ? Integer.MIN_VALUE : nums2[partitiony - 1];
//            int minRightY = (partitiony == y) ? Integer.MAX_VALUE : nums2[partitiony];
//
//            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
//                if ((x + y) % 2 == 0) {
//                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
//                }
//                return Math.max(maxLeftX, maxLeftY);
//            } else if (minRightY > maxLeftX) {
//                low = partitionx + 1;
//            } else {
//                high = partitionx - 1;
//            }
//        }
//        throw new IllegalArgumentException();
//    }

//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int n = nums1.length;
//        int m = nums2.length;
//        int left = (n + m + 1) / 2;
//        int right = (n + m + 2) / 2;
//        return (kth(nums1, 0, n - 1, nums2, 0, m - 1, left) + kth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
//    }
//    private int kth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
//        int len1 = end1 - start1 + 1;
//        int len2 = end2 - start2 + 1;
//        if (len1 > len2) {
//            return kth(nums2, start2, end2, nums1, start1, end1, k);
//        }
//        if (len1 == 0) {
//            return nums2[start2 + k - 1];
//        }
//        if (k == 1) {
//            return Math.min(nums1[start1], nums2[start2]);
//        }
//        int i = start1 + Math.min(len1, k / 2) - 1;
//        int j = start2 + Math.min(len2, k / 2) - 1;
//        if (nums1[i] > nums2[j]) {
//            return kth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
//        } else {
//            return kth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
//        }
//    }


    // 先合并两个数组 然后根据奇数还是偶数 返回中位数
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int[] nums;
//        int m = nums1.length;
//        int n = nums2.length;
//        nums = new int[m + n];
//
//        // 处理nums1为空的情况
//        if (m == 0) {
//            if (n % 2 == 0) {
//                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
//            } else {
//                return nums2[n / 2];
//            }
//        }
//
//        // 处理nums2为空的情况
//        if (n == 0) {
//            if (m % 2 == 0) {
//                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
//            } else {
//                return nums1[m / 2];
//            }
//        }
//
//        int count = 0;
//        int i = 0, j = 0;
//        while (count != (m + n)) {
//            if (i == m) {
//                while (j != n) {
//                    nums[count++] = nums2[j++];
//                }
//                break;
//            }
//            if (j == n) {
//                while (i != m) {
//                    nums[count++] = nums1[i++];
//                }
//                break;
//            }
//
//            if (nums1[i] < nums2[j]) {
//                nums[count++] = nums1[i++];
//            } else {
//                nums[count++] = nums2[j++];
//            }
//        }
//
//        if (count % 2 == 0) {
//            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
//        } else {
//            return nums[count / 2];
//        }
//    }


    // 循环找中位数
//    public double findMedianSortedArrays(int[] A, int[] B) {
//       int m = A.length;
//       int n = B.length;
//       int len = m + n;
//       int left = -1, right = -1;
//       int aStart = 0, bStart = 0;
//
//       for (int i = 0; i <= len / 2; i++) {
//          left = right;
//          if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
//              right = A[aStart++];
//          } else {
//              right = B[bStart++];
//          }
//       }
//
//       if ((len & 1) == 0) {
//          return (left + right) / 2.0;
//       } else {
//           return right;
//       }
//    }

//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int n = nums1.length;
//        int m = nums2.length;
//
//        // 这里因为是要找中位数 所以一开始 总长度一半开始
//        int left = (n + m + 1) / 2;
//        int right = (n + m + 2) / 2;
//        // 将偶数和奇数的情况合并，如果是奇数，会求两次同样的k
//        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left)
//                + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
//    }
//
//    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
//        int len1 = end1 - start1 + 1;
//        int len2 = end2 - start2 + 1;
//        // 让 len1的长度小于len2, 这样就能保证如果有数组空了， 一定是len1
//        if (len1 > len2) {
//            return getKth(nums2, start2, end2, nums1, start1, end1, k);
//        }
//
//        if (len1 == 0) {
//           return nums2[start2 + k - 1];
//        }
//        if (k == 1) {
//            // 最后两个数要取最小的
//            return Math.min(nums1[start1], nums2[start2]);
//        }
//
//        // 取最小是防止排除的长度超过一半将中位数也排除掉了
//        int i = start1 + Math.min(len1, k / 2) - 1;
//        int j = start2 + Math.min(len2, k / 2) - 1;
//
//        // i+1, j+1  在排除的基础上向右走一步 以排除当前已经及左边已经确认排除的数
//        if (nums1[i] > nums2[j]) {
//            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
//        } else {
//            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
//        }
//    }

    public double findMedianSortedArrays(int[] A, int[] B) {
       int m = A.length;
       int n = B.length;

       if (m > n) {
          return findMedianSortedArrays(B, A); //保证 m <= n
       }

       int iMin = 0, iMax = m;
       while (iMin <= iMax) {
           int i = (iMin + iMax) / 2;
           int j = (m + n + 1) / 2 - i;
           if (j != 0 && i != m && B[j - 1] > A[i]) {  // i 需要增大
               iMin = i + 1;
           } else if (i != 0 && j != n && A[i - 1] > B[j]) { // i 需要减小
               iMax = i - 1;
           } else {  // 达到要求, 并且将边界条件列出来单独考虑
               int maxLeft = 0;
               if (i == 0) {
                   maxLeft = B[j -1];
               } else if (j == 0) {
                   maxLeft = A[i - 1];
               } else {
                   maxLeft = Math.max(A[i-1], B[j-1]);
               }

               if ((m+n) % 2 == 1) { //奇数的话不需要考虑右半部分
                  return maxLeft;
               }

               int minRight = 0;
               if (i == m) {
                  minRight = B[j];
               } else if (j == n) {
                  minRight = A[i];
               } else {
                   minRight = Math.min(A[i], B[j]);
               }
               return (maxLeft + minRight) / 2.0;  // 如果是偶数的话返回结果
           }
       }
       return 0.0;
    }



    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4, 9};
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Four four = new Four();
        System.out.println(four.findMedianSortedArrays(nums1, nums2));
    }
}
