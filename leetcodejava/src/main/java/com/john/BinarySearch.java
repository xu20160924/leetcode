package com.john;

import com.entity.ListNode;
import com.entity.TreeNode;

/**
 * @author: John
 * @date: 2020-01-30 15:37
 * @description:
 **/
public class BinarySearch {

    /**
     * find partial minimum in array
     * @param arr
     * @return
     */
    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1|| arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left < right) {
            mid = (left + right) /2;
            if (arr[mid] > arr[mid - 1]) {
                 right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return mid;
    }

    /**
     * find minimum in rotated sorted array
     * @param
     * @return
     */
    public static int getMin(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low < high) {
            if (low == high - 1) {
                break;
            }
            if (arr[low] < arr[high]) {
                return arr[low];
            }
            mid = (low + high) / 2;
            if (arr[low] > arr[mid]) {
                high = mid;
                continue;
            }
            if (arr[mid] > arr[high]) {
                low = mid;
                continue;
            }
            while (low < mid) {
                if (arr[low] == arr[mid]) {
                    low++;
                } else if (arr[low] < arr[mid]) {
                    return arr[low];
                } else {
                    high = mid;
                    break;
                }
            }
        }
        return Math.min(arr[low], arr[high]);
    }

    /**
     * 算法存在问题  在 1,2,3,4,5 下 返回结果是7  solution from book
     * @param head
     * @return
     */
    public static int nodeNum(TreeNode head) {
       if (head == null) {
           return 0;
       }
       return bs(head, 1, mostLeftLevel(head));
    }

    public static int bs(TreeNode node, int l, int h) {
        if (node == null) {
            return 0;
        }
        if (l == h) {
            int a  = (1 << (h - 1));
//            int b = bs(node.right, l + 1, h);
            return  (1 << h - 1) + bs(node.right, l + 1, h);
        } else {
            int a = (1 << (h - l - 1));
//            int b =  bs(node.left, l + 1, h);
            return (1 << (h - l - 1)) + bs(node.left, l + 1, h);
        }
    }

    public static int mostLeftLevel(TreeNode node) {
        int level = 0;
        while (node != null) {
            level++;
            node = node.left;
        }
        return level;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        System.out.println(BinarySearch.nodeNum(root));
    }
}
