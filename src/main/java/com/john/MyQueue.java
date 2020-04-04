package com.john;

/**
 * @author: John
 * @date: 2020-01-16 17:07
 * @description:
 **/
public class MyQueue {
    private int[] array;
    private int front;
    private int rear;

    public MyQueue(int capacity) {
        this.array = new int[capacity];
    }

    /**
     * enqueue
     * @param element
     * @throws Exception
     */
    public void enQueue(int element) throws Exception {
        if ((rear+1) % array.length == front) {
            throw new Exception("queue full");
        }
        array[rear] = element;
        rear = (rear + 1) % array.length;
    }

    /**
     * dequeue
     * @return
     * @throws Exception
     */
    public int deQueue() throws Exception {
        if (rear == front) {
            throw new Exception("队列已空");
        }
        int deQueueElement = array[front];
        front = (front + 1) % array.length;
        return deQueueElement;
    }

    public void output() {
        for (int i = front; i != rear; i = (i + 1) % array.length) {
            System.out.println(array[i]);
        }
    }
}
