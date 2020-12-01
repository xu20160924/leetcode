package com.nowcoder;

/**
 * @author: John
 * @date: 2020-11-22 21:12
 * @description: NC91
 **/
public class NcNineOne {


    public int[] LIS(int[] arr) {
        int n = arr.length;
        int[] res = new int[n + 1];
        int[] dp = new int[n];
        res[1] = arr[0];
        dp[0] = 1;
        int len = 1;

        for (int i = 0; i < n; i++) {
            if (res[len] < arr[i]) {
                res[++len] = arr[i];
                dp[i] = len;
            } else {
                int l = 0;
                int r = len;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (res[mid] >= arr[i]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                res[l] = arr[i];
                dp[i] = l;
            }
        }

        int[] ress = new int[len];
        for (int i = n - 1; i >= 0; --i) {
            if (dp[i] == len) {
                ress[--len] = arr[i];
            }
        }
        return ress;
    }

    public static void main(String[] args) {
        NcNineOne ncNineOne = new NcNineOne();
        int[] a = ncNineOne.LIS(new int[]{2,1,5,3,6,4,8,9,7});
    }
//        int n = arr.length;
//        int[] res = new int[n + 1];
//        int[] dp = new int[n];
//        dp[0] = 1;
//        int len = 1;
//        res[1] = arr[0];
//        for (int i = 0; i < n; i++) {
//            if (res[len] < arr[i]) {
//                 res[++len] = arr[i];
//                 dp[i] = len;
//            } else {
//                int l = 0;
//                int r = len;
//                while (l <= r) {
//                    int mid = l + (r - l) / 2;
//                    if (res[mid] >= arr[i]) {
//                        r = mid - 1;
//                    } else {
//                        l = mid + 1;
//                    }
//                }
//                res[l] = arr[i];
//                dp[i] = l;
//            }
//        }
//        for(int i = n-1; i>=0; i--){
//            if(dp[i] == len){
//                res[--len] = arr[i];
//            }
//        }
//        return res;
//    }


//    public int[] LIS(int[] arr) {
//        // write code here
//
//        List<Integer> res = new ArrayList<>();
//        List<Integer> maxLen = new ArrayList<>();
//        if (arr.length < 1) {
//            return new int[0];
//        }
//        res.add(arr[0]);
//        maxLen.add(1);
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i] > res.get(res.size())) {
//                res.add(arr[i]);
//                maxLen.add(res.size());
//            } else {
//                int pos = find(res, arr[i]);
//            }
//        }
//
//    }
//
//
//    private int find(int[] nums, int target) {
//        int left = nums.length;
//        int right = nums.length - 1;
//
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (target >= nums[mid]) {
//                return mid + 1;
//            } else {
//                right = mid;
//            }
//        }
//    }
}
