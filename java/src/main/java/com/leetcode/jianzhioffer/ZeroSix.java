package com.leetcode.jianzhioffer;

import com.entity.ListNode;

import java.util.ArrayList;

/**
 * @author: John
 * @date: 2020-05-04 15:57
 * @description: 06
 **/
public class ZeroSix {

    ArrayList<Integer> temp = new ArrayList<>();


    /**
     * no stack no recursion
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head) {
        ListNode node = head;
        int count = 0;
        while (node != null) {
            ++count;
            node = node.next;
        }
        int[] nums = new int[count];
        node = head;
        for (int i = count - 1; i >= 0; --i) {
            nums[i] = node.val;
            node = node.next;
        }
        return nums;
    }

//    /**
//     * recursion
//     * @param head
//     * @return
//     */
//    public int[] reversePrint(ListNode head) {
//        recursion(head);
//        int[] res = new int[temp.size()];
//        for (int i = 0; i < res.length; i++) {
//            res[i] = temp.get(i);
//        }
//        return res;
//    }
//
//    void recursion(ListNode head) {
//        if (head == null) {
//            return;
//        }
//        recursion(head.next);
//        temp.add(head.val);
//    }


    /**
     * stack
     *
     * @param head
     * @return
     */
//    public int[] reversePrint(ListNode head) {
//        Stack<ListNode> stack = new Stack<>();
//        ListNode temp = head;
//        while (temp != null) {
//            stack.push(temp);
//            temp = temp.next;
//        }
//        int size = stack.size();
//        int[] print = new int[size];
//        for (int i = 0; i < size; i++) {
//            print[i] = stack.pop().val;
//        }
//        return print;
//    }
}
