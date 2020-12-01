package com.leetcode;

/**
 * @author: John
 * @date: 2020-11-15 10:41
 * @description:
 **/
public class GG  {
    static class T extends Thread {
        @Override
        public void run() {
            System.out.println("Current Thread Name: " + this.getName());
        }
    }


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            long start = System.currentTimeMillis();
            Thread.sleep(300);
            long end = System.currentTimeMillis();
            System.out.println("time: " + (end - start));
            T t = new T();
            t.setName("TestThread");
            t.start();
        }
    }
}
