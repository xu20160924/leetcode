package com.leetcode;

import java.util.HashMap;

/**
 * @author: John
 * @date: 2020-04-19 18:12
 * @description: 146
 **/
public class OneFourSix {

//    class DLinkedNode {
//        int key;
//        int value;
//        DLinkedNode pre;
//        DLinkedNode post;
//    }
//
//    private HashMap<Integer, DLinkedNode> cache = new HashMap<>();
//    private int count;
//    private int capacity;
//    private DLinkedNode head, tail;
//
//    /**
//     * Always add the new node right after head.
//     * @param node
//     */
//    private void addNode(DLinkedNode node) {
//        node.pre = head;
//        node.post = head.post;
//
//        head.post.pre = node;
//        head.post = node;
//    }
//
//    /**
//     * Remove an existing node from the linked list.
//     * @param node
//     */
//    private void removeNode(DLinkedNode node) {
//        DLinkedNode pre = node.pre;
//        DLinkedNode post = node.post;
//
//        pre.post = post;
//        post.pre = pre;
//    }
//
//    /**
//     * Move certain node in between to the head.
//     * @param node
//     */
//    private void moveToHead(DLinkedNode node) {
//        this.removeNode(node);
//        this.addNode(node);
//    }
//
//    private DLinkedNode popTail() {
//        DLinkedNode res = tail.pre;
//        this.removeNode(res);
//        return res;
//    }
//
//    public OneFourSix(int capacity) {
//        this.count = 0;
//        this.capacity = capacity;
//
//        head = new DLinkedNode();
//        head.pre = null;
//
//        tail = new DLinkedNode();
//        tail.post = null;
//
//        head.post = tail;
//        tail.pre = head;
//    }
//
//    public int get(int key) {
//       DLinkedNode node = cache.get(key);
//       if (node == null) {
//          return -1; // should raise exception here.
//       }
//       // move the accessed node to the head
//       this.moveToHead(node);
//       return node.value;
//    }
//
//    public void put(int key, int value) {
//        DLinkedNode node = cache.get(key);
//
//        if (node == null) {
//           DLinkedNode newNode = new DLinkedNode();
//           newNode.key = key;
//           newNode.value = value;
//
//           this.cache.put(key, newNode);
//           this.addNode(newNode);
//           ++count;
//            if (count > capacity) {
//                // pop the tail
//                DLinkedNode tail = this.popTail();
//                this.cache.remove(tail.key);
//                --count;
//            }
//        } else {
//            // update the value.
//            node.value = value;
//            this.moveToHead(node);
//        }
//    }


    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // If need ensure thread safe, can replace to concurrenceMap
    private HashMap<Integer, DLinkedNode> map = new HashMap<>();
    private int capacity;
    private DLinkedNode head, tail;

    public OneFourSix(int capacity) {
        this.capacity = capacity;

        head = new DLinkedNode();
        tail = new DLinkedNode();

        head.next = tail;
        head.pre = null;

        tail.pre = head;
        tail.next = null;
    }

    public int get(int key) {
        DLinkedNode current = map.get(key);
        // 如果不存在
        if (current == null) {
            return -1;
        }
        // 更新当前节点
        moveToHead(key);
        return current.value;
    }

    public void put(int key, int value) {
        // 如果当前节点存在 直接更新当前节点的值
        if (get(key) != -1) {
            DLinkedNode currNode = map.get(key);
            currNode.value = value;
            moveToHead(key);
            return;
        }

        // 超出capacity 处理
        if (map.size() >= capacity) {
            // 从 tail 开始删除
            DLinkedNode removeNode = tail.pre;

            // 将当前节点从tail中删除
            removeNode.pre.next = tail;
            tail.pre = removeNode.pre;

            // 删除 map中的节点
            map.remove(removeNode.key);
        }

        // 将新节点链接到头上, 并put 进 map
        DLinkedNode newNode = new DLinkedNode(key, value);
        newNode.pre = head;
        newNode.next = head.next;

        head.next.pre = newNode;
        head.next = newNode;
        map.put(key, newNode);
    }


    private void moveToHead(int key) {
        DLinkedNode curNode = map.get(key);
        DLinkedNode preNode = curNode.pre;

        // 如果当前节点前继节点是head 就表明已经是最前面了
        if (preNode == head) {
            return;
        }

        // 先断开当前的指针:  上一个指向下一个   下一个指向上一个
        curNode.pre.next = curNode.next;
        curNode.next.pre = curNode.pre;

        // 将当前节点链接head的下一个节点
        head.next.pre = curNode;
        curNode.next = head.next;

        // 将当前节点链接head节点
        curNode.pre = head;
        head.next = curNode;
    }


    public static void main(String[] args) {
//        OneFourSix oneFourSix = new OneFourSix(2);
//        oneFourSix.put(1,1);
//        oneFourSix.put(2,2);
//        System.out.println(oneFourSix.get(1));
//        oneFourSix.put(3, 3);
//        System.out.println(oneFourSix.get(2));
//        oneFourSix.put(4,4);
//        System.out.println(oneFourSix.get(1));
//        System.out.println(oneFourSix.get(3));
//        System.out.println(oneFourSix.get(4));

//        OneFourSix oneFourSix = new OneFourSix(3);
//        oneFourSix.put(1, 1);
//        oneFourSix.put(2, 2);
//        oneFourSix.put(3, 3);
//        oneFourSix.put(4, 4);
//        System.out.println(oneFourSix.get(4));
//        System.out.println(oneFourSix.get(3));
//        System.out.println(oneFourSix.get(2));
//        System.out.println(oneFourSix.get(1));
//        oneFourSix.put(5, 5);
//        System.out.println(oneFourSix.get(1));
//        System.out.println(oneFourSix.get(2));
//        System.out.println(oneFourSix.get(3));
//        System.out.println(oneFourSix.get(4));
//        System.out.println(oneFourSix.get(5));


        OneFourSix oneFourSix = new OneFourSix(2);
        oneFourSix.put(1, 1);
        oneFourSix.put(2, 2);
        System.out.println(oneFourSix.get(1));
        oneFourSix.put(3, 3);
        System.out.println(oneFourSix.get(2));
        oneFourSix.put(4, 4);
        System.out.println(oneFourSix.get(1));
        System.out.println(oneFourSix.get(3));
        System.out.println(oneFourSix.get(4));

//        ￿￿System.out.println(oneFourSix.get(1￿));
//        oneFourSix.put(3, 3);
//        ￿￿System.out.println(oneFourSix.get(1));
//        oneFourSix.put(3, 3);
//        ￿￿System.out.println(oneFourSix.get(2));

    }
}
