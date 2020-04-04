//package com.entity;
//
///**
// * @author: John
// * @date: 2019-12-20 18:51
// * @description:
// **/
//public class NodeLinkedList {
//    private Node head;
//    private Node last;
//    private int size;
//
//    public void insert(int data, int index) throws Exception {
//        if (index<0 || index>size) {
//            throw new IndexOutOfBoundsException("超出链表节点范围!");
//        }
//        Node insertedNode = new Node(data);
//        if (size == 0) {
//            // 空链表
//            head = insertedNode;
//            last = insertedNode;
//        } else if (index == 0) {
//            insertedNode.next = head;
//            head = insertedNode;
//        } else if (size == index) {
//            last.next = insertedNode;
//            last = insertedNode;
//        } else {
////            Node prevNode =
//            Node prevNode = get(index - 1);
//            insertedNode.next = prevNode.next;
//            prevNode.next = insertedNode;
//        }
//        size++;
//    }
//
//    public Node remove(int index) throws Exception {
//        if (index<0 || index>=size) {
//            throw new IndexOutOfBoundsException("超出链表节点范围");
//        }
//        Node removedNode = null;
//        if (index == 0) {
//            removedNode = head;
//            head = head.next;
//        } else if (index == size-1) {
//            Node prevNode = get(index -1);
//        }
//    }
//
//    public Node get(int index) throws Exception {
//        if (index<0 || index>=size) {
//            throw new IndexOutOfBoundsException("超出链表节点范围");
//        }
//        Node temp = head;
//        for (int i=0; i<index; i++) {
//            temp = temp.next;
//        }
//        return temp;
//    }
//
//    public void output() {
//        Node temp = head;
//        while (temp!=null){
//            System.out.println(temp.data);
//            temp = temp.next;
//        }
//    }
//
//
//    private static class Node {
//        int data;
//        Node next;
//
//        public Node(int data) {
//            this.data = data;
//        }
//    }
//}
