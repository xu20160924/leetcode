package com.lintcode;


import java.util.HashMap;

/**
 * @author: John
 * @date: 2020-04-19 10:23
 * @description: 134
 **/
public class OneThreeFour {

//    class ListNode {
//        public int key, val;
//        public ListNode next;
//
//        public ListNode(int key, int val) {
//           this.key = key;
//           this.val = val;
//           this.next = null;
//        }
//    }
//
//    private int capacity, size;
//    private ListNode dummy, tail;
//    private Map<Integer, ListNode> keyToPrev;
//
//    public OneThreeFour(int capacity) {
//        this.capacity = capacity;
//        this.keyToPrev = new HashMap<>();
//        this.dummy = new ListNode(0, 0);
//        this.tail = this.dummy;
//    }
//
//    private void moveToTail(int key) {
//       ListNode prev = keyToPrev.get(key);
//       ListNode curt = prev.next;
//
//       if (tail == curt) {
//           return;
//       }
//       prev.next = prev.next.next;
//       tail.next = curt;
//
//       if (prev.next != null) {
//          keyToPrev.put(prev.next.key, prev);
//       }
//       keyToPrev.put(curt.key, tail);
//       tail = curt;
//    }
//
//    public int get(int key) {
//        if (!keyToPrev.containsKey(key)) {
//           return -1;
//        }
//        // 这里移到Tail 就是标记为最新的
//        moveToTail(key);
//        return tail.val;
//    }
//
//    public void set(int key, int value) {
//        // get method will move the key to the end of the linked list
//        if (get(key) != -1) {
//            ListNode prev = keyToPrev.get(key);
//            prev.next.val = value;
//            return;
//        }
//
//        if (size < capacity) {
//            size++;
//            ListNode curt = new ListNode(key, value);
//            tail.next = curt;
//            keyToPrev.put(key, tail);
//
//            tail = curt;
//            return;
//        }
//
//        // replace the first node with new key, value
//        // 删除最老的数据 替换成当前set的数据
//        ListNode first = dummy.next;
//        keyToPrev.remove(first.key);
//
//        // 替换成当前的key value
//        first.key = key;
//        first.val = value;
//        keyToPrev.put(key, dummy);
//
//        // 将当前设置的移到tail 标记为最新
//        moveToTail(key);
//    }

    private class Node {
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> hs = new HashMap<>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);

    public OneThreeFour(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        // 找不到key
        if (!hs.containsKey(key)) {
            return -1;
        }

        // remove current
        // 这里之所以要先删除是断掉之前的prev next 链接
        // 由于当前最新访问,所以链接到最后
        Node current = hs.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;

        // move current to tail
        // 每次get, 使用次数 + 1, 最近使用，放于尾部
        moveToTail(current);
        return hs.get(key).value;
    }

    // 数据放入缓存
    public void set(int key, int value) {
        if (get(key) != -1) {
            hs.get(key).value = value;
            return;
        }

        if (hs.size() == capacity) {
            // 超出缓存上限
            hs.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }

        // 新建节点
        Node insert = new Node(key, value);
        hs.put(key, insert);
        // 放入尾部
        moveToTail(insert);
    }

    private void moveToTail(Node current) { // 移动数据至尾部
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;
    }

    public static void main(String[] args) {
        OneThreeFour oneThreeFour = new OneThreeFour(2);
        oneThreeFour.set(2, 1);
        oneThreeFour.set(1, 1);
        oneThreeFour.get(2);
        oneThreeFour.set(4, 1);
        oneThreeFour.get(1);
        oneThreeFour.get(2);
    }
}
