package com.leetcode;


import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: John
 * @date: 2020-01-18 12:44
 * @description: LRU
 **/
public class LRUCache {

//    class DLinkedNode {
//        int key;
//        int value;
//        DLinkedNode pre;
//        DLinkedNode post;
//    }
//
//    private Hashtable<Integer, DLinkedNode> cache = new Hashtable<>();
//    private int count;
//    private int capacity;
//    private DLinkedNode head, tail;
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
//        DLinkedNode node = cache.get(key);
//        if (node == null) {
//            return -1;
//        }
//
//        // move the accssed node to the head;
//        this.moveToHead(node);
//        return node.value;
//    }
//
//    public void put(int key, int value) {
//        DLinkedNode node = cache.get(key);
//        if (node == null) {
//            DLinkedNode newNode = new DLinkedNode();
//            newNode.key = key;
//            newNode.value = value;
//
//            this.cache.put(key, newNode);
//            this.addNode(newNode);
//
//            ++count;
//
//            if (count > capacity) {
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
//
//    /**
//     * Move certain node in between to the haed.
//     * @param node
//     */
//    private void moveToHead(DLinkedNode node) {
//        this.removeNode(node);
//        this.addNode(node);
//    }
//
//    /**
//     * Remove an existing node from the linked list
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
//     * pop the current tail
//     * @return
//     */
//    private DLinkedNode popTail() {
//        DLinkedNode res = tail.pre;
//        this.removeNode(res);
//        return res;
//    }
//
//
//
//    /**
//     * Always add the new node right after head
//     * @param node
//     */
//    private void addNode(DLinkedNode node) {
//        node.pre = head;
//        node.post = head.post;
//
//        head.post.pre = node;
//        head.post = node;
//    }

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode post;
    }

    private Hashtable<Integer, DLinkedNode> cache = new Hashtable<Integer, DLinkedNode>();
    private int count;
    private DLinkedNode head, tail;
    private int capacity;


    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.prev = null;

        tail = new DLinkedNode();

        head.post = tail;
        tail.post = head;
    }

    public int get(int key) {
        DLinkedNode res = cache.get(key);
        if (res == null) {
            return -1;
        }
        // move the accessed node to the head
        this.moveToHead(res);
        return res.value;
    }

    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    public void put(int key, int value) {
        DLinkedNode cur = cache.get(key);
        if (cur == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            this.cache.put(key, newNode);
            this.addNode(newNode);
            this.count++;
            if (this.count > this.capacity) {
                DLinkedNode tail =  this.popTail();
                this.cache.remove(tail.key);
                this.count--;
            }
        } else {
            // cache.put(vlaue, cur);
            cur.value = value;
            this.moveToHead(cur);
        }
    }
    private DLinkedNode popTail() {
        DLinkedNode res = this.tail.prev;
        this.removeNode(res);
        return res;
    }

    private void removeNode(DLinkedNode res) {
        DLinkedNode prev = res.prev;
        DLinkedNode post = res.post;

        prev.post = post;
        post.prev = prev;
    }

    private void addNode(DLinkedNode res) {
        res.prev = head;
        res.post = head.post;

        head.post.prev = res;
        head.post = res;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        cache.get(2);
        cache.put(4, 4);
        cache.get(1);
        cache.get(3);
        cache.get(4);

    }

    /**
     * using linkedHashMap
     * By overriding removeEldestEntry in this way,
     * we do not need to take care of it ourselves.
     * It will automatically remove the least recent one
     * when the size of map exceeds the specified capacity.
     */
    class LRUCache1 {
        private LinkedHashMap<Integer, Integer> map;
        private final int CAPACITY;

        LRUCache1(int capacity) {
            CAPACITY = capacity;
            // accessOrder if we set it to true，it will be in access order
            map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry eldest) {
                    return size() > CAPACITY;
                }
            };
        }

        public int get(int key) {
            return map.getOrDefault(key, -1);
        }
        public void set(int key, int value) {
            map.put(key, value);
        }

    }
}
