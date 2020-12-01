package com.leetcode;

import com.entity.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: John
 * @date: 2020-02-04 20:12
 * @description: 23
 **/
public class TwoThree {
//    public static ListNode mergeKLists(ListNode[] lists) {
//        if (lists == null || lists.length == 0) {
//            return null;
//        }
//        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                if (o1.val < o2.val) {
//                    return -1;
//                } else if (o1.val == o2.val) {
//                    return 0;
//                } else {
//                    return 1;
//                }
//            }
//        });
//
//        ListNode dummy = new ListNode(0);
//        ListNode tail = dummy;
//        for (ListNode node : lists) {
//            if (node != null) {
//                queue.add(node);
//            }
//        }
//        while (!queue.isEmpty()) {
//            tail.next = queue.poll();
//            tail = tail.next;
//        }
//        return dummy.next;
//    }
//        if (lists == null || lists.length == 0) {
//            return null;
//        }
//        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                if (o1.val < o2.val) {
//                    return -1;
//                } else if (o1.val == o2.val) {
//                    return 0;
//                } else {
//                    return 1;
//                }
//            }
//        });
//
//        ListNode dummy = new ListNode(0);
//        ListNode tail = dummy;
//        for (ListNode node : lists) {
//            if (node != null) {
//                queue.add(node);
//            }
//        }
//        while (!queue.isEmpty()) {
//            tail.next = queue.poll();
//            tail = tail.next;
//            // there because linkedlist is chain structure， so should put next of current into queue
//            if (tail.next != null) {
//                queue.add(tail.next);
//            }
//        }
//        return dummy.next;
//    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = null;
        ListNode former = null;
        int i = 0;
        while (l1!=null && l2!=null) {
            i++;
            if (l1.val > l2.val) {
                if (former == null) {
                    former = l2;
                } else {
                    former.next = l2;
                }
                if (head == null) {
                    head = former;
                } else {
                    former = former.next;
                }
                l2 = l2.next;
            } else {
                if (former == null) {
                    former = l1;
                } else {
                    former.next = l1;
                }
                if (head == null) {
                    head = former;
                } else {
                    former = former.next;
                }
                l1 = l1.next;
            }
        }
        System.out.println(i);
        if (l2 != null) {
            l1 = l2;
        }
        former.next = l1;
        return head;
    }

    public static ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        }
        if (lists.size() == 1) {
            return lists.get(0);
        }
        if (lists.size() == 2) {
            return mergeTwoLists(lists.get(0), lists.get(1));
        }
        return mergeTwoLists(mergeKLists(lists.subList(0, lists.size()/2)),
                mergeKLists(lists.subList(lists.size()/2, lists.size())));
    }


    public static void main(String[] args) {
        ListNode[] result = new ListNode[3];
        ListNode listNode1 = new ListNode(1);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode4;
        listNode4.next = listNode5;

        ListNode listNode11 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode44 = new ListNode(4);
        listNode11.next = listNode3;
        listNode3.next = listNode44;

        ListNode listNode2 = new ListNode(2);
        ListNode listNode6 = new ListNode(6);
        listNode2.next = listNode6;

//        result[0] = listNode1;
//        result[1] = listNode11;
//        result[2] = listNode2;
        List<ListNode> input = new ArrayList<>();
        input.add(listNode1);
        input.add(listNode11);
        input.add(listNode2);
        ListNode aa = TwoThree.mergeKLists(input);
    }
}
